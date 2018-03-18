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
        instr = new Vector<IRInstruction>();
        temps = new TempFactory();

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
    
    public void addIRInstruction (IRInstruction i)
    {
        instr.addElement(i);
    }

    public String toString() 
    {
        // TODO: print "FUNC", then name, signature
        System.out.println(String.format("FUNC %s %s", name, signature));
        System.out.println("{");

        // TODO: then print tempFactory, then print list of instructions
        System.out.println(temps);

        Iterator<IRInstruction> itr = instr.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        System.out.println("}");

        return "";
    }
}