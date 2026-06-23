package LeetCode.Array;

import java.util.Stack;

public class ValidParentheses {
	public Boolean isValid(String n) {
		Stack<Character> st = new Stack<>();
		for (char c : n.toCharArray()) {
			if (c == '(' || c == '{' || c == '[')
				st.push(c);
			else {
				char top = st.pop();
				if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
					return false; // Mismatch in pair
				}
			}
		} 

		// If stack is empty, all brackets matched
		return st.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		String input = "([{}])";
		boolean result = vp.isValid(input);
		System.out.println("Is valid? " + result); // Output: true
	}
}
