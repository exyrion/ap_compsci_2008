/**
 * Creates a bug that starts in a specified corner, moving until running into
 * another bug or the wall, dancing before it returns to its corner to dance by itself.
 *
 * Minh Nguyen
 * 3/16/09
 */
import java.awt.Color;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
public class DiscoBug extends Bug
{
    private int corner;
    private int turns;
   
    /**
     * Constructs a disco bug, with a parameter specifying which corner it will 
     * be moved to.
     */
    public DiscoBug(int startingPlace)
    {
        corner = startingPlace;  
        turns = 0;
    }
   /**
    * Calling this method will move the bug to its new location,
    * depending on what int it was constructed with.
    */
    public void display()
    {
        if(corner == 1)
        {
            moveTo(new Location(0,0));
            setDirection(135);
        }
        else if(corner == 2)
        {
            moveTo(new Location(0,9));
            setDirection(225);
        }
        else if(corner == 3)
        {
            moveTo(new Location(9,9));
            setDirection(315);
        }
        else if(corner == 4)
        {
            moveTo(new Location(9,0));
            setDirection(45);
        }
    }
   /**
    * Will turn and change colors depending on how many times it has already turned
    * to make sure it goes at least 720. As soon as the bug hits something, it will
    * turn back to its corner, dancing by itself forever.
    */
    public void act()
    {
        if(canMove() && turns == 0)
        {
            move();
        }
        else if(!canMove() && turns == 0)
        {
            turns++;
        }
        else if(turns == 1 || turns == 9)
        {
           turn();
           setColor(Color.BLUE);
           turns++;
        }
        else if(turns == 2 || turns == 10)
        {
           turn();
           setColor(Color.RED);
           turns++;
        }
        else if(turns == 3 || turns == 11)
        {
           turn();
           setColor(Color.GREEN);
           turns++;
        }
        else if(turns == 4 || turns == 12)
        {
           turn();
           setColor(Color.YELLOW);
           turns++;
        }
        else if(turns == 5 || turns == 13)
        {
           turn();
           setColor(Color.ORANGE);
           turns++;
        }
        else if(turns == 6 || turns == 14)
        {
           turn();
           setColor(Color.CYAN);
           turns++;
        }
        else if(turns == 7 || turns == 15)
        {
           turn();
           setColor(Color.PINK);
           turns++;
        }
        else if(turns == 8)
        {
           turn();
           setColor(Color.MAGENTA);
           turns++;
        }
        else if(turns == 16 && corner == 1)
        {
            setDirection(315);
            setColor(Color.MAGENTA);
            turns = 0;
        }
        else if(turns == 16 && corner == 2)
        {
            setDirection(45);
            setColor(Color.MAGENTA);
            turns = 0;
        }
        else if(turns == 16 && corner == 3)
        {
            setDirection(135);
            setColor(Color.MAGENTA);
            turns = 0;
        }
        else if(turns == 16 && corner == 4)
        {
            setDirection(225);
            setColor(Color.MAGENTA);
            turns = 0;
        }
    }
}
