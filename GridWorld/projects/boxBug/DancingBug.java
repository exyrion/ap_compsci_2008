package projects.boxBug;


/**
 * The bug will run in a dance.
 * 
 * Justin Liang
 * Period 1
 */
import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    private int steps;
    private int sideLength;
    private int[] b;
    private int check = 0;

    /**
     * Constructs a dancing bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug(int length, int[] a)
    {
        b = a;
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
        else if(check == b.length)
        {
            check = 0;
        }
        else
        {
            setDirection(getDirection() + (b[check] * 45));
            steps = 0;
            check++;
        }
    }
}
