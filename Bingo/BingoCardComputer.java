
/**
 * Simulates the computer playing bingo.
 * 
 * Justin Liang
 * Period 1
 */
import java.awt.*;
public class BingoCardComputer extends BingoCard 
{
    public boolean isBingoComputer = false;
    
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
     * Draws the computer bingo card and its numbers
     * If setMatch of a square is true, automatically highlights the square
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < SIZE; i++)
        {
            for (int k = 0; k < SIZE; k++)
            {
                squares[i][k].x = 500 + (k * 50);
                squares[i][k].y = 300 + (i * 50);
                
                g2.draw(squares[i][k]);
                if (squares[i][k].match == true)
                {
                    Rectangle filled = new Rectangle(squares[i][k].x+1,squares[i][k].y+1, 49,49);
                    g2.draw(filled);
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
                 * If computer player has 5 in a row and the values of the squares all match 5 of values generated,
                 * sets isBingoHuman to true.
                 */
                if(squares[i][0].match == true && squares[i][1].match == true && squares[i][2].match == true && squares[i][3].match == true && squares[i][4].match == true)
                {
                    isBingoComputer = true;
                }
                if(squares[0][k].match == true && squares[1][k].match == true && squares[2][k].match == true && squares[3][k].match == true && squares[4][k].match == true)
                {
                    isBingoComputer = true;
                }
                
                if(squares[0][0].match == true && squares[1][1].match == true && squares[2][2].match == true && squares[3][3].match == true && squares[4][4].match == true)
                {
                    isBingoComputer = true;
                }
                if(squares[0][4].match == true && squares[1][3].match == true && squares[2][2].match == true && squares[3][1].match == true && squares[4][0].match == true)
                {
                    isBingoComputer = true;
                }
            }
        }
    }
    
    /**
     * Checks if computer player won bingo
     * @return returns true if computer player won bingo
     */
    public boolean checkBingoC()
    {
        if(isBingoComputer == true)
        {
            return true;
        }
        return false;
    }
    /**
     * Resets and regenerate new numbers for all values of computer bingo squares
     * Unhighlights all the computer bingo squares
     * @param pressed determines whether to run the method or not, becomes true when Restart button is pressed.
     */
    public void restartPressedComputer(boolean pressed)
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int k = 0; k < SIZE; k++)
            {
                squares[i][k].match = false;
                squares[i][k].setMatch(false);
            }
        }
        isBingoComputer = false;
    }
}
