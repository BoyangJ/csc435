package IR;

import java.util.Iterator;
import java.util.Vector;
import AST.*;
import Types.*;

public class IRFunction
{
    String name;
    String signature;

    public Vector<IRInstruction> instr;
    TempFactory temps;

    public IRFunction(FunctionDeclaration fd) 
    {
        name = fd.name.name;

        // for every parameter in fd, create new temp with temps
        Iterator<FormalParameter> itr = fd.params.fpList.iterator();
        while(itr.hasNext())
        {
            FormalParameter param = itr.next();
            Type paramType = param.ctype.type;
            String paramName = param.name.name;

            temps.getTemp(paramType, TempClass.PARAMETERS, paramName);
        }
        
    }
    
    public void add (IRInstruction i)
    {
        instr.addElement(i);
    }

    public String toString() 
    {
        // TODO: print "FUNC", then name, signature

        // TODO: then print tempFactory, then print list of instructions
        return "";
    }
}