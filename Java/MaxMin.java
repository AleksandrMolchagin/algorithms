/**
 *  MaxMin 1.5n
 *  
 *  An algorithm that finds both the smallest and the largest numbers in a list of n numbers through 1.5n comparisons.
 *  Time complexity: 1 + 1.5n 
 *                   O(n)
 * 
 * 
 *  Problem from the book "Foundations of Algorithms" by Richard Neapolitan:
 * 
 *  Write an algorithm that finds both the smallest and largest numbers in a list of n numbers. 
 *  Try to find a method that does at most 1.5 n comparisons of array items.
 *w 
 
 *  @author Aleksandr Molchagin
 *  @version April 8, 2021
 */
public class MaxMin
{
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     *              (but main methods always need this parameter)
     **/
    public static void main(String[] args)
    {
        System.out.print("\n\tWelcome to the MaxMin program. (Java)\n");

        /* Test case */
        int [] nums = {2, 9, 55, 3, 1, 111100};

        System.out.print("\n\tThe solution; " + Find(nums));
        
        System.out.print("\n\n\tProgram done.\n");

    }

    public static String Find(int[] nums) {

        //Global max value
        int globalMax = nums[nums.length-1];
        //Global min value
        int globalMin = nums[nums.length-1];

        /*We make the global values as the last number of the array, 
        so we do no need to go through this number if an array contains 
        odd number of integers*/

        int maxIndex = nums.length-1;   //if there are even number of integers in an array

        if (nums.length % 2 == 1){      //if there are odd number of integers in an array
            maxIndex = nums.length-2; 
        }

        for (int i = 0; i <= maxIndex; i+=2) {   
            int localMax;
            int localMin;

            // Find local max and min values
            if (nums[i] > nums[i+1]){
                localMax = nums[i];
                localMin = nums[i+1];
            }
            else {
                localMax = nums[i+1];
                localMin = nums[i];
            }
            //Compare the local max and the global max value
            if (localMax > globalMax){
                globalMax = localMax;
            }
            //Compare the local min and the global min value
            if (localMin < globalMin){
                globalMin = localMin;
            }
        }
        //Return an answer as a string
        return ("\n\tMax value is: " + globalMax + "\n\tMin value is: " + globalMin);
    }
}

