package Types;

public class ArrayType extends Type
{
    public Type type;
    public int size;

    public String toString()
    {
        return type.toString() + "[" + size + "]";
    }
}