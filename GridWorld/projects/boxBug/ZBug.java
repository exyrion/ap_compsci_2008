package projects.boxBug;


/**
 * The bug will run in a Z-Shaped pattern.
 * 
 * Justin Liang
 * Period 1
 */
import info.gridworld.actor.Bug;

public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int directionCheck = 0;
    
    /**
     * Constructs a Z bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        turn();
        turn();
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else if((steps >= sideLength || !canMove()) && directionCheck == 0)
        {
            turn();
            turn();
            turn();
            steps = 0;
            directionCheck = 1;
        }
        else if(directionCheck == 1)
        {
            turn();
            turn();
            turn();
            turn();
            turn();
            steps = 0;
            directionCheck = 2;
        }
        else if(directionCheck == 2)
        {
            turn();
            turn();
            turn();
            turn();
            steps = 0;
            directionCheck = 0;
        }
            
    }
}
