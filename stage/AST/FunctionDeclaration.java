package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class FunctionDeclaration extends ASTNode
{
    public TypeNode ctype;
    public Identifier name;
    public FormalParameterList params;

    public FunctionDeclaration (TypeNode t, Identifier i, FormalParameterList pList)
    {
        ctype = t;
        name = i;
        params = pList; 
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