package LeetCode.Array;

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] n = {10, 9, 83, 23,456,73,74,677,767,67,77,87};
		int target = 83;
		System.out.println(InsertPosition(n,target));
	}
	public static int InsertPosition(int[] n, int t) {
		int left = 0 , right = n.length;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(n[mid] == t)
				return mid;
			else if (n[mid] < t)
				left = mid + 1;
			else 
				right = mid;
		}
		return left;
		
	}
}
