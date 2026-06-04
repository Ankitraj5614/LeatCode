package StreamApiQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class nthLargest {
	public static void main(String[] args ) {
		int[] n = {23,29,73,9,87,8,78,91,68,96,87,6,72,89,78,7,787,7,28,77};
		int l = 4;
		nthLargestNum(n, l);
		nthSmallestNum(n,l);
	}
	public static void nthLargestNum(int[] n, int l) {
		ArrayList<Integer> ar = new ArrayList<>();
		for(int i : n) {
			ar.add(i);
		}
		ar.stream().sorted()
		.forEach(b->System.out.print(b+" "));;
		System.out.println();
		int largest = ar.stream()
				.sorted(Comparator.reverseOrder())
				.skip(l-1)
				.findFirst()
				.orElseThrow();
		System.out.println(largest);
	}
	public static void nthSmallestNum(int[] n, int s) {
		int smallest = Arrays.stream(n)
				.boxed()
				.sorted()
				.skip(s-1)
				.findFirst()
				.get();
	System.out.println(smallest);
	}
}
