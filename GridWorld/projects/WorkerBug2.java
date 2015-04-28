package projects;


/**
 * Write a description of class WorkerBug2 here.
 * 
 * @author (Ken) 
 * @version (a version number or a date)
 */
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
public class WorkerBug2 extends Bug
{
   
    private int position;
    private int row;
    private int col;
    private int steps;
    private boolean found;
    public WorkerBug2()
    {
        position = -1;
        row = 0;
        col = 0;
        steps = -1;
        found = false;
    }
    
    public void findLocation()
    {
        Location loc = this.getLocation();
        row = loc.getRow();
        col = loc.getCol();
    }
    
    public void findPosition()
    {
        BoundedGrid grid = (BoundedGrid) getGrid();
        Location loc = this.getLocation();
        row = loc.getRow();
        col = loc.getCol();
        
        ArrayList<Actor> neigh = grid.getNeighbors(this.getLocation());
        for(int i = 0; i < neigh.size(); i++)
        {
            Actor queen =  neigh.get(i);
            if(queen instanceof QueenBug2)
            {
                found = true;
                Location locQ = queen.getLocation();
                int rowQ = locQ.getRow();
                int colQ = locQ.getCol();
            
                if(row == rowQ && col > colQ) //east
                {
                    setDirection(Location.NORTH); 
                    steps = 1;
                }
                else if(row < rowQ && col > colQ)
                {
                   //northeast
                   setDirection(Location.WEST);
                    steps = 0;
                }
                else if(row < rowQ && col == colQ)
                {
                    //north
                    setDirection(Location.WEST);
                    steps = 1;
                }
                else if(row < rowQ && col < colQ)
                {
                    //northwest
                    setDirection(Location.SOUTH);
                    steps = 0;
                }
                else if(row == rowQ && col < colQ)
                {
                    //west
                    setDirection(Location.SOUTH);
                    steps = 1;
                }
                else if(row > rowQ && col < colQ)
                {
                    //southwest
                    setDirection(Location.EAST);
                    steps = 0;
                }
                else if(row > rowQ && col == colQ)
                {
                    //south
                    setDirection(Location.EAST);
                    steps = 1;
                }
                else if(row > rowQ && col > colQ)
                {
                    //southeast
                    setDirection(Location.NORTH);
                    steps = 0;
                }
             }
        }
                
    }
    public void act()
    {
        findPosition();
        //if(steps == -1 && canMove())
          //  move();
        if (!found)
        {
            if(canMove())
                move();
            else
                turn();
            
            return;
        }
            
        if (steps < 2 && canMove())
        {
            move();
            steps++;
        }
        else
        {
            
            setDirection(getDirection() + 90);
            steps = 0;
        }
       
        
    }
    
    
}
