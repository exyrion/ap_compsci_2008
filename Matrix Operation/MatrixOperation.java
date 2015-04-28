/**
 * Multiplies the scalar to a matrix, add 2 matrices together, subtract 2 matrices, or multiply 2 matrices.
 * 
 * Justin Liang, Jessica Chen, Michelle Hartono
 * 10/30/08
 * Period 1
 */
import java.util.Scanner;

public class MatrixOperation
{
    /**
     * Multiplies the user-inputed matrix by a user-inputed scalar.
     */
    public void scalar ()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the matrix dimensions [row column]: ");
        int rows = input.nextInt();
        int columns = input.nextInt();
        
        System.out.println("Enter the scalar: ");
        int scale = input.nextInt();
        
        int [][] xy = new int [rows][columns];
        int spacing = 0;
        
        System.out.println("Enter the elements of the matrix: ");
           
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                xy[i][j]=input.nextInt();
            }
        }       
        
        int max = xy[0][0];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if (Math.abs(xy[i][j]) > max)
                max = xy[i][j];
                String maxL = max + "";
                int length = maxL.length();
                String length1 = xy[i][j] + "";
                int length2 = length1.length();
                spacing = (length+1) - length2;
            }
        }
        
        System.out.println (spacing);
        System.out.println("Your final matrix is: ");
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++)
            {
                System.out.print (scale * xy [r][c]);
                for (int s = 1; s < spacing; s++)
                {
                    System.out.print (" ");
                }
                
            }
            System.out.println ();
        }
    }
    
    /**
     * Adds two user-inputed matrices together.
     */
    public void add ()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the first matrix dimensions [row column]: ");
        int rowsFirst = input.nextInt();
        int columnsFirst = input.nextInt();
        System.out.println("Enter the second matrix dimensions [row column]: ");
        int rowsSecond = input.nextInt();
        int columnsSecond = input.nextInt();
        
        int [][] xyFirst = new int [rowsFirst][columnsFirst];
        int [][] xySecond = new int [rowsSecond][columnsSecond];
        
        boolean go = true;
        while (go)
        {
            if (rowsFirst != rowsSecond && columnsFirst != columnsSecond)
            {
                System.out.println("Operation denied.");
                break;
            }
            else if (rowsFirst == rowsSecond && columnsFirst == columnsSecond)
            {
                
            System.out.println("Enter the elements of matrix A : ");
           
            for(int i=0;i<rowsFirst;i++)
            {
                for(int j=0;j<columnsFirst;j++)
                {
                    xyFirst[i][j]=input.nextInt();
                }
            }
           
            System.out.println("Enter the elements of matrix B : ");
                
            for(int i=0;i<rowsSecond;i++)
            {
                for(int j=0;j<columnsSecond;j++)
                {
                    xySecond[i][j]=input.nextInt(); 
                }
            }
                System.out.println("Your final matrix is: ");
                for (int r = 0; r < rowsFirst; r++)
                {
                    for (int c = 0; c < columnsFirst; c++)
                    {
                    System.out.print((xyFirst[r][c] + xySecond[r][c]) + " ");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }
    
    /**
     * Subtracts 2 user-inputed matrices from each other.
     */
    public void sub()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the first matrix dimensions [row column]: ");
        int rowsFirst = input.nextInt();
        int columnsFirst = input.nextInt();
        System.out.println("Enter the second matrix dimensions [row column]: ");
        int rowsSecond = input.nextInt();
        int columnsSecond = input.nextInt();
        
        int [][] xyFirst = new int [rowsFirst][columnsFirst];
        int [][] xySecond = new int [rowsSecond][columnsSecond];
        
        boolean go = true;
        while (go)
        {
            if (rowsFirst != rowsSecond && columnsFirst != columnsSecond)
            {
                System.out.println("Operation denied.");
                break;
            }
            else if (rowsFirst == rowsSecond && columnsFirst == columnsSecond)
            {           
                System.out.println("Enter the elements of matrix A : ");
           
                for(int i=0;i<rowsFirst;i++)
                {
                    for(int j=0;j<columnsFirst;j++)
                    {
                        xyFirst[i][j]=input.nextInt();
                    }
                }
                    
                System.out.println("Enter the elements of matrix B : ");
                
                for(int i=0;i<rowsSecond;i++)
                {
                    for(int j=0;j<columnsSecond;j++)
                    {
                        xySecond[i][j]=input.nextInt(); 
                    }
                }

                System.out.println("Your final matrix is: ");
            
                for (int r = 0; r < rowsFirst; r++)
                {
                    for (int c = 0; c < columnsFirst; c++)
                    {
                        System.out.print((xyFirst[r][c] - xySecond[r][c]) + " ");
                    }
                    System.out.println();
                }
                break;
            }
        }        
    }
    
    /**
     * Multiplies 2 user-inputed matrices.
     */
    public void mult ()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the first matrix dimensions [row column]: ");
        int rowsFirst = input.nextInt();
        int columnsFirst = input.nextInt();
        System.out.println("Enter the second matrix dimensions [row column]: ");
        int rowsSecond = input.nextInt();
        int columnsSecond = input.nextInt();
        
        int [][] xyFirst = new int [rowsFirst][columnsFirst];
        int [][] xySecond = new int [rowsSecond][columnsSecond];
        int [][] finalMatrix = new int [rowsFirst][columnsSecond];
        int [] row1 = new int [rowsFirst];
        int [] column1 = new int [columnsFirst];
        int [] row2 = new int [rowsSecond];
        int [] column2 = new int [columnsSecond];
        
        boolean done = true;
        
        while(done)
        {
            if(columnsFirst != rowsSecond)
            {
                System.out.println("Operation denied.");
                break;
            }
           
            System.out.println("Enter the elements of matrix A : ");
           
            for(int i=0;i<rowsFirst;i++)
            {
                for(int j=0;j<columnsFirst;j++)
                {
                    xyFirst[i][j]=input.nextInt();
                }
            }
           
            System.out.println("Enter the elements of matrix B : ");
                
            for(int i=0;i<rowsSecond;i++)
            {
                for(int j=0;j<columnsSecond;j++)
                {
                    xySecond[i][j]=input.nextInt(); 
                }
            }
            
            int [][] xy = new int [rowsFirst][columnsSecond];
            for (int r = 0; r < rowsFirst; r++)
            {
                for (int c = 0; c < columnsSecond; c++)
                {
                    for (int k = 0; k < columnsSecond; k++)
                    {
                    xy[r][c] = xy[r][c] + (xyFirst[r][k] * xySecond[k][c]);
                    }
                }
            }
            
            System.out.println("Your final matrix is: ");
            for (int r = 0; r < rowsFirst; r++)
            {
                for (int c = 0; c < columnsSecond; c++)
                {
                    System.out.print (xy[r][c] + " ");
                }
                System.out.println ();
            }
            break;           
        }
    }
    
    /**
     * Runs the program.
     */
    public static void main(String[] args)
    {
        boolean done = true;
        while(done)
        {
            Scanner input = new Scanner(System.in);
        
            MatrixOperation trix = new MatrixOperation();
            System.out.println("Selections:");
            System.out.println("Press [1] to perform scalar multiplication.");
            System.out.println("Press [2] to perform matrix addition.");
            System.out.println("Press [3] to perform matrix subtraction.");
            System.out.println("Press [4] to perform matrix multiplication.");
            System.out.println("Press [0] to exit the program.");
            
            System.out.println("Please enter your selection: ");
            int select = input.nextInt();
            System.out.println();
        
            if (select == 1)
                trix.scalar();
            else if (select == 2)
                trix.add();
            else if (select == 3)
                trix.sub();
            else if (select == 4)
                trix.mult();
            else if (select == 0)
                break;
        }  
    }
}
