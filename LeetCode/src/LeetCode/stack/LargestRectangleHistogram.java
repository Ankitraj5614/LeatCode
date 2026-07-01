package LeetCode.stack;

import java.util.Stack;

/*
 * 37 Largest Rectangle in Histogram 
 
 
Imagine you have a histogram that looks like a series of bars next to each other. The 
height of each bar represents a number, and all the bars have the same width. The task 
is to find the largest rectangle that can be formed by combining one or more of these 
bars.   
Problem Breakdown: 
• You are given an array of numbers where each number represents the height of a bar in a histogram. 
• Your goal is to figure out the largest possible rectangle you can draw using the bars, where the width of 
the rectangle is determined by the number of consecutive bars you include, and the height is the 
smallest height of the bars in that range 
											6
										5	*
										*	*		
										*	*		3
								2	1	*	*	2	*
								*		*	*	*	*	
								*	*	*	*	*	*
Approach: 
	1. Stack: You can use a stack to help keep track of the bars, and for each bar, you find the largest rectangle 
		it can participate in. 
	2. Pop and calculate: Whenever you find a bar that's smaller than the one on top of the stack, you pop 
		from the stack and calculate the area of the rectangle that can be formed. 
 */
public class LargestRectangleHistogram {
	public static int largestRectangleArea(int[] heights) { 
        Stack<Integer> stack = new Stack<>(); 
        int maxArea = 0; 
        int n = heights.length; 
        
        // Traverse each bar in the histogram 
        for (int i = 0; i <= n; i++) { 
            // We need to process the last bar after the loop ends 
            int h = (i == n) ? 0 : heights[i]; 
             
            // When the current bar is smaller than the bar at stack's top, we pop 
            while (!stack.isEmpty() && h < heights[stack.peek()]) { 
                int height = heights[stack.pop()]; 
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; 
                maxArea = Math.max(maxArea, height * width); 
            } 
             
            // Push the current index into the stack 
            stack.push(i); 
        }          
        return maxArea; 
    } 
 
    // Main method to test the implementation 
    public static void main(String[] args) { 
        int[] heights = {2, 1, 5, 6, 2, 3}; 
        System.out.println("Largest rectangle area: " + largestRectangleArea(heights)); 
    }
}
