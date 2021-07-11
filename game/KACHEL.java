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
    
    
    public KACHEL(int x, int y, int lookid, boolean BossLevel)
    {
        this.x = x; 
        this.y = y;
        this.lookid = lookid;
        if(lookid == 0) {
                if (BossLevel) look = TEXTUR.WegBoss;
                else look = TEXTUR.ranke;
            }
        if(lookid == 1){ 
            if (BossLevel) look = TEXTUR.WandBoss;
            else look = TEXTUR.wandFuellelement;}
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
