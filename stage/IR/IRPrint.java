package IR;

import Types.*;

public class IRPrint extends IRInstruction
{
    Temp operand;
    Type type;

    String operator;

    public IRPrint(Temp o)
    {
        operand = o;
        type = operand.type;

        // String typeSpecifier;

        if (operand.type instanceof ArrayType)
        {
            ArrayType aType = (ArrayType)operand.type;
            type = aType.type;
        }

        // if (type instanceof BooleanType) { typeSpecifier = "i"; }
        // else if (type instanceof CharType) { typeSpecifier = "i"; }
        // else if (type instanceof IntegerType) { typeSpecifier = "i"; }
        // else if (type instanceof FloatType) { typeSpecifier = "f"; }
        // else if (type instanceof StringType) { typeSpecifier = STRING_SPECIFIER; }
        // else { typeSpecifier = "?"; }

        // operator = "PRINT" + typeSpecifier;
    }

    public String toString()
    {
        /* IR
        String ir;
        ir = String.format("\t%s %s;", operator, operand);
        return ir;
        */
        String jType = "";
        String jTypeSpecifier = "";

        if (type instanceof BooleanType) { jType = "i"; jTypeSpecifier = "Z"; }
        else if (type instanceof CharType) { jType = "i"; jTypeSpecifier = "C"; }
        else if (type instanceof IntegerType) { jType = "i"; jTypeSpecifier = "I"; }
        else if (type instanceof FloatType) { jType = "f"; jTypeSpecifier = "F"; }
        else if (type instanceof StringType) { jType = "a"; jTypeSpecifier = STRING_SPECIFIER; }
        else { jType = "?"; jTypeSpecifier = "?"; }

        System.out.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;");
        System.out.println(String.format("\t%sload %d", jType, operand.number));
        System.out.println(String.format("\tinvokevirtual java/io/PrintStream/print(%s)V", jTypeSpecifier));

        return "";
    }
}