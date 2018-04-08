package IR;

import Types.*;

public class IRReturn extends IRInstruction
{
    Temp operand;

    public IRReturn()
    {
        operand = null;
    }

    public IRReturn(Temp o)
    {
        operand = o;
    }

    public String toString()
    {
        if (operand != null)
        {
            String jType = "";

            if (operand.type instanceof BooleanType) { jType = "i"; }
            else if (operand.type instanceof CharType) { jType = "i"; }
            else if (operand.type instanceof IntegerType) { jType = "i"; }
            else if (operand.type instanceof FloatType) { jType = "f"; }
            else if (operand.type instanceof StringType) { jType = "a"; }
            else { jType = "?"; }

            System.out.println(String.format("\t%sload %d", jType, operand.number));
            System.out.println(String.format("\t%sreturn", jType));
        }
        else 
        {
            System.out.println("\treturn");
        }
        return "";
    }
}