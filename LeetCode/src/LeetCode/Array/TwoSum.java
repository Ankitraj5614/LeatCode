package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] a = {2,23,4,5,4,5,6};
		int target= 9;
		int[] n=findTarget(a, target);
		// Print the result (the indices of the two numbers that add up to the target) 
		  System.out.println("index1=" + n[0] + ", index2=" + n[1]); 
	}
	public static int[]  findTarget(int[] n, int t) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n.length; i++) {
			int c = t - n[i];
			if(map.containsKey(c)) {
				return new int[] {map.get(c) +1, i +1};
			}
			map.put(n[i], i);
		}
		
		return new int[]{-1,-1};
	}
}
