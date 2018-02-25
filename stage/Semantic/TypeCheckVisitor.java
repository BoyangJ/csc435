package Semantic;

import java.util.Iterator;
import AST.*;
import Types.*;
import Environment.*;

public class TypeCheckVisitor implements TypeVisitor
{
    //private int indents;
    ListEnvironment<String,FunctionDeclaration> fEnv;
    ListEnvironment<String,Type> vEnv;

    private boolean hasMain;
    private Type currentFuncReturnType;
    private int currentFuncLine;
    private int currentFuncOffset;

    public TypeCheckVisitor()
    {
        fEnv = new ListEnvironment<String,FunctionDeclaration>();
        vEnv = new ListEnvironment<String,Type>();
        hasMain = false;
    }

    public Type visit (Program p) throws SemanticException
    {
        Iterator<Function> itr = p.functionList.iterator();
        if (!itr.hasNext())
        {
            String msg = "A program must contain at least one function.";
            throw new SemanticException(msg, p.line, p.offset);
        }

        while(itr.hasNext())
        {
            itr.next().accept(this);
        }

        if (!hasMain)
        {
            String msg = "A program must have a main function.";
            throw new SemanticException(msg, p.line, p.offset);
        }
        return null;
    }
    public Type visit (Function f) throws SemanticException
    {
        currentFuncReturnType = f.decl.accept(this);
        f.body.accept(this);
        return currentFuncReturnType;
    }
    public Type visit (FunctionDeclaration fd) throws SemanticException
    {
        Type returnType = fd.ctype.accept(this);
        fd.name.accept(this);

        if (!fEnv.inCurrentScope(fd.name.name))
        {
            fEnv.add(fd.name.name, fd);
            currentFuncLine = fd.name.line;
            currentFuncOffset = fd.name.offset;
        }
        else 
        {
            String msg = "A function named " + fd.name.name + " already exists.";
            throw new SemanticException(msg, fd.name.line, fd.name.offset);
        }

        // System.out.print(" ");
        // System.out.print(" ");
        Iterator<FormalParameter> itr = fd.params.fpList.iterator();

        if (fd.name.name.equals("main"))
        {
            if (itr.hasNext())
            {
                String msg = "The main function cannot have parameters.";
                throw new SemanticException(msg, fd.name.line, fd.name.offset);
            }
            if (!(returnType instanceof VoidType))
            {
                String msg = "The main function must return type 'void'.";
                throw new SemanticException(msg, fd.name.line, fd.name.offset);
            }
            hasMain = true;
        }

        // System.out.print("(");

        // add Formal Parameters to function's variable environment
        vEnv.beginScope();
        while(itr.hasNext())
        {
            FormalParameter param = itr.next();
            Type paramType = param.accept(this);
            String paramName = param.name.name;

            if (!vEnv.inCurrentScope(paramName))
            {
                if (!(paramType instanceof VoidType))
                {
                    vEnv.add(paramName, paramType);
                }
                else
                {
                    String msg = "A parameter cannot be type 'void'.";
                    throw new SemanticException(msg, param.name.line, param.name.offset);
                }
            }
            else 
            {
                String msg = "A parameter named " + paramName + " already exists.";
                throw new SemanticException(msg, param.name.line, param.name.offset);
            }
            // if (itr.hasNext())
            // {
            //     System.out.print(", ");
            // }
        }
        // System.out.print(")");
        return returnType;
    }
    public Type visit (FunctionBody fb) throws SemanticException
    {
        // printNewLine();
        // System.out.print("{");
        // indents++;
        // printNewLine();

        Iterator<VariableDeclaration> itr = fb.vdList.varDeclList.iterator();
        while(itr.hasNext())
        {
            VariableDeclaration var = itr.next();
            Type varType = var.accept(this);
            String varName = var.name.name;

            if (!vEnv.inCurrentScope(varName))
            {
                if (!(varType instanceof VoidType))
                {
                    vEnv.add(varName, varType);
                }
                else 
                {
                    String msg = "A variable cannot be type 'void'.";
                    throw new SemanticException(msg, var.name.line, var.name.offset);
                }
            }
            else
            {
                String msg = "A variable or parameter named " + varName + " already exists.";
                throw new SemanticException(msg, var.name.line, var.name.offset);
            }
            // printNewLine();
        }

        //DEBUG
        System.out.println("current vEnv: " + vEnv);

        Iterator<Statement> itr2 = fb.sList.sList.iterator();
        while(itr2.hasNext())
        {
            Statement stmt = itr2.next();
            if (stmt instanceof ReturnStatement && itr2.hasNext())
            {
                String msg = "Return statement must be the last statement in the function.";
                throw new SemanticException(msg, stmt.getLine(), stmt.getOffset());
            }
            else
            {
                stmt.accept(this);
            }
            // printNewLine();
        }

        // indents--;
        // System.out.print("\b\b\b\b");
        // System.out.print("}");

        // end the function's variable environment scope
        vEnv.endScope();
        return null;
    }
    public Type visit (FormalParameter fp) throws SemanticException
    {
        Type paramType = fp.ctype.accept(this);
        fp.name.accept(this);
        // System.out.print(" ");

        return paramType;
    }
    public Type visit (VariableDeclaration vd) throws SemanticException
    {
        Type varType = vd.type.accept(this);
        vd.name.accept(this);
        // System.out.print(" ");
        // System.out.print(";");
        return varType;
    }
    public Type visit (Identifier i) throws SemanticException
    {
        // System.out.print(i.name);
        return null;
    }
    public Type visit (TypeNode t) throws SemanticException
    {
        //System.out.print(t.type);
        // if (t.index != null)
        // {
            // System.out.print("[");
            // t.index.accept(this);
            // System.out.print("]");
        // }

        return t.type;
    }

