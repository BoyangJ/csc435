package AST;

import Types.*;
import Semantic.*;

public class ArrayAssignmentStatement extends Statement
{
    public Identifier name;
    public Expression index;
    public Expression expr;

    public ArrayAssignmentStatement (Identifier i, Expression e1, Expression e2)
    {
        name = i;
        index = e1;
        expr = e2;
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