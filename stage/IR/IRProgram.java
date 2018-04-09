package IR;

import java.util.Iterator;
import java.util.Vector;
import Types.*;

public class IRProgram
{
    String sourceName;
    public String className;
    public Vector<IRFunction> functions;

    public static int labels;

    public IRProgram(String n) 
    {
        sourceName = n.substring(n.lastIndexOf("/")+1);
        className = n.substring(n.lastIndexOf("/")+1, n.lastIndexOf("."));
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