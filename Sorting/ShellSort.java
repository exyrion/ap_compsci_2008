
/**
 * Uses shell sort method to sort 30 random integers between 1 and 50
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.*;

public class ShellSort extends JComponent
{
    private int[] data = new int[30];
    public static int[] originalData = new int[30];
    int l = 0;
    
    /**
     * Sets array 
     * 
     * @param value value of array
     */
    public void insert(int value)
    {
        data[l] = value;
        originalData[l] = value;
        l++;
    }
    
    /**
     * Displays the data values
     */
    public void display() 
    {
        System.out.print("Data:");
        for (int j = 0; j < l; j++)
        {
            System.out.print(data[j] + " ");
        }
        System.out.println("");
    }
    
    /**
     * Sorts the data values
     */
    public void shellSort() throws InterruptedException
    {
        int inner, outer;
        int temp;
       
        int h = 1;
        while (h <= l / 3)
        h = h * 3 + 1; 

        while (h > 0) 
        {
           
            for (outer = h; outer < l; outer++) 
            {
                temp = data[outer];
                inner = outer;
                
                while (inner > h - 1 && data[inner - h] >= temp) 
                {
                    data[inner] = data[inner - h];
                    inner -= h;
                    Thread.sleep(250);
                    repaint();
                }
                data[inner] = temp;
               
            }
            h = (h - 1) / 3; 
            
        }
    }
    
    /**
     * Draws the rectangles
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        for(int i = 0; i < data.length; i++)
        {
            Rectangle r = new Rectangle(20+15*i, 300-originalData[i]*3, 10, originalData[i]*3);
            g2.draw(r);
            g2.setColor(Color.BLACK);
            g2.fill(r);
        }
        for(int i = 0; i < data.length; i++)
        {
            Rectangle r = new Rectangle(20+15*i, 500-data[i]*3, 10, data[i]*3);
            g2.draw(r);
            g2.setColor(Color.MAGENTA);
            g2.fill(r);
        }
            
    }
    
    /**
     * Runs the whole program 
     */
    public static void main(String[] args) throws InterruptedException
    {
        ShellSort arr = new ShellSort();
        
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.add(arr);
        frame.setVisible(true);

        for (int j = 0; j < 30; j++)
        {
            int n = (int) (java.lang.Math.random() * 50)+1;
            arr.insert(n);
            arr.originalData[j] = n;
        }
        arr.display();
        arr.shellSort();
        arr.display();
        
        frame.setDefaultCloseOperation(3);
    }
}

