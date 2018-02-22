package AST;

import Types.*;
import Semantic.*;

public class ReturnStatement extends Statement
{
    public Expression expr;

    public ReturnStatement ()
    {
        expr = null;
    }

    public ReturnStatement (Expression e)
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
}