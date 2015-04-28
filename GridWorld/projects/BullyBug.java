package projects;

/**
 * Creates a BullyBug.
 * 
 * Justin Liang
 * Period 1
 * 3/22/09
 */
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
import java.awt.Color;

public class BullyBug extends Bug
{

    /**
     * Overrides and modifies the canMove method in the Bug class.
     * Same method as canMove method in Bug class except that when the BullyBug
     * has a Rock in front of it, it gets removed.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        if(neighbor instanceof Rock)
        {
            gr.remove(next);
        }
            
        return (neighbor == null) || (neighbor instanceof Flower);
        
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
    
    /**
     * Moves to the next location that the BullyBug is facing.
     * If there are any regular Bugs around it, they will be scared of the BullyBug
     * and turn the opposite direction and keep on moving.
     */
    public void act()
    {
        BoundedGrid grid = (BoundedGrid)getGrid();        
        
        ArrayList<Actor> bug = grid.getNeighbors(this.getLocation());
        boolean turn = true;
        for(int i = 0; i < bug.size(); i++)
        {
            Actor neigh = bug.get(i);
            if(neigh instanceof Bug)
            {
                neigh.setDirection(neigh.getDirection() + Location.HALF_CIRCLE);
                turn = false;                
            }
        }
        
        if(canMove())
        {
            move();
        }
        else if(!canMove() && turn == false)
        {
        }
        else if(!canMove() && turn == true)
        {
            turn();
        }
    }
    
    /**
     * Main method.
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        BullyBug mrLuc = new BullyBug();
        mrLuc.setColor(Color.BLUE);
        Bug justin = new Bug();
        justin.setDirection(justin.getDirection() + 180);
        Bug raymond = new Bug();
        raymond.setDirection(raymond.getDirection() + 90);
        Bug michael = new Bug();
        michael.setDirection(michael.getDirection() + 270);
        Bug vien = new Bug();
        world.add(new Location(9, 5), mrLuc);
        world.add(new Location(5, 0), raymond);
        world.add(new Location(7, 9), michael);
        world.add(new Location(1, 5), justin);
        world.add(new Location(0, 5), new Rock());
        world.add(new Location(0, 3), new Rock());
        world.add(new Location(8, 9), new Rock());
        world.show();
    }
}