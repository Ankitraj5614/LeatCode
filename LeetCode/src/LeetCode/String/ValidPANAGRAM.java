package LeetCode.String;

import java.util.Scanner;

public class ValidPANAGRAM {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the 1st string");
		String s=sc.nextLine();
		sc.close();
		if(isPanagram(s))
			System.out.println("A string is panagram ");
		else 
			System.out.println("A String is not panagram ");
	}
	public static boolean isPanagram(String s) {
		if(s.length()<26)
			return false;
		int[] freq =getFreqArray(s);
		for(int i=0;i<26;i++) {
			if(freq[i]==0)
				return false;
		}
		return true;
	}
	
	public static int[] getFreqArray(String s){
		int[] freq=new int[26];
		for(char c:s.toCharArray()) {
			if(c>=65 && c<=90)
				freq[c-65]++;
			else if(c>=97 && c<=122)
				freq[c-97]++;
		}
		return freq;
	}
}
