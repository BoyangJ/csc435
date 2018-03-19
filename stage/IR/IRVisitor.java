package IR;

import java.util.Iterator;
import java.util.Vector;
import AST.*;
import Types.*;
import Environment.*;

public class IRVisitor implements TempVisitor
{
    IRProgram prog;
    IRFunction currentFunction;

    String assignmentVar;
    Type tempType;

    Temp arrayIndexTemp;

    public IRVisitor(String n)
    {
        prog = new IRProgram(n);
    }

    public Temp visit (Program p)
    {
        Iterator<Function> itr = p.functionList.iterator();

        while(itr.hasNext())
        {
            itr.next().accept(this);
        }

        // TODO: last step - print prog
        System.out.println(prog);

        return null;
    }
    public Temp visit (Function f)
    {
        IRFunction IRFunc = new IRFunction(f.decl);
        prog.addIRFunction(IRFunc);
        currentFunction = IRFunc;
        f.decl.accept(this);

        f.body.accept(this);

        IRInstruction in = new IRReturn();
        currentFunction.addIRInstruction(in);

        return null;
    }
    public Temp visit (FunctionDeclaration fd)
    {
        return null;
    }
    public Temp visit (FunctionBody fb)
    {
        Iterator<VariableDeclaration> itr = fb.vdList.varDeclList.iterator();
        while(itr.hasNext())
        {
            VariableDeclaration var = itr.next();
            Type varType = var.type.type;
            String varName = var.name.name;

            Temp newTemp = currentFunction.temps.getTemp(varType, TempClass.LOCALS, varName);

            if (varType instanceof ArrayType)
            {
                ArrayType varArrayType = (ArrayType)varType;
                IRInstruction in = new IRVarAssign(newTemp, varArrayType.type, varArrayType.size, AssignmentType.NEW_ARRAY);
                currentFunction.addIRInstruction(in);
            }
        }

        Iterator<Statement> itr2 = fb.sList.sList.iterator();
        while(itr2.hasNext())
        {
            Statement stmt = itr2.next();
            stmt.accept(this);
        }
        return null;
    }
    // are these 4 necessary???
    public Temp visit (FormalParameter fp){return null;}
    public Temp visit (VariableDeclaration vd){return null;}
    public Temp visit (Identifier i){ System.out.println("found here lol"); return null;}
    public Temp visit (TypeNode t){return null;}
    // these 4

    // this one for function calls
    // if an ID is not found in temp factory, must be function name
    public Temp visit (ExpressionStatement es)
    {
        if (es.expr != null)
        {
            return es.expr.accept(this);
        }
        return null;
    }

