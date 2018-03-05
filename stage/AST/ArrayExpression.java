package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class ArrayExpression extends Expression
{
    public Identifier id;
    public Expression expr;

    public ArrayExpression (Identifier i, Expression e)
    {
        id = i;
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