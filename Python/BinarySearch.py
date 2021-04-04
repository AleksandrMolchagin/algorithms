from typing import List
"""
   Binary Search
   
   A search alrgorithm for SORTED arrays that devides the search interval in half.
   Time complexity: Log2(n)
  
   LeetCode problem:
  
   Given an array of integers nums which is sorted in ascending order, and
   an integer target, write a function to search target in nums. If target
   exists, then return its index. Otherwise, return -1.
 
   Author: Aleksandr Molchagin
   Version: April 4, 2021
   
"""

def BinarySearch(nums: List[int], target: int) -> int:

    #First number's index, last number's index
    low, high = 0, len(nums) - 1
    
    while low <= high:    
        mid = (high + low) // 2
        
        #If mid index != target, compare and make left/right step
                                                                 #This order of if statements makes the code faster!
        if nums[mid] < target:
            low = mid + 1
        elif nums[mid] > target:   
            high = mid - 1    
        else:
            return mid

    #Return -1 if not found
    return -1

if __name__ == "__main__":
    print("\n\tWelcome to the Binary Search program. (Python)");

    #Test case
    nums = [-1,0,3,5,9,12]
    target = 9

    print("\n\tGiven array: ", nums, "\n\tTarget: ", target, "\n\n\tPosition found: ", BinarySearch(nums, target));

    print("\n\tProgram done.");


