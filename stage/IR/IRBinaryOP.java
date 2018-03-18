package IR;

import Types.*;

enum BinaryOPType
{
    IRBinaryAdd,
    IRBinarySubtract,
    IRBinaryMult,
    IRBinaryEquality,
    IRBinaryLessThan;
}

public class IRBinaryOP extends IRInstruction
{
    //Temp dest;
    Temp operand1;
    Temp operand2;

    BinaryOPType type;
    String operator;

    /*
    public IRBinaryOP(Temp d, Temp o1, Temp o2, BinaryOPType t)
    {
        dest = d;
        operand1 = o1;
        operand2 = o2;
        type = t;
    }
    */

    public IRBinaryOP(Temp o1, Temp o2, BinaryOPType t)
    {
        operand1 = o1;
        operand2 = o2;
        type = t;

        switch (t)
        {
            case IRBinaryAdd:
                operator = "+";
                break;
            case IRBinarySubtract:
                operator = "-";
                break;
            case IRBinaryMult:
                operator = "*";
                break;
            case IRBinaryEquality:
                operator = "==";
                break;
            case IRBinaryLessThan:
                operator = "<";
                break;
            
        }
    }

    public String toString()
    {
        // TODO: print (dest) := (operand1) (operand type)(binary op) (operand2)
        return "";
    }
}