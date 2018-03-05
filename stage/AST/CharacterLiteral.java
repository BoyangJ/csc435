package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class CharacterLiteral extends Expression
{
    public Character value;

    public CharacterLiteral (Character c)
    {
        value = c;
    }

    public CharacterLiteral (Character c, int l, int o)
    {
        value = c;
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