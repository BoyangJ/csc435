package AST;

import Types.*;
import Semantic.*;

public class ArrayExpression extends Expression
{
    public String name;
    public Expression expr;

    public ArrayExpression (String n, Expression e)
    {
        name = n;
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