    public Type visit (ExpressionStatement es) throws SemanticException
    {
        if (es.expr != null)
        {
            es.expr.accept(this);
        }
        // System.out.print(";");
        return null;
    }
    public Type visit (IfStatement is) throws SemanticException
    {
        // System.out.print("if (");
        Type conditionType = is.expr.accept(this);
        if (!(conditionType instanceof BooleanType))
        {
            String msg = "If statement condition expression must be type boolean. Found (" + conditionType + ").";
            throw new SemanticException(msg, is.getLine(), is.getOffset());
        }
        // System.out.print(")");
        
        is.ifBlock.accept(this);

        if (is.elseBlock != null)
        {
            // printNewLine();
            // System.out.print("else");
            is.elseBlock.accept(this);
        }
        return null;
    }
    public Type visit (WhileStatement ws) throws SemanticException
    {
        // System.out.print("while (");
        Type conditionType = ws.expr.accept(this);
        if (!(conditionType instanceof BooleanType))
        {
            String msg = "While statement condition expression must be type boolean. Found (" + conditionType + ").";
            throw new SemanticException(msg, ws.getLine(), ws.getOffset());
        }

        // System.out.print(")");

        ws.block.accept(this);
        return null;
    }
    public Type visit (PrintStatement ps) throws SemanticException
    {
        // System.out.print("print ");
        Type exprType = ps.expr.accept(this);
        if (exprType instanceof VoidType || exprType instanceof ArrayType)
        {
            String msg = "Print statement expression cannot be of type " + exprType + ".";
            throw new SemanticException(msg, ps.getLine(), ps.getOffset());
        }

        // System.out.print(";");
        return null;
    }
    public Type visit (PrintlnStatement pls) throws SemanticException
    {
        // System.out.print("println ");
        Type exprType = pls.expr.accept(this);
        if (exprType instanceof VoidType || exprType instanceof ArrayType)
        {
            String msg = "Println statement expression cannot be of type " + exprType + ".";
            throw new SemanticException(msg, pls.getLine(), pls.getOffset());
        }

        // System.out.print(";");
        return null;
    }
    public Type visit (ReturnStatement rs) throws SemanticException
    {
        // System.out.print("return");
        Type returnType;
        if (rs.expr != null)
        {
            // System.out.print(" ");
            returnType = rs.expr.accept(this);
            System.out.println("return type: " + returnType + ", currentfuncreturntype: " + currentFuncReturnType);
            if (!returnType.getClass().equals(currentFuncReturnType.getClass()))
            {
                String msg = "Return type does not match function declaration.";
                throw new SemanticException(msg, rs.getLine(), rs.getOffset());
            }
        }
        else 
        {
            returnType = new VoidType();
            if (!returnType.getClass().equals(currentFuncReturnType.getClass()))
            {
                String msg = "Return type does not match function declaration.";
                throw new SemanticException(msg, currentFuncLine, currentFuncOffset);
            }
        }
        // System.out.print(";");
        return returnType;
    }
    public Type visit (AssignmentStatement as) throws SemanticException
    {
        as.id.accept(this);
        if (!vEnv.inCurrentScope(as.id.name))
        {
            String msg = "Variable " + as.id.name + " is not defined.";
            throw new SemanticException(msg, as.getLine(), as.getOffset());
        }
        Type varType = vEnv.lookup(as.id.name);
        System.out.println("type of " + as.id.name + " is " + varType);

        // System.out.print(" = ");
        Type exprType = as.expr.accept(this);
        System.out.println("type of expr is " + exprType);

        if (!varType.getClass().equals(exprType.getClass()))
        {
            String msg = "Variable type and assignment expression type do not match. Found ("
                         + exprType + "), requires (" + varType + ").";
            throw new SemanticException(msg, as.getLine(), as.getOffset());

        }
        // System.out.print(";");
        return varType;
    }
    public Type visit (ArrayAssignmentStatement aas) throws SemanticException
    {
        Type varType = aas.arrayExpr.accept(this);
        Type exprType = aas.expr.accept(this);

        if (!varType.getClass().equals(exprType.getClass()))
        {
            String msg = "Array variable type and assignment expression type do not match. Found ("
                         + exprType + "), requires (" + varType + ").";
            throw new SemanticException(msg, aas.getLine(), aas.getOffset());
        }

        // System.out.print("[");
        // aas.index.accept(this);
        // System.out.print("] = ");
        // aas.expr.accept(this);
        // System.out.print(";");
        return varType;
    }

