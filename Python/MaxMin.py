from typing import List
"""
   MaxMin 1.5n
   
   An algorithm that finds both the smallest and the largest numbers in a list of n numbers through 1.5n comparisons.
   Time complexity: 1.5n 
                    O(n)
  
  
   Problem from the book "Foundations of Algorithms" by Richard Neapolitan:
  
   Write an algorithm that finds both the smallest and largest numbers in a list of n numbers. 
   Try to find a method that does at most 1.5 n comparisons of array items.
 
   @author Aleksandr Molchagin
   @version April 8, 2021
   
"""

def Find(nums: List[int]) -> str:

    #Global max value
    globalMax = nums[len(nums) - 1]
    #Global min value
    globalMin = nums[len(nums)-1]

    """ We make the global values as the last number of the array, 
        so we do no need to go through this number if an array contains 
        odd number of integers
    """

    maxIndex = len(nums)-1   #if there are even number of integers in an array

    if (len(nums) % 2 == 1):     #if there are odd number of integers in an array
        maxIndex = len(nums)-2 
    

    for i in range (0, maxIndex + 1 , 2): 
        #Find local max and min values
        if nums[i] > nums[i+1]:
            localMax = nums[i]
            localMin = nums[i+1]
        else:
            localMax = nums[i+1]
            localMin = nums[i]

        #Compare the local max and the global max value
        if localMax > globalMax:
            globalMax = localMax
        #Compare the local min and the global min value
        if localMin < globalMin:
            globalMin = localMin

    #Return an answer as a string
    return "Max value is: ", globalMax, "Min value is: ", globalMin;

if __name__ == "__main__":
    print("\n\tWelcome to the MaxMin program. (Python)");

    #Test case
    nums = [2, 9, 55, 3, 1, 111100];

    print("\n\tFound solution: ", Find(nums));

    print("\n\tProgram done.");


