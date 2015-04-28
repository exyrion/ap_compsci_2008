/**
 * Creates and draws the cockroach.
 * 
 * Justin Liang
 * 12/14/08
 * Period 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class RoachComponent extends JComponent
{
    private Ellipse2D.Double body = new Ellipse2D.Double(200,200,40,80);
    private Ellipse2D.Double head = new Ellipse2D.Double(205,180,30,30);
    
    private Line2D.Double leftHind1 = new Line2D.Double(220,240,190,280);
    private Line2D.Double leftHind2 = new Line2D.Double(190,280,210,310);
    
    private Line2D.Double rightHind1 = new Line2D.Double(220,240,250,280);
    private Line2D.Double rightHind2 = new Line2D.Double(250,280,230,310);
    
    private Line2D.Double leftMid1 = new Line2D.Double(220,255,190,230);
    private Line2D.Double leftMid2 = new Line2D.Double(190,230,180,270);
    
    private Line2D.Double rightMid1 = new Line2D.Double(220,255,250,230);
    private Line2D.Double rightMid2 = new Line2D.Double(250,230,260,270);
    
    private Line2D.Double leftFront = new Line2D.Double(220,250,185,195);
    
    private Line2D.Double rightFront = new Line2D.Double(220,250,255,195);
    
    private Line2D.Double leftAnt = new Line2D.Double(220,205,205,155);
    
    private Line2D.Double rightAnt = new Line2D.Double(220,205,235,155);
    
    /**
     * Draws the cockroach's parts.
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.fill(body);
        g2.fill(head);
        g2.draw(leftHind1);
        g2.draw(leftHind2);
        g2.draw(rightHind1);
        g2.draw(rightHind2);
        g2.draw(leftMid1);
        g2.draw(leftMid2);
        g2.draw(rightMid1);
        g2.draw(rightMid2);
        g2.draw(leftFront);
        g2.draw(rightFront);
        g2.draw(leftAnt);
        g2.draw(rightAnt);
    }
    
    /**
     * Moves the cockroach.
     * @param x the number that the cockroach moves horizontally for each delay
     * @param y the number that the cockroach moves vertically for each delay
     * (Precondition: x & y has to be a number)
     */
    public void moveBy(int x, int y)
    {
        body.x = body.x + x;
        body.y = body.y + y;
        
        head.x = head.x + x;
        head.y = head.y + y;
        
        leftHind1.x1 = leftHind1.x1 + x;
        leftHind1.x2 = leftHind1.x2 + x;
        leftHind1.y1 = leftHind1.y1 + y;
        leftHind1.y2 = leftHind1.y2 + y;
        
        leftHind2.x1 = leftHind2.x1 + x;
        leftHind2.x2 = leftHind2.x2 + x;
        leftHind2.y1 = leftHind2.y1 + y;
        leftHind2.y2 = leftHind2.y2 + y;
        
        rightHind1.x1 = rightHind1.x1 + x;
        rightHind1.x2 = rightHind1.x2 + x;
        rightHind1.y1 = rightHind1.y1 + y;
        rightHind1.y2 = rightHind1.y2 + y;
        
        rightHind2.x1 = rightHind2.x1 + x;
        rightHind2.x2 = rightHind2.x2 + x;
        rightHind2.y1 = rightHind2.y1 + y;
        rightHind2.y2 = rightHind2.y2 + y;
        
        leftMid1.x1 = leftMid1.x1 + x;
        leftMid1.x2 = leftMid1.x2 + x;
        leftMid1.y1 = leftMid1.y1 + y;
        leftMid1.y2 = leftMid1.y2 + y;
        
        leftMid2.x1 = leftMid2.x1 + x;
        leftMid2.x2 = leftMid2.x2 + x;
        leftMid2.y1 = leftMid2.y1 + y;
        leftMid2.y2 = leftMid2.y2 + y;
        
        rightMid1.x1 = rightMid1.x1 + x;
        rightMid1.x2 = rightMid1.x2 + x;
        rightMid1.y1 = rightMid1.y1 + y;
        rightMid1.y2 = rightMid1.y2 + y;
        
        rightMid2.x1 = rightMid2.x1 + x;
        rightMid2.x2 = rightMid2.x2 + x;
        rightMid2.y1 = rightMid2.y1 + y;
        rightMid2.y2 = rightMid2.y2 + y;
        
        leftFront.x1 = leftFront.x1 + x;
        leftFront.x2 = leftFront.x2 + x;
        leftFront.y1 = leftFront.y1 + y;
        leftFront.y2 = leftFront.y2 + y;
        
        rightFront.x1 = rightFront.x1 + x;
        rightFront.x2 = rightFront.x2 + x;
        rightFront.y1 = rightFront.y1 + y;
        rightFront.y2 = rightFront.y2 + y;
        
        leftAnt.x1 = leftAnt.x1 + x;
        leftAnt.x2 = leftAnt.x2 + x;
        leftAnt.y1 = leftAnt.y1 + y;
        leftAnt.y2 = leftAnt.y2 + y;
        
        rightAnt.x1 = rightAnt.x1 + x;
        rightAnt.x2 = rightAnt.x2 + x;
        rightAnt.y1 = rightAnt.y1 + y;
        rightAnt.y2 = rightAnt.y2 + y;
        
        repaint();
    }
}
