
/**
 * Generates 78 random numbers and displays it on the frame.
 * 
 * Justin Liang
 * Period 1
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class BingoNumbers extends JComponent
{
    Random generator = new Random();
    int newValue = 0;
    public boolean restartPressedNumbers = false;
    protected static int[] numbers = new int[78];  //stores all the bingo numbers
    int i = 0;
    int count = 0;
    
    /**
     * Gets the last number in the array.
     * @return returns the last number in the array.
     */
    public int getLastNumber()
    {
        return numbers[count - 1];
    }
    
    /**
     * Goes through the array and look for the value
     * @param value the value we are searching for
     * @return true if the value is in the array
     */
    private boolean isExisted(int value)
    {
        for (int i = 0; i < count; i++)
        {
            if (value == numbers[i])
                return true;
        }
        return false;
    }
    
    /**
     * Generates a random number and stores it into the array
     */
    public void generateNumber()
    {
        boolean found = false;   //exit the loop if we found a new #
        while(!found)
        {
            newValue = generator.nextInt(78) + 1;
            if (!isExisted(newValue))
            {
                numbers[count] = newValue;
                count++;
                found = true;
            }
        }
        repaint();
    }
    
    /**
     * Displays the numbers
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        Font font = new Font("Arial", Font.BOLD, 12);
        g2.setFont(font);
        
        for (int i = 0; i < count; i++)
        {
            if (i == count - 1)   //the last non-zero in the array
            {
                font = new Font("Comic Sans", Font.BOLD, 40);
                g2.setFont(font);
                g2.setColor(Color.BLUE);
                g2.drawString(numbers[i] + "", 380, 345);
            }
            
            font = new Font("Arial", Font.BOLD, 12);
            g2.setColor(Color.BLACK);
            g2.setFont(font);
            
            if (i >= 0 && i <= 38)
            {             
                g2.drawString(numbers[i] + "", i * 20 , 100);
            }
            else if (i >= 39 && i <= 79)
            {
                g2.drawString(numbers[i] + "", (i - 40) * 20 , 125);
            }
        }
    }
    
    /**
     * Set count back to 0 when restart button is pressed.
     */
    public void restartPressedBingo()
    {
        count = 0;
    }
}
