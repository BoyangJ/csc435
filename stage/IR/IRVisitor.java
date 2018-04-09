package IR;

import java.util.Iterator;
import java.util.Vector;
import AST.*;
import Types.*;
import Environment.*;

public class IRVisitor implements TempVisitor
{
    ListEnvironment<String,Type> fEnv;

    IRProgram prog;
    IRFunction currentFunction;

    public IRVisitor(String n)
    {
        prog = new IRProgram(n);
        fEnv = new ListEnvironment<String,Type>();
    }

    public Temp visit (Program p)
    {
        /* IR
        System.out.println(String.format("PROG %s", prog.name));
        */
        System.out.println(String.format(".source %s", prog.sourceName));
        System.out.println(String.format(".class public %s", prog.className));
        System.out.println(".super java/lang/Object");
        System.out.println();
        Iterator<Function> itr = p.functionList.iterator();

        // Add all function declarations to the function environment.
        while(itr.hasNext())
        {
            FunctionDeclaration fd = itr.next().decl;
            fEnv.add(fd.name.name, fd.ctype.type);            
        }

        itr = p.functionList.iterator();
        while(itr.hasNext())
        {
            itr.next().accept(this);
        }

        // TODO: last step - print prog
        System.out.println(prog);

        // Program end Boilerplate
        printEndBoilerplate();

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

        return null;
    }
    public Temp visit (WhileStatement ws)
    {
        IRInstruction in;
        IRLabel l1 = new IRLabel();
        IRLabel l2 = new IRLabel();

        currentFunction.addIRInstruction(l1);

        Temp t = ws.expr.accept(this);

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
        Temp t = ps.expr.accept(this);
 
        in = new IRPrint(t);
        currentFunction.addIRInstruction(in);

        return t;
    }

    public Temp visit (PrintlnStatement pls)
    {
        IRInstruction in;
        Temp t = pls.expr.accept(this);

        in = new IRPrintln(t);
        currentFunction.addIRInstruction(in);

        return t;
    }

