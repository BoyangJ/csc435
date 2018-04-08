package IR;

import Types.*;

enum UnaryOPType
{
    IRNegation,
    IRInvertBool;
}

public class IRUnaryOP extends IRInstruction
{
    Temp dest;
    Temp operand;
    UnaryOPType type;

    public IRUnaryOP(Temp d, Temp o, UnaryOPType t)
    {
        dest = d;
        operand = o;
        type = t;
    }

    public String toString()
    {
        // IR
        switch (type)
        {
            case IRNegation:
                break;

            case IRInvertBool:
                System.out.println(String.format(";\t\t\t%s := Z! %s;", dest, operand));
        }

        switch (type)
        {
            case IRNegation:
                break;

            case IRInvertBool:
                System.out.println(String.format("\tiload %d", operand.number));
                System.out.println("\tlcd 1");
                System.out.println("\tixor");
                System.out.println(String.format("\tistore %d", dest.number));
        }
        return "";
    }
}