package IR;

import Types.*;

public class TempFactory
{
    int next;

    Temp[] TempsList;

    public TempFactory() 
    {
        next = 0;
        TempsList = new Temp[20000];
    }

    public Temp getTemp(Type t)
    {
        Temp newTemp = new Temp(t, next);
        TempsList[next] = newTemp;
        next++;

        return newTemp;
    }

    public Temp getTemp(Type t, TempClass tc, String n)
    {
        Temp newTemp = new Temp(t, next, tc, n);
        TempsList[next] = newTemp;
        next++;

        return newTemp;
    }

    public Temp lookup(String n) 
    {
        for (int i = 0; i < next; i++)
        {
            if (TempsList[i].name.equals(n))
            {
                return TempsList[i];
            }
        }
        return null;
    }
    
    public String toString() 
    {
        // TODO: print declarations of all temps in a row
        String typeSpecifier = "";
        for (int i = 0; i < next; i++)
        {
            if (TempsList[i].type instanceof BooleanType) { typeSpecifier = "Z"; }
            else if (TempsList[i].type instanceof CharType) { typeSpecifier = "C"; }
            else if (TempsList[i].type instanceof IntegerType) { typeSpecifier = "I"; }
            else if (TempsList[i].type instanceof FloatType) { typeSpecifier = "F"; }
            else if (TempsList[i].type instanceof StringType) { typeSpecifier = "U"; }

            else if (TempsList[i].type instanceof ArrayType)
            {
                ArrayType varArrayType = (ArrayType)TempsList[i].type;

                if (varArrayType.type instanceof BooleanType) { typeSpecifier = "AZ"; }
                else if (varArrayType.type instanceof CharType) { typeSpecifier = "AC"; }
                else if (varArrayType.type instanceof IntegerType) { typeSpecifier = "AI"; }
                else if (varArrayType.type instanceof FloatType) { typeSpecifier = "AF"; }
                else if (varArrayType.type instanceof StringType) { typeSpecifier = "AU"; }
            }

            System.out.println(String.format("\tTEMP %d:%s;", i, typeSpecifier));
        }
        return "";
    }
}