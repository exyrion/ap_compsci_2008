package projects;


/**
 * A Queen Bug with surrounding Worker Bugs.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import info.gridworld.grid.*;
import java.util.*;
import info.gridworld.actor.*;

public class QueenBug2 extends Bug
{
    public void act()
    {
        BoundedGrid grid = (BoundedGrid)getGrid();
        ArrayList<Actor> neighbors = grid.getNeighbors(this.getLocation());
        boolean moving = true;
        for(int i = 0; i < neighbors.size(); i++)
        {
            Actor neigh = neighbors.get(i);
            if ((neigh instanceof Bug))
                moving = false;
        }
        
        if(moving == true && canMove())
            move();
        else
            turn();
        
        
        
        
            
            
            
            
            
            
            
            
            
            
        
        
        
    }
}
