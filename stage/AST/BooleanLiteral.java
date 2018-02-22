package AST;

import Types.*;
import Semantic.*;

public class BooleanLiteral extends Expression
{
    public Boolean value;

    public BooleanLiteral (Boolean b)
    {
        value = b;
    }

    public BooleanLiteral (Boolean b, int l, int o)
    {
        value = b;
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

    public int getLine()
    {
        return line;
    }

    public int getOffset()
    {
        return offset;
    }
}