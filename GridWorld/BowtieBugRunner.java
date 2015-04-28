 

/**
 * Write a description of class BowtieBug here.
 * 
 * Justin Liang
 * Period 1
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.Actor;

public class BowtieBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        DiscoBug justin = new DiscoBug(1);
        justin.setColor(Color.ORANGE);
        DiscoBug vien = new DiscoBug(2);
        vien.setColor(Color.RED);
        DiscoBug luc = new DiscoBug(3);
        luc.setColor(Color.GREEN);
        DiscoBug michael = new DiscoBug(4);
        michael.setColor(Color.BLUE);
        
        world.add(vien);
        world.add(luc);
        world.add(michael);
        
        vien.display();
        luc.display();
        michael.display();
        world.show();
    }
}