
/**
 * Represents a square(seat) on the graphic.
 * 
 * Justin Liang && Michael Lam
 * Period 1
 * CompSci AP
 * Luc
 * February 19, 2009
 */

import java.awt.*;

public class Seat extends Rectangle
{
    public boolean clicked;

    /**
     * Constructor for objects of class Seat.
     */
    public Seat()
    {
        clicked = false;
        x = 0;
        y = 0;
        height = 25;
        width = 25;
    }
    
    
    /**
     * Retrieves the value of clicked
     * @return clicked returns true or false
     */
    public boolean getClicked()
    {
        return clicked;
    }
    
    /**
     * Changes clicked to true or false
     * @param input the new boolean value
     */
    public void changeClicked(boolean input)
    {
        clicked = input;
    }
}
