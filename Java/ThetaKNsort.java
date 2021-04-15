import java.util.Arrays;  
/**
 *  ThetaKNsort
 *  
 *  An algorithm that sorts n distinct integers, ranging in size between 1
 *  and kn inclusive, where k is a constant positive integer. ( Hint: Use a kn element array.) 
 * 
 *  TimeComplexity: O(kn)
 * 
 * 
 *  Problem from the book "Foundations of Algorithms" by Richard Neapolitan:
 * 
 * Write a Θ( n ) algorithm that sorts n distinct integers, ranging in size between 1
 * and kn inclusive, where k is a constant positive integer. ( Hint: Use a kn element array.) 
 * 
 *  @author Aleksandr Molchagin
 *  @version April 14, 2021
 */
public class ThetaKNsort {
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] 
     *             
     **/
    public static void main(String[] args) {
        System.out.print("\n\tWelcome to the ThetaKNsort program. (Java)\n");

        /* Test case */
        int [] nums = {2, 55, 3, 1, 1000, 23, 1231, 99, 120, 9, 4, 101, 202, 45, 48};

        System.out.print("\n\t\tThe solution: " + Sort(nums));
        
        System.out.print("\n\n\tProgram done.\n");
    }
    /**
     *  The Sorting function that sorts n distinct integers, ranging in size between 1 and kn inclusive.
     *    @param    int[] - array of integers that needs to be sorted
     *             
     **/
    public static String Sort(int[] nums) {

        //First, let's find the maximum element and make it k constant
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k)
                k = nums[i];
        }

        // Let's create HashArray which serves as a hashtable: each index represents a number,
        // and the value of the index shows if a number exist (1) or if it doesn't exist (0)

        int HashArray[] = new int[k+1];       //Size of the array is the maximum value we obtained from the given array
        for (int i = 0; i <= k; i++) {
            HashArray[i] = 0;
            //System.out.println(i + ": " + HashArray[i]);
        }

        //Let's assign 1 to existing integers
        for (int i = 0; i < nums.length; i++) {
            HashArray[nums[i]] = 1;
        }

        //Now let's finally sort the given array! We use j as an index of the given array, and go through the whole
        //hasharray to find existing numbers and put them back into the array.
        int j = 0;
        for (int i = 0; i <= k; i++) {
            if (HashArray[i] == 1){
                nums[j] = i;
                j++;
            }
        }
        //Return an answer as a string
        return ("\n\tSorted array: " + Arrays.toString(nums));
    }
}

