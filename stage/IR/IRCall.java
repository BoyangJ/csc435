package IR;

import java.util.Iterator;
import java.util.Vector;
import Types.*;

public class IRCall extends IRInstruction
{
    Temp dest;

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

    public IRCall(Temp d, String n, Vector<Temp> t)
    {
        dest = d;
        funcName = n;
        arguments = t;
    }

    public String toString()
    {
        // TODO: print (dest) := (operand1) (operand type)(binary op) (operand2)
        String destString = "";
        if (dest != null) 
        {
            destString = String.format("T%d := ", dest.number);
        }

        String argumentsString = "";
        Iterator<Temp> itr = arguments.iterator();
        while (itr.hasNext())
        {
            argumentsString = argumentsString + String.format("T%d", itr.next().number);
        }

        String ir = String.format("\t%sCALL %s(%s);", destString, funcName, argumentsString);
        
        return ir;
    }
}