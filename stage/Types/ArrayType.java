package Types;

public class ArrayType extends Type
{
    public Type type;
    public int index;

    public String toString()
    {
        return type.toString() + "[" + index + "]";
    }
}