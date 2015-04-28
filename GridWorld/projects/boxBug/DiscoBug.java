package projects.boxBug;


/**
 * Creates a DiscoBug.
 * 
 * Justin Liang
 * Period 1
 */
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.Color;


public class DiscoBug extends Bug
{
    private int direction;
    private boolean turn = false;
    private int turnChecker = 0;
    private boolean infiniteTurn = false;
    private int steps = 0;
    private int colorCheck = 1;
    private Location startingLoc;
    
    
    /**
     * Constructs a disco bug that is placed depending on cornerStatus
     * @param length the side length
     */
    public DiscoBug(int cornerStatus)
    {
        direction = cornerStatus;
        
    }
    
    public void display()
    {
        if(direction == 1)
        {
            moveTo(new Location(0,0));
            setDirection(getDirection() + 135);
            Location startinLoc = new Location(0,0);
        }
        else if(direction == 2)
        {
            moveTo(new Location(0,9));
            setDirection(getDirection() + 225);
            Location startinLoc = new Location(0,9);
        }
        else if(direction == 3)
        {
            moveTo(new Location(9,0));
            setDirection(getDirection() + 45);
            Location startinLoc = new Location(9,0);
        }
        else if(direction == 4)
        {
            moveTo(new Location(9,9));
            setDirection(getDirection() + 315);
            Location startinLoc = new Location(9,9);
        }
    }
    /**
     * Moves to the next location of the square.
     * If it bumps into a bug, it will turn 12 times while changing colors,
     * then move back to its corner and dance all night long.
     * If it doesn't hit any bug, it will go back and forth.
     */
    public void act()
    {   
        
        if(canMove() && turn == false)
        {
            move();
            steps++;
        }
        
        else if(steps == 9)
        {
            turn();
            turn();
            turn();
            turn();
        }
        
        else if(steps == 18)
        {
            turn = true;
            turn();
        }
        
        else
        {
            turn = true;
            if(turnChecker != 12)
            {
                turn();
                if(colorCheck == 1 || colorCheck == 5 || colorCheck == 9 || colorCheck == 13)
                {
                    setColor(Color.BLUE);
                    colorCheck++;
                }
                else if(colorCheck == 2 || colorCheck == 6 || colorCheck == 10 || colorCheck == 14)
                {
                    setColor(Color.RED);
                    colorCheck++;
                }
                
                else if(colorCheck == 3 || colorCheck == 7 || colorCheck == 11 || colorCheck == 15)
                {
                    setColor(Color.YELLOW);
                    colorCheck++;
                }
                else if(colorCheck == 4 || colorCheck == 8 || colorCheck == 12 || colorCheck == 16)
                {
                    setColor(Color.GREEN);
                    colorCheck++;
                }
                turnChecker++;
            }
            else if(turnChecker == 12)
            {
                turn = false;
                turnChecker++;
            }
        }
    }
}