
/**
 * Write a description of class BucketSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BucketSort2 extends JComponent
{
    public static int[] a = new int[30];
    public static int[] b = new int[30];
    public int currentValue = 0;
    static Random generator = new Random();
    int count = 0;
    
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
     */
    public void makeArray()
    {
        for(int i = 0; i < a.length; i++)
        {
            a[i] = generator.nextInt(50)+1;
        }
    }
    
    /**
     * Inserts all array a elements to the 10 ArrayList "buckets".
     * This method is the first pass, sorting by ones digit only.
     */
    public void insertToBucket()
    {
        for(int i = 0; i < a.length; i++)
        {
            b[i] = a[i];
            if(a[i] % 10 == 0)
                zero.add(a[i]);
            if(a[i] % 10 == 1)
                one.add(a[i]);
            if(a[i] % 10 == 2)
                two.add(a[i]);
            if(a[i] % 10 == 3)
                three.add(a[i]);
            if(a[i] % 10 == 4)
                four.add(a[i]);
            if(a[i] % 10 == 5)
                five.add(a[i]);
            if(a[i] % 10 == 6)
                six.add(a[i]);
            if(a[i] % 10 == 7)
                seven.add(a[i]);
            if(a[i] % 10 == 8)
                eight.add(a[i]);
            if(a[i] % 10 == 9)
                nine.add(a[i]);
        }        
    }
    
    /**
     * Inserts the elements of the 10 ArrayList or "buckets" back into
     * the original array. Also empties the "buckets".
     */
    public void insertToArray()
    {
        int count = 0;
        while(count < 30)
        {
            for(int i = 0; i < zero.size(); i++)
            {
                a[count] = zero.get(i);
                count++;
            }
            for(int i = 0; i < one.size(); i++)
            {
                a[count] = one.get(i);
                count++;
            }
            for(int i = 0; i < two.size(); i++)
            {
                a[count] = two.get(i);
                count++;
            }
            for(int i = 0; i < three.size(); i++)
            {
                a[count] = three.get(i);
                count++;
            }
            for(int i = 0; i < four.size(); i++)
            {
                a[count] = four.get(i);
                count++;
            }
            for(int i = 0; i < five.size(); i++)
            {
                a[count] = five.get(i);
                count++;
            }
            for(int i = 0; i < six.size(); i++)
            {
                a[count] = six.get(i);
                count++;
            }
            for(int i = 0; i < seven.size(); i++)
            {
                a[count] = seven.get(i);
                count++;
            }
            for(int i = 0; i < eight.size(); i++)
            {
                a[count] = eight.get(i);
                count++;
            }
            for(int i = 0; i < nine.size(); i++)
            {
                a[count] = nine.get(i);
                count++;
            }
        }
        
        //clears the buckets
        zero.clear();
        one.clear();
        two.clear();
        three.clear();
        four.clear();
        five.clear();
        six.clear();
        seven.clear();
        eight.clear();
        nine.clear();
    }
    
    /**
     * Inserts all array a elements to the 10 ArrayList "buckets".
     * This method is the second pass, sorting by tens digit only.
     */
    public void insertToBucket2()
    {
        for(int i = 0; i < a.length; i++)
        {
            
            int temp = a[i];            
            if(temp / 10 == 0)
                zero.add(a[i]);
            if(temp / 10 == 1)
                one.add(a[i]);
            if(temp / 10 == 2)
                two.add(a[i]);
            if(temp / 10 == 3)
                three.add(a[i]);
            if(temp / 10 == 4)
                four.add(a[i]);
            if(temp / 10 == 5)
                five.add(a[i]);
            if(temp / 10 == 6)
                six.add(a[i]);
            if(temp / 10 == 7)
                seven.add(a[i]);
            if(temp / 10 == 8)
                eight.add(a[i]);
            if(temp / 10 == 9)
                nine.add(a[i]);
        }
    }
    
    /**
     * Inserts the elements of the 10 ArrayList or "buckets" back into
     * the original array.
     */
    public void insertToArray2()
    {
        int count = 0;
        while(count < 30)
        {
            for(int i = 0; i < zero.size(); i++)
            {
                a[count] = zero.get(i);
                count++;
            }
            for(int i = 0; i < one.size(); i++)
            {
                a[count] = one.get(i);
                count++;
            }
            for(int i = 0; i < two.size(); i++)
            {
                a[count] = two.get(i);
                count++;
            }
            for(int i = 0; i < three.size(); i++)
            {
                a[count] = three.get(i);
                count++;
            }
            for(int i = 0; i < four.size(); i++)
            {
                a[count] = four.get(i);
                count++;
            }
            for(int i = 0; i < five.size(); i++)
            {
                a[count] = five.get(i);
                count++;
            }
            for(int i = 0; i < six.size(); i++)
            {
                a[count] = six.get(i);
                count++;
            }
            for(int i = 0; i < seven.size(); i++)
            {
                a[count] = seven.get(i);
                count++;
            }
            for(int i = 0; i < eight.size(); i++)
            {
                a[count] = eight.get(i);
                count++;
            }
            for(int i = 0; i < nine.size(); i++)
            {
                a[count] = nine.get(i);
                count++;
            }
        }
    }
    
    /**
     * Draws the diagram.
     * Note: Example only, no animation yet.
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawLine(0,150,525,150);
        g2.drawLine(0,350,525,350);
        g2.drawLine(0,550,525,550);
        g2.drawLine(0,750,525,750);
        
        int count0 = 140;
        int count1 = 140;
        int count2 = 140;
        int count3 = 140;
        int count4 = 140;
        int count5 = 140;
        int count6 = 140;
        int count7 = 140;
        int count8 = 140;
        int count9 = 140;
        
        for(int i = 0; i < b.length; i++)
        {
            if(a[i] % 10 == 0)
            {
                Rectangle r0 = new Rectangle(25,count0,20,10);
                g2.draw(r0);
                count0 = count0 - 10;
            }
            if(a[i] % 10 == 1)
            {
                Rectangle r1 = new Rectangle(75,count1,20,10);
                g2.draw(r1);
                count1 = count1 - 10;
            }
            if(a[i] % 10 == 2)
            {
                Rectangle r2 = new Rectangle(125,count2,20,10);
                g2.draw(r2);
                count2 = count2 - 10;
            }
            if(a[i] % 10 == 3)
            {
                Rectangle r3 = new Rectangle(175,count3,20,10);
                g2.draw(r3);
                count3 = count3 - 10;
            }
            if(a[i] % 10 == 4)
            {
                Rectangle r4 = new Rectangle(225,count4,20,10);
                g2.draw(r4);
                count4 = count4 - 10;
            }
            if(a[i] % 10 == 5)
            {
                Rectangle r5 = new Rectangle(275,count5,20,10);
                g2.draw(r5);
                count5 = count5 - 10;
            }
            if(a[i] % 10 == 6)
            {
                Rectangle r6 = new Rectangle(325,count6,20,10);
                g2.draw(r6);
                count6 = count6 - 10;
            }
            if(a[i] % 10 == 7)
            {
                Rectangle r7 = new Rectangle(375,count7,20,10);
                g2.draw(r7);
                count7 = count7 - 10;
            }
            if(a[i] % 10 == 8)
            {
                Rectangle r8 = new Rectangle(425,count8,20,10);
                g2.draw(r8);
                count8 = count8 - 10;
            }
            if(a[i] % 10 == 9)
            {
                Rectangle r9 = new Rectangle(475,count9,20,10);
                g2.draw(r9);
                count9 = count9 - 10;
            }
        }
        int counter1 = 30;
        for(int i = 0; i < b.length; i++)
        {
            Rectangle r = new Rectangle(counter1, 350 - b[i]*3, 10, b[i]*3);
            g2.draw(r);
            g2.drawString(b[i] + "", counter1, 370);
            counter1 = counter1 + 15;
        }
        
        int count01 = 540;
        int count11 = 540;
        int count21 = 540;
        int count31 = 540;
        int count41 = 540;
        int count51 = 540;
        int count61 = 540;
        int count71 = 540;
        int count81 = 540;
        int count91 = 540;
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] / 10 == 0)
            {
                Rectangle r0 = new Rectangle(25,count01,20,10);
                g2.draw(r0);
                count01 = count01 - 10;
            }
            if(a[i] / 10 == 1)
            {
                Rectangle r1 = new Rectangle(75,count11,20,10);
                g2.draw(r1);
                count11 = count11 - 10;
            }
            if(a[i] / 10 == 2)
            {
                Rectangle r2 = new Rectangle(125,count21,20,10);
                g2.draw(r2);
                count21 = count21 - 10;
            }
            if(a[i] / 10 == 3)
            {
                Rectangle r3 = new Rectangle(175,count31,20,10);
                g2.draw(r3);
                count31 = count31 - 10;
            }
            if(a[i] / 10 == 4)
            {
                Rectangle r4 = new Rectangle(225,count41,20,10);
                g2.draw(r4);
                count41 = count41 - 10;
            }
            if(a[i] / 10 == 5)
            {
                Rectangle r5 = new Rectangle(275,count51,20,10);
                g2.draw(r5);
                count51 = count51 - 10;
            }
            if(a[i] / 10 == 6)
            {
                Rectangle r6 = new Rectangle(325,count61,20,10);
                g2.draw(r6);
                count61 = count61 - 10;
            }
            if(a[i] / 10 == 7)
            {
                Rectangle r7 = new Rectangle(375,count71,20,10);
                g2.draw(r7);
                count71 = count71 - 10;
            }
            if(a[i] / 10 == 8)
            {
                Rectangle r8 = new Rectangle(425,count81,20,10);
                g2.draw(r8);
                count81 = count81 - 10;
            }
            if(a[i] / 10 == 9)
            {
                Rectangle r9 = new Rectangle(475,count9,20,10);
                g2.draw(r9);
                count91 = count91 - 10;
            }
        }
        
        int counter2 = 30;
        for(int i = 0; i < a.length; i++)
        {   
            Rectangle r = new Rectangle(counter2, 750 - a[i]*3, 10, a[i]*3);
            g2.draw(r);
            counter2 = counter2 + 15;
        }
    }
    
    public static void main(String[] args)
    {        
        JFrame frame = new JFrame();
        frame.setSize(525,800);
        
        final BucketSort2 bucket = new BucketSort2();  
        bucket.makeArray();
        bucket.insertToBucket();
        bucket.insertToArray();
        bucket.insertToBucket2();
        bucket.insertToArray2();
        frame.add(bucket);
        frame.setVisible(true);
         
        frame.setDefaultCloseOperation(3);
    }
}