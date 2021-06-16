package game;

public abstract class BewegtesObjekt
{
    public int X;
    public int Y;
    
    BewegtesObjekt (int X, int Y)
    {
        this.X = X * Textur.kachelgroesse;
        this.Y = Y * Textur.kachelgroesse;
        
    }
}
