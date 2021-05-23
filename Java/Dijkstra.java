import java.util.Random;   
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 *  Dijkstra algorithm
 * 
 *  An algorithm that determines the shortest paths from v1 to all other vertices in a weighted, directed graph.
 *  
 *  Time complexity: O(n^2)
 *
 *  @author Aleksandr Molchagin
 *  @version May 21, 2021
 */

public class Dijkstra
{
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     *              (but main methods always need this parameter)
     **/
    public static void main(String[] args)
    {
        System.out.print("\n\tWelcome to Dijkstra program. (Java)\n");

                //TRUE = enable run timer to print the algorithm's execution time in microseconds
                boolean timeTest = true; 

                long startTime = 0; long endTime = 0; long totalTime = 0;

        //Matrix parameters
        int vertices = 8;
        int maxWeight = 9;
        
        int [][] matrix = getRandomDijkstraMatrix(vertices, maxWeight+1, true);
        
        printMatrix("\n\tGenerated matrix:\n", matrix);

                //Start timer (IF timeTest = TRUE)
                if (timeTest == true) { startTime = System.nanoTime();};

        /* Compute the shortest paths*/
        int[] distances = dijkstra(matrix); 

                //End timer, get timer's value in nanoseconds, convert nanoseconds into microseconds
                if (timeTest == true) {endTime = System.nanoTime();  totalTime = (endTime - startTime); long ms = NANOSECONDS.toMicros(totalTime); System.out.println("\n\tThe runtime is " + ms + " microseconds");};
    
        System.out.print("\n\tThe solution:\n");

        for (int i = 0; i <= matrix.length - 1; i++){
            System.out.print("\n\tv1 -> v" + (i+1) + " = " + distances[i]);
        }

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
                if (matrix[i][j] == Integer.MAX_VALUE)
                    System.out.print("- ");  
                else  
                    System.out.print(matrix[i][j] + " ");
            } 
            System.out.print("\n\t");
        }
    }
    /**
     *  A function that returns a randomly generated graph specificaly designed for Dijkstra problem.
     * 
     *    @param    vertices - the number of vertices
     *    @param    max - maximum weight
     *    @param    increaseInfProb - increases probability of infinity distances (means no route) between the note
     * 
     *    @return   randomly generated matrix
     **/
    public static int[][] getRandomDijkstraMatrix(int vertices, int max, boolean increaseInfProb){

        int [][]matrix = new int[vertices][vertices];
        int h, g;
        int infProb = 0;
        Random random = new Random();  

        for (h = 0; h <= vertices-1; h++){
            for (g = 0; g <= vertices-1; g++){
                int x = random.nextInt(max);
                if (h == g) { 
                    matrix[h][g] = 0;
                }
                else {
                    infProb = random.nextInt(4); 
                    if (infProb > 2 && increaseInfProb) 
                        matrix[h][g] = Integer.MAX_VALUE;
                    else {
                        matrix[h][g] = x;
                        matrix[g][h] = x;
                    }
                }
            }
        };
        return matrix;  
    }
    /**   
     *    Function that implements Dijkstra’s algorithm and returns an array of distances.
     * 
     *    @param matrix - matrix with direct distances between edges
     *   
     *    @return calculated shortest distances      
     **/
    public static int[] dijkstra(int matrix[][]) {
        //Infinity value
        int INF = Integer.MAX_VALUE;
        //The number of vertices
        int v = matrix.length;
        //Array of visited vertices
        boolean visited[] = new boolean[v];
        //Distance for vertices, first is 0
        int[]distances = new int[v];

        distances[0] = 0;
        //Set infinity to each path after the first one
        for (int i = 1; i < v; i++){
            distances[i] = INF;
        } 

        //Calculate distances
        for (int i = 0; i < v - 1; i++){
            //Find the vertex with minimum distance
            int minVertex = -1;
            for (int k = 0; k < distances.length; k++){
                if(visited[k] == false && (minVertex == -1 || distances[k] < distances[minVertex])){
                    minVertex = k;
                }
            }
            System.out.println("Min vertex: " + minVertex  +", visited[minVertex]: " + visited[minVertex]);
            //Now this edge was visited
            visited[minVertex] = true;

            //Cacluale the distances
            for (int j = 0; j < v; j++){
                if (matrix[minVertex][j] != INF && matrix[minVertex][j] != 0 && visited[j] == false && distances[minVertex] != INF){
                    int newDistance = distances[minVertex] + matrix[minVertex][j];
                    if (newDistance < distances[j]){
                        distances[j] = newDistance;
                        System.out.println("\tj:"  + j +  " New distance: " + newDistance  +", matrix[minVertex][j]: " + matrix[minVertex][j]);
                    }
                }
            }
        }
        //Return all distances
        return distances;
    }
}

