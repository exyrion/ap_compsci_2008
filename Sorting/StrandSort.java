/*------------------*\
| Name: Raymond Lee  |
| Period: 1          |
| Due: March 3, 2009 |
\*------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/**
    An animation showing the sorting of an array of random integers using the strand sorting algorithm.
 */
public class StrandSort extends JComponent
{
    private static Random rand = new Random();
    private Rectangle[] bar;
    private Rectangle[] subBar;
    private ArrayList<Rectangle> newBar;
    private int[] data;
    private int[] subData;
    private ArrayList<Integer> newData;
    private int checkCount;
    private int dataCount;
    private int comparisonCount;
    
    /**
        Constructs a new animation with all values reset.
        @param range the highest number to determine the range of random integers.
        @param values the number of values in the array.
     */
    public StrandSort(int range, int values)
    {
        data = new int[values];
        subData = new int[values];
        newData = new ArrayList<Integer>();
        bar = new Rectangle[values];
        subBar = new Rectangle[values];
        newBar = new ArrayList<Rectangle>();
        checkCount = 0;
        dataCount = 0;
        comparisonCount = 0;
        
        for (int v = 0; v < values; v++)
        {
            data[v] = rand.nextInt(range) + 1;
        }
    }
    
    /**
        Used to pull a single value into the sub-list of data.
     */
    public void pullStrand()
    {
        for (int c = checkCount; c < data.length; c++)
        {
            if (data[checkCount] != 0 && data[checkCount] >= dataCount)
            {
                dataCount = data[checkCount];
                subData[checkCount] = data[checkCount];
                data[checkCount] = 0;
                checkCount++;
                comparisonCount++;
                break;
            }
        
            else if (data[checkCount] != 0)
            {
                checkCount++;
                comparisonCount++;
                break;
            }
            
            else
            {
                checkCount++;
            }
        }
    }
    
    /**
        Used to collect a value in the sub-list of data into the new list of data.
        @return whether there is still some strands left in the sub-list of data.
     */
    public boolean collectStrand()
    {
        for (int i = 0; i < subData.length; i++)
        {
            if (subData[i] != 0)
            {
                if (newData.size() == 0)
                {
                    newData.add(subData[i]);
                }
                
                else
                {
                    for (int s = 0; s < newData.size(); s++)
                    {
                        if (subData[i] < newData.get(s))
                        {
                            newData.add(s,subData[i]);
                            break;
                        }
                    }
                    
                    newData.add(subData[i]);
                }
                
                newBar.add(new Rectangle());
                subData[i] = 0;
                return true;
            }
        }
        
        return false;
    }
    
