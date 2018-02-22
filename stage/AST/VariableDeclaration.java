package AST;

import Types.*;
import Semantic.*;

public class VariableDeclaration extends ASTNode
{
    public TypeNode type;
    public Identifier name;

    public VariableDeclaration (TypeNode t, Identifier i)
    {
        type = t;
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
}