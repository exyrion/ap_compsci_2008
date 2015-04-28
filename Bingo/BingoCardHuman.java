
/**
 * Simulates the computer playing bingo.
 * 
 * Justin Liang
 * Period 1
 */
import java.awt.*;
public class BingoCardHuman extends BingoCard
{
    public boolean isBingoHuman = false;
    
    /**
     * Checks if square is highlighted or not.
     * If highlighted, set status of square to false when clicked.
     * If not highlighted, set status of square to true when clicked.
     * @param x the x coordinate of the mouse click.
     * @param y the y coordinate of the mouse click
     */
    public void checkSquare(int x, int y)
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int k = 0; k < SIZE; k++)
            {     
                if(squares[i][k].contains(x,y) && squares[i][k].filled == false)
                {
                    squares[i][k].filled = true;
                    squares[2][2].filled = true;
                }
                
                else if(squares[i][k].contains(x,y) && squares[i][k].filled == true)
                {
                    squares[i][k].filled = false;
                    squares[2][2].filled = true;
                }
            }
        }
    }
    
    /**
     * Checks to see if any of the numbers on the bingo card matches the bingo number.
     * If it matches, sets the status of setMatch to true.
     * @param matchingValue the value that is generated
     */
    public void findMatch(int matchingValue)
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int k = 0; k < SIZE; k++)
            {
                squares[2][2].setMatch(true);
                
                if (matchingValue == squares[i][k].getNumber())
                {
                    squares[i][k].setMatch(true);
                }
            }
        }
    }
    
    /**
     * Draws the human bingo card and its numbers.
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < SIZE; i++)
        {
            for (int k = 0; k < SIZE; k++)
            {
                squares[i][k].x = 50 + (k * 50);
                squares[i][k].y = 300 + (i * 50);
                
                g2.draw(squares[i][k]);
                
                Rectangle filled = new Rectangle(squares[2][2].x+1, squares[2][2].y+1, 49,49);
                g2.setColor(Color.LIGHT_GRAY);
                g2.fill(filled);
                
                if(squares[i][k].filled == true)
                {
                    filled = new Rectangle(squares[i][k].x+1, squares[i][k].y+1, 49,49);
                    g2.setColor(Color.LIGHT_GRAY);
                    g2.fill(filled);
                }
                
                g2.setColor(Color.BLACK);
                
                int x = squares[i][k].x + 25;
                int y = squares[i][k].y + 25;
                
                if(i != 2 || k != 2)
                {
                    g2.drawString(squares[i][k].getNumber() + "", x, y);
                }
                
                /**
                 * If human player highlights 5 squares in a row and the values of the squares all match 5 of values generated,
                 * sets isBingoHuman to true.
                 */
                if(squares[i][0].filled == true && squares[i][1].filled == true && squares[i][2].filled == true && squares[i][3].filled == true && squares[i][4].filled == true && 
                   squares[i][0].match == true && squares[i][1].match == true && squares[i][2].match == true && squares[i][3].match == true && squares[i][4].match == true)
                {
                    isBingoHuman = true;
                }
                if(squares[0][k].filled == true && squares[1][k].filled == true && squares[2][k].filled == true && squares[3][k].filled == true && squares[4][k].filled == true && 
                   squares[0][k].match == true && squares[1][k].match == true && squares[2][k].match == true && squares[3][k].match == true && squares[4][k].match == true)
                {
                    isBingoHuman = true;
                }
                
                if(squares[0][0].filled == true && squares[1][1].filled == true && squares[2][2].filled == true && squares[3][3].filled == true && squares[4][4].filled == true && 
                   squares[0][0].match == true && squares[1][1].match == true && squares[2][2].match == true && squares[3][3].match == true && squares[4][4].match == true)
                {
                    isBingoHuman = true;
                }
                if(squares[0][4].filled == true && squares[1][3].filled == true && squares[2][2].filled == true && squares[3][1].filled == true && squares[4][0].filled == true && 
                   squares[0][4].match == true && squares[1][3].match == true && squares[2][2].match == true && squares[3][1].match == true && squares[4][0].match == true)
                {
                    isBingoHuman = true;
                }
            }
        }
    }
    
    /**
     * Checks if human player won bingo
     * @return returns true if human player won bingo
     */
    public boolean checkBingoH()
    {
        if(isBingoHuman == true)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Resets and regenerate new numbers for all values of human bingo squares
     * Unhighlights all the human bingo squares
     * @param pressed determines whether to run the method or not, becomes true when Restart button is pressed.
     */
    public void restartPressedHuman(boolean pressed)
    {
        if(pressed == true)
        {
            for (int i = 0; i < SIZE; i++)
            {
                for (int k = 0; k < SIZE; k++)
                {
                    squares[i][k].filled = false;
                    squares[i][k].setMatch(false);
                }
            }
            isBingoHuman = false;
        }
    }   
}