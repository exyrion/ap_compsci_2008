
/**
 * Represents a single box on a bingo card.
 * 
 * Justin Liang
 * Period 1
 */
import java.awt.*;
public class BingoSquare extends Rectangle
{
    public int number = 0;         //the bingo number on the square
    public boolean match;  //the status of the square
    public boolean filled;
    
    /**
     * Retrieves the number.
     * @return number the number of the square
     */
    public int getNumber()
    {
        return number;
    }
    
    /**
     * Retrieves the match status.
     * @return match the status of the square
     */
    public void getMatch()
    {
        match = false;
    }
    
    /**
     * Assigns new value for the bingo number.
     * @param newValue the new value for the number
     */
    public void setNumber(int newValue)
    {
        number = newValue;
    }
    
    /**
     * Change the status of the square.
     * @param newStatus the new status for the square
     */
    public void setMatch(boolean newStatus)
    {
        match = newStatus;
    }
    
    /**
     * Determines if the bingo square is highlighted or not
     */
    public void filled()
    {
        filled = false;
    }
    
    /**
     * Resets all values to default and sets number to 0
     * @param pressed determines whether to run the method or not, becomes true when Restart button is pressed.
     */
    public void restartPressedSquares(boolean pressed)
    {
        match = false;
        filled = false;
        number = 0;
    }
}
