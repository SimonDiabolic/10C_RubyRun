package game;

public class Collision
{
    public static boolean RechteckZuRechteck(float rect1x, float rect1y, int width1, int height1,
                float rect2x, float rect2y, int width2, int height2)
        {
            if(rect1x <= rect2x + width2 && rect1x + width1 >= rect2x &&
               rect1y <= rect2y + height2 && rect1y + height1 >= rect2y) return true;
            return false;
        }
}
