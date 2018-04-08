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
        /* IR
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
        */

        // Arguments
        String argumentsString = "";

        String jType = "";
        String jTypeSpecifier = "";
        Iterator<Temp> itr = arguments.iterator();
        while (itr.hasNext())
        {
            Temp arg = itr.next();
            if (arg.type instanceof BooleanType) { jType = "i"; jTypeSpecifier = "Z"; }
            else if (arg.type instanceof CharType) { jType = "i"; jTypeSpecifier = "C"; }
            else if (arg.type instanceof IntegerType) { jType = "i"; jTypeSpecifier = "I"; }
            else if (arg.type instanceof FloatType) { jType = "f"; jTypeSpecifier = "F"; }
            else if (arg.type instanceof StringType) { jType = "a"; jTypeSpecifier = STRING_SPECIFIER; }
            else { jType = "?"; jTypeSpecifier = "?"; }
            System.out.println(String.format("\t%sload %d", jType, arg.number));

            argumentsString = argumentsString + jTypeSpecifier;
        }

        if (dest != null)
        {
            // invokestatic
            String jDestType = "";
            String jReturnType = "";
            if (dest.type instanceof BooleanType) { jDestType = "i"; jReturnType = "Z"; }
            else if (dest.type instanceof CharType) { jDestType = "i"; jReturnType = "C"; }
            else if (dest.type instanceof IntegerType) { jDestType = "i"; jReturnType = "I"; }
            else if (dest.type instanceof FloatType) { jDestType = "f"; jReturnType = "F"; }
            else if (dest.type instanceof StringType) { jDestType = "a"; jReturnType = STRING_SPECIFIER; }
            else if (dest.type instanceof VoidType) { jReturnType = "V"; }
            else { jDestType = "?"; jReturnType = "?"; }
            System.out.println(String.format("\tinvokestatic call/%s(%s)%s", funcName, argumentsString, jReturnType));

            // destination
            System.out.println(String.format("\t%sstore %d", jDestType, dest.number));
        }
        else
        {
            System.out.println(String.format("\tinvokestatic call/%s(%s)V", funcName, argumentsString));
        }

        return "";
    }
}