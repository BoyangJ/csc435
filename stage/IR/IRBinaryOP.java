package IR;

import Types.*;

enum BinaryOPType
{
    IRBinaryAdd,
    IRBinarySubtract,
    IRBinaryMult,
    IRBinaryEquality,
    IRBinaryLessThan;
}

public class IRBinaryOP extends IRInstruction
{
    Temp operand1;
    Temp operand2;

    BinaryOPType type;
    String operator;

    Type operandType;

    public IRBinaryOP(Temp o1, Temp o2, BinaryOPType t)
    {
        operand1 = o1;
        operand2 = o2;
        operandType = operand1.type;
        type = t;

        String typeSpecifier;
        if (operand1.type instanceof ArrayType)
        {
            ArrayType aType = (ArrayType)operand1.type;
            operandType = aType.type;
        }

    }

    public String toString()
    {
        // if (operandType instanceof BooleanType) { typeSpecifier = "Z"; }
        // else if (operandType instanceof CharType) { typeSpecifier = "C"; }
        // else if (operandType instanceof IntegerType)
        // {
        // }
        // else if (operandType instanceof FloatType) { typeSpecifier = "F"; }
        // else if (operandType instanceof StringType) { typeSpecifier = "U"; }
        // else { typeSpecifier = "?"; }
        String typeSpecifier = "";

        int jLabel1;
        int jLabel2;
        switch (type)
        {
            case IRBinaryAdd:
                if (operandType instanceof IntegerType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\tiadd");
                }
                else if (operandType instanceof FloatType)
                {
                    System.out.println(String.format("\tfload %d", operand1.number));
                    System.out.println(String.format("\tfload %d", operand2.number));
                    System.out.println("\tfadd");
                }
                else if (operandType instanceof CharType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\tiadd");
                    System.out.println("\ti2c");
                }
                else if (operandType instanceof StringType)
                {
                    System.out.println("\tnew java/lang/StringBuffer");
                    System.out.println("\tdup");
                    System.out.println("\tinvokenonvirtual java/lang/StringBuffer/<init>()V");
                    System.out.println(String.format("\taload %d", operand1.number));
                    System.out.println(String.format("\tinvokenonvirtual java/lang/StringBuffer/append(%s)%s", STRING_SPECIFIER, STRING_SPECIFIER));
                    System.out.println(String.format("\taload %d", operand2.number));
                    System.out.println(String.format("\tinvokenonvirtual java/lang/StringBuffer/append(%s)Ljava/lang/StringBuffer;", STRING_SPECIFIER));
                    System.out.println(String.format("\tinvokenonvirtual java/lang/StringBuffer/toString()%s", STRING_SPECIFIER));
                }
                break;

            case IRBinarySubtract:
                if (operandType instanceof IntegerType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\tisub");
                }
                else if (operandType instanceof FloatType)
                {
                    System.out.println(String.format("\tfload %d", operand1.number));
                    System.out.println(String.format("\tfload %d", operand2.number));
                    System.out.println("\tfsub");
                }
                else if (operandType instanceof CharType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\tisub");
                    System.out.println("\ti2c");
                }
                break;

            case IRBinaryMult:
                if (operandType instanceof IntegerType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\timul");
                }
                else if (operandType instanceof FloatType)
                {
                    System.out.println(String.format("\tfload %d", operand1.number));
                    System.out.println(String.format("\tfload %d", operand2.number));
                    System.out.println("\tfmul");
                }
                break;

            case IRBinaryLessThan:
                jLabel1 = IRProgram.labels++;
                jLabel2 = IRProgram.labels++;
                if (operandType instanceof IntegerType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\tisub");
                    System.out.println(String.format("\tiflt LJ_%d", jLabel1));
                    System.out.println("\tlcd 0");
                    System.out.println(String.format("\tgoto LJ_%d", jLabel2));
                    System.out.println(String.format("LJ_%d:", jLabel1));
                    System.out.println("\tlcd 1");
                    System.out.println(String.format("LJ_%d:", jLabel2));
                }
                else if (operandType instanceof FloatType)
                {
                    System.out.println(String.format("\tfload %d", operand1.number));
                    System.out.println(String.format("\tfload %d", operand2.number));
                    System.out.println("\tfcmpg");
                    System.out.println(String.format("\tiflt LJ_%d", jLabel1));
                    System.out.println("\tlcd 0");
                    System.out.println(String.format("\tgoto LJ_%d", jLabel2));
                    System.out.println(String.format("LJ_%d:", jLabel1));
                    System.out.println("\tlcd 1");
                    System.out.println(String.format("LJ_%d:", jLabel2));
                }
                else if (operandType instanceof CharType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\tisub");
                    System.out.println(String.format("\tiflt LJ_%d", jLabel1));
                    System.out.println("\tlcd 0");
                    System.out.println(String.format("\tgoto LJ_%d", jLabel2));
                    System.out.println(String.format("LJ_%d:", jLabel1));
                    System.out.println("\tlcd 1");
                    System.out.println(String.format("LJ_%d:", jLabel2));
                }
                else if (operandType instanceof StringType)
                {
                    System.out.println(String.format("\taload %d", operand1.number));
                    System.out.println(String.format("\taload %d", operand2.number));
                    System.out.println(String.format("\tinvokevirtual java/lang/String/compareTo(%s)I", STRING_SPECIFIER));
                    System.out.println(String.format("\tiflt LJ_%d", jLabel1));
                    System.out.println("\tlcd 0");
                    System.out.println(String.format("\tgoto LJ_%d", jLabel2));
                    System.out.println(String.format("LJ_%d:", jLabel1));
                    System.out.println("\tlcd 1");
                    System.out.println(String.format("LJ_%d:", jLabel2));
                }
                break;

            case IRBinaryEquality:
                jLabel1 = IRProgram.labels++;
                jLabel2 = IRProgram.labels++;
                if (operandType instanceof IntegerType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\tisub");
                    System.out.println(String.format("\tifeq LJ_%d", jLabel1));
                    System.out.println("\tlcd 0");
                    System.out.println(String.format("\tgoto LJ_%d", jLabel2));
                    System.out.println(String.format("LJ_%d:", jLabel1));
                    System.out.println("\tlcd 1");
                    System.out.println(String.format("LJ_%d:", jLabel2));
                }
                else if (operandType instanceof FloatType)
                {
                    System.out.println(String.format("\tfload %d", operand1.number));
                    System.out.println(String.format("\tfload %d", operand2.number));
                    System.out.println("\tfcmpg");
                    System.out.println(String.format("\tifeq LJ_%d", jLabel1));
                    System.out.println("\tlcd 0");
                    System.out.println(String.format("\tgoto LJ_%d", jLabel2));
                    System.out.println(String.format("LJ_%d:", jLabel1));
                    System.out.println("\tlcd 1");
                    System.out.println(String.format("LJ_%d:", jLabel2));
                }
                else if (operandType instanceof CharType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\tisub");
                    System.out.println(String.format("\tifeq LJ_%d", jLabel1));
                    System.out.println("\tlcd 0");
                    System.out.println(String.format("\tgoto LJ_%d", jLabel2));
                    System.out.println(String.format("LJ_%d:", jLabel1));
                    System.out.println("\tlcd 1");
                    System.out.println(String.format("LJ_%d:", jLabel2));
                }
                else if (operandType instanceof StringType)
                {
                    System.out.println(String.format("\taload %d", operand1.number));
                    System.out.println(String.format("\taload %d", operand2.number));
                    System.out.println(String.format("\tinvokevirtual java/lang/String/compareTo(%s)I", STRING_SPECIFIER));
                    System.out.println(String.format("\tifeq LJ_%d", jLabel1));
                    System.out.println("\tlcd 0");
                    System.out.println(String.format("\tgoto LJ_%d", jLabel2));
                    System.out.println(String.format("LJ_%d:", jLabel1));
                    System.out.println("\tlcd 1");
                    System.out.println(String.format("LJ_%d:", jLabel2));
                }
                else if (operandType instanceof BooleanType)
                {
                    System.out.println(String.format("\tiload %d", operand1.number));
                    System.out.println(String.format("\tiload %d", operand2.number));
                    System.out.println("\tixor");
                    System.out.println("\tlcd 1");
                    System.out.println("\tixor");
                }
                break;

            
        }
        /*
        // IR
        System.out.println(String.format(";\t\t\t%s %s %s;", operand1, operator, operand2));

        String jType = "";
        String jOperator = "";
        
        if (operandType instanceof IntegerType) 
        { 
            switch (type)
            {
                case IRBinaryAdd:
                    System.out.println(String.format("iload %d", operand1.number));
                    System.out.println(String.format("iload %d", operand2.number));
                    System.out.println("iadd");
                    System.out.println(String.format("istore %d", operand1.number));

                    break;
                case IRBinarySubtract:
                    jOperator = typeSpecifier + "-";
                    break;
                case IRBinaryMult:
                    jOperator = typeSpecifier + "*";
                    break;
                case IRBinaryEquality:
                    jOperator = typeSpecifier + "==";
                    break;
                case IRBinaryLessThan:
                    jOperator = typeSpecifier + "<";
                    break;
            }
        }
        else if (operandType instanceof CharType) { jType = "C"; }
        else if (operandType instanceof FloatType) { jType = "F"; }
        else if (operandType instanceof StringType) { jType = "U"; }
        else { jType = "?"; }
        */

        return "";
    }
}