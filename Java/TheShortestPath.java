import java.lang.reflect.Array;
import java.util.Random;   
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 *  TheShortestPath (Floyd's Algorithm)
 *  
 *  An algorithm that computes the shortest paths from each vertex in a weighted graph to
 *  each of other vertices, and creates an array with the highest indexes of intermediate vertices.
 * 
 *  Time complexity: O(n^3)
 *
 *  @author Aleksandr Molchagin
 *  @version May 2, 2021
 */

public class TheShortestPath
{
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     *              (but main methods always need this parameter)
     **/
    public static void main(String[] args)
    {
        System.out.print("\n\tWelcome to TheShortestPath program. (Java)\n");

        /* No road number */
        int INF = 999;

        /* Test case */

        int n = 5; //n rows and n columns

        Random random = new Random();  


        int h, g;

        /* Matrix Generator */
        for (h = 0; h <= n-1; h++){
            for (g = 0; g <= n-1; g++){
                int x = random.nextInt(11);
                if (h == g)
                    W[h][g] = 0;
                else if ( x == 10 )
                    W[h][g] = INF;
                else
                    W[h][g] = x;
            }
        }

        printMatrix("\n\tGenerated matrix:", W);

        //Start timer to measure perfomance
        long startTime = System.nanoTime();
 
        /* Compute the shortest paths*/
        W = floyd(n, W); 

        //End timer
        long endTime = System.nanoTime();
        //Get timer's value in nanoseconds
        long totalTime = (endTime - startTime);
        //Convert nanoseconds in milliseconds
        long ms = NANOSECONDS.toMillis(totalTime);


        System.out.print("\n\tThe solution, " );
        printMatrix("the original matrix:", W);
        
        System.out.println("The runtime in milliseconds: " + ms + " ms");

        System.out.print("\n\n\tProgram done.\n");
    }
    /**
     *  A function that prints the matrix.
     *    @param    String printMessage - matrix's name or any other message.
     *    @param    int[][] matrix - matrix itself.
     *              
     **/
    public static void printMatrix(String printMessage, int matrix[][]){
        System.out.println(printMessage);
        int i, j;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 999)
                    System.out.print("- ");
                else
                    System.out.print(matrix[i][j] + " ");
            } 
            System.out.println();
        }
    };
    /**
     *  A function that computes the results (the shortest paths from each vertex) using Floyd's algorithm. 
     *    @param    int n - the number of verteces.
     *    @param    int[][] W - matrix itself.
     *              
     **/
    public static int[][] floyd(int n, int W[][]) {
        //Setting up variables
        int D[][] = W;
        int P[][] = new int[n][n];
        int i, j, k;

        //Making an array with the highest indexes of intermediate vertices empty
        for (i = 0; i <= n-1; i++) {
            for (j = 0; j <= n-1; j++)
                P[i][j] = 0;
        };

        //Floyd's algorithm
        for (k = 0; k <= n-1; k++){
            for(i = 0; i <= n-1; i++)
                for(j = 0; j <= n-1; j++)
                    if(D[i][k] + D[k][j] < D[i][j]) {
                        P[i][j] = k+1;                    //Assign the highest index of an intermediate vertix
                        D[i][j] = D[i][k] + D[k][j];
                    }
            }
          
                    
        printMatrix("\n\tA matrix with highest indexes of an intermediate vertices:", P); //SHOULD BE COMMENTED TO MEASURE THE PERFORMANCE
        
        //return the final matrix
        return D;
    }
}