    public Type visit (Block b) throws SemanticException
    {
        // printNewLine();
        // System.out.print("{");
        // indents++;
        // printNewLine();

        Iterator<Statement> itr = b.sList.sList.iterator();
        while(itr.hasNext())
        {
            itr.next().accept(this);
            // printNewLine();
        }

        // indents--;
        // System.out.print("\b\b\b\b");
        // System.out.print("}");
        return null;
    }

    public Type visit (EqualityExpression e) throws SemanticException
    {
        Type e1Type = e.expr1.accept(this);
        // System.out.print("==");
        Type e2Type = e.expr2.accept(this);

        System.out.println("e1type = " + e1Type + ", e2type = " + e2Type);
        if (e1Type instanceof VoidType || e1Type instanceof ArrayType)
        {
            String msg = "Invalid type for == expression. Found (" + e1Type + ").";
            throw new SemanticException(msg, e.expr1.getLine(), e.expr1.getOffset());
        }
        else if (e2Type instanceof VoidType || e2Type instanceof ArrayType)
        {
            String msg = "Invalid type for == expression. Found (" + e2Type + ").";
            throw new SemanticException(msg, e.expr2.getLine(), e.expr2.getOffset());
        }

        if (!e1Type.getClass().equals(e2Type.getClass()))
        {
            String msg = "Types of == expression must match. Found (" + 
                         e1Type + ") and (" + e2Type + ").";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }
        return new BooleanType();
    }
    public Type visit (LessThanExpression e) throws SemanticException
    {
        Type e1Type = e.expr1.accept(this);
        // System.out.print("<");
        Type e2Type = e.expr2.accept(this);

        System.out.println("e1type = " + e1Type + ", e2type = " + e2Type);
        if (e1Type instanceof VoidType || e1Type instanceof ArrayType)
        {
            String msg = "Invalid type for < expression. Found (" + e1Type + ").";
            throw new SemanticException(msg, e.expr1.getLine(), e.expr1.getOffset());
        }
        else if (e2Type instanceof VoidType || e2Type instanceof ArrayType)
        {
            String msg = "Invalid type for < expression. Found (" + e2Type + ").";
            throw new SemanticException(msg, e.expr2.getLine(), e.expr2.getOffset());
        }

        if (!e1Type.getClass().equals(e2Type.getClass()))
        {
            String msg = "Types of < expression must match. Found (" + 
                         e1Type + ") and (" + e2Type + ").";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }
        return new BooleanType();
    }
    public Type visit (AddExpression e) throws SemanticException
    {
        Type expr1Type = e.expr1.accept(this);
        // System.out.print("+");
        Type expr2Type = e.expr2.accept(this);

        if (expr1Type instanceof ArrayType || expr1Type instanceof VoidType || expr1Type instanceof BooleanType)
        {
            String msg = "Add expression left operand cannot have type " + expr1Type + ".";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }
        else if (expr2Type instanceof ArrayType || expr2Type instanceof VoidType || expr2Type instanceof BooleanType)
        {
            String msg = "Add expression right operand cannot have type " + expr2Type + ".";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }
        else if (!expr1Type.getClass().equals(expr2Type.getClass()))
        {
            String msg = "Add expression operands must have matching types. Found (" 
                + expr1Type + ") and (" + expr2Type + ").";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }
        return expr1Type;
    }
    public Type visit (SubtractExpression e) throws SemanticException
    {
        Type expr1Type = e.expr1.accept(this);
        // System.out.print("+");
        Type expr2Type = e.expr2.accept(this);

        if (expr1Type instanceof ArrayType || expr1Type instanceof VoidType || expr1Type instanceof BooleanType || expr1Type instanceof StringType)
        {
            String msg = "Subtract expression left operand cannot have type " + expr1Type + ".";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }
        else if (expr2Type instanceof ArrayType || expr2Type instanceof VoidType || expr2Type instanceof BooleanType || expr2Type instanceof StringType)
        {
            String msg = "Subtract expression right operand cannot have type " + expr2Type + ".";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }
        else if (!expr1Type.getClass().equals(expr2Type.getClass()))
        {
            String msg = "Subtract expression operands must have matching types. Found (" 
                + expr1Type + ") and (" + expr2Type + ").";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }

        return expr1Type;
    }
    public Type visit (MultExpression e) throws SemanticException
    {
        Type expr1Type = e.expr1.accept(this);
        // System.out.print("+");
        Type expr2Type = e.expr2.accept(this);

        if (expr1Type instanceof ArrayType || expr1Type instanceof VoidType || expr1Type instanceof BooleanType || expr1Type instanceof StringType || expr1Type instanceof CharType)
        {
            String msg = "Multiply expression left operand cannot have type " + expr1Type + ".";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }
        else if (expr2Type instanceof ArrayType || expr2Type instanceof VoidType || expr2Type instanceof BooleanType || expr2Type instanceof StringType || expr2Type instanceof CharType)
        {
            String msg = "Multiply expression right operand cannot have type " + expr2Type + ".";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }
        else if (!expr1Type.getClass().equals(expr2Type.getClass()))
        {
            String msg = "Multiply expression operands must have matching types. Found (" 
                + expr1Type + ") and (" + expr2Type + ").";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }

        return expr1Type;
    }
    public Type visit (ParenExpression e) throws SemanticException
    {
        // System.out.print("(");
        // e.expr.accept(this);
        // System.out.print(")");
        return e.expr.accept(this);
    }
    public Type visit (IdentifierExpression e) throws SemanticException
    {
        if (!vEnv.inCurrentScope(e.id.name))
        {
            String msg = "Variable " + e.id.name + " is not defined.";
            throw new SemanticException(msg, e.id.line, e.id.offset);
        }
        // System.out.print(e.name);
        return vEnv.lookup(e.id.name);
    }
    public Type visit (ArrayExpression e) throws SemanticException
    {
        // System.out.print(e.name);
        // System.out.print("[");
        // e.expr.accept(this);
        // System.out.print("]");

        e.id.accept(this);
        if (!vEnv.inCurrentScope(e.id.name))
        {
            String msg = "Array " + e.id.name + " is not defined.";
            throw new SemanticException(msg, e.getLine(), e.getOffset());
        }

        ArrayType varArrayType = (ArrayType)vEnv.lookup(e.id.name);
        return varArrayType.type;
        
    }
    public Type visit (FunctionExpression e) throws SemanticException
    {
        // System.out.print(e.name);
        // System.out.print("(");
        
        // Iterator<Expression> itr = e.eList.eList.iterator();
        // while(itr.hasNext())
        // {
        //     itr.next().accept(this);
        //     if (itr.hasNext())
        //     {
        //         System.out.print(", ");
        //     }
        // }

        // System.out.print(")");
        return null;
    }

    public Type visit (IntegerLiteral i) throws SemanticException
    {
        // System.out.print(i.value);
        return new IntegerType();
    }
    public Type visit (StringLiteral s) throws SemanticException
    {
        // System.out.print(s.value);
        return new StringType();
    }
    public Type visit (FloatLiteral f) throws SemanticException
    {
        // System.out.print(f.value);
        return new FloatType();
    }
    public Type visit (CharacterLiteral c) throws SemanticException
    {
        // System.out.print("'");
        // System.out.print(c.value);
        // System.out.print("'");
        return new CharType();
    }
    public Type visit (BooleanLiteral b) throws SemanticException
    {
        // System.out.print(b.value);
        return new BooleanType();
    }


    // private void printNewLine ()
    // {
    //     System.out.print("\n");
    //     for (int i = 0; i < indents*4; i++)
    //     {
    //         System.out.print(" ");
    //     }
    // }

}