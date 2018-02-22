package AST;

import java.util.Vector;
import Semantic.*;

public class StatementList
{
    public Vector<Statement> sList;

    public StatementList ()
    {
        sList = new Vector<Statement>();
    }

    public void addElement (Statement vd)
    {
        sList.addElement(vd);
    }

    public Statement elementAt (int index)
    {
        return (Statement)sList.elementAt(index);
    }
    
    public int size ()
    {
        return sList.size();
    }
}