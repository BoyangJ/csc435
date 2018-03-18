package IR;

import Types.*;

public class IRLabel extends IRInstruction
{
    public static int labels;

    int number;

    static {
        labels = 0;
    }

    public IRLabel() 
    {
        number = labels;
        labels++;
    }

    public String toString()
    {
        // TODO: print L#:;
        String label = String.format("L%d:;", number);
        return label;
    }
}