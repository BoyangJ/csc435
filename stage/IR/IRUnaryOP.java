package IR;

import Types.*;

enum UnaryOPType
{
    IRNegation,
    IRInvertBool;
}

public class IRUnaryOP extends IRInstruction
{
    Temp dest;
    Temp operand;
    UnaryOPType type;

    public IRUnaryOP(Temp d, Temp o, UnaryOPType t)
    {
        dest = d;
        operand = o;
        type = t;
    }

    public String toString()
    {
        // TODO: print (dest) := (operand type)(unary op) (operand)
        return "";
    }
}