package AST;

import Types.*;
import Semantic.*;
import IR.*;

public abstract class Statement extends ASTNode
{
    public abstract void accept (Visitor v);
    public abstract Type accept (TypeVisitor v) throws SemanticException;
    public abstract Temp accept (TempVisitor v);

    public abstract int getLine();
    public abstract int getOffset();
}