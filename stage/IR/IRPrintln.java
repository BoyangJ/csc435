package IR;

import Types.*;

public class IRPrintln extends IRInstruction
{
    Temp operand;

    String operator;

    public IRPrintln(Temp o)
    {
        operand = o;

        String typeSpecifier;
        if (operand.type instanceof BooleanType) { typeSpecifier = "Z"; }
        else if (operand.type instanceof CharType) { typeSpecifier = "C"; }
        else if (operand.type instanceof IntegerType) { typeSpecifier = "I"; }
        else if (operand.type instanceof FloatType) { typeSpecifier = "F"; }
        else if (operand.type instanceof StringType) { typeSpecifier = "U"; }
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