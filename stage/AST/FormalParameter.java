package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class FormalParameter extends ASTNode
{
    public TypeNode ctype;
    public Identifier name;

    public FormalParameter (TypeNode t, Identifier i)
    {
        ctype = t;
        name = i;
    }

    public void accept (Visitor v)
    {
        v.visit(this);
    }

    public Type accept (TypeVisitor v) throws SemanticException
    {
        return v.visit(this);
    }

    public void accept (TempVisitor v)
    {
        v.visit(this);
    }
}