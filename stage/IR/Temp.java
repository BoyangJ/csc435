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

    public Temp(Type t) 
    {
        type = t;
    }

    public Temp(Type t, TempClass tc, String n) 
    {
        type = t;
        tempClass = tc;
        name = n;
    }
    
    public String toString() 
    {
        // TODO: print format for temp
        return "";
    }
}