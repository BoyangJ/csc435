package IR;

import Types.*;

enum AssignmentType
{
    CONSTANT,
    NEW_ARRAY,
    TWO_OPERANDS,
    UNARY_OP,
    BINARY_OP,
    ARRAY_LEFT,
    ARRAY_RIGHT;
    // TODO: bunch more
}

public class IRVarAssign extends IRInstruction
{
    Temp dest;
    Temp operand1;
    Temp operand2;

    String constant;

    Type arrayType;
    int arraySize;
    String typeSpecifier;

    IRUnaryOP unaryOP;
    IRBinaryOP binaryOP;
    // IRCall call;

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

    public IRVarAssign(Temp d, Type ty, int s, AssignmentType t)
    {
        dest = d;
        arrayType = ty;
        arraySize = s;
        type = t;

        typeSpecifier = "";
        if (arrayType instanceof BooleanType) { typeSpecifier = "Z"; }
        else if (arrayType instanceof CharType) { typeSpecifier = "C"; }
        else if (arrayType instanceof IntegerType) { typeSpecifier = "I"; }
        else if (arrayType instanceof FloatType) { typeSpecifier = "F"; }
        else if (arrayType instanceof StringType) { typeSpecifier = "U"; }
    }

    public IRVarAssign(Temp d, IRBinaryOP b, AssignmentType t)
    {
        dest = d;
        binaryOP = b;
        type = t;
    }

    // public IRVarAssign(Temp d, IRCall c, AssignmentType t)
    // {
    //     dest = d;
    //     call = c;
    //     type = t;
    // }

    public IRVarAssign(Temp d, Temp o1, Temp o2, AssignmentType t)
    {
        dest = d;
        operand1 = o1;
        operand2 = o2;
        type = t;
    }

    public String toString()
    {
        String jType = "";
        if (dest.type instanceof BooleanType) { jType = "i"; }
        else if (dest.type instanceof CharType) { jType = "i"; }
        else if (dest.type instanceof IntegerType) { jType = "i"; }
        else if (dest.type instanceof FloatType) { jType = "f"; }
        else if (dest.type instanceof StringType) { jType = "a"; }
        else if (dest.type instanceof ArrayType) { jType = "a"; }

        String ir = "";
        switch (type)
        {
            // TODO: more cases
            case CONSTANT:
                //ir = String.format("\t%s := %s;", dest, constant);
                if (dest.type instanceof CharType)
                {
                    constant = Integer.toString((int)constant.charAt(1));
                }
                else if (dest.type instanceof BooleanType)
                {
                    if (constant.equals("FALSE")) { constant = "0"; }
                    else if (constant.equals("TRUE")) { constant = "1"; }
                }
                System.out.println(String.format("\tldc %s", constant));
                System.out.println(String.format("\t%sstore %d", jType, dest.number));
                break;

            case NEW_ARRAY:
                ir = String.format("\t%s := NEWARRAY %s %d;", dest, typeSpecifier, arraySize);
                break;

            case TWO_OPERANDS:
                //ir = String.format("\t%s := %s;", dest, operand1);
                System.out.println(String.format("\t%sload %d", jType, operand1.number));
                System.out.println(String.format("\t%sstore %d", jType, dest.number));
                break;

            case BINARY_OP:
                //ir = String.format("\t%s := %s %s %s;", dest, binaryOP.operand1, binaryOP.operator, binaryOP.operand2);
                System.out.print(binaryOP);
                System.out.println(String.format("\t%sstore %d", jType, dest.number));
                break;

            case ARRAY_LEFT:
                ir = String.format("\t%s[%s] := %s;", dest, operand1, operand2);
                break;

            case ARRAY_RIGHT:
                ir = String.format("\t%s := %s[%s];", dest, operand1, operand2);
                break;
        }
        // TODO: print (dest) := (operand1) (operand type)(binary op) (operand2)
        return "";
    }
}