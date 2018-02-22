package AST;

import Types.*;
import Semantic.*;

public class FunctionExpression extends Expression
{
    public String name;
    public ExpressionList eList;

    public FunctionExpression (String n, ExpressionList el)
    {
        name = n;
        eList = el;
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
        return eList.elementAt(0).getLine();
    }

    public int getOffset()
    {
        return eList.elementAt(0).getOffset();
    }
}