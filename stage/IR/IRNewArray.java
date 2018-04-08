/*
package IR;

import Types.*;

public class IRNewArray extends IRInstruction
{
    Temp dest;
    Type type;
    int size;

    public IRNewArray(Temp d, Type t, int s)
    {
        dest = d;
        type = t;
        size = s;
    }

    public String toString()
    {
        /* IR
        String ir;

        String typeSpecifier = "";
        if (type instanceof BooleanType) { typeSpecifier = "Z"; }
        else if (type instanceof CharType) { typeSpecifier = "C"; }
        else if (type instanceof IntegerType) { typeSpecifier = "I"; }
        else if (type instanceof FloatType) { typeSpecifier = "F"; }
        else if (type instanceof StringType) { typeSpecifier = "U"; }

        ir = String.format("\t%s := NEWARRAY %s %d;", dest, typeSpecifier, size);
        
        return ir;
        *
        System.out.println(String.format("\tldc %d", size));

        if (type instanceof StringType)
        {
            System.out.println(String.format("\tanewarray java/lang/String"));
        }
        else
        {
            System.out.println(String.format("\tnewarray %s", type));
        }

        System.out.println(String.format("astore %d", dest.number));

        return "";
    }
}
*/