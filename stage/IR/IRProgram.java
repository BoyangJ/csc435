package IR;

import java.util.Iterator;
import java.util.Vector;
import Types.*;

public class IRProgram
{
    String name;
    public Vector<IRFunction> functions;

    public IRProgram(String n) 
    {
        name = n;
        functions = new Vector<IRFunction>();
    }
    
    public void addIRFunction (IRFunction f)
    {
        functions.addElement(f);
    }

    public String toString() 
    {
        // TODO: for every function in functions, print function
        Iterator<IRFunction> itr = functions.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        return "";
    }
}