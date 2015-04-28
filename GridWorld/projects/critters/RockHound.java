package projects.critters;


/**
 * Write a description of class RockHound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;
public class RockHound extends Critter
{
    /**
     * A RockHound processes its actors like a normal Critter except that it
     * only removes Rock actors that are around it.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if ((a instanceof Rock))
                a.removeSelfFromGrid();
        }
    }
}