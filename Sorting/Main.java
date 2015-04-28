
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main 
{
    public static void main(String[] args)
    {        
        JFrame frame = new JFrame();
        frame.setSize(800,600);
        
        final BucketSort bucket = new BucketSort();  
        
        frame.add(bucket);
        frame.setVisible(true);
         
        class TimerListener implements ActionListener
        {
            /**
             * The timer to insert the value from the array to an appropriate bucket
             * or the value from a bucket to the array, depending on current
             * value of digitChecker
             */
            public void actionPerformed(ActionEvent event)
            {
                //if the digits of current value is greater than 0, 
                //run the if and else statements
                if(bucket.digitChecker > 0)
                {
                    if(bucket.k < bucket.a.length)
                    {   
                        bucket.insertToBucket();
                        bucket.repaint();
                    }
                    else if(bucket.c < bucket.a.length)
                    {
                        bucket.insertToArray();
                        bucket.repaint();
                    }
                    else
                    {
                        bucket.k = 0;
                        bucket.c = 0;
                        bucket.digitChecker--;
                    }
                }
            }
        }
        
        ActionListener time = new TimerListener();
        final int DELAY = 200;
        final Timer t = new Timer(DELAY, time);
        //starts the timer
        t.start();
        
        //if the digitChecker is less than or equal to 0,
        //stop the timer
        if(bucket.digitChecker <= 0)
        {
            t.stop();
        }
        
        frame.setDefaultCloseOperation(3);
    }
}