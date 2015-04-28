package projects.boxBug;


import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class Runner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        HexaBug alice = new HexaBug(3);
        world.add(new Location(3, 3), alice);
        world.show();
    }
}