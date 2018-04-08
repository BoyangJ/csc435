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
        /* IR
        String ir = "";
        ir = String.format("\tGOTO L%d;", label.number);
        */
        System.out.println(String.format("\tgoto LI%d", label.number));
        return "";
    }
}