package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class AssignmentStatement extends Statement
{
    public Identifier id;
    public Expression expr;

    public AssignmentStatement (Identifier i, Expression e)
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
        return id.line;
    }

    public int getOffset()
    {
        return id.offset;
    }
}