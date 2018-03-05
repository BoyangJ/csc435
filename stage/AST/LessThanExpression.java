package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class LessThanExpression extends Expression
{
    public Expression expr1;
    public Expression expr2;

    public LessThanExpression (Expression e1, Expression e2)
    {
        expr1 = e1;
        expr2 = e2;
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
        return expr1.getLine();
    }

    public int getOffset()
    {
        return expr1.getOffset();
    }
}