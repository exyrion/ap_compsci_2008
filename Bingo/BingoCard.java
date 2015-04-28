
/**
 * A bingo card with 25 BingoSquares.
 * 
 * Justin Liang
 * Period 1
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class BingoCard extends JComponent
{
    public boolean restartPressedCard = false;
    final protected int SIZE = 5;
    public BingoSquare[][] squares = new BingoSquare[SIZE][SIZE];
        
    Random generator1 = new Random();
    Random generator2 = new Random();
    Random generator3 = new Random();
    Random generator4 = new Random();
    Random generator5 = new Random();
    
    int newNumber1 = generator1.nextInt(16)+1;
    int newNumber2 = generator2.nextInt(16)+17;
    int newNumber3 = generator3.nextInt(16)+33;
    int newNumber4 = generator4.nextInt(16)+48;
    int newNumber5 = generator5.nextInt(16)+63;
        
        
    /**
     * Constructor
     */
    public BingoCard()
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int k = 0; k < SIZE; k++)
            {
                squares[i][k] = new BingoSquare();
                squares[i][k].x = 0;
                squares[i][k].y = 0;
                squares[i][k].height = 50;
                squares[i][k].width = 50;
            }
        }
    }
    
    /**
     * Looks for the value inside the array
     * @param value the value we are searching for
     * @return true if the value is inside the array
     */
    private boolean isExisted(int value)
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int k = 0; k < SIZE; k++)
            {
                if (value == squares[i][k].getNumber())
                    return true;
             }
        }
        return false;
    }
    
    /**
     * Draws the miscellenaous objects such as the lines and the heading.
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawLine(0,65,800,65);
        g2.drawLine(0,150,800,150);

        Rectangle numberBox = new Rectangle(370,300,60,60);
        g2.draw(numberBox);
        
        Font font = new Font("Arial", Font.BOLD, 20);
        g2.setFont(font);
        g2.drawString("Human", 140, 240);
        g2.drawString("Computer", 580, 240);
        
        font = new Font("Arial", Font.BOLD, 40);
        g2.setFont(font);
        g2.drawString("B", 60, 290);
        g2.drawString("I", 120, 290);
        g2.drawString("N", 160, 290);
        g2.drawString("G", 210, 290);
        g2.drawString("O", 260, 290);        
        g2.drawString("B", 510, 290);
        g2.drawString("I", 570, 290);
        g2.drawString("N", 610, 290);
        g2.drawString("G", 660, 290);
        g2.drawString("O", 710, 290);
    }
    
    /**
     * Assigns values to the bingo squares
     */
    public void assignValues()
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int k = 0; k < SIZE; k++)
            {
                boolean found = false;
                while (!found)
                {
                    newNumber1 = generator1.nextInt(16)+1;
                    newNumber2 = generator2.nextInt(16)+17;
                    newNumber3 = generator3.nextInt(16)+33;
                    newNumber4 = generator4.nextInt(16)+48;
                    newNumber5 = generator5.nextInt(16)+63;
                    
                    if (!isExisted(newNumber1))
                    {
                        squares[i][0].setNumber(newNumber1);
                        found = true;
                    }
                    if (!isExisted(newNumber2))
                    {
                        squares[i][1].setNumber(newNumber2);
                        found = true;
                    }
                    if (!isExisted(newNumber3))
                    {
                        squares[i][2].setNumber(newNumber3);
                        found = true;
                    }
                    if (!isExisted(newNumber4))
                    {
                        squares[i][3].setNumber(newNumber4);
                        found = true;
                    }
                    if (!isExisted(newNumber5))
                    {
                        squares[i][4].setNumber(newNumber5);
                        found = true;
                    }
                }
            }
        }
        squares[2][2].setNumber(0);
        squares[2][2].filled = true;
    }
    
    /**
     * Resets all the numbers in the bingo cards and generates new numbers for each square.
     * @param pressed determines whether to run the method or not, becomes true when Restart button is pressed.
     */
    public void restartPressedCard(boolean pressed)
    {
        if(restartPressedCard == true)
        {
            for (int i = 0; i < SIZE; i++)
            {
                for (int k = 0; k < SIZE; k++)
                {
                    int zero = 0;
                    zero = squares[i][k].getNumber();
                    
                    boolean found = false;
                    while (!found)
                    {
                        int newNumber1 = generator1.nextInt(16)+1;
                        int newNumber2 = generator2.nextInt(16)+17;
                        int newNumber3 = generator3.nextInt(16)+33;
                        int newNumber4 = generator4.nextInt(16)+48;
                        int newNumber5 = generator5.nextInt(16)+63;
                    
                        if (!isExisted(newNumber1))
                        {
                            squares[i][0].setNumber(newNumber1);
                            found = true;
                        }
                        if (!isExisted(newNumber2))
                        {
                            squares[i][1].setNumber(newNumber2);
                            found = true;
                        }
                        if (!isExisted(newNumber3))
                        {
                            squares[i][2].setNumber(newNumber3);
                            found = true;
                        }
                        if (!isExisted(newNumber4))
                        {   
                            squares[i][3].setNumber(newNumber4);
                            found = true;
                        }
                        if (!isExisted(newNumber5))
                        {
                            squares[i][4].setNumber(newNumber5);
                            found = true;
                        }
                    }
                }
            }
        }
    }
}
