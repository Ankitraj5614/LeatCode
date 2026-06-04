package LeetCode.Array;

public class ShortestWordDistance {
	public static void main(String[] args) {
		String[] n = {"coding", "practice", "tech","Learning", "market"};
		String word1 = "coding";
		String word2 = "tech";
		int a = sortWordDis(n, word1, word2);
		System.out.println(a);
	}
	public static int sortWordDis(String[] n, String s, String t) {
		int minLength = Integer.MAX_VALUE;
		int index =-1, index2 =-1;
		for(int i =0; i< n.length; i++) {
			if(n[i].equals(s))
				index = i;
			if(n[ i] .equals( t))
				index2 =i;
			if(index != -1 && index2 != -1) {
				minLength = Math.min(minLength, Math.abs(index- index2));
			}
		}
		return minLength;
	}
}
