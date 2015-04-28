
/**
 * Draws an ellipse
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.geom.*;
import javax.swing.*;
import java.awt.*;

public class EllipseComponent extends JComponent
{
    private Ellipse2D.Double ellipse = new Ellipse2D.Double(100,100, 50, 100);
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(ellipse);
    }
    
    public void moveBy(int x, int y)
    {
        ellipse.x = ellipse.x + x;
        ellipse.y = ellipse.y + y;
        repaint();
    }
}
