package IR;

import java.util.Iterator;
import java.util.Vector;
import Types.*;

public class IRCall extends IRInstruction
{
    String funcName;
    Vector<Temp> arguments;

    public IRCall(String n)
    {
        funcName = n;
        arguments = new Vector<Temp>();
    }

    public IRCall(String n, Vector<Temp> t)
    {
        funcName = n;
        arguments = t;
    }

    public String toString()
    {
        // TODO: print (dest) := (operand1) (operand type)(binary op) (operand2)
        String argumentsString = "";
        Iterator<Temp> itr = arguments.iterator();
        while (itr.hasNext())
        {
            argumentsString = argumentsString + String.format("T%d, ", itr.next().number);
        }
        if (!argumentsString.equals(""))
        {
            argumentsString = argumentsString.substring(0, argumentsString.length() - 2);
        }

        String ir = String.format("\tCALL %s(%s)", funcName, argumentsString);
        
        return ir;
    }
}