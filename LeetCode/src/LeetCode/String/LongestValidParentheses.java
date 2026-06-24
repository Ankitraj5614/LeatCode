package LeetCode.String;

import java.util.Stack;
/*
 * 34 Longest Valid Parentheses  
 
 
 
You are given a string made up of just parentheses ( and ). Your task is to find the length 
of the longest substring where the parentheses are valid. By "valid," we mean that each 
opening parenthesis ( has a matching closing parenthesis ), and they are correctly 
ordered.  
For example: 
• For the string "(()", the longest valid substring is "()", which has a length of 2. 
• For the string ")()())", the longest valid substring is "()()", which has a length of 4. 
Your job is to return this longest valid substring's length. 
Example: 
• Input: "(()" 
• Output: 2 
• Input: ")()())" 
• Output: 4 
Approach: 
To solve this problem, we can use a stack to keep track of the positions of parentheses. Here's how: 
1. Using a Stack: 
o We'll push the index of every opening parenthesis ( onto the stack. 
o If we encounter a closing parenthesis ), we check if there's an unmatched opening parenthesis 
on top of the stack (i.e., if the stack isn't empty). If there is, we pop the index from the stack and 
calculate the length of the valid substring using the difference between the current index and 
the index at the new top of the stack. 
o If the stack is empty when we encounter a closing parenthesis, it means this ) doesn't have a 
matching (, so we push its index onto the stack as a marker. 
2. Tracking Valid Substring Length: 
o The difference between the current index and the top of the stack gives us the length of the 
valid substring. 
3. Edge Case: 
o If the string is empty, or there are no valid parentheses, the result should be 0. 
 */

public class LongestValidParentheses {
	
	
	public int longestValidParentheses(String s) { 
		  Stack<Integer> stack = new Stack<>(); 
		  stack.push(-1); // Initial base for when we calculate lengths 
		 
		  int maxLength = 0; 
		 
		  for (int i = 0; i < s.length(); i++) { 
		   char c = s.charAt(i); 
		 
		 
		 
		   if (c == '(') { 
		    // Push the index of '(' onto the stack 
		    stack.push(i); 
		   } else { 
		    // For ')' we pop the last '(' index from the stack 
		    stack.pop(); 
		 
		   if (stack.isEmpty()) { 
		    // If stack is empty, push current index as base for future calculations 
		     stack.push(i); 
		    } else { 
		     // Calculate the length of the valid substring 
		     int currentLength = i - stack.peek(); 
		     maxLength = Math.max(maxLength, currentLength); 
		    } 
		   } 
		  } 
		 
		  return maxLength; 
		 } 
		 
		 public static void main(String[] args) { 
		  LongestValidParentheses solution = new LongestValidParentheses(); 
		  String input = ")()())"; 
		  int result = solution.longestValidParentheses(input); 
		 System.out.println("The length of the longest valid parentheses substring is: " + result);  
		        // Output: 4 
		 } 
}
