package IR;

import Types.*;

public class IRIfStatement extends IRInstruction
{
    Temp operand;
    IRLabel label;

    public IRIfStatement(Temp o, IRLabel l)
    {
        operand = o;
        label = l;
    }

    public String toString()
    {
        /* IR
        String ir = "";
        ir = String.format("\tIF %s GOTO L%s;", operand, label.number);
        */

        System.out.println(String.format("\tiload %d", operand.number));
        System.out.println(String.format("\tifne LI%d", label.number));
        return "";
    }
}