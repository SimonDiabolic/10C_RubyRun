package game;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.LinkedList;

public abstract class BewegtesObjekt
{
    protected int x;
    protected int y;
    protected int oldx;
    protected int oldy;
    protected BufferedImage look;
    protected LinkedList<BewegtesObjekt> other;
    BewegtesObjekt (int x, int y)
    {
        this.x = x * Textur.kachelgroesse;
        this.y = y * Textur.kachelgroesse;
    }
    public int getX() { return x; }
    public int getY() { return y; }
    public void setOther(LinkedList<BewegtesObjekt> o)
    {
        other = o;
    }
    public void update()
    {  
        int nextx = x / Textur.kachelgroesse ;
        int nexty = y / Textur.kachelgroesse + 1;
        if(Welt.kacheln[nextx] [nexty].getLookID() == 0 )
        {
            boolean moveok = true;
            for (BewegtesObjekt i : other) {
                if (nextx == i.getX() / Textur.kachelgroesse && 
                    nexty == i.getY() / Textur.kachelgroesse) {
                    moveok = false;
                }
            }
            if (moveok)
                y = nexty * Textur.kachelgroesse;
        } 
 
    }
    public void resetPosition()
    {
     // x=oldx;
     // y=oldy;
    }
    public boolean RubinCollection(){return false;}
    //public void fallen(){y = y + Textur.kachelgroesse;}
    public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
}
