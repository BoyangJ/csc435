package AST;

import java.util.Vector;

public class ExpressionList
{
    public Vector<Expression> eList;

    public ExpressionList ()
    {
        eList = new Vector<Expression>();
    }

    public void addElement (Expression e)
    {
        eList.addElement(e);
    }

    public Expression elementAt (int index)
    {
        return (Expression)eList.elementAt(index);
    }
    
    public int size ()
    {
        return eList.size();
    }
}