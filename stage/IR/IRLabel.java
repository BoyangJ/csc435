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
        /* IR
        String label = String.format("L%d:;", number);
        */

        String label = String.format("LI%d:", number);
        return label;
    }
}