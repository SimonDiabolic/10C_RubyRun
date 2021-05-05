



// testen von Aufsammelbares
class test
{
    int x, y;
    Aufsammelbares hihi;
    test (int px, int py)
    {
        x = px;
        y = py;
        hihi = new Aufsammelbares (5, 5);
    }
    boolean lol ()
    {
        if (hihi.Player (x, y))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}