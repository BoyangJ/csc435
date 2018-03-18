package IR;

import java.util.Iterator;
import AST.*;
import Types.*;
import Environment.*;

public class IRVisitor implements TempVisitor
{
    IRProgram prog;
    IRFunction currentFunction;

    String assignmentVar;
    Type tempType;

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

            currentFunction.temps.getTemp(varType, TempClass.LOCALS, varName);
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
    public Temp visit (Identifier i){return null;}
    public Temp visit (TypeNode t){return null;}
    // these 4

    // this one for function calls
    // if an ID is not found in temp factory, must be function name
    public Temp visit (ExpressionStatement es){return null;}

    public Temp visit (IfStatement is)
    {
        IRInstruction in;
        IRLabel l1 = new IRLabel();
        IRLabel l2 = new IRLabel();

        Temp t = is.expr.accept(this);
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

        //debug
        //System.out.println("factory output for " + currentFunction.name + ": \n" + currentFunction.temps);

        return null;
    }
    public Temp visit (WhileStatement e){return null;}
    public Temp visit (PrintStatement e){return null;}
    public Temp visit (PrintlnStatement e){return null;}
    public Temp visit (ReturnStatement e){return null;}
    public Temp visit (AssignmentStatement as)
    {
        IRInstruction in;

        Temp dest = currentFunction.temps.lookup(as.id.name);

        if (isLiteral(as.expr))
        {
            as.expr.accept(this);
            in = new IRVarAssign(dest, assignmentVar, AssignmentType.CONSTANT);
        }
        else
        {
            Temp expr = as.expr.accept(this);
            in = new IRVarAssign(dest, expr, AssignmentType.TWO_OPERANDS);
        }
        currentFunction.addIRInstruction(in);

        return null;
    }
    public Temp visit (ArrayAssignmentStatement e){return null;}

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
    public Temp visit (LessThanExpression e){return null;}
    public Temp visit (AddExpression e){return null;}
    public Temp visit (SubtractExpression e){return null;}
    public Temp visit (MultExpression e){return null;}
    public Temp visit (ParenExpression e){return null;}
    public Temp visit (IdentifierExpression e)
    {
        return currentFunction.temps.lookup(e.id.name);
    }
    public Temp visit (ArrayExpression e){return null;}
    public Temp visit (FunctionExpression e){return null;}

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