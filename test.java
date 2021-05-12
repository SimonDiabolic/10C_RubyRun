



// testen von Aufsammelbares
class test
{
    int x, y;
    Keys hihi;
    test (int px, int py)
    {
        x = px;
        y = py;
        hihi = new Keys (5, 5);
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