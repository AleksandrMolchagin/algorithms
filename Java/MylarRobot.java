import java.lang.reflect.Array;
import java.util.Random;   
import static java.lang.Math.min;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 *  MylarRobot
 * 
 *  Problem:
 * 
 *  Mylar the robot has a simple life. His sole purpose is to navigate from the top row of an NxN grid to the bottom row, 
 *  while consuming as little fuel as possible. Mylar is able to choose his starting column. At each time step he can select 
 *  from one of three possible actions: move straight down, or move diagonally down left or right. If Mylar ever attempts to
 *  step off the left or right edge of the grid, he reappears in the appropriate location on the opposite side.
 *
 *  Find more here: http://www.cs.kzoo.edu/cs215/HW/hw4.html
 * 
 *  Description of the solution:
 * 
 *  First, the program goes through the 1st row to find a column cell with the minimum amount of fuel. Since there are n columns, 
 *  the time complexity of this loop - 0(n). This cell will be the start. The amount of fuel is increased by the given amount of 
 *  fuel in this cell. After that, the program goes through each row choosing the minimum amount of fuel below the given position
 *  among the left, middle, or right columns. If the left column does not exist (index = -1), then we use the last column. If the
 *  right column does not exist (index = length of row), then we use the first column. The total amount of fuel is constantly
 *  increasing throughout all rows by given values inside the cells of choice. Since there are n rows, the time complexity
 *  of this loop is  0(n). The overall time complexity is: O(n) + O(n)
 * 
 *  Therefore, time complexity is O(n), where n is the number of rows.
 *
 *  @author Aleksandr Molchagin
 *  @version May 21, 2021
 */

public class MylarRobot
{
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     *              (but main methods always need this parameter)
     **/
    public static void main(String[] args)
    {
        System.out.print("\n\tWelcome to MylarRobot program. (Java)\n");

                //TRUE = enable run timer to print the algorithm's execution time in microseconds
                boolean timeTest = true; 

                long startTime = 0; long endTime = 0; long totalTime = 0;

        //Matrix parameters
        int rows = 20000;
        int columns = 20000;
        int maxWeight = 9;
        
        int [][] matrix = getRandomMatrix(rows, columns, maxWeight);

        //printMatrix("\n\tGenerated matrix:\n", matrix);
 

                //Start timer (IF timeTest = TRUE)
                if (timeTest == true) { startTime = System.nanoTime();};

        /* Compute the shortest paths*/
        int answer = findFinalFuel(matrix); 

                //End timer, get timer's value in nanoseconds, convert nanoseconds into microseconds
                if (timeTest == true) {endTime = System.nanoTime();  totalTime = (endTime - startTime); long ms = NANOSECONDS.toMicros(totalTime); System.out.println("\n\tThe runtime is " + ms + " microseconds");};
    
        System.out.print("\n\tThe solution, " + answer + "\n");

        System.out.print("\n\n\tProgram done.\n");
    }
    /**
     *  A function that prints the matrix.
     *    @param    printMessage - matrix's name or any other message.
     *    @param    matrix - matrix itself.
     **/
    public static void printMatrix(String printMessage, int matrix[][]){
        System.out.print(printMessage + "\n\t");
        int i, j;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            } 
            System.out.print("\n\t");
        }
    }
    /**
     *  A function that returns a randomly generated matrix.
     * 
     *    @param    columns - the number of matrix's columns
     *    @param    rows - the number of matrix's columns
     *    @param    max - maximum weight
     *     
     *    @return   randomly generated matrix
     **/
    public static int[][] getRandomMatrix(int rows, int columns, int max){

        int [][]matrix = new int[rows][columns];
        int h, g;

        Random random = new Random();  

        for (h = 0; h <= rows-1; h++){
            for (g = 0; g <= columns-1; g++){
                int x = random.nextInt(max);
                    matrix[h][g] = x + 1;
            }
        };

        return matrix;  
      
    }
    /**
     *  A function that computes the total ammount of fuel. 
     *    @param    int x - the current location in terms of horizontal line.
     *    @param    int y - the current location in terms of vertical line.
     *    @param    int fuel - total fuel.
     *    @param    int[][] matrix - matrix itself.
     *              
     **/
    public static int findFinalFuel(int matrix[][]) {

        //Variables for the next step
        int col = 0;
        int row = 0;

        //Choose the minimum weight from the 1st row
        int temp = matrix[0][0];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] < temp) {
                temp = matrix[0][i];
                col = i;
            }
        }

        int []Fuel = new int[matrix.length];
        Fuel[0] = matrix[row][col];

        int totalFuel = Fuel[0];
        
        //A loop for the rest of rows
        for (int i = 1; i <= Fuel.length - 1; i++) {


            // colA - left column
            int colA = col - 1;        
            if (colA == -1)
                colA = matrix[0].length - 1;
            int a = matrix[row + i][colA];

            // colB - straight down column
            int colB = col;
            int b = matrix[row + i][colB];
            
            // colC - right column
            int colC = col + 1;
            if (colC == matrix[0].length)
                colC = 0;
            int c = matrix[row + i][colC];
            
            //if left choice has the minimum fuel cost
            if (a <= b && a <= c) {
                Fuel[i] = a;
                col = colA;
            //if middle choice has the minimum fuel cost
            } else if (b <= c && b <= a) {
                Fuel[i] = b;
                col = colB;
            //if right choice has the minimum fuel cost
            } else {
                Fuel[i] = c;
                col = colC;
            }
            totalFuel += Fuel[i];
        }  
        return totalFuel;
    }
}

