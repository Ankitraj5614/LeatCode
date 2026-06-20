package LeetCode.String.practice;

import java.util.Arrays;
import java.util.Comparator;

public class CountWord {
	public static void main(String[] args) {
		String n = "the ram amm kahta hai the ram amm kahra hai ";
		
		CountWord1(n);
		System.out.println("  \n");
		String[] s = n.split(" ");
		for(String i : s) {
			System.out.print(i+" ");
		}
		int[] t = {10, 394,5,580,978,74,68,7,4,667,51,8974,62,87,0,68};
		NthLargest(t);
	}
	public static void CountWord1(String n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n.length(); i++) {
			char c = n.charAt(i);
			if(c!= ' ') {
				sb.append(c);
			}
			else if((c==' '||i != n.length()-1)&& !sb.toString().isBlank()) {
				System.out.print(sb.reverse() +" ");
				sb.delete(0, sb.length());
			}
		}
	}
	public static void NthLargest(int[] n) {
		int i = Arrays.stream(n)
			.boxed()
			.sorted(Comparator.reverseOrder())
			.skip(1)
			.findFirst()
			.get();
		System.out.println(i);
	}
}
