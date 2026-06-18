package LeetCode.Array;

import java.util.Random;

public class GuessNumberHigherOrLower {
	private int secretNumber; 
	 
	 public GuessNumberHigherOrLower(int n) { 
	  // Generate a secret number between 1 and n 
	  Random rand = new Random(); 
	  secretNumber = rand.nextInt(n) + 1; // +1 to include n in the range 
	 } 
	 
	 // Method to make a guess 
	 public String guess(int number) { 
	  if (number < secretNumber) { 
	   return "higher"; // Your guess is too low 
	  } else if (number > secretNumber) { 
	   return "lower"; // Your guess is too high 
	  } else { 
	   return "correct"; // You've guessed the number 
	  } 
	 } 
	 
	 // Method to play the game using binary search 
	 public int play(int n) { 
	  int low = 1; 
	  int high = n; 
	  int guess = 0; 
	 
	  while (low <= high) { 
	   guess = low + (high - low) / 2; // Calculate mid-point 
	   String result = guess(guess); // Make a guess and get the feedback 
	 
	   if (result.equals("correct")) { 
	    return guess; // Return the correct guess 
	   } else if (result.equals("higher")) { 
	    low = guess + 1; // Adjust the low range 
	   } else { 
	    high = guess - 1; // Adjust the high range 
	   } 
	  } 
	  return -1; // This should not happen in a valid game 
	 } 
	 
	 
	 
	 public static void main(String[] args) { 
	 GuessNumberHigherOrLower game = new GuessNumberHigherOrLower(10); // Secret number in range [1, 10] 
	  int correctGuess = game.play(10); // Start the game 
	  System.out.println("The correct guess is: " + correctGuess); 
	 } 
	 
}
