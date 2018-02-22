package AST;

import Types.*;
import Semantic.*;

public class IntegerLiteral extends Expression
{
    public Integer value;

    public IntegerLiteral (Integer i)
    {
        value = i;
    }

    public IntegerLiteral (Integer i, int l, int o)
    {
        value = i;
        line = l;
        offset = o;
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