package IR;

import Types.*;

enum AssignmentType
{
    CONSTANT,
    NEW_ARRAY,
    TWO_OPERANDS,
    UNARY_OP,
    BINARY_OP;

    // TODO: bunch more
}

public class IRVarAssign extends IRInstruction
{
    Temp dest;
    Temp operand1;
    Temp operand2;

    String constant;

    IRUnaryOP unaryOP;
    IRBinaryOP binaryOP;

    AssignmentType type;

    public IRVarAssign(Temp d, Temp o, AssignmentType t)
    {
        dest = d;
        operand1 = o;
        type = t;
    }

    public IRVarAssign(Temp d, String c, AssignmentType t)
    {
        dest = d;
        constant = c;
        type = t;
    }

    public IRVarAssign(Temp d, IRBinaryOP b, AssignmentType t)
    {
        dest = d;
        binaryOP = b;
        type = t;
    }

    public String toString()
    {
        String ir = "";
        switch (type)
        {
            // TODO: more cases
            case CONSTANT:
                ir = String.format("\t%s := %s", dest, constant);
                break;

            case TWO_OPERANDS:
                ir = String.format("\t%s := %s;", dest, operand1);
                break;

            case BINARY_OP:
                ir = String.format("\t%s := %s %s %s", dest, binaryOP.operand1, binaryOP.operator, binaryOP.operand2);
                break;
        }
        // TODO: print (dest) := (operand1) (operand type)(binary op) (operand2)
        return ir;
    }
}