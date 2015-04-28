package projects.boxBug;


/**
 * Write a description of class DizzyBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import info.gridworld.actor.Bug;
public class HexaBug extends Bug
{
    public int directionCheck = 0;
    public int count = 0;
    public int steps = 0;
    public HexaBug(int side)
    {
        steps = side;
        turn();
        turn();
    }
    
    public void act()
    
    {
        if(canMove() && count < steps)
        {
            count++;
            move();
        }
        else if(directionCheck == 0 || directionCheck == 2 || directionCheck == 3 || directionCheck == 5)
        {
            turn();
            count = 0;
            directionCheck++;
            if(directionCheck == 5)
            {
                directionCheck = 0;
            }
        }
        else if(directionCheck == 1 || directionCheck == 4)
        {
            turn();
            turn();
            directionCheck++;
            count = 0;
        }
    }
}