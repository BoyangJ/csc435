package AST;

import Types.*;
import Semantic.*;

public class ArrayAssignmentStatement extends Statement
{
    public ArrayExpression arrayExpr;
    public Expression expr;

    public ArrayAssignmentStatement (ArrayExpression ae, Expression e)
    {
        arrayExpr = ae;
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

    public int getLine()
    {
        return expr.getLine();
    }

    public int getOffset()
    {
        return expr.getOffset();
    }
}