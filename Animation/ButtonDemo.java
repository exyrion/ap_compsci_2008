
/**
 * Write a description of class ButtonDemo here.
 * 
 * Justin Liang
 * 12/5/08
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class ButtonDemo
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JButton b = new JButton("Touch me");
        
        frame.add(b);   //adds the button onto the frame
        
        class ClickListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                System.out.println("I was touched! Who touched me?");
            }
        }
        
        ActionListener listen = new ClickListener();
        b.addActionListener(listen);
        
        frame.setSize(100,50);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}