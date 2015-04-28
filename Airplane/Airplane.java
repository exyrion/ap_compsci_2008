/**
 * Runs the seating chart program.
 * 
 * Justin Liang && Michael Lam
 * Period 1
 * CompSci AP
 * Luc
 * February 19, 2009
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.geom.*;

public class Airplane extends SeatingChart //Needed to extend SeatingChart to use SeatingChart's local variables to draw the headers.
{
    public static int header = 0;
    public static void main(String[] args)
    {   
        class Painter extends JComponent
        {
            /**
             * Draws the appropriate header.
             */
            public void paintComponent(Graphics g)
            {        
                Graphics2D g2 = (Graphics2D) g;
                
                Font font = new Font("COURIER", Font.BOLD, 22);
                g2.setFont(font);
                g2.setColor(Color.BLACK);                
                
                if(header == 0)
                {
                    g2.drawString("Welcome to Luc Airlines. Please select your seats.", 5, 50);
                    repaint();
                }                
                else if(header == 1)
                {
                    g2.drawString("Your seats have been resetted.", 5, 50);
                    repaint();
                }                
                else if(header == 2)
                {
                    g2.drawString("Your seating chart has been saved.", 5, 50);
                    repaint();
                }
                
                else if(header == 3)
                {
                    String letter = "Z";
                    String select = "Z";
                    
                    if(seatID2 == 0)
                        letter = "A";
                    if(seatID2 == 1)
                        letter = "B";
                    if(seatID2 == 2)
                        letter = "C";
                    if(seatID2 == 3)
                        letter = "D";
                    if(seatID2 == 4)
                        letter = "E";
                    if(seatID2 == 5)
                        letter = "F";
                        
                    if(selection == 1)
                        select = "selected";
                    if(selection == 2)
                        select = "deselected";

                    if(firstOrEcon == 1)
                    {
                        if(seatID2 == 0 || seatID2 == 3)
                        {
                            g2.drawString("You have " + select + " a FIRST class WINDOW seat: Seat #" + letter + seatID1, 5, 50);
                        }
                        
                        if(seatID2 == 1 || seatID2 == 2)
                        {
                            g2.drawString("You have " + select + " a FIRST class AISLE seat: Seat #" + letter + seatID1, 5, 50);
                        }
                    }
                    
                    if(firstOrEcon == 2)
                    {
                        if(seatID2 == 0 || seatID2 == 5)
                        {
                            g2.drawString("You have " + select + " an ECONOMY class WINDOW seat: Seat #" + letter + seatID1, 5, 50);
                        }
                        
                        if(seatID2 == 1 || seatID2 == 4)
                        {
                            g2.drawString("You have " + select + " an ECONOMY class CENTER seat: Seat #" + letter + seatID1, 5, 50);
                        }
                        
                        if(seatID2 == 2 || seatID2 == 3)
                        {
                            g2.drawString("You have " + select + " an ECONOMY class AISLE seat: Seat #" + letter + seatID1, 5, 50);
                        }
                    }
                    repaint();
                }
            }
        }
        
        final Painter paint = new Painter();        
        final SeatingChart chart = new SeatingChart();
        chart.readSeats();
        
        JFrame frame = new JFrame();        
        frame.setSize(800,800);
        
        JButton save = new JButton("Save");
        frame.add(save);
        save.setSize(150,50);
        save.setLocation(240,700);
        save.setVisible(true);
        
        JButton reset = new JButton("Reset Seats");
        frame.add(reset);
        reset.setSize(150,50);
        reset.setLocation(410,700);
        reset.setVisible(true);
        
        frame.add(chart);
        frame.setVisible(true);
        
        frame.add(paint);
        frame.setVisible(true);
        
        class MousePressListener implements MouseListener
        {
            /**
             * Highlights and selects the seat on the seating chart.
             */
            public void mousePressed(MouseEvent event)
            {
                header = 3;
                int x = event.getX()-5;
                int y = event.getY()-30;
                chart.checkSeat(x,y);                
            }
            
            public void mouseReleased(MouseEvent event){}
            public void mouseClicked(MouseEvent event){}
            public void mouseEntered(MouseEvent event){}
            public void mouseExited(MouseEvent event){}
        }
        
        MouseListener listener001 = new MousePressListener();
        frame.addMouseListener(listener001);
        
        class SaveButtonListener implements ActionListener
        {
            /**
             * Saves the seating chart onto two .txt files,
             * FirstClass.txt for the first class seating chart and
             * Economy.txt for the economy class seating chart.
             */
            public void actionPerformed(ActionEvent event)
            {
                header = 2;                
                try
                {
                    chart.saveSeats();
                }
                catch(FileNotFoundException exception)
                {
                }
            }
        }
         
        ActionListener listener2 = new SaveButtonListener();
        save.addActionListener(listener2);
        
        class ResetButtonListener implements ActionListener
        {
            /**
             * Resets the seating chart.
             */
            public void actionPerformed(ActionEvent event)
            {
                header = 1;
                chart.resetColors();
            }
        }
        
        ActionListener listener99 = new ResetButtonListener();
        reset.addActionListener(listener99);
        
        frame.setDefaultCloseOperation(3);
    }
}