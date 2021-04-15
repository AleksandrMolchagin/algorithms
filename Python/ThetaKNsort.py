from typing import List
"""
    An algorithm that sorts n distinct integers, ranging in size between 1
    and kn inclusive, where k is a constant positive integer. ( Hint: Use a kn element array.) 
  
    TimeComplexity: O(kn)
  
    Problem from the book "Foundations of Algorithms" by Richard Neapolitan:
  
    Write a Θ( n ) algorithm that sorts n distinct integers, ranging in size between 1
    and kn inclusive, where k is a constant positive integer. ( Hint: Use a kn element array.) 
  
    Author: Aleksandr Molchagin
    Version: April 14, 2021
   
"""

"""
The Sorting function that sorts n distinct integers, 
ranging in size between 1 and kn inclusive.

Parameters: List[int] - list of integers that needs to be sorted
"""
def Sort(nums: List[int]) -> List[int]:

    # First, let's find the maximum element and make it k constant
    k = 0
    for i in range(0, len(nums), 1):
        if nums[i] > k:
            k = nums[i]
    
    # Let's create HashArray which serves as a hashtable: each index represents a number,
    # and the value of the index shows if a number exist (1) or if it doesn't exist (0)
    HashArray = [0] * (k+1)
    
    #Let's assign 1 to existing integers
    for i in range (0, len(nums) , 1):
        HashArray[nums[i]] = 1
    
    # Now let's finally sort the given array! We use j as an index of the given array, and go through the whole
    # hasharray to find existing numbers and put them back into the array.
    j = 0
    for i in range(0, k+1, 1):
        if HashArray[i] == 1:
            nums[j] = i
            j+=1

    # Return an answer as an array
    return nums

if __name__ == "__main__":
    print("\n\tWelcome to the ThetaKNsort program. (Python)")

    #Test case
    nums = [2, 55, 3, 1, 1000, 23, 1231, 99, 120, 9, 4, 101, 202, 45, 48]

    print("\n\tThe solution:")
    print("\t\tSorted Array: ", Sort(nums))

    print("\n\tProgram done.")
