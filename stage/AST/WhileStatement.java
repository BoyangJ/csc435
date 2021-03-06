package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class WhileStatement extends Statement
{
    public Expression expr;
    public Block block;

    public WhileStatement (Expression e, Block b)
    {
        expr = e;
        block = b;
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