package AST;

import Types.*;
import Semantic.*;

public class Block extends ASTNode
{
    public StatementList sList;

    public Block ()
    {
        sList = new StatementList();
    }

    public Block (StatementList sl)
    {
        sList = sl;
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