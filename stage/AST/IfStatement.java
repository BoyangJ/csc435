package AST;

import Types.*;
import Semantic.*;

public class IfStatement extends Statement
{
    public Expression expr;
    public Block ifBlock;
    public Block elseBlock;

    public IfStatement (Expression e, Block b1)
    {
        expr = e;
        ifBlock = b1;
    }

    public IfStatement (Expression e, Block b1, Block b2)
    {
        expr = e;
        ifBlock = b1;
        elseBlock = b2;
    }

    public void accept (Visitor v)
    {
        v.visit(this);
    }

    public Type accept (TypeVisitor v) throws SemanticException
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