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
        // TODO: print (dest) := (operand1) (operand type)(binary op) (operand2)
        String ir;
        if (operand != null)
        {
            ir = String.format("\tRETURN %s;", operand);   
        }
        else 
        {
            ir = "\tRETURN;";
        }
        return ir;
    }
}