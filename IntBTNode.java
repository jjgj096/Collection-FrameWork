public class IntBTNode
{

    private int data;
    private IntBTNode left, right;


    public IntBTNode(int initialData, IntBTNode initialLeft, IntBTNode initialRight)
    {
        data = initialData;
        left = initialLeft;
        right = initialRight;
    }

    public int getData( )
    {
        return data;
    }

    public IntBTNode getLeft( )
    {
        return left;
    }

    public int getLeftmostData( )
    {
        if (left == null)
            return data;
        else
            return left.getLeftmostData( );
    }

    public int getRightmostData( )
    {
        if (right == null)
            return data;
        else
            return right.getRightmostData( );
    }

    public IntBTNode getRight( )
    {
        return right;
    }

    public IntBTNode removeLeftmost( )
    {
        if (left == null)
            return right;
        else
        {
            left = left.removeLeftmost( );
            return this;
        }
    }

    public IntBTNode removeRightmost( )
    {
        if (right == null)
            return left;
        else
            return right.removeRightmost( );
    }

    public void setData(int newData)
    {
        data = newData;
    }

    public void setLeft(IntBTNode newLeft)
    {
        left = newLeft;
    }

    public void setRight(IntBTNode newRight)
    {
        right = newRight;
    }

    final int PRE_ORDER = 0;
    final int IN_ORDER = 1;
    final int POST_ORDER = 2;

    public void travel(IntBTNode cursor, int travelType){

        if(travelType == PRE_ORDER){
            System.out.println(cursor.data);
        }
        travel(cursor.left);
        if(travelType == IN_ORDER){
            System.out.println(cursor.data);
        }
        travel(cursor.right);
        if(travelType == POST_ORDER){
            System.out.println(cursor.data);
        }

    }

}
