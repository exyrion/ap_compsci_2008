
/**
 * Reacts to the "Touch me" button
 * 
 * Justin Liang
 * 12/5/08
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClickListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("I was touched! Who touched me?");
    }
}
    