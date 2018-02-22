package AST;

import Types.*;
import Semantic.*;

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
}