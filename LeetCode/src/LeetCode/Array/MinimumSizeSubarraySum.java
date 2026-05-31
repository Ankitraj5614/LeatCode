package LeetCode.Array;
//Minimum Size Subarray Sum 

/*	Given an array of positive integers nums and a positive integer target, return the minimal 
		length of a contiguous subarray of which the sum is greater than or equal to target. If 
		there is no such subarray, return 0 instead. */

//Example: 

//• Input: target = 7, nums = [2, 3, 1, 2, 4, 3] 

//• Output: 2 

//Explanation: The subarray [4, 3] has the minimal length of 2 with a sum equal to 7. 

//Approach: 

/*To solve this problem efficiently, we can use the sliding window technique: 
	1. Use two pointers (or a window) to keep track of a portion of the array. 
	
	2. Expand the window by adding elements to the right until the sum becomes greater than or 
		equal to the target. 
	
	3. Once the sum is greater than or equal to the target, try to minimize the window by removing 
		elements from the left, and check if this gives the smallest subarray. 
	
	4. Repeat the process until you've scanned the whole array.*/
public class MinimumSizeSubarraySum {
	
	public static int minSubArrayLen(int t, int[] nums) {
		// Initialize variables 
		int minLength = Integer.MAX_VALUE ;// To store the minimum length found 
		int sum = 0; //// To store the current sum of the window 
		int left = 0;// Left pointer for the sliding window 
		
		// Iterate over the array with the right pointer 
		for(int right =0; right < nums.length; right++) {
			
			// Add the current element to the sum
			sum += nums[right];
			
			// When the sum is greater than or equal to the target 
			while(sum >= t) {
				// Update the minimum length if the current window is smaller 
				minLength = Math.min(minLength ,right -left + 1 );
				
				// Remove the left element from the sum and move the left pointer 
				sum -= nums[left];
				left++;
			}
		}
		// If we found a valid subarray, return the minimum length, otherwise return 0
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
	
	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 }; 
		  int target = 7; 
		 
		  int result = minSubArrayLen(target, nums); 
		  System.out.println("The minimum length of the subarray is: " + result); 

	}
}
