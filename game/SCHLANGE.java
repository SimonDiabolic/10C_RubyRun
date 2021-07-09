    package game;
    import java.awt.image.BufferedImage;
    import java.awt.Graphics;
    import java.util.LinkedList;
    
    public class SCHLANGE extends BEWEGTESOBJEKT
    {
        int bewegungsrichtung;
        char coodaxis;
        SCHLANGE (int x, int y, char coodaxis)
        {
            super(x,y);
            this.coodaxis = coodaxis;
            look = TEXTUR.schlange;
            bewegungsrichtung = 1;
            type = 'z'; // z für zisch
        }
        public void update()
        {   
            SchlangeBewegung();
        }
        public void draw(Graphics g)
        {
         g.drawImage(look, x, y, null);
        }
        public int getSchlangeX() { return x; }
        public int getSchlangeY() { return y; }
        public boolean SchlangeSchlaegtSpieler()
        {
            if (COLLISION.RechteckZuRechteck(SPIELER.getXPos(),SPIELER.getYPos(),10,10,x,y,10,10))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public void SchlangeBewegung()
        {
                    
        if (coodaxis == 'x')
        
        {
        int nextx = x / TEXTUR.kachelgroesse + bewegungsrichtung;
        int nexty = y / TEXTUR.kachelgroesse ;
                
        if(bewegungsrichtung == -1 && x % TEXTUR.kachelgroesse != 0)
        {
            nextx++;
        }
        
        boolean moveok = false;
        if(WELT.kacheln[nextx] [nexty].getLookID() == 0)
            {
                moveok = true;
               for (BEWEGTESOBJEKT i : other) {
                    if (nextx == i.getX()/TEXTUR.kachelgroesse && 
                        nexty == i.getY()/TEXTUR.kachelgroesse && this != i)  {
                        moveok = false;
                    }
                }
            } 
        if(moveok)
            {
                x = x + 10*bewegungsrichtung;
            }
            else
            {
                bewegungsrichtung = bewegungsrichtung*-1;
            }
        }
        if (coodaxis == 'y')
        {
        int nextx = x / TEXTUR.kachelgroesse ;
        int nexty = y / TEXTUR.kachelgroesse + bewegungsrichtung;
        if(bewegungsrichtung == -1 && y % TEXTUR.kachelgroesse != 0)
        {
            nexty++;
        }
        boolean moveok = false;
        if(WELT.kacheln[nextx] [nexty].getLookID() == 0 )
            {
                moveok = true;
                for (BEWEGTESOBJEKT i : other) {
                    if (nextx == i.getX()/TEXTUR.kachelgroesse && 
                        nexty == i.getY()/TEXTUR.kachelgroesse && this != i)  {
                        moveok = false;
                    }
                }             
            } 
        if(moveok)
            {
                y = y + 10*bewegungsrichtung;
            }
            else
            {
                bewegungsrichtung = bewegungsrichtung*-1;
            }
        
         
        }
        }
        public boolean isteseineSchlange()
        {
            return true;
        }
        
           
}


    
    
    
    
    

