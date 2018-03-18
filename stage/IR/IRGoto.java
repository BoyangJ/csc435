package IR;

import Types.*;

public class IRGoto extends IRInstruction
{
    IRLabel label;

    public IRGoto(IRLabel l)
    {
        label = l;
    }

    public String toString()
    {
        String ir = "";
        ir = String.format("\tGOTO L%d;", label.number);
        // TODO: print (dest) := (operand1) (operand type)(binary op) (operand2)
        return ir;
    }
}