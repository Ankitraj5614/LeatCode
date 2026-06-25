package LeetCode.stack;

import java.util.Stack;

/*
 * 36 Min Stack   
A Min Stack is a special kind of stack where, along with the regular push and pop operations, you also 
have an extra operation to get the minimum value from the stack at any given time. This means, no 
matter how many elements you push or pop, you should always be able to retrieve the minimum 
element in constant time. 
The goal is to implement a stack with these three main operations: 
1. Push: Add an element to the top of the stack. 
2. Pop: Remove the element from the top of the stack. 
3. GetMin: Retrieve the minimum element in the stack without removing it. 
Key Points: 
• In a normal stack, you can only access the last element added (top of the stack). But here, you 
need to know what the minimum value is at any time, even if it's not the top element. 
• The challenge is to make getMin() efficient, i.e., O(1) time complexity, while still keeping the 
stack's behavior intact. 
Solution Strategy: 
To keep track of the minimum efficiently, we can use two stacks: 
1. Main Stack: This stack will hold all the elements you push, just like a normal stack. 
2. Min Stack: This stack will keep track of the minimum elements at every stage. Every time a new 
element is pushed onto the main stack, you also push the current minimum onto the min stack. 
When you pop from the main stack, you also pop from the min stack.
 */
public class Min_Stack {
	// Main method for testing 
	private Stack<Integer> mainStack;
	private Stack<Integer> minStack;
	// 
	//Constructor to initialize the stacks 
	public void minStack() {
		mainStack = new Stack<>();
		minStack = new Stack<>();
	}
	// Push an element onto the stack
	public void push(int val) {
		mainStack.push(val);
		// Push the minimum value so far into the minStack
		if(minStack.isEmpty() || val <= minStack.peek())
			minStack.push(val);
	}
	
	// Pop the element from the top of the stack 
	public void pop() {
		if(mainStack.isEmpty()) {
			return;
		}
		// If the popped element is the minimum, pop it from the minStack too
		if(mainStack.peek().equals(minStack.peek()))
			minStack.pop();
		mainStack.pop();
	}
	// Get the top element of the stack 
	 public int top() { 
	  return mainStack.peek(); 
	 } 
	 
	 
	 
	 // Get the minimum element in the stack 
	 public int getMin() { 
	  return minStack.peek(); 
	 } 
	 
	 
	 
	 public static void main(String[] args) { 
	  Min_Stack stack = new Min_Stack(); 
	 
	  // Test operations 
	  stack.push(-2); 
	  stack.push(0); 
	  stack.push(-3); 
	  System.out.println("Current minimum: " + stack.getMin()); // Output: -3 
	  stack.pop(); 
	  System.out.println("Current minimum after pop: " + stack.getMin()); // Output: -2 
	 }
}
