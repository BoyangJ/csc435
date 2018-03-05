package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class FunctionExpression extends Expression
{
    public Identifier id;
    public ExpressionList eList;

    public FunctionExpression (Identifier i, ExpressionList el)
    {
        id = i;
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

    public Temp accept (TempVisitor v)
    {
        return v.visit(this);
    }

    public int getLine()
    {
        return id.line;
    }

    public int getOffset()
    {
        return id.offset;
    }
}