    /**
        Draws the components of the Strand Sorter.
        @param g the drawing tool.
     */
    public void paintComponent(Graphics g)
    {
        g.drawLine(25,200,675,200);
        g.drawLine(25,400,675,400);
        g.drawLine(25,600,675,600);
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawString("Comparisons: " + comparisonCount,25,615);
        g2.drawString("Swaps: 0",625,615);
        
        for (int b = 0; b < bar.length; b++)
        {
            int value = data[b];
            int redValue = 0;
            int greenValue = 0;
            
            if (value <= 25)
            {
                redValue = 255;
                greenValue = 5 + value * 10;
            }
            
            else if (value <= 50)
            {
                redValue = 255 - (value - 25) * 10;
                greenValue = 255;
            }
            
            bar[b] = new Rectangle();
            bar[b].x = b * 20 + 50;
            bar[b].y = 200 - value * 3;
            bar[b].width = 15;
            bar[b].height = value * 3;
            
            if (value == 0)
            {
            }
            
            else if (value < 10)
            {
                if (b == checkCount)
                {
                    g2.setColor(Color.BLUE);
                    g2.drawString("0" + value,bar[b].x + 1,bar[b].y - 2);
                    g2.setColor(Color.CYAN);
                    g2.fill(bar[b]);
                    g2.setColor(Color.BLACK);
                    g2.draw(bar[b]);
                }
                
                else
                {
                    g2.drawString("0" + value,bar[b].x + 1,bar[b].y - 2);
                    g2.setColor(new Color(redValue,greenValue,0));
                    g2.fill(bar[b]);
                    g2.setColor(Color.BLACK);
                    g2.draw(bar[b]);
                }
            }
            
            else
            {
                if (b == checkCount)
                {
                    g2.setColor(Color.BLUE);
                    g2.drawString("" + value,bar[b].x + 1,bar[b].y - 2);
                    g2.setColor(Color.CYAN);
                    g2.fill(bar[b]);
                    g2.setColor(Color.BLACK);
                    g2.draw(bar[b]);
                }
                
                else
                {
                    g2.drawString("" + value,bar[b].x + 1,bar[b].y - 2);
                    g2.setColor(new Color(redValue,greenValue,0));
                    g2.fill(bar[b]);
                    g2.setColor(Color.BLACK);
                    g2.draw(bar[b]);
                }
            }
        }
        
        for (int sB = 0; sB < subBar.length; sB++)
        {
            int value = subData[sB];
            int redValue = 0;
            int greenValue = 0;
            
            if (value <= 25)
            {
                redValue = 255;
                greenValue = 5 + value * 10;
            }
            
            else if (value <= 50)
            {
                redValue = 255 - (value - 25) * 10;
                greenValue = 255;
            }
            
            subBar[sB] = new Rectangle();
            subBar[sB].x = sB * 20 + 50;
            subBar[sB].y = 400 - value * 3;
            subBar[sB].width = 15;
            subBar[sB].height = value * 3;
            
            if (value == 0)
            {
            }
            
            else if (value < 10)
            {
                g2.drawString("0" + value,subBar[sB].x + 1,subBar[sB].y - 2);
            }
            
            else
            {
                g2.drawString("" + value,subBar[sB].x + 1,subBar[sB].y - 2);
            }
            
            g2.setColor(new Color(redValue,greenValue,0));
            g2.fill(subBar[sB]);
            g2.setColor(Color.BLACK);
            g2.draw(subBar[sB]);
        }
        
        for (int nB = 0; nB < newBar.size(); nB++)
        {
            int value = newData.get(nB);
            int redValue = 0;
            int greenValue = 0;
            
            if (value <= 25)
            {
                redValue = 255;
                greenValue = 5 + value * 10;
            }
            
            else if (value <= 50)
            {
                redValue = 255 - (value - 25) * 10;
                greenValue = 255;
            }
            
            newBar.get(nB).x = nB * 20 + 50;
            newBar.get(nB).y = 600 - value * 3;
            newBar.get(nB).width = 15;
            newBar.get(nB).height = value * 3;
            
            if (value == 0)
            {
            }
            
            else if (value < 10)
            {
                g2.drawString("0" + value,newBar.get(nB).x + 1,newBar.get(nB).y - 2);
            }
            
            else
            {
                g2.drawString("" + value,newBar.get(nB).x + 1,newBar.get(nB).y - 2);
            }
            
            g2.setColor(new Color(redValue,greenValue,0));
            g2.fill(newBar.get(nB));
            g2.setColor(Color.BLACK);
            g2.draw(newBar.get(nB));
        }
    }
    
    /**
        The main method used to run the animation.
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Strand Sort");
        frame.setSize(700,700);
        frame.getContentPane().setBackground(Color.WHITE);
        
        final StrandSort sorter = new StrandSort(50,30);
        
        frame.add(sorter);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setAlwaysOnTop(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /**
            Used to perform a single action for a timer.
         */
        class ActionPerformer implements ActionListener
        {
            /**
                Does a single action, either pulling a strand or collecting the strands into the new array.
             */
            public void actionPerformed(ActionEvent e)
            {
                if (sorter.checkCount < sorter.data.length)
                {
                    sorter.pullStrand();
                }
                
                else if (sorter.checkCount == sorter.data.length)
                {
                    if (!sorter.collectStrand())
                    {
                        sorter.checkCount = 0;
                        sorter.dataCount = 0;
                        sorter.repaint();
                    }
                    
                    sorter.repaint();
                }
                
                sorter.repaint();
            }
        }
        ActionListener moveSorter = new ActionPerformer();
        final Timer sorting = new Timer(150, moveSorter);
        sorting.start();
    }
}