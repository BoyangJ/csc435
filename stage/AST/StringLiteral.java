package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class StringLiteral extends Expression
{
    public String value;

    public StringLiteral (String s)
    {
        value = s;
    }

    public StringLiteral (String s, int l, int o)
    {
        value = s;
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