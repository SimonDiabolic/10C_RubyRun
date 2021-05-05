

class Aufsammelbares
{
    final int x, y;
    
    Aufsammelbares (int px,int py)
    {
        x = px;
        y = py;
    }
    boolean Player (int xPlayer, int yPlayer)
    {  
        if ((xPlayer == x) && (yPlayer == y))
        {
            return true;   
        }
        else
        {
            return false;
        }
    }
    int getX ()
    {
        return x;
    }
    int getY ()
    {  
        return y;
    }
}