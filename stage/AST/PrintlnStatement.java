package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class PrintlnStatement extends Statement
{
    public Expression expr;

    public PrintlnStatement (Expression e)
    {
        expr = e;
    }

    public void accept (Visitor v)
    {
        v.visit(this);
    }

    public Type accept (TypeVisitor v) throws SemanticException
    {
        return v.visit(this);
    }

    public Temp accept (TempVisitor v)
    {
        return v.visit(this);
    }

    public int getLine()
    {
        return expr.getLine();
    }

    public int getOffset()
    {
        return expr.getOffset();
    }
}