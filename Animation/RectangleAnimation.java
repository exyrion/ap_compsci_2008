
/**
 * Moves the rectangle diagonally.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.event.*;

public class RectangleAnimation
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        
        final RectangleComponent r = new RectangleComponent();
                
        frame.add(r);
        frame.setVisible(true);
        
        JButton fast = new JButton("Faster");
        JButton slow = new JButton("Slower");
        
        JPanel panel = new JPanel();
        panel.add(fast);
        panel.add(slow);
                
        frame.add(panel);
                
        class TimerListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                r.moveBy(1,1);
            }
        }
        
        ActionListener listen = new TimerListener();
        int DELAY = 100;    //in milliseconds
        
        final Timer t = new Timer(DELAY, listen);
        
        //t is the time clock that delays every 100 milliseconds
        //and calls the method moveBy
        
        
        class FasterButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                t.setDelay(50);
            }
        }
        
        class SlowerButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                t.setDelay(220);
            }
        }
        
        ActionListener fastButtonListener = new FasterButtonListener();
        ActionListener slowButtonListener = new SlowerButtonListener();
        fast.addActionListener(fastButtonListener);
        slow.addActionListener(slowButtonListener);
        
        t.start();
                       
        frame.add(panel);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(3);
    }
}