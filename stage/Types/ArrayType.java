package Types;

public class ArrayType extends Type
{
    public Type type;
    public int size;

    public ArrayType(Type t, int s)
    {
        type = t;
        size = s;
    }

    public String toString()
    {
        return type.toString() + "[" + size + "]";
    }
}