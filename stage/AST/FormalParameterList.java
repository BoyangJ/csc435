package AST;

import java.util.Vector;

public class FormalParameterList
{
    public Vector<FormalParameter> fpList;

    public FormalParameterList ()
    {
        fpList = new Vector<FormalParameter>();
    }

    public void addElement (FormalParameter fp)
    {
        fpList.addElement(fp);
    }

    public FormalParameter elementAt (int index)
    {
        return (FormalParameter)fpList.elementAt(index);
    }
    
    public int size ()
    {
        return fpList.size();
    }
}