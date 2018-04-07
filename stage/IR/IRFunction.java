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

    int endLabel;

    public IRFunction(FunctionDeclaration fd) 
    {
        name = fd.name.name;
        instr = new Vector<IRInstruction>();
        temps = new TempFactory();
        signature = "(";

        temps.startLabel = IRProgram.labels++;
        endLabel = IRProgram.labels++;

        // for every parameter in fd, create new temp with temps
        Iterator<FormalParameter> itr = fd.params.fpList.iterator();
        while(itr.hasNext())
        {
            FormalParameter param = itr.next();
            Type paramType = param.ctype.type;
            String paramName = param.name.name;

            temps.getTemp(paramType, TempClass.PARAMETERS, paramName);

            // build signature
            String typeSpecifier = "";
            if (paramType instanceof ArrayType)
            {
                ArrayType varArrayType = (ArrayType)paramType;
                typeSpecifier = "A";
                paramType = varArrayType.type;
            }

            typeSpecifier += getTypeSpecifier(paramType);

            signature += typeSpecifier;
        }
        signature += ")";

        Type returnType = fd.ctype.type;
        String typeSpecifier = "";
        if (returnType instanceof ArrayType)
        {
            ArrayType varArrayType = (ArrayType)returnType;
            typeSpecifier = "A";
            returnType = varArrayType.type;
        }
        typeSpecifier += getTypeSpecifier(returnType);
        signature += typeSpecifier;
        
    }
    
    public void addIRInstruction (IRInstruction i)
    {
        instr.addElement(i);
    }

    public String getTypeSpecifier(Type t)
    {
        String typeSpecifier = "";

        if (t instanceof BooleanType) { typeSpecifier += "Z"; }
        else if (t instanceof CharType) { typeSpecifier += "C"; }
        else if (t instanceof IntegerType) { typeSpecifier += "I"; }
        else if (t instanceof FloatType) { typeSpecifier += "F"; }
        else if (t instanceof StringType) { typeSpecifier += "Ljava/lang/String;"; }
        else if (t instanceof VoidType) { typeSpecifier += "V"; }

        return typeSpecifier;
    }

    public String toString() 
    {
        /* IR 
        System.out.println(String.format("FUNC %s %s", name, signature));
        System.out.println("{");

        System.out.println(temps);
        */

        System.out.println(String.format(".method public static %s%s", name, signature));
        System.out.println(String.format("\t.limit locals %d", temps.getNumTemps()));
        System.out.println(temps);

        Iterator<IRInstruction> itr = instr.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        /* IR
        System.out.println("}");
        */

        return "";
    }
}