package projects.critters;


/**
 * Write a description of class BlusterCritter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;
public class BlusterCritter extends Critter
{
    private static final double COLOR_FACTOR = 0.05;
    private int courageLevel = 0;
    
    /**
     * Constructs a BlusterCritter with a certain courage level.
     * @param courage the courage level of the BlusterCritter
     */
    public BlusterCritter(int courage)
    {
        courageLevel = courage;
    }
    
    /**
     * Instead of getting the actors the same way as a Critter,
     * the BlusterCritter will get actors that are within 2 squares of it.
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = getLocation();
        for(int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ )
        {
            for(int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++)
            {
                Location tempLoc = new Location(r,c);
                if(getGrid().isValid(tempLoc))
                {
                    Actor a = getGrid().get(tempLoc);
                    if(a != null && a != this)
                        actors.add(a);
                }
            }
        }
        return actors;
    }
    
    /**
     * Darkens the BlusterCritter.
     */
    public void darken()
    {
        Color c = getColor();            
        int red = (int) (c.getRed() * (1 - COLOR_FACTOR));
        int green = (int) (c.getGreen() * (1 - COLOR_FACTOR));
        int blue = (int) (c.getBlue() * (1 - COLOR_FACTOR));
            
        setColor(new Color(red, green, blue));
    }

    /**
     * Lightens the BlusterCritter.
     */
    public void lighten()
    {
        Color c = getColor();            
        int red = (int) c.getRed();
        int green = (int) c.getGreen();
        int blue = (int) c.getBlue();
        
        if(red < 255)
        {
            red++;
        }
        if(green < 255)
        {
            green++;
        }
        if(blue < 255)
        {
            blue++;
        }
        
        setColor(new Color(red, green, blue));
    }
    
    /**
     * Creates a counter actorCount that keeps track of how many critters are
     * near the BlusterCritter. If it's less than the courage level, it will
     * brighten. If it's more than the courage level, it will darken.
     * @param actors the ArrayList
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int actorCount = 0;
        for(int i = 0; i < actors.size(); i++)
        {
            if(actors.get(i) instanceof Critter)
            {
                actorCount++;
            }
        }
        
        if(actorCount < courageLevel)
        {
            lighten();
        }
        else if(actorCount >= courageLevel)
        {
            darken();
        }
    }
        
}