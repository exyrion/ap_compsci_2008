package projects.boxBug;


/**
 * Write a description of class BowTieBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import info.gridworld.actor.Bug;

public class BowtieBug extends Bug
{
    private int steps;
    private int sideLength;
    private int directionCheck = 0;
    
    /**
     * Constructs a Z bug that traces a square of a given side length
     * @param length the side length
     */
    public BowtieBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else if((steps >= sideLength || !canMove()) && directionCheck == 0)
        {
            turn();
            turn();
            turn();
            steps = 0;
            directionCheck = 1;
        }
        else if((steps >= sideLength || !canMove()) && directionCheck == 1)
        {
            turn();
            turn();
            turn();
            turn();
            turn();
            steps = 0;
            directionCheck = 2;
        }
        else if((steps >= sideLength || !canMove()) && directionCheck == 2)
        {
            turn();
            turn();
            turn();
            turn();
            turn();
            steps = 0;
            directionCheck = 3;
        }
        else if((steps >= sideLength || !canMove()) && directionCheck == 3)
        {
            turn();
            turn();
            turn();
            steps = 0;
            directionCheck = 0;
        }
        else if(!canMove())
        {
        }
    }
}