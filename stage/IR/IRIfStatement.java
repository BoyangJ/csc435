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
        String ir = "";
        ir = String.format("\tIF %s GOTO L%s;", operand, label.number);
        return ir;
    }
}