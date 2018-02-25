import java.util.Iterator;
import AST.*;

public class PrettyPrintVisitor implements Visitor
{
    private int indents;

    public PrettyPrintVisitor()
    {
        indents = 0;
    }

    public void visit (Program p)
    {
        Iterator<Function> itr = p.functionList.iterator();
        while(itr.hasNext())
        {
            itr.next().accept(this);
            printNewLine();
            printNewLine();
        }
    }
    public void visit (Function f)
    {
        f.decl.accept(this);
        f.body.accept(this);
    }
    public void visit (FunctionDeclaration fd)
    {
        fd.ctype.accept(this);
        System.out.print(" ");
        fd.name.accept(this);
        System.out.print(" ");

        System.out.print("(");
        Iterator<FormalParameter> itr = fd.params.fpList.iterator();
        while(itr.hasNext())
        {
            itr.next().accept(this);
            if (itr.hasNext())
            {
                System.out.print(", ");
            }
        }
        System.out.print(")");

    }
    public void visit (FunctionBody fb)
    {
        printNewLine();
        System.out.print("{");
        indents++;
        printNewLine();

        Iterator<VariableDeclaration> itr = fb.vdList.varDeclList.iterator();
        while(itr.hasNext())
        {
            itr.next().accept(this);
            printNewLine();
        }

        Iterator<Statement> itr2 = fb.sList.sList.iterator();
        while(itr2.hasNext())
        {
            itr2.next().accept(this);
            printNewLine();
        }

        indents--;
        System.out.print("\b\b\b\b");
        System.out.print("}");

    }
    public void visit (FormalParameter fp)
    {
        fp.ctype.accept(this);
        System.out.print(" ");
        fp.name.accept(this);
    }
    public void visit (VariableDeclaration vd)
    {
        vd.type.accept(this);
        System.out.print(" ");
        vd.name.accept(this);
        System.out.print(";");
    }
    public void visit (Identifier i)
    {
        System.out.print(i.name);
    }
    public void visit (TypeNode t)
    {
        System.out.print(t.type);
        // if (t.index != null)
        // {
        //     System.out.print("[");
        //     t.index.accept(this);
        //     System.out.print("]");
        // }
    }

    public void visit (ExpressionStatement es)
    {
        if (es.expr != null)
        {
            es.expr.accept(this);
        }
        System.out.print(";");
    }
    public void visit (IfStatement is)
    {
        System.out.print("if (");
        is.expr.accept(this);
        System.out.print(")");
        
        is.ifBlock.accept(this);

        if (is.elseBlock != null)
        {
            printNewLine();
            System.out.print("else");

            is.elseBlock.accept(this);
        }
    }
    public void visit (WhileStatement ws)
    {
        System.out.print("while (");
        ws.expr.accept(this);
        System.out.print(")");

        ws.block.accept(this);
    }
    public void visit (PrintStatement ps)
    {
        System.out.print("print ");
        ps.expr.accept(this);
        System.out.print(";");
    }
    public void visit (PrintlnStatement pls)
    {
        System.out.print("println ");
        pls.expr.accept(this);
        System.out.print(";");
    }
    public void visit (ReturnStatement rs)
    {
        System.out.print("return");
        if (rs.expr != null)
        {
            System.out.print(" ");
            rs.expr.accept(this);
        }
        System.out.print(";");
    }
    public void visit (AssignmentStatement as)
    {
        as.id.accept(this);
        System.out.print(" = ");
        as.expr.accept(this);
        System.out.print(";");
    }
    public void visit (ArrayAssignmentStatement aas)
    {
        aas.arrayExpr.accept(this);
        System.out.print("[");
        //aas.index.accept(this);
        System.out.print("] = ");
        aas.expr.accept(this);
        System.out.print(";");
    }

    public void visit (Block b)
    {
        printNewLine();
        System.out.print("{");
        indents++;
        printNewLine();

        Iterator<Statement> itr = b.sList.sList.iterator();
        while(itr.hasNext())
        {
            itr.next().accept(this);
            printNewLine();
        }

        indents--;
        System.out.print("\b\b\b\b");
        System.out.print("}");
    }

    public void visit (EqualityExpression e)
    {
        e.expr1.accept(this);
        System.out.print("==");
        e.expr2.accept(this);
    }
    public void visit (LessThanExpression e)
    {
        e.expr1.accept(this);
        System.out.print("<");
        e.expr2.accept(this);
    }
    public void visit (AddExpression e)
    {
        e.expr1.accept(this);
        System.out.print("+");
        e.expr2.accept(this);
    }
    public void visit (SubtractExpression e)
    {
        e.expr1.accept(this);
        System.out.print("-");
        e.expr2.accept(this);
    }
    public void visit (MultExpression e)
    {
        e.expr1.accept(this);
        System.out.print("*");
        e.expr2.accept(this);
    }
    public void visit (ParenExpression e)
    {
        System.out.print("(");
        e.expr.accept(this);
        System.out.print(")");
    }
    public void visit (IdentifierExpression e)
    {
        System.out.print(e.id.name);
    }
    public void visit (ArrayExpression e)
    {
        System.out.print(e.id.name);
        System.out.print("[");
        e.expr.accept(this);
        System.out.print("]");
    }
    public void visit (FunctionExpression e)
    {
        System.out.print(e.id.name);
        System.out.print("(");
        
        Iterator<Expression> itr = e.eList.eList.iterator();
        while(itr.hasNext())
        {
            itr.next().accept(this);
            if (itr.hasNext())
            {
                System.out.print(", ");
            }
        }

        System.out.print(")");
    }

    public void visit (IntegerLiteral i)
    {
        System.out.print(i.value);
    }
    public void visit (StringLiteral s)
    {
        System.out.print(s.value);
    }
    public void visit (FloatLiteral f)
    {
        System.out.print(f.value);
    }
    public void visit (CharacterLiteral c)
    {
        System.out.print("'");
        System.out.print(c.value);
        System.out.print("'");
    }
    public void visit (BooleanLiteral b)
    {
        System.out.print(b.value);
    }


    private void printNewLine ()
    {
        System.out.print("\n");
        for (int i = 0; i < indents*4; i++)
        {
            System.out.print(" ");
        }
    }

}