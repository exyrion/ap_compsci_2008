
/**
 * Plays the game.
 * 
 * Justin Liang
 * Period 1
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.util.*;
    
public class BingoGame
{
    public static int bingoHead = 0;
    public static boolean bingoHeader = true;
        
    public static void main(String[] args)
    {
        final BingoCardComputer computer = new BingoCardComputer();
        final BingoCardHuman human = new BingoCardHuman();
        final BingoCard card = new BingoCard();
        final BingoNumbers bingo = new BingoNumbers();
        final BingoSquare squares = new BingoSquare();
                
        class Painter extends JComponent
        {
            /**
             * Draws headers for the bingo game
             */
            public void paintComponent(Graphics g)
            {
                Graphics2D g2 = (Graphics2D) g;
                
                g2.setColor(Color.BLACK);
                Font font = new Font("Arial", Font.BOLD, 30);
                g2.setFont(font);
                
                if(bingoHead == 4)
                {
                    g2.drawString("Bingo has been resetted. Welcome to Bingo!",1, 50);
                    repaint();
                }
                if(bingoHead == 3)
                {
                    g2.drawString("You got Bingo! Congratulations!", 1, 50);
                }
                if(bingoHead == 2)
                {
                    g2.drawString("Sorry, no Bingo. Please try again.", 1, 50);
                    bingoHead = 2;
                }
                if(computer.checkBingoC() == true)
                {
                    bingoHead = 1;
                    repaint();
                    g2.drawString("The computer got Bingo! You lose.", 1, 50);
                    bingoHeader = false;
                }
                if(bingoHeader == true)
                {
                    bingoHead = 1;
                    g2.drawString("Welcome to Bingo!", 1, 50);
                    repaint();
                }
                repaint();
            }
        }
        
        final Painter paint = new Painter();
                
        JFrame frame = new JFrame();
        frame.setSize(800,600);
        
        frame.add(computer);
        frame.setVisible(true);
        
        frame.add(paint);
        frame.setVisible(true);
        
        frame.add(human);
        frame.setVisible(true);
                
        frame.add(card);
        frame.setVisible(true);
       
        JButton bingoButton = new JButton("Bingo!");
        frame.add(bingoButton);
        bingoButton.setSize(100,50);
        bingoButton.setLocation(350,400);
        bingoButton.setVisible(true);
       
        JButton restartButton = new JButton("Restart");
        frame.add(restartButton);
        restartButton.setSize(100,50);
        restartButton.setLocation(350,500);
        restartButton.setVisible(true);
        
        computer.assignValues();
        human.assignValues();
        
        class TimerListener implements ActionListener
        {
            /**
             * Generates a new number and 
             * checks to see if any of the computer or human numbers match that number
             */
            public void actionPerformed(ActionEvent event)
            {
                bingo.generateNumber();
                computer.findMatch(bingo.getLastNumber());
                human.findMatch(bingo.getLastNumber());
            }
        }
       
        ActionListener generateTimerListener = new TimerListener();
        int DELAY = 5000;
        final Timer t = new Timer(DELAY, generateTimerListener);
        
        t.start();
        
        class CheckerListener implements ActionListener
        {
            /**
             * If human player won or computer player won,
             * stop the timer.
             */
            public void actionPerformed(ActionEvent event)
            {        
                if(human.checkBingoH() == true || computer.checkBingoC() == true)
                {
                    t.stop();
                }
            }
        }
        
        ActionListener bingoChecker = new CheckerListener();
        final Timer c = new Timer(100, bingoChecker);
        c.start();
        
        class MousePressListener implements MouseListener
        {
            /**
             * Highlights the square that the user clicked on.
             */
            public void mousePressed(MouseEvent event)
            {
                int x = event.getX()-5;
                int y = event.getY()-25;
                human.checkSquare(x,y);
            }
            
            public void mouseReleased(MouseEvent event)
            {

            }
            
            public void mouseClicked(MouseEvent event)
            {
                
            }
            
            public void mouseEntered(MouseEvent event)
            {
                
            }
            
            public void mouseExited(MouseEvent event)
            {
                
            }
        }
        
        MouseListener clickListener = new MousePressListener();
        frame.addMouseListener(clickListener);
        
        class BingoButtonListener implements ActionListener
        {
            /**
             * Displays the header to notice the human player
             * if he/she got bingo, or if they didn't get bingo.
             */
            public void actionPerformed(ActionEvent event)
            {
                bingoHeader = false;
                
                if(human.checkBingoH() == true)
                {
                    bingoHead = 3;
                }
                
                if(human.checkBingoH() == false)
                {
                    bingoHead = 2;
                }
            }
        }
        
        ActionListener BINGO = new BingoButtonListener();
        bingoButton.addActionListener(BINGO);
        
        class RestartButtonListener implements ActionListener
        {
            /**
             * Restarts the game.
             */
            public void actionPerformed(ActionEvent event)
            {
                bingoHeader = false;
                
                bingo.generateNumber();
                card.restartPressedCard(true);
                human.restartPressedHuman(true);
                computer.restartPressedComputer(true);
                squares.restartPressedSquares(true);
                bingo.restartPressedBingo();
                
                bingoHead = 4;
                
                computer.assignValues();
                human.assignValues();
                
                t.start();
                c.start();
            }
        }
        
        ActionListener RESTART = new RestartButtonListener();
        restartButton.addActionListener(RESTART);
       
        frame.add(bingo);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(3);
    }
}
