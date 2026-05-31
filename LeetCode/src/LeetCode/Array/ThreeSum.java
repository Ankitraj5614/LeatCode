package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//3Sum  
	//Given an array of integers nums, find all unique triplets (a, b, c) such that: 
		//• a + b + c = 0 
	//• The solution set should not contain duplicate triplets. 

	//Example: 
		//• Input: nums = [-1, 0, 1, 2, -1, -4] 
		//• Output: [[-1, -1, 2], [-1, 0, 1]] 

	//Approach: 
/*• Sort the Array: Sorting helps us avoid duplicates and makes it easier to apply the two-pointer 
technique. 
• Fix one number: Use a loop to fix one number, then find the other two numbers using two 
pointers (start and end of the remaining part of the array). 
• Check for triplet sum = 0. 
• Skip duplicates: After finding one triplet, skip over any duplicates to avoid repeating the same 
triplet.*/ 
public class ThreeSum {
	public static void main(String[] args) { 
		  int[] nums = { -1, 0, 1, 2, -1, -4 }; 
		  List<List<Integer>> result = threeSum(nums); 
		 
		  System.out.println("Triplets that sum to 0:"); 
		  for (List<Integer> triplet : result) { 
		   System.out.println(triplet); 
		  } 
		 }

	private static List<List<Integer>> threeSum(int[] nums) {
		  List<List<Integer>> result = new ArrayList<>(); 
		  if (nums == null || nums.length < 3) 
		   return result; 
		 
		  // Step 1: Sort the array 
		  Arrays.sort(nums); 
		 
		 
		 
		  // Step 2: Iterate through the array 
		  for (int i = 0; i < nums.length - 2; i++) { 
		   // Skip duplicate values for the first number 
		   if (i > 0 && nums[i] == nums[i - 1]) 
		    continue; 
		 
		   // Use two-pointer approach to find the remaining two numbers 
		   int left = i + 1, right = nums.length - 1; 
		   while (left < right) { 
		    int sum = nums[i] + nums[left] + nums[right]; 
		 
		    if (sum == 0) { 
		     // We found a valid triplet 
		     result.add(Arrays.asList(nums[i], nums[left], nums[right])); 
		 
		     // Move both pointers and skip duplicates 
		     while (left < right && nums[left] == nums[left + 1]) 
		      left++; 
		     while (left < right && nums[right] == nums[right - 1]) 
		      right--; 
		 
		     left++; 
		     right--; 
		    } else if (sum < 0) { 
		     // We need a larger sum, move left pointer 
		     left++; 
		    } else { 
		     // We need a smaller sum, move right pointer 
		     right--; 
		    } 
		   } 
		  } 
		 
		  return result; 
		
	} 

}
