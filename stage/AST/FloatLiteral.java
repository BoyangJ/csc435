package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class FloatLiteral extends Expression
{
    public Float value;

    public FloatLiteral (Float f)
    {
        value = f;
    }

    public FloatLiteral (Float f, int l, int o)
    {
        value = f;
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

    public Temp accept (TempVisitor v)
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