    public Temp visit (IfStatement is)
    {
        IRInstruction in;
        IRLabel l1 = new IRLabel();
        IRLabel l2 = new IRLabel();

        Temp t;

        if (isLiteral(is.expr))
        {
            t = currentFunction.temps.getTemp(new BooleanType());
            is.expr.accept(this);
            in = new IRVarAssign(t, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            t = is.expr.accept(this);
        }

        // make new Temp to prevent overwriting a parameter or local
        Temp t2 = currentFunction.temps.getTemp(new BooleanType());
        in = new IRVarAssign(t2, t, AssignmentType.TWO_OPERANDS);
        currentFunction.addIRInstruction(in);
        t = t2;

        in = new IRUnaryOP(t, t, UnaryOPType.IRInvertBool);
        currentFunction.addIRInstruction(in);

        in = new IRIfStatement(t, l1);
        currentFunction.addIRInstruction(in);

        is.ifBlock.accept(this);

        in = new IRGoto(l2);
        currentFunction.addIRInstruction(in);

        currentFunction.addIRInstruction(l1);

        if (is.elseBlock != null)
        {
            is.elseBlock.accept(this);
        }

        currentFunction.addIRInstruction(l2);

        return null;
    }
    public Temp visit (WhileStatement ws)
    {
        IRInstruction in;
        IRLabel l1 = new IRLabel();
        IRLabel l2 = new IRLabel();

        Temp t;

        currentFunction.addIRInstruction(l1);

        if (isLiteral(ws.expr))
        {
            t = currentFunction.temps.getTemp(new BooleanType());
            ws.expr.accept(this);
            in = new IRVarAssign(t, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            t = ws.expr.accept(this);
        }

        // make new Temp to prevent overwriting a parameter or local
        Temp t2 = currentFunction.temps.getTemp(new BooleanType());
        in = new IRVarAssign(t2, t, AssignmentType.TWO_OPERANDS);
        currentFunction.addIRInstruction(in);
        t = t2;

        in = new IRUnaryOP(t, t, UnaryOPType.IRInvertBool);
        currentFunction.addIRInstruction(in);

        in = new IRIfStatement(t, l2);
        currentFunction.addIRInstruction(in);

        ws.block.accept(this);

        in = new IRGoto(l1);
        currentFunction.addIRInstruction(in);

        currentFunction.addIRInstruction(l2);

        return null;
    }

    public Temp visit (PrintStatement ps)
    {
        IRInstruction in;
        Temp t;

        if (isLiteral(ps.expr))
        {
            t = currentFunction.temps.getTemp(tempType);
            ps.expr.accept(this);
            in = new IRVarAssign(t, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            t = ps.expr.accept(this);
        }

        in = new IRPrint(t);
        currentFunction.addIRInstruction(in);

        return null;
    }

    public Temp visit (PrintlnStatement pls)
    {
        IRInstruction in;
        Temp t;

        if (isLiteral(pls.expr))
        {
            t = currentFunction.temps.getTemp(tempType);
            pls.expr.accept(this);
            in = new IRVarAssign(t, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            t = pls.expr.accept(this);
        }

        in = new IRPrintln(t);
        currentFunction.addIRInstruction(in);

        return null;
    }

    public Temp visit (ReturnStatement rs)
    {
        IRInstruction in;
        Temp t;

        if (rs.expr != null)
        {
            if (isLiteral(rs.expr))
            {
                t = currentFunction.temps.getTemp(tempType);
                rs.expr.accept(this);
                in = new IRVarAssign(t, assignmentVar, AssignmentType.CONSTANT);
                currentFunction.addIRInstruction(in);
            }
            else
            {
                t = rs.expr.accept(this);
            }
            in = new IRReturn(t);
        }
        else 
        {
            in = new IRReturn();
        }

        currentFunction.addIRInstruction(in);

        return null;
    }

    public Temp visit (AssignmentStatement as)
    {
        IRInstruction in;

        Temp dest = currentFunction.temps.lookup(as.id.name);

        if (isLiteral(as.expr))
        {
            as.expr.accept(this);
            in = new IRVarAssign(dest, assignmentVar, AssignmentType.CONSTANT);
        }

        // else if as.expr instanceof functionexpression
        else if (as.expr instanceof FunctionExpression)
        {
            FunctionExpression e = (FunctionExpression)as.expr;
            Iterator<Expression> itr = e.eList.eList.iterator();
            Vector<Temp> argumentsList = new Vector<Temp>();

            while(itr.hasNext())
            {
                Temp argTemp;
                Expression argument = itr.next();
                 
                if (isLiteral(argument))
                {
                    argTemp = currentFunction.temps.getTemp(tempType);
                    argument.accept(this);
                    in = new IRVarAssign(argTemp, assignmentVar, AssignmentType.CONSTANT);
                    currentFunction.addIRInstruction(in);
                }
                else
                {
                    argTemp = argument.accept(this);
                }

                argumentsList.add(argTemp);
            }

            IRCall call = new IRCall(e.id.name, argumentsList);
            in = new IRVarAssign(dest, call, AssignmentType.FUNCTION_CALL);
        }

        else if (as.expr instanceof ArrayExpression)
        {
            Temp expr = as.expr.accept(this);
            in = new IRVarAssign(dest, expr, arrayIndexTemp, AssignmentType.ARRAY_RIGHT);
        }

        else
        {
            Temp expr = as.expr.accept(this);
            in = new IRVarAssign(dest, expr, AssignmentType.TWO_OPERANDS);
        }
        currentFunction.addIRInstruction(in);

        return null;
    }
    public Temp visit (ArrayAssignmentStatement aas)
    {
        IRInstruction in;

        Temp dest = aas.arrayExpr.accept(this); 
        Temp destIndex = arrayIndexTemp;

        Temp expr;

        if (isLiteral(aas.expr))
        {
            expr = currentFunction.temps.getTemp(tempType);
            aas.expr.accept(this);
            in = new IRVarAssign(expr, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }

        else if (aas.expr instanceof ArrayExpression)
        {
            Temp yolo = currentFunction.temps.getTemp(dest.type.type);

            expr = aas.expr.accept(this);
            in = new IRVarAssign(yolo, expr, arrayIndexTemp, AssignmentType.ARRAY_RIGHT);
            currentFunction.addIRInstruction(in);

            expr = yolo;
        }
        
        else
        {
            expr = aas.expr.accept(this);
        }

        in = new IRVarAssign(dest, destIndex, expr, AssignmentType.ARRAY_LEFT);
        currentFunction.addIRInstruction(in);

        return null;
    }

    public Temp visit (Block b)
    {
        Iterator<Statement> itr = b.sList.sList.iterator();
        while(itr.hasNext())
        {
            itr.next().accept(this);
        }

        return null;
    }

    public Temp visit (EqualityExpression e)
    {
        IRInstruction in;
        Temp dest = currentFunction.temps.getTemp(new BooleanType());
        Temp e1Temp;
        Temp e2Temp;

        if (isLiteral(e.expr1))
        {
            e1Temp = currentFunction.temps.getTemp(tempType);
            e.expr1.accept(this);
            in = new IRVarAssign(e1Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e1Temp = e.expr1.accept(this);
        }

        if (isLiteral(e.expr2))
        {
            e2Temp = currentFunction.temps.getTemp(tempType);
            e.expr2.accept(this);
            in = new IRVarAssign(e2Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e2Temp = e.expr2.accept(this);
        }

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinaryEquality), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (LessThanExpression e)
    {
        IRInstruction in;
        Temp dest = currentFunction.temps.getTemp(new BooleanType());
        Temp e1Temp;
        Temp e2Temp;

        if (isLiteral(e.expr1))
        {
            e1Temp = currentFunction.temps.getTemp(tempType);
            e.expr1.accept(this);
            in = new IRVarAssign(e1Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e1Temp = e.expr1.accept(this);
        }

        if (isLiteral(e.expr2))
        {
            e2Temp = currentFunction.temps.getTemp(tempType);
            e.expr2.accept(this);
            in = new IRVarAssign(e2Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e2Temp = e.expr2.accept(this);
        }

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinaryLessThan), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (AddExpression e)
    {
        IRInstruction in;
        Temp e1Temp;
        Temp e2Temp;

        if (isLiteral(e.expr1))
        {
            e1Temp = currentFunction.temps.getTemp(tempType);
            e.expr1.accept(this);
            in = new IRVarAssign(e1Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e1Temp = e.expr1.accept(this);
        }

        if (isLiteral(e.expr2))
        {
            e2Temp = currentFunction.temps.getTemp(tempType);
            e.expr2.accept(this);
            in = new IRVarAssign(e2Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e2Temp = e.expr2.accept(this);
        }

        Temp dest = currentFunction.temps.getTemp(e1Temp.type);

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinaryAdd), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (SubtractExpression e)
    {
        IRInstruction in;
        Temp e1Temp;
        Temp e2Temp;

        if (isLiteral(e.expr1))
        {
            e1Temp = currentFunction.temps.getTemp(tempType);
            e.expr1.accept(this);
            in = new IRVarAssign(e1Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e1Temp = e.expr1.accept(this);
        }

        if (isLiteral(e.expr2))
        {
            e2Temp = currentFunction.temps.getTemp(tempType);
            e.expr2.accept(this);
            in = new IRVarAssign(e2Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e2Temp = e.expr2.accept(this);
        }

        Temp dest = currentFunction.temps.getTemp(e1Temp.type);

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinarySubtract), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (MultExpression e)
    {
        IRInstruction in;
        Temp e1Temp;
        Temp e2Temp;

        if (isLiteral(e.expr1))
        {
            e1Temp = currentFunction.temps.getTemp(tempType);
            e.expr1.accept(this);
            in = new IRVarAssign(e1Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e1Temp = e.expr1.accept(this);
        }

        if (isLiteral(e.expr2))
        {
            e2Temp = currentFunction.temps.getTemp(tempType);
            e.expr2.accept(this);
            in = new IRVarAssign(e2Temp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            e2Temp = e.expr2.accept(this);
        }

        Temp dest = currentFunction.temps.getTemp(e1Temp.type);

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinaryMult), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }

    public Temp visit (ParenExpression e)
    {
        IRInstruction in;
        Temp eTemp;

        if (isLiteral(e.expr))
        {
            eTemp = currentFunction.temps.getTemp(tempType);
            e.expr.accept(this);
            in = new IRVarAssign(eTemp, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            eTemp = e.expr.accept(this);
        }

        return eTemp;
    }

    public Temp visit (IdentifierExpression e)
    {
        return currentFunction.temps.lookup(e.id.name);
    }

    public Temp visit (ArrayExpression e)
    {
        IRInstruction in;
        Temp t;

        if (isLiteral(e.expr))
        {
            t = currentFunction.temps.getTemp(tempType);
            e.expr.accept(this);
            in = new IRVarAssign(t, assignmentVar, AssignmentType.CONSTANT);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            t = e.expr.accept(this);
        }

        arrayIndexTemp = t;
        return currentFunction.temps.lookup(e.id.name);
    }

    public Temp visit (FunctionExpression e)
    {
        System.out.println("function call found");
        IRInstruction in;

        Iterator<Expression> itr = e.eList.eList.iterator();
        Vector<Temp> argumentsList = new Vector<Temp>();

        while(itr.hasNext())
        {
            Temp argTemp;
            Expression argument = itr.next();
             
            if (isLiteral(argument))
            {
                argTemp = currentFunction.temps.getTemp(tempType);
                argument.accept(this);
                in = new IRVarAssign(argTemp, assignmentVar, AssignmentType.CONSTANT);
                currentFunction.addIRInstruction(in);
            }
            else
            {
                argTemp = argument.accept(this);
            }

            argumentsList.add(argTemp);
        }

        in = new IRCall(e.id.name, argumentsList);
        currentFunction.addIRInstruction(in);

        return null;
    }

    public Temp visit (IntegerLiteral i)
    {
        assignmentVar = i.value.toString();
        return null;
    }
    public Temp visit (StringLiteral s)
    {
        assignmentVar = s.value.toString();
        return null;
    }
    public Temp visit (FloatLiteral f)
    {
        assignmentVar = f.value.toString();
        return null;
    }
    public Temp visit (CharacterLiteral c)
    {
        assignmentVar = c.value.toString();
        return null;
    }
    public Temp visit (BooleanLiteral b)
    {
        assignmentVar = b.value.toString().toUpperCase();
        return null;
    }


    public boolean isLiteral(Expression e)
    {
        if (e instanceof IntegerLiteral)
        {
            tempType = new IntegerType();
            return true;
        } 
        else if (e instanceof StringLiteral)
        {
            tempType = new StringType();
            return true;
        } 
        else if (e instanceof FloatLiteral)
        {
            tempType = new FloatType();
            return true;
        }
        else if (e instanceof CharacterLiteral)
        {
            tempType = new CharType();
            return true;
        } 
        else if (e instanceof BooleanLiteral)
        {
            tempType = new BooleanType();
            return true;
        }
        else 
        {
            return false;
        }
    }

}