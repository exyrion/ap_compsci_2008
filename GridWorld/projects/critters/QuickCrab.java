package projects.critters;

/**
 * Write a description of class QuickCrab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;

public class QuickCrab extends CrabCritter
{
    /**
     * Get possible move locations the same way as a CrabCritter except
     * for the fact that it will search 2 squares to the left or the right
     * instead of 1.
     * @return returns the possible move locations in the array list.
     */
    public ArrayList<Location> getMoveLocations()
    {
        Grid grid = getGrid();
        
        ArrayList<Location> locs = new ArrayList<Location>();
        Location loc = getLocation();
        int r = loc.getRow();
        int c = loc.getCol();
        Location locLeft = new Location(r, c-1);
        Location tempLeft = new Location(r, c-2);
        Location locRight = new Location(r, c+1);
        Location tempRight = new Location(r, c+2);
        if(grid.isValid(locLeft) && grid.get(locLeft) == null && grid.isValid(tempLeft) && grid.get(tempLeft) == null)
        {
            locs.add(tempLeft);
        }
        if(grid.isValid(locRight) && grid.get(locRight) == null && grid.isValid(tempRight) && grid.get(tempRight) == null)
        {
            locs.add(tempRight);
        }
        else if(locs.size() == 0)
        {
            return super.getMoveLocations();
        }
        return locs;
    }
}
