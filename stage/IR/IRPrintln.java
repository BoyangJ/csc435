package IR;

import Types.*;

public class IRPrintln extends IRInstruction
{
    Temp operand;
    Type type;

    String operator;

    public IRPrintln(Temp o)
    {
        operand = o;
        type = operand.type;

        String typeSpecifier;

        if (operand.type instanceof ArrayType)
        {
            ArrayType aType = (ArrayType)operand.type;
            type = aType.type;
        }

        if (type instanceof BooleanType) { typeSpecifier = "Z"; }
        else if (type instanceof CharType) { typeSpecifier = "C"; }
        else if (type instanceof IntegerType) { typeSpecifier = "I"; }
        else if (type instanceof FloatType) { typeSpecifier = "F"; }
        else if (type instanceof StringType) { typeSpecifier = "U"; }
        else { typeSpecifier = "?"; }

        operator = "PRINTLN" + typeSpecifier;
    }

    public String toString()
    {
        // TODO: print (dest) := (operand1) (operand type)(binary op) (operand2)
        String ir;
        ir = String.format("\t%s %s;", operator, operand);
        return ir;
    }
}