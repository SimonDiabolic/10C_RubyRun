package game;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.LinkedList;

public abstract class BEWEGTESOBJEKT
{
    protected int x;
    protected int y;
    protected int oldx; 
    protected int oldy;
    protected BufferedImage look;
    protected static LinkedList<BEWEGTESOBJEKT> other;
    protected static char type; //s für stein, r für rubin, b für busch
    BEWEGTESOBJEKT (int x, int y)
    {
        this.x = x * TEXTUR.kachelgroesse;
        this.y = y * TEXTUR.kachelgroesse;
    }
    public int getX() { return x; }
    public int getY() { return y; }
    public void setOther(LinkedList<BEWEGTESOBJEKT> o)
    {
        other = o;
    }
    public void update()
    {  
        int nextx = x / TEXTUR.kachelgroesse ;
        int nexty = y / TEXTUR.kachelgroesse + 1;
        if(WELT.kacheln[nextx] [nexty].getLookID() == 0 )
        {
            boolean moveok = true;
            for (BEWEGTESOBJEKT i : other) {
                 if (nextx == i.getX() / TEXTUR.kachelgroesse && 
                    nexty == i.getY() / TEXTUR.kachelgroesse) {
                    moveok = false;
                }
            }
            if (moveok)
                y = y+20;//nexty * Textur.kachelgroesse;
        } 
 
    }   
    public boolean RubinCollection(){return false;}
    public boolean BuschDecay(){return false;}
    public boolean SpielerAufStein(){return false;}
    public boolean SaphirCollection(){return false;}
    public boolean SchlangeSchlaegtSpieler(){return false;}
    public char getType () {return type;}
    public void draw(Graphics g)
    {
     g.drawImage(look, x, y, null);
    }
    public boolean isteseineSchlange()
    {
        return false;
    }
    public BEWEGTESOBJEKT SteinAufSchlange()
    {
        return null;
    }
}
