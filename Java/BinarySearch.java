import java.util.Arrays;  
/**
 *  Binary Search
 *  
 *  A search alrgorithm for SORTED arrays that devides the search interval in half.
 *  Time complexity: Log2(n)
 * 
 * 
 *  LeetCode problem:
 * 
 *  Given an array of integers nums which is sorted in ascending order, and
 *  an integer target, write a function to search target in nums. If target
 *  exists, then return its index. Otherwise, return -1.
 *
 *  @author Aleksandr Molchagin
 *  @version April 4, 2021
 */
public class BinarySearch
{
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     *              (but main methods always need this parameter)
     **/
    public static void main(String[] args)
    {
        System.out.print("\n\tWelcome to the Binary Search program. (Java)\n");

        /* Test case */
        int [] nums = {-1,0,3,5,9,12};
        int target = 9;

        System.out.print("\n\tGiven array: " + Arrays.toString(nums) + "\n\tTarget: "  + target + "\n\n\tPosition found: " + search(nums, target) + "\n");
        

        System.out.print("\n\tProgram done.\n");

    }

    public static int search(int[] nums, int target) {

        //First number's index
        int low = 0;

        //Last number's index
        int high = nums.length - 1;

        //Mid index
        int mid;
        
        while (low <= high)
        {
            mid = (high + low) / 2;

            if (nums[mid] == target)
                    return mid;
            
            //If mid index != target, compare and make left/right step
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        //Return -1 if not found
        return -1;
    }

}

