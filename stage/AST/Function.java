package AST;

import Semantic.*;
import IR.*;

public class Function extends ASTNode
{
    public FunctionDeclaration decl;
    public FunctionBody body;

    public Function (FunctionDeclaration fd, FunctionBody fb)
    {
        decl = fd;
        body = fb;
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
}