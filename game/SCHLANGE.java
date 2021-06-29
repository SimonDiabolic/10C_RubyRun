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
        int nextx = x / TEXTUR.kachelgroesse ;
        int nexty = y / TEXTUR.kachelgroesse + bewegungsrichtung;
        if (coodaxis == 'x')
        {
            nextx = x / TEXTUR.kachelgroesse + bewegungsrichtung - 1;
        }
        else if (coodaxis == 'x')
        {
            nexty = y / TEXTUR.kachelgroesse + bewegungsrichtung - 1;
        }
        boolean moveok = false;
        if(WELT.kacheln[nextx] [nexty].getLookID() == 0 )
            {
                moveok = true;
                for (BEWEGTESOBJEKT i : other) {
                    if (nextx == i.getX() / TEXTUR.kachelgroesse && 
                        nexty == i.getY() / TEXTUR.kachelgroesse )  {
                        moveok = false;
                    }
                }             
            } 
        if (moveok)
        {
            if (coodaxis == 'y') {y = y + 10*bewegungsrichtung;}
                else if (coodaxis == 'y') {y = y + 10*bewegungsrichtung;}
        }
        else    
                bewegungsrichtung = bewegungsrichtung * -1;

        }
        public boolean isteseineSchlange()
        {
            return true;
        }
}


    
    
    
    
    

