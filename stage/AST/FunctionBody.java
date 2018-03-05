package AST;

import Semantic.*;
import IR.*;

public class FunctionBody extends ASTNode
{
    public VariableDeclarationList vdList;
    public StatementList sList;

    public FunctionBody ()
    {
        vdList = new VariableDeclarationList();
        sList = new StatementList();
    }

    public FunctionBody (VariableDeclarationList vd, StatementList s)
    {
        vdList = vd;
        sList = s;
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