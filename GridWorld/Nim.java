/**
 * Plays a game of Nim.
 * 
 * @Justin Liang
 * @10/16/08
 * @Period 1
 */

import java.util.Random;
import java.util.Scanner;
public class Nim
{
    /**
     * Plays a game of Nim.
     * A pile of marbles is made and the amount of marbles in the pile is a random number between 10-100.
     * The human player plays against the computer.
     * The program randomly selects whether the computer or player goes first.
     * The computer is randomly selected to play in smart mode or stupid mode. 
     * The human player and computer take turns taking away marbles from the pile.
     * No one can take more than half the amount of marbles in the current pile.
     * The person who takes the last marble loses.
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        Random nimGenerator = new Random();
        
        int size = nimGenerator.nextInt(91)+10;
        int firstTurn = nimGenerator.nextInt(2);
        int smartStupid = nimGenerator.nextInt(2);
        
        System.out.println("There are " +size+ " marbles.");
        
        if(firstTurn == 0)
        {
            System.out.println("The computer will go first.");
            
            if(smartStupid == 0)
            {
                System.out.println("The computer will play stupid.");
                {   
                    boolean done = true;
                    while(done)
                    {   
                        if(size == 1) 
                        {
                            System.out.println("");
                            System.out.println("It is the computer's turn.");
                            System.out.println("The computer took away 1. There are 0 marbles.");
                            System.out.println("");
                            System.out.println("You have won!");
                            System.out.println("");
                            break;
                        }
                        
                        System.out.println("");
                        System.out.println("It is the computer's turn.");
                        int compTakes = nimGenerator.nextInt(size/2)+1;
                        size = size - compTakes;
                        System.out.println("The computer took away " +compTakes+ ". There are now " +size+ " marble(s).");
                        
                        if(size == 1)
                        {
                            System.out.println("");
                            System.out.println("You have lost!");
                            System.out.println("");
                            break;
                        }
                        
                        boolean illegal = true;
                        while(illegal)
                        {
                            System.out.println("");
                            System.out.println("It is your turn. How much will you take away?");
                            System.out.println("");
                            int youTake = in.nextInt();
                            size = size - youTake;
                            System.out.println("You took away " +youTake+ ". There are now " +size+ " marble(s).");
                        
                            if(youTake > (size+youTake)/2 || youTake <= 0)
                            {   
                                size = size + youTake;
                                System.out.println("");
                                System.out.println("You have made taken an illegal amount of marbles.");
                                System.out.println("The marbles are back to " + size + ".");                                
                                illegal = true;
                            }
                        
                            else
                            {
                                illegal = false;
                            }
                        }
                    }
                }
            }
            
            if(smartStupid == 1)
            {
                System.out.println("The computer will play smart.");
                {
                    
                boolean done = true;
                    while(done)
                    {
                        int enough = 0;
                        
                        if(size > 63)
                        {
                            enough = size - 63;
                        }
                        else if(size > 31 && size < 63)
                        {
                            enough = size - 31;
                        }
                        else if(size > 15 && size < 31)
                        {
                            enough = size - 15;
                        }                        
                        else if(size > 7 && size < 15)
                        {
                            enough = size - 7;
                        }
                        else if(size > 3 && size < 7)
                        {
                            enough = size - 3;
                        }
                        else if(size < 3 && size > 1)
                        {
                            enough = 1;
                        }
                        else
                        {
                            if(size == 1)
                            {
                            enough = 1;
                            }
                            
                            else
                            {
                            enough = nimGenerator.nextInt(size/2)+1;
                            }
                        }
                        
                        if(size == 1) 
                        {
                            System.out.println("");
                            System.out.println("It is the computer's turn.");
                            System.out.println("The computer took away 1 marble. There are 0 marbles.");
                            System.out.println("");
                            System.out.println("You have won!");
                            System.out.println("");
                            break;
                        }
                        
                        System.out.println("");
                        System.out.println("It is the computer's turn.");
                        int compTakes = enough;
                        size = size - compTakes;
                        System.out.println("The computer took away " +compTakes+ ". There are now " +size+ " marble(s).");
                        
                        if(size == 1)
                        {
                            System.out.println("You have lost!");
                            System.out.println("");
                            break;
                        }
                        
                        boolean illegal = true;
                        while(illegal)
                        {
                            System.out.println("");
                            System.out.println("It is your turn. How much will you take away?");
                            System.out.println("");
                            int youTake = in.nextInt();
                            size = size - youTake;
                            System.out.println("You took away " +youTake+ ". There are now " +size+ " marble(s).");
                        
                            if(youTake > (size+youTake)/2 || youTake <= 0)
                            {   
                                size = size + youTake;
                                System.out.println("");
                                System.out.println("You have made taken an illegal amount of marbles.");
                                System.out.println("The marbles are back to " + size + ".");
                                illegal = true;
                            }
                        
                            else
                            {
                                illegal = false;
                            }
                        }
                    }
                }
            }
        }
            
        else if(firstTurn == 1)
        {
            System.out.println("You will go first.");
            
            if(smartStupid == 0)
            {
                System.out.println("The computer will play stupid.");
                {
                    boolean done = true;
                    while(done)
                    {   
                        
                        if(size == 1)
                        {
                            System.out.println("You have lost!");
                            System.out.println("");
                            break;
                        }
                        
                        boolean illegal = true;
                        while(illegal)
                        {
                            System.out.println("");
                            System.out.println("It is your turn. How much will you take away?");
                            System.out.println("");
                            int youTake = in.nextInt();
                            size = size - youTake;
                            System.out.println("You took away " +youTake+ ". There are now " +size+ " marble(s).");
                        
                            if(youTake > (size+youTake)/2 || youTake <= 0)
                            {   
                                size = size + youTake;
                                System.out.println("");
                                System.out.println("You have made taken an illegal amount of marbles.");
                                System.out.println("The marbles are back to " + size + ".");
                                illegal = true;
                            }
                        
                            else
                            {
                                illegal = false;
                            }
                        }
                        
                        if(size == 1) 
                        {
                            System.out.println("");
                            System.out.println("It is the computer's turn.");
                            System.out.println("The computer took away 1. There are 0 marbles.");
                            System.out.println("");
                            System.out.println("You have won!");
                            System.out.println("");
                            break;
                        }
                        
                        System.out.println("");
                        System.out.println("It is the computer's turn.");
                        int compTakes = nimGenerator.nextInt(size/2)+1;
                        size = size - compTakes;
                        System.out.println("The computer took away " +compTakes+ ". There are now " +size+ " marble(s).");
                    }
                }
            }
            
            if(smartStupid == 1)
            {
                System.out.println("The computer will play smart.");
                {
                    boolean done = true;
                    while(done)
                    {   
                        
                        if(size == 1)
                        {   
                            System.out.println("");
                            System.out.println("You have lost!");
                            System.out.println("");
                            break;
                        }
                        
                        boolean illegal = true;
                        while(illegal)
                        {
                            System.out.println("");
                            System.out.println("It is your turn. How much will you take away?");
                            System.out.println("");
                            int youTake = in.nextInt();
                            size = size - youTake;
                            System.out.println("You took away " +youTake+ ". There are now " +size+ " marble(s).");
                        
                            if(youTake > (size+youTake)/2 || youTake <= 0)
                            {   
                                size = size + youTake;
                                System.out.println("");
                                System.out.println("You have made taken an illegal amount of marbles.");
                                System.out.println("The marbles are back to " + size + ".");
                                illegal = true;
                            }
                        
                            else
                            {
                                illegal = false;
                            }
                        }
                        
                        int enough = 0;
                        
                        if(size > 63)
                        {
                            enough = size - 63;
                        }
                        else if(size > 31 && size < 63)
                        {
                            enough = size - 31;
                        }
                        else if(size > 15 && size < 31)
                        {
                            enough = size - 15;
                        }                        
                        else if(size > 7 && size < 15)
                        {
                            enough = size - 7;
                        }
                        else if(size > 3 && size < 7)
                        {
                            enough = size - 3;
                        }
                        else if(size < 3 && size > 1)
                        {
                            enough = 1;
                        }
                        else
                        {
                            if(size == 1)
                            {
                            enough = 1;
                            }
                            
                            else
                            {
                            enough = nimGenerator.nextInt(size/2)+1;
                            }
                        }
                        
                        if(size == 1) 
                        {
                            System.out.println("");
                            System.out.println("It is the computer's turn.");
                            System.out.println("The computer took away 1. There are 0 marbles.");
                            System.out.println("");
                            System.out.println("You have won!");
                            System.out.println("");
                            break;
                        }
                        
                        System.out.println("");
                        System.out.println("It is the computer's turn.");
                        int compTakes = enough;
                        size = size - compTakes;
                        System.out.println("The computer took away " +compTakes+ ". There are now " +size+ " marble(s).");
                    }
                }
            }
        }
    }
}