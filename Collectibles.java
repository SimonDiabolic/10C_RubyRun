
import java.awt.Color;

public class Collectibles
{
    final int x, y;
    final int width, height;
    final Color colour;
    
    
    
    Collectibles (int px, int py, Color pcolour)
    {
        x = px;
        y = py;
        width = 100;
        height = 100;
        colour = pcolour;
    }
    /*boolean PickUp ()
    {
     //player muss noch initialisiert werden
        if ((player.x == x)&&(player.y == y))
        {
            return true;
        }
    }*/
    public int getX ()
    {
        return x;
    }
    public int getY ()
    {
        return y;
    }
}