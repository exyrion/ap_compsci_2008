
/**
 * Creates and draws the rectangle.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;

public class RectangleComponent extends JComponent
{
    private Rectangle rect1 = new Rectangle(0,0,100,200);
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.draw(rect1);
    }
    
    public void moveBy(int x, int y)
    {
        rect1.translate(x,y);
        repaint();  //it calls the paintComponent method again
    }
}
