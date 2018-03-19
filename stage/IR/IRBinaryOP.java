package IR;

import Types.*;

enum BinaryOPType
{
    IRBinaryAdd,
    IRBinarySubtract,
    IRBinaryMult,
    IRBinaryEquality,
    IRBinaryLessThan;
}

public class IRBinaryOP extends IRInstruction
{
    Temp operand1;
    Temp operand2;

    BinaryOPType type;
    String operator;

    public IRBinaryOP(Temp o1, Temp o2, BinaryOPType t)
    {
        operand1 = o1;
        operand2 = o2;
        type = t;

        String typeSpecifier;
        if (operand1.type instanceof BooleanType) { typeSpecifier = "Z"; }
        else if (operand1.type instanceof CharType) { typeSpecifier = "C"; }
        else if (operand1.type instanceof IntegerType) { typeSpecifier = "I"; }
        else if (operand1.type instanceof FloatType) { typeSpecifier = "F"; }
        else if (operand1.type instanceof StringType) { typeSpecifier = "U"; }

        else { typeSpecifier = "?"; }

        switch (t)
        {
            case IRBinaryAdd:
                operator = typeSpecifier + "+";
                break;
            case IRBinarySubtract:
                operator = typeSpecifier + "-";
                break;
            case IRBinaryMult:
                operator = typeSpecifier + "*";
                break;
            case IRBinaryEquality:
                operator = typeSpecifier + "==";
                break;
            case IRBinaryLessThan:
                operator = typeSpecifier + "<";
                break;
            
        }
    }

    public String toString()
    {
        String ir;
        ir = String.format("\t%s %s %s;", operand1, operator, operand2);
        return ir;
    }
}