package AST;

import Semantic.*;
import IR.*;

public class Identifier extends ASTNode
{
    public String name;

    public Identifier (String n)
    {
        name = n;
    }

    public Identifier (String n, int l, int o)
    {
        name = n;
        line = l;
        offset = o;
    }

    public void accept (Visitor v)
    {
        v.visit(this);
    }

    public void accept (TypeVisitor v) throws SemanticException
    {
        v.visit(this);
    }

    public void accept (TempVisitor v)
    {
        v.visit(this);
    }

    public String toString()
    {
        return name;
    }
}