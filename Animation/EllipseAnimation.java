
/**
 * Creates two buttons that control the timers for movements of the ellipse
 * 
 * @author (Luc) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EllipseAnimation
{
    public static void main(String [] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        
        //adding the ellipse onto the frame
        final EllipseComponent ellipseComponent = new EllipseComponent();
        frame.add(ellipseComponent);
        frame.setVisible(true);
        
        //creating buttons
        JButton up = new JButton("UP");
        JButton down = new JButton("DOWN");
        
        //creating the panel for the buttons
        JPanel panel = new JPanel();
        //adding the panel onto the frame
        frame.add(panel);
        
        panel.add(up);
        panel.add(down);
        
        frame.setVisible(true);
        
        //this timer would be called when "upTimer" is started
        class UpMovementTimer implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                ellipseComponent.moveBy(0,-1);
            }
        }
       
        //this timer would be called when "downTimer" is started
        class DownMovementTimer implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                ellipseComponent.moveBy(0,1);
            }
        }
        
        //the delay time
        int DELAY = 50;
        
        ActionListener listen1 = new UpMovementTimer();
        ActionListener listen2 = new DownMovementTimer();      
        
        //creating the actual timers with names
        final Timer upTimer = new Timer(DELAY, listen1);
        final Timer downTimer = new Timer(DELAY, listen2);
        
        //this listener is called ONCE when the "UP" button is clicked
        class UpButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                //we want to make sure only upTimer is running
                downTimer.stop();
                upTimer.start();
            }
        }
        
        //this listener is called ONCE when the "DOWN" button is clicked
        class DownButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                //we want to make sure only downTimer is running
                upTimer.stop();
                downTimer.start();
            }
        }
        
        ActionListener listen3 = new UpButtonListener();
        ActionListener listen4 = new DownButtonListener();
        
        up.addActionListener(listen3);
        down.addActionListener(listen4);
        
        frame.setDefaultCloseOperation(3);
                
        
    }
}
