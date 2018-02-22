package AST;

import Types.*;
import Semantic.*;

public class TypeNode extends ASTNode
{
    public Type type;
    // public IntegerLiteral index;

    public TypeNode (Type t)
    {
        type = t;
    }

    public TypeNode (ArrayType t, Type arrayType, IntegerLiteral i, int l, int o)
    {
        type = t;
        t.type = arrayType;
        t.index = i.value;

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
}