package IR;

import Types.*;

enum TempClass 
{
    PARAMETERS, 
    LOCALS, 
    TEMPS,
    UNKNOWN;
}

public class Temp
{
    int number;
    Type type;

    String name;
    boolean inUse;
    TempClass tempClass;

    public Temp(Type t, int num) 
    {
        type = t;
        number = num;
    }

    public Temp(Type t, int num, TempClass tc, String n) 
    {
        type = t;
        number = num;
        tempClass = tc;
        name = n;
    }
    
    public String toString() 
    {
        // TODO: print format for temp
        return String.format("T%d", number);
    }
}