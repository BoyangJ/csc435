package AST;

import Types.*;
import Semantic.*;
import IR.*;

public class TypeNode extends ASTNode
{
    public Type type;

    public TypeNode (Type t)
    {
        type = t;
    }

    public TypeNode (Type t, IntegerLiteral i, int l, int o)
    {
        type = new ArrayType(t, i.value);
        type.type = t;
        type.size = i.value;

        line = l;
        offset = o;
    }

    public TypeNode (Type t, int l, int o)
    {
        type = t;
        line = l;
        offset = o;
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