package AST;

import java.util.Vector;

public class VariableDeclarationList
{
    public Vector<VariableDeclaration> varDeclList;

    public VariableDeclarationList ()
    {
        varDeclList = new Vector<VariableDeclaration>();
    }

    public void addElement (VariableDeclaration vd)
    {
        varDeclList.addElement(vd);
    }

    public VariableDeclaration elementAt (int index)
    {
        return (VariableDeclaration)varDeclList.elementAt(index);
    }
    
    public int size ()
    {
        return varDeclList.size();
    }
}