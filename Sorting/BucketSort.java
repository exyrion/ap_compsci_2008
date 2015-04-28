
/**
 * Sorts a set of 30 numbers using the bucket sort algorithm
 * 
 * Justin Liang
 * 3/2/09
 * Period 1
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BucketSort extends JComponent
{
    public int[] a = new int[30];
    public int[] b = new int[30];
    public static Rectangle[] rect = new Rectangle[30];
    public static Rectangle[] bar = new Rectangle[30];
    static Random generator = new Random();
    int digitChecker = 2;
    int count = 0;
    int k = 0;
    int c = 0;
    int s = 0;
    
    ArrayList<Integer> zero = new ArrayList<Integer>();
    ArrayList<Integer> one = new ArrayList<Integer>();
    ArrayList<Integer> two = new ArrayList<Integer>();
    ArrayList<Integer> three = new ArrayList<Integer>();
    ArrayList<Integer> four = new ArrayList<Integer>();
    ArrayList<Integer> five = new ArrayList<Integer>();
    ArrayList<Integer> six = new ArrayList<Integer>();
    ArrayList<Integer> seven = new ArrayList<Integer>();
    ArrayList<Integer> eight = new ArrayList<Integer>();
    ArrayList<Integer> nine = new ArrayList<Integer>();
    
    /**
     * Constructs the array.
     * Copies the original array a to array b.
     */
    public BucketSort()
    {
        for(int i = 0; i < 30; i++)
        {
            a[i] = generator.nextInt(50)+1;
            b[i] = a[i];
        }
    }
    
    /**
     * Helper method.
     * Checks the current value of the array to see if the algorithm is
     * on its first pass, or second.
     * @param currentValue the current value it is checking.
     * @return currentVal the value that gets sorted into the bucket
     */
    public int valueCheck(int currentValue)
    {   
        int currentVal = currentValue;
        
        if(digitChecker == 2)
            currentVal = a[k] % 10;
        else
            currentVal = a[k] / 10;
            
        return currentVal;
    }
        
    /**
     * Inserts all array a elements to the 10 ArrayList "buckets".
     */
    public void insertToBucket()
    {
        int value = 0;
        value = valueCheck(value);
        
        //inserts value in the array to the buckets
        if(value == 0)
        {
            zero.add(a[k]);
            a[k] = 0;
        }
        if(value == 1)
        {
            one.add(a[k]);
            a[k] = 0;
        }
        if(value == 2)
        {
            two.add(a[k]);
            a[k] = 0;
        }
        if(value == 3)
        {
            three.add(a[k]);
            a[k] = 0;
        }
        if(value == 4)
        {
            four.add(a[k]);
            a[k] = 0;
        }
        if(value == 5)
        {
            five.add(a[k]);
            a[k] = 0;
        }
        if(value == 6)
        {
            six.add(a[k]);
            a[k] = 0;
        }
        if(value == 7)
        {
            seven.add(a[k]);
            a[k] = 0;
        }
        if(value == 8)
        {
            eight.add(a[k]);
            a[k] = 0;
        }
        if(value == 9)
        {
            nine.add(a[k]);
            a[k] = 0;
        }
            
        k++;
    }
    
    /**
     * Inserts the elements of the 10 ArrayList or "buckets" back into
     * the original array. Also empties the "buckets" and increases the
     * swap counter by one everytime it inserts a value back to array.
     */
    public void insertToArray()
    {
        //if the bucket size is not empty, empty out the bucket
        if(zero.size() != 0)
        {
            a[c] = zero.get(0);
            zero.remove(0);
            c++; s++;
            return;
        }
        if(one.size() != 0)
        {
            a[c] = one.get(0);
            one.remove(0);
            c++; s++;
            return;
        }
        if(two.size() != 0)
        {
            a[c] = two.get(0);
            two.remove(0);
            c++; s++;
            return;
        }
        if(three.size() != 0)
        {
            a[c] = three.get(0);
            three.remove(0);
            c++; s++;
            return;
        }
        if(four.size() != 0)
        {
            a[c] = four.get(0);
            four.remove(0);
            c++; s++;
            return;
        }
        if(five.size() != 0)
        {
            a[c] = five.get(0);
            five.remove(0);
            c++; s++;
            return;
        }
        if(six.size() != 0)
        {
            a[c] = six.get(0);
            six.remove(0);
            c++; s++;
            return;
        }
        if(seven.size() != 0)
        {
            a[c] = seven.get(0);
            seven.remove(0);
            c++; s++;
            return;
        }
        if(eight.size() != 0)
        {
            a[c] = eight.get(0);
            eight.remove(0);
            c++; s++;
            return;
        }
        if(nine.size() != 0)
        {
            a[c] = nine.get(0);
            nine.remove(0);
            c++; s++;
            return;
        }
    }              
    
    /**
     * Draws the bar graph, the buckets, and other misc. objects.
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        //draws the lines
        g2.drawLine(0,200,800,200);
        g2.drawLine(0,400,800,400);
        
        //draws the bars on the bar graph
        int counter = 55;
        
        for(int i = 0; i < 30; i++)
        {
            bar[i] = new Rectangle();
            bar[i].x = counter;
            bar[i].y = 400 - a[i] * 3;
            bar[i].width = 15;
            bar[i].height = a[i] * 3;
            
            int color = 0;
            color = a[i];
            
            if(color > 0 && color <=4)
                g2.setColor(Color.RED);
            if(color > 4 && color <=9)
                g2.setColor(Color.ORANGE);
            if(color > 9 && color <=14)
                g2.setColor(Color.YELLOW);
            if(color > 14 && color <=19)
                g2.setColor(Color.GREEN);
            if(color > 19 && color <=24)
                g2.setColor(Color.CYAN);
            if(color > 24 && color <=29)
                g2.setColor(Color.BLUE);
            if(color > 29 && color <=34)
                g2.setColor(Color.PINK);
            if(color > 34 && color <=39)
                g2.setColor(Color.MAGENTA);
            if(color > 39 && color <=44)
                g2.setColor(Color.LIGHT_GRAY); 
            if(color > 44 && color <=49)
                g2.setColor(Color.DARK_GRAY);
            if(color == 50)
                g2.setColor(Color.BLACK);
            
            g2.fill(bar[i]);
            g2.setColor(Color.BLACK);
            g2.draw(bar[i]);
            
            if(a[i] != 0)
            {
                Font font = new Font("Arial", Font.BOLD, 12);
                g2.setFont(font);
                
                if(a[i] / 10 == 0)
                {
                    g2.drawString("0" + a[i] , counter+1, 390-a[i]*3);
                }
                else
                    g2.drawString("" + a[i] , counter+1, 390-a[i]*3);
            }
            
            counter = counter + 24;
        }
        
        Font font1 = new Font("Arial", Font.PLAIN, 12);
        g2.setFont(font1);
        
        //draws the values
        for(int i = 0; i < 10; i++)
        {
            g2.drawString(i + "", i*75 + 60, 215);
        }
        
        
        
        
        //draws the buckets
        for(int i = 0; i < k; i++)
        {
            g2.drawString("Bucket", 1, 215);
            g2.drawString("Values", 1, 415);
            
            
            if(zero.size() != 0)
            {
                for(int j = 0; j < zero.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 50;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    
                    int color = 0;
                    color = zero.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
            if(one.size() != 0)
            {
                for(int j = 0; j < one.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 125;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    g2.draw(rect[j]);
                    
                    
                    int color = 0;
                    color = one.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
            if(two.size() != 0)
            {
                for(int j = 0; j < two.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 200;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    g2.draw(rect[j]);
                    
                    
                    int color = 0;
                    color = two.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
            if(three.size() != 0)
            {
                for(int j = 0; j < three.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 275;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    g2.draw(rect[j]);
                    
                    
                    int color = 0;
                    color = three.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
            
            if(four.size() != 0)
            {
                for(int j = 0; j < four.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 350;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    g2.draw(rect[j]);
                    
                    
                    int color = 0;
                    color = four.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
            if(five.size() != 0)
            {
                for(int j = 0; j < five.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 425;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    g2.draw(rect[j]);
                    
                    
                    int color = 0;
                    color = five.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
            if(six.size() != 0)
            {
                for(int j = 0; j < six.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 500;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    g2.draw(rect[j]);
                    
                    
                    int color = 0;
                    color = six.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
            if(seven.size() != 0)
            {
                for(int j = 0; j < seven.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 575;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    g2.draw(rect[j]);
                    
                    
                    int color = 0;
                    color = seven.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
            if(eight.size() != 0)
            {
                for(int j = 0; j < eight.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 650;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    g2.draw(rect[j]);
                    
                    
                    int color = 0;
                    color = eight.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
            if(nine.size() != 0)
            {
                for(int j = 0; j < nine.size(); j++)
                {
                    rect[j] = new Rectangle();
                    rect[j].x = 725;
                    rect[j].y = 185 - j*15;
                    rect[j].width = 25;
                    rect[j].height = 15;
                    g2.draw(rect[j]);
                    
                    
                    int color = 0;
                    color = nine.get(j);
            
                    if(color > 0 && color <=4)
                        g2.setColor(Color.RED);
                    if(color > 4 && color <=9)
                        g2.setColor(Color.ORANGE);
                    if(color > 9 && color <=14)
                        g2.setColor(Color.YELLOW);
                    if(color > 14 && color <=19)
                        g2.setColor(Color.GREEN);
                    if(color > 19 && color <=24)
                        g2.setColor(Color.CYAN);
                    if(color > 24 && color <=29)
                        g2.setColor(Color.BLUE);
                    if(color > 29 && color <=34)
                        g2.setColor(Color.PINK);
                    if(color > 34 && color <=39)
                        g2.setColor(Color.MAGENTA);
                    if(color > 39 && color <=44)
                        g2.setColor(Color.LIGHT_GRAY); 
                    if(color > 44 && color <=49)
                        g2.setColor(Color.DARK_GRAY);
                    if(color == 50)
                        g2.setColor(Color.BLACK);
                        
                    g2.fill(rect[j]);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect[j]);
                }
            }
        }
        
        //copies original array to an array list
        //copies final array to an array list
        ArrayList<Integer> startingArrayList = new ArrayList<Integer>();
        ArrayList<Integer> finalArrayList = new ArrayList<Integer>();
        for(int i = 0; i < 30; i++)
        {
            startingArrayList.add(b[i]);
            finalArrayList.add(a[i]);
        }
        
        //displays original and final array
        Font font3 = new Font("Arial", Font.PLAIN, 13);
        g2.setFont(font3);        
        g2.drawString("The number of comparisons are: 0", 2, 475);
        g2.drawString("The number of swaps are: " + s, 2, 500);
        g2.drawString("The original numbers are: " + startingArrayList, 2, 525);
        g2.drawString("The sorted numbers are: " + finalArrayList, 2, 550);
    }
}