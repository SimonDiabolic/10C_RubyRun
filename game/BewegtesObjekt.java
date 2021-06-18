package game;

import java.awt.image.BufferedImage;

public abstract class BewegtesObjekt
{
    protected int x;
    protected int y;
    protected BufferedImage look;
    BewegtesObjekt (int x, int y)
    {
        this.x = x * Textur.kachelgroesse;
        this.y = y * Textur.kachelgroesse;
        
    }
}
