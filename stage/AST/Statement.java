package AST;

import Types.*;
import Semantic.*;

public abstract class Statement extends ASTNode
{
    public abstract Type accept (TypeVisitor v) throws SemanticException;
    public abstract void accept (Visitor v);
}