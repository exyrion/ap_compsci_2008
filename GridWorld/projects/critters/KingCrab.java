package projects.critters;


/**
 * Write a description of class KingCrab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;

public class KingCrab extends CrabCritter
{
    /**
     * Instead of removing the Actor in front of the crab, the KingCrab will
     * make the Actor move one unit up. If the unit can not move up, the KingCrab
     * will eat the Actor like a normal CrabCritter.
     * @param actors the ArrayList
     */
    public void processActors(ArrayList<Actor> actors)
    {
        Grid grid = getGrid();
        for(int i = 0; i < actors.size(); i++)
        {
            Actor a = actors.get(i);
            if (!(a instanceof Rock) && !(a instanceof Critter))
            {
                Location loc = a.getLocation();
                int r = loc.getRow();
                int c = loc.getCol();
                Location temp = new Location(r-1, c);
                if(grid.isValid(temp) && grid.get(temp) == null)
                {
                    a.moveTo(temp);
                }
                else
                {
                    grid.remove(loc);
                }
            }
        }
    }
}