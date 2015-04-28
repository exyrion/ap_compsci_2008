/**
 * Moves a cockroach left, right, up, or down.
 * 
 * Justin Liang
 * 12/14/08
 * Period 1
 */

import javax.swing.*;
import java.awt.event.*;

public class RoachAnimation
{
    /**
     * Runs the RoachAnimation program.
     */
    public static void main(String[] args)
    {        
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        
        final RoachComponent r = new RoachComponent();
                
        frame.add(r);
        frame.setVisible(true);
        
        JButton left = new JButton("left");
        JButton right = new JButton("right");
        JButton up = new JButton("up");
        JButton down = new JButton("down");
        JButton stop = new JButton("stop");
        
        JPanel panel = new JPanel();
        panel.add(left);
        panel.add(right);
        panel.add(up);
        panel.add(down);
        panel.add(stop);
                
        frame.add(panel);
        
        class leftTimerListener implements ActionListener
        {
            /**
             * Moves the cockroach left
             */
            public void actionPerformed(ActionEvent event)
            {
                r.moveBy(-1,0);
            }           
        }
        
        class rightTimerListener implements ActionListener
        {
            /**
             * Moves the cockroach right
             */
            public void actionPerformed(ActionEvent event)
            {
                r.moveBy(1,0);
            }           
        }
        
        class upTimerListener implements ActionListener
        {
            /**
             * Moves the cockroach up
             */
            public void actionPerformed(ActionEvent event)
            {
                r.moveBy(0,-1);
            }           
        }
        
        class downTimerListener implements ActionListener
        {
            /**
             * Moves the cockroach down
             */
            public void actionPerformed(ActionEvent event)
            {
                r.moveBy(0,1);
            }           
        }
        
        class stopTimerListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                r.moveBy(0,0);
            }           
        }
        
        ActionListener leftListen = new leftTimerListener();
        ActionListener rightListen = new rightTimerListener();
        ActionListener upListen = new upTimerListener();
        ActionListener downListen = new downTimerListener();
        ActionListener stopListen = new stopTimerListener();
        
        int delay = 25;
        
        final Timer leftT = new Timer(delay, leftListen);
        final Timer rightT = new Timer(delay, rightListen);
        final Timer upT = new Timer(delay, upListen);
        final Timer downT = new Timer(delay, downListen);
        final Timer stopT = new Timer(delay, stopListen);
        
        class LeftButtonListener implements ActionListener
        {
            /**
             * Starts the timer leftT and stops all other timers
             */
            public void actionPerformed(ActionEvent event)
            {
                leftT.start();
                rightT.stop();
                upT.stop();
                downT.stop();
            }
        }
        
        class RightButtonListener implements ActionListener
        {
            /**
             * Starts the timer rightT and stops all other timers
             */
            public void actionPerformed(ActionEvent event)
            {
                leftT.stop();
                rightT.start();
                upT.stop();
                downT.stop();
            }
        }
        
        class UpButtonListener implements ActionListener
        {
            /**
             * Starts the timer upT and stops all other timers
             */
            public void actionPerformed(ActionEvent event)
            {
                leftT.stop();
                rightT.stop();
                upT.start();
                downT.stop();
            }
        }
        
        class DownButtonListener implements ActionListener
        {
            /**
             * Starts the timer downT and stops all other timers
             */
            public void actionPerformed(ActionEvent event)
            {
                leftT.stop();
                rightT.stop();
                upT.stop();
                downT.start();
            }
        }
        
        class StopButtonListener implements ActionListener
        {
            /**
             * Stops all timers
             */
            public void actionPerformed(ActionEvent event)
            {
                leftT.stop();
                rightT.stop();
                upT.stop();
                downT.stop();
            }
        }
        
        ActionListener leftButtonListener = new LeftButtonListener();
        ActionListener rightButtonListener = new RightButtonListener();
        ActionListener upButtonListener = new UpButtonListener();
        ActionListener downButtonListener = new DownButtonListener();
        ActionListener stopButtonListener = new StopButtonListener();
        
        left.addActionListener(leftButtonListener);
        right.addActionListener(rightButtonListener);
        up.addActionListener(upButtonListener);
        down.addActionListener(downButtonListener);
        stop.addActionListener(stopButtonListener);
                       
        frame.add(panel);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(3);
    }
}