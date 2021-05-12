package game;
//---------------------//
import java.awt.image.*;
import java.awt.Graphics;
//---------------------//
public class Kachel
{
    private int x;
    private int y;
    private int lookid;
    private BufferedImage look;
    
    public Kachel(int x, int y, int lookid)
    {
        this.x = x;
        this.y = y;
        this.lookid = lookid;
        if(lookid == 0) look = Textur.ranke;
        if(lookid == 1) look = Textur.wandFuellelement;
    }
    public void draw(Graphics g)
    {
        g.drawImage(look, x*Textur.kachelgroesse, x*Textur.kachelgroesse, null);
    }
    public int getLookID()
    {
        return lookid;
    }
}