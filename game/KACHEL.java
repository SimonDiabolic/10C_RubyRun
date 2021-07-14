package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
//---------------------//
public class KACHEL
{
    private int x;
    private int y;
    private int lookid;
    private BufferedImage look;
    
    
    public KACHEL(int x, int y, int lookid)
    {
        this.x = x; 
        this.y = y;
        this.lookid = lookid;
        if(lookid == 0) {
            look = TEXTUR.ranke;
            }
        if(lookid == 1)
        { 
            look = TEXTUR.wandFuellelement;
            if(WELT.bosslevel) look = TEXTUR.WandBoss;
        }
        if(lookid == 2)
         look = TEXTUR.spawn;
        if(lookid == 3)
         look = TEXTUR.AusgangAUF;
        if(lookid == 4)
         look = TEXTUR.ranke; //Ausgang kontrolle, feld nur direkt nach AusgangAUF erreichbar, wenn player auf feld game ende
        if(lookid == 5)
         look = TEXTUR.telea;
        if(lookid == 6)
         look = TEXTUR.teleb;
        if(lookid == 7)
          look = TEXTUR.keySchlossAuf;
    }
    public void draw(Graphics g)
    {
        g.drawImage(look, x*TEXTUR.kachelgroesse, y*TEXTUR.kachelgroesse, null);
    }
    public int getLookID()
    {
        return lookid;
    }
}