    public Temp visit (ReturnStatement rs)
    {
        IRInstruction in;

        if (rs.expr != null)
        {
            Temp t = rs.expr.accept(this);
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
        Temp expr = as.expr.accept(this);

        in = new IRVarAssign(dest, expr, AssignmentType.TWO_OPERANDS);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (ArrayAssignmentStatement aas)
    {
        IRInstruction in;

        Temp dest = currentFunction.temps.lookup(aas.arrayExpr.id.name);
       
        ArrayExpression aExpr = (ArrayExpression)aas.arrayExpr;
        Temp arrayIndex = aExpr.expr.accept(this);

        Temp expr = aas.expr.accept(this);

        in = new IRVarAssign(dest, arrayIndex, expr, AssignmentType.ARRAY_LEFT);
        currentFunction.addIRInstruction(in);

        return dest;
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
        Temp e1Temp = e.expr1.accept(this);
        Temp e2Temp = e.expr2.accept(this);

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinaryEquality), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (LessThanExpression e)
    {
        IRInstruction in;
        Temp dest = currentFunction.temps.getTemp(new BooleanType());
        Temp e1Temp = e.expr1.accept(this);
        Temp e2Temp = e.expr2.accept(this);

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinaryLessThan), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (AddExpression e)
    {
        IRInstruction in;
        Temp e1Temp = e.expr1.accept(this);
        Temp e2Temp = e.expr2.accept(this);

        Temp dest = currentFunction.temps.getTemp(e1Temp.type);

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinaryAdd), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (SubtractExpression e)
    {
        IRInstruction in;
        Temp e1Temp = e.expr1.accept(this);
        Temp e2Temp = e.expr2.accept(this);

        Temp dest = currentFunction.temps.getTemp(e1Temp.type);

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinarySubtract), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (MultExpression e)
    {
        IRInstruction in;
        Temp e1Temp = e.expr1.accept(this);
        Temp e2Temp = e.expr2.accept(this);

        Temp dest = currentFunction.temps.getTemp(e1Temp.type);

        in = new IRVarAssign(dest, new IRBinaryOP(e1Temp, e2Temp, BinaryOPType.IRBinaryMult), AssignmentType.BINARY_OP);
        currentFunction.addIRInstruction(in);

        return dest;
    }

    public Temp visit (ParenExpression e)
    {
        IRInstruction in;
        Temp eTemp = e.expr.accept(this);

        return eTemp;
    }

    public Temp visit (IdentifierExpression e)
    {
        return currentFunction.temps.lookup(e.id.name);
    }

    public Temp visit (ArrayExpression e)
    {
        IRInstruction in;

        Type arrayType = currentFunction.temps.lookup(e.id.name).type;
        Temp dest = currentFunction.temps.getTemp(arrayType.type);
        
        Temp arrayTemp = currentFunction.temps.lookup(e.id.name);
        Temp arrayIndex = e.expr.accept(this);

        in = new IRVarAssign(dest, arrayTemp, arrayIndex, AssignmentType.ARRAY_RIGHT);
        currentFunction.addIRInstruction(in);

        return dest;
    }

    public Temp visit (FunctionExpression e)
    {
        IRInstruction in;

        Temp dest = null;
        Iterator<Expression> itr = e.eList.eList.iterator();
        Vector<Temp> argumentsList = new Vector<Temp>();

        while(itr.hasNext())
        {
            Expression argument = itr.next();
            Temp argTemp = argument.accept(this);

            argumentsList.add(argTemp);
        }
        
        if (fEnv.lookup(e.id.name) instanceof VoidType)
        {
            in = new IRCall(e.id.name, argumentsList, prog.className);
            currentFunction.addIRInstruction(in);
        }
        else
        {
            dest = currentFunction.temps.getTemp(fEnv.lookup(e.id.name));
            in = new IRCall(dest, e.id.name, argumentsList, prog.className);
            currentFunction.addIRInstruction(in);
        }

        return dest;
    }

    public Temp visit (IntegerLiteral i)
    {
        IRInstruction in;
        Temp dest = currentFunction.temps.getTemp(new IntegerType());
        in = new IRVarAssign(dest, i.value.toString(), AssignmentType.CONSTANT);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (StringLiteral s)
    {
        IRInstruction in;
        Temp dest = currentFunction.temps.getTemp(new StringType());
        in = new IRVarAssign(dest, s.value.toString(), AssignmentType.CONSTANT);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (FloatLiteral f)
    {
        IRInstruction in;
        Temp dest = currentFunction.temps.getTemp(new FloatType());
        in = new IRVarAssign(dest, f.value.toString(), AssignmentType.CONSTANT);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (CharacterLiteral c)
    {
        IRInstruction in;
        Temp dest = currentFunction.temps.getTemp(new CharType());
        in = new IRVarAssign(dest, String.format("\'%s\'",c.value.toString()), AssignmentType.CONSTANT);
        currentFunction.addIRInstruction(in);

        return dest;
    }
    public Temp visit (BooleanLiteral b)
    {
        IRInstruction in;
        Temp dest = currentFunction.temps.getTemp(new BooleanType());
        in = new IRVarAssign(dest, b.value.toString().toUpperCase(), AssignmentType.CONSTANT);
        currentFunction.addIRInstruction(in);

        return dest;
    }

    void printEndBoilerplate()
    {
        System.out.println(";--------------------------------------------;");
        System.out.println(";                                            ;");
        System.out.println("; Boilerplate                                ;");
        System.out.println(";                                            ;");
        System.out.println(";--------------------------------------------;");
        System.out.println();
        System.out.println(String.format(".method public static main([%s)V", IRInstruction.STRING_SPECIFIER));
        System.out.println("\t; set limits used by this method");
        System.out.println("\t.limit locals 1");
        System.out.println("\t.limit stack 4");
        System.out.println(String.format("\tinvokestatic %s/__main()V", prog.className));
        System.out.println("\treturn");
        System.out.println(".end method");
        System.out.println();
        System.out.println("; standard initializer");
        System.out.println(".method public <init>()V");
        System.out.println("\taload_0");
        System.out.println("\tinvokenonvirtual java/lang/Object/<init>()V");
        System.out.println("\treturn");
        System.out.println(".end method");
    }

}