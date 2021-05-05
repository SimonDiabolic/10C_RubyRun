public abstract class feld
{
    int feldKoordinate;
    
    feld(int feldKoordinate)
    {
        this.feldKoordinate=feldKoordinate;
    }
    public abstract boolean IstFeldBesetzt();
    public abstract Piece getPiece();
    public static final class feldLeer extends feld
    {
     feldLeer(int Koordinate)
     {
        super(Koordinate);
     }
     @Override public boolean IstFeldBesetzt()
     {
        return false;
     }
     @Override public Piece getPiece()
     {
        return null;
     }
    }
     public static final class feldBesetzt extends feld
    {
     Piece pieceOnTile;
     feldBesetzt(int feldKoordinate, Piece pieceOnTile) 
     {
            super(feldKoordinate);
            this.pieceOnTile = pieceOnTile;
            
     }
     @Override public boolean IstFeldBesetzt()
     {
        return true;
     }
     @Override public Piece getPiece()
     {
        return this.pieceOnTile;
     }   
    }
}