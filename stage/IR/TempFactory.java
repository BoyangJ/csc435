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
        Temp newTemp = new Temp(t);
        TempsList[next] = newTemp;
        next++;

        return newTemp;
    }

    public Temp getTemp(Type t, TempClass tc, String n)
    {
        Temp newTemp = new Temp(t, tc, n);
        TempsList[next] = newTemp;
        next++;

        return newTemp;
    }
    
    public String toString() 
    {
        // TODO: print declarations of all temps in a row
        return "";
    }
}