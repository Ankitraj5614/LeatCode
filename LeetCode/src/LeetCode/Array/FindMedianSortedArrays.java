package LeetCode.Array;

public class FindMedianSortedArrays {
	public static void main(String[] args) { 
		  int[] nums1 = { 1, 3 }; 
		  int[] nums2 = { 2 }; 
		 
		  // Find the median and print the result 
		  double result = findMedianSortedArrays(nums1, nums2); 
		  System.out.println("Median: " + result); // Output: Median: 2.0 
		 
		  // Another example 
		  int[] nums3 = { 1, 2 }; 
		  int[] nums4 = { 3, 4 }; 
		 
		 
		 
		  // Find the median and print the result 
		  double result2 = findMedianSortedArrays(nums3, nums4); 
		  System.out.println("Median: " + result2); // Output: Median: 2.5 
		 }

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length >nums2.length) {
			int[] temps = nums1;
			nums1 = nums2;
			nums2 = temps;
		}
		int x =0, y= 0 ;
		int low =0;
		int high = 0;
		while(low <= high) {
			int partitionX = (low + high) /2;
			int partionionY = (x + y + 1)/ 2 - partitionX ;
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE: nums1[partitionX - 1];
			int minRightX = (partitionX == y) ?  Integer.MAX_VALUE : nums1[partitionX];
			
			
			int maxLeftY = (partionionY == 0) ? Integer.MIN_VALUE : nums2[partionionY - 1];
			int minRightY = (partionionY == y) ? Integer.MAX_VALUE : nums2[partionionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				
				if((x + y) % 2 == 0) {
					return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
				}else {
					return Math.max(maxLeftY, maxLeftY);
				}
				
			} else if(maxLeftX > minRightY) {
				high = partitionX - 1; 
			}
			else {
				low = partitionX +1;
			}
		}
		throw new IllegalArgumentException("Input arrays are not sorted.");
	}
}
