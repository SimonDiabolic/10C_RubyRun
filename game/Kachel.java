package game;
//---------------------//
import java.awt.image.BufferedImage;
import java.awt.Graphics;
//---------------------//
public class Kachel
{
    private int x;
    private int y;
    private int lookid;
    private boolean hasRuby;
    private BufferedImage look;
    
    
    public Kachel(int x, int y, int lookid)
    {
        this.x = x; 
        this.y = y;
        this.lookid = lookid;
        if(lookid == 0) look = Textur.ranke;
        if(lookid == 1) look = Textur.wandFuellelement;
        if(lookid == 2) look = Textur.ranke; hasRuby = true; //ist Feld das als Rubin erkannt wird aber Rankentextur hat; bekommt rubin ID für rubin spawning
        if(lookid == 3) look = Textur.spawn;
        if(lookid == 4) look = Textur.stein;
    }
    
    
    
    public void draw(Graphics g)
    {
        g.drawImage(look, x*Textur.kachelgroesse, y*Textur.kachelgroesse, null);
    }
    public int getLookID()
    {
        return lookid;
    }
}
