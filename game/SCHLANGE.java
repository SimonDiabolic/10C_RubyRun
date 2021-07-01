    package game;
    import java.awt.image.BufferedImage;
    import java.awt.Graphics;
    import java.util.LinkedList;
    import java.util.Timer;
import java.util.TimerTask;
    
    public class SCHLANGE extends BEWEGTESOBJEKT
    {
        int bewegungsrichtung;
        char coodaxis;
        int leftx = x/TEXTUR.kachelgroesse - 1;
        int rightx = x/TEXTUR.kachelgroesse + 1;
        private boolean linksWand;
        private boolean rechtsWand;
        SCHLANGE (int x, int y, char coodaxis)
        {
            super(x,y);
            this.coodaxis = coodaxis;
            look = TEXTUR.schlange;
            bewegungsrichtung = 1;
            type = 'z';
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
            if ((getX()==SPIELER.getXPos()) && (getY()==SPIELER.getYPos()))
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
        
        boolean moveok = false;
        if(WELT.kacheln[nextx] [nexty].getLookID() == 0  
            )
            {
                moveok = true;
                for (BEWEGTESOBJEKT i : other) {
                    if (nextx == i.getX()/TEXTUR.kachelgroesse&& 
                        nexty == i.getY()/TEXTUR.kachelgroesse)  {
                        moveok = false;
                    }
                }
            } 
        if(moveok)
            {
                            
                        x = x + 40*bewegungsrichtung;
                    
                
                
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
        boolean moveok = false;
        if(WELT.kacheln[nextx] [nexty].getLookID() == 0 )
            {
                moveok = true;
                for (BEWEGTESOBJEKT i : other) {
                    if (nextx == i.getX()/TEXTUR.kachelgroesse&& 
                        nexty == i.getY()/TEXTUR.kachelgroesse)  {
                        moveok = false;
                    }
                }             
            } 
        if(moveok)
            {
                y = y + 40*bewegungsrichtung;
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


    
    
    
    
    

