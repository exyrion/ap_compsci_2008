
/**
 * The seating chart for the airplane.
 * 
 * Justin Liang && Michael Lam
 * Period 1
 * CompSci AP
 * Luc
 * February 19, 2009
 */

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class SeatingChart extends JComponent
{
    public Seat[][] first;
    public Seat[][] econ;
    public static int seatID1 = 0;
    public static int seatID2 = 0;
    public static int firstOrEcon = 0;
    public static int selection = 0;
    
    /**
     * The constructor.
     */
    public SeatingChart()
    {
        first = new Seat[5][4];
        for(int i = 0; i < 5; i++)
        {
            for (int k = 0; k<2; k++)
            {
                first[i][k] = new Seat();
                first[i][k].x = 100 + (k * 25);
                first[i][k].y = 300 + (i * 25);
            }
        }
        
        for( int i = 0; i < 5; i++)
        {
            for (int k = 2; k<4; k++)
            {
                first[i][k] = new Seat();
                first[i][k].x = 150 + (k * 25);
                first[i][k].y = 300 + (i * 25);
            }
        }
                
        econ = new Seat[15][7];
        for( int i = 0; i < 15; i++)
        {
            for (int k = 0; k<3; k++)
            {
                econ [i][k] = new Seat();
                econ[i][k].x = 500 + (k * 25);//positions the first
                econ[i][k].y = 200 + (i * 25);
            }
        }        
        for( int i = 0; i < 15; i++)
        {
            for (int k = 3; k<6; k++)
            {
                econ [i][k] = new Seat();
                econ[i][k].x = 550 + (k * 25);//positions the first
                econ[i][k].y = 200 + (i * 25);
            }
        } 
    }
    
    /**
     * Colors the box if the box is clicked, uncolors it if it was already clicked
     * @param int x the x coordinate of the point of click
     * @param int y the y coordinate of the point of click
     * (Precondition: int coordinate inside the card)
     * (Postcondition: changes boolean to true and false, highlight and no highlight)
     */
    
     public void checkSeat(int x, int y)
     {
        for(int i = 0; i < 5; i++)
        {
            for(int k = 0; k < 4; k++)
            {
                if(first[i][k].contains(x, y))//if it was inside a specific box
                {
                    firstOrEcon = 1;
                    if (first[i][k].clicked == false)//if it wasn't highlighted, it gets highlighted
                    {
                        first[i][k].clicked = true;
                        seatID1 = i;
                        seatID2 = k;
                        seatID1 = seatID1 + 1;
                        selection = 1;
                    }
                                    
                    else if(first[i][k].clicked == true) //if it was highlighted, it gets unhighlighted
                    {
                        first[i][k].clicked = false;
                        seatID1 = i;
                        seatID2 = k;
                        seatID1 = seatID1 + 1;
                        selection = 2;
                    }
                }
            }
        }   
                        
        for(int p = 0; p < 15; p++)
        {
            for(int z = 0; z < 6; z++)
            {
                if(econ[p][z].contains(x, y))//if it was inside a specific box
                {
                    firstOrEcon = 2;
                    if (econ[p][z].clicked == false)//if it wasn't highlighted, it gets highlighted
                    {
                        econ[p][z].clicked = true;
                        seatID1 = p;
                        seatID2 = z;
                        seatID1 = seatID1 + 1;
                        selection = 1;
                    }
                                    
                    else if(econ[p][z].clicked == true) //if it was highlighted, it gets unhighlighted
                    {
                        econ[p][z].clicked = false;
                        seatID1 = p;
                        seatID2 = z;
                        seatID1 = seatID1 + 1;
                        selection = 2;
                    }
                }
            }
        }
        repaint();
    }
    
    /**
     * Resets the seating chart and clears all highlighted seats.
     */    
    public void resetColors()
    {
        for (int i = 0; i < 5; i ++)
        {
            for (int k = 0; k < 4; k++)
            {
                first[i][k].changeClicked(false);
            }
        }
        for ( int i = 0; i < 15; i++)
        {
            for (int k = 0; k<6; k++)
            {
                econ [i][k].changeClicked(false);
            }
        }
        repaint();
    }
    
    /**
     * Saves the current seating chart to the FirstClass.txt and Economy.txt files.
     */
    public void saveSeats() throws FileNotFoundException
    {
        PrintWriter write = new PrintWriter("FirstClass.txt");
        PrintWriter write2 = new PrintWriter("Economy.txt");
        for(int i = 0; i < 5; i++)
        {
            for(int k = 0; k < 4; k++)
            {
               if (first[i][k].getClicked()==true)//if it was inside a specific box
                {
                    write.print(i);
                    write.print(" ");
                    write.print(k);
                    write.println();
                }
            }
        }   
                        
        for(int p = 0; p < 15; p++)
        {
            for(int z = 0; z < 6; z++)
            {
                if(econ[p][z].getClicked()==true)//if it was inside a specific box
                {
                   write2.print(p);
                   write2.print(" ");
                   write2.print(z);
                   write2.println();
                }
            }
        }
        write.close();
        write2.close();    
    }
    
    /**
     * Reads the FirstClass.txt and Economy.txt files and
     * loads the seating chart.
     */
    public void readSeats()
    {
        try
        {
            FileReader read = new FileReader("FirstClass.txt");
            Scanner in = new Scanner(read);
            while(in.hasNext())
            {
                int r = in.nextInt();
                int g = in.nextInt();
                
                first[r][g].changeClicked(true);
            }
        }
        catch(FileNotFoundException exception)
        {
        }
        
        try
        {
            FileReader read1 = new FileReader("Economy.txt");
            Scanner in1 = new Scanner(read1);
            while(in1.hasNext())
            {
                int r = in1.nextInt();
                int g = in1.nextInt();
                
                econ[r][g].changeClicked(true);
            }
        }
        catch(FileNotFoundException exception)
        {
        }
    }
       
    /**
     * Draws the seating chart and the labels.
     */
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        
        for (int i = 0; i < 5; i++)
        {
            for (int k = 0; k < 4; k++)
            {
                g2.draw(first[i][k]);//draws all the first
                
                if (first[i][k].getClicked() == true)
                {
                    Rectangle filled = new Rectangle(first[i][k].x+1, first[i][k].y+1, 24, 24);
                    g2.setColor(Color.LIGHT_GRAY);
                    g2.fill(filled);
                }
                g2.setColor(Color.BLACK);
            }
        }
                
        for ( int p = 0; p < 15; p++)
        {
            for (int z = 0; z < 6; z++)
            {
                g2.draw(econ[p][z]);
                if (econ[p][z].getClicked() == true)
                {
                    Rectangle filled = new Rectangle(econ[p][z].x+1, econ[p][z].y+1, 24, 24);
                    g2.setColor(Color.LIGHT_GRAY);
                    g2.fill(filled);
                }
                g2.setColor(Color.BLACK);
            }
        }
                
        Font font = new Font("Arial", Font.PLAIN, 16);
        g2.setFont(font);
        
        g2.drawString("A",105,295);
        g2.drawString("B",130,295);
        g2.drawString("C",205,295);
        g2.drawString("D",230,295);
        
        g2.drawString("1", 85, 320);
        g2.drawString("2", 85, 345);
        g2.drawString("3", 85, 370);
        g2.drawString("4", 85, 395);
        g2.drawString("5", 85, 420);
        
        g2.drawString("A",505,195);
        g2.drawString("B",530,195);
        g2.drawString("C",555,195);
        g2.drawString("D",630,195);
        g2.drawString("E",655,195);
        g2.drawString("F",680,195);
        
        g2.drawString("1",485,220);
        g2.drawString("2",485,245);
        g2.drawString("3",485,270);
        g2.drawString("4",485,295);
        g2.drawString("5",485,320);
        g2.drawString("6",485,345);
        g2.drawString("7",485,370);
        g2.drawString("8",485,395);
        g2.drawString("9",485,420);
        g2.drawString("10",475,445);
        g2.drawString("11",475,470);
        g2.drawString("12",475,495);
        g2.drawString("13",475,520);
        g2.drawString("14",475,545);
        g2.drawString("15",475,570);
                
        Font font1 = new Font("Arial", Font.PLAIN, 18);
        g2.setFont(font1);
        
        g2.drawString("Front",155,270);
        g2.drawString("Window",10,370);
        g2.drawString("Aisle",157,370);
        g2.drawString("Window",265,370);
        g2.drawString("Back",155,460);
        
        g2.drawString("Front",580,170);
        g2.drawString("Window",410,380);
        g2.drawString("Aisle",582,380);
        g2.drawString("Window",710,380);
        g2.drawString("Back",580,605);
        
        Font font2 = new Font("Arial", Font.BOLD, 30);
        g2.setFont(font2);
        
        g2.drawString("First Class", 100, 525);
        g2.drawString("Economy", 535, 650);
        
        g2.drawLine(0,75,800,75);
    }
}