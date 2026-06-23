package LeetCode.Array;
/*
 * 29 First Bad Version 
Imagine you're a tester for a software company, and you have a lot of versions of a software program. 
Most of these versions work perfectly, but at some point, a bad version was released, which contains a 
bug. Your job is to find the first bad version among all the versions available. 
You know that once a version is bad, all the versions released after it are also bad. So if you find a bad 
version, you can be sure that any version after it is also bad. 
Example: 
• Input: Versions: [1, 2, 3, 4, 5], with version 4 being the first bad version. 
• Output: 4 (This means versions 1, 2, and 3 are good, and version 4 is the first bad one.) 
 
Approach: 
To solve this problem, you can use a binary search method. This approach is efficient because it 
minimizes the number of checks needed to find the first bad version. 
1. Initialize Pointers: 
o Start with two pointers, left (the first version) and right (the last version). 
2. Binary Search: 
o While left is less than right: 
▪ Calculate the midpoint version: mid = left + (right - left) / 2. 
▪ Check if the mid version is bad: 
▪ If it is bad, it means the first bad version could be mid or any version before it, so 
you move the right pointer to mid. 
▪ If it is not bad, then the first bad version must be after mid, so you move the left 
pointer to mid + 1. 
3. Return Result: 
o When left equals right, you have found the first bad version. 

 */
public class VersionControl {
	// Simulating a method to check if a version is bad 
    public boolean isBadVersion(int version) { 
        // This method should be implemented by the testing framework 
        return version >= 4; // For example, versions 4 and above are bad 
    } 
 
 // Method to find the first bad version 
    public int firstBadVersion(int n) { 
        int left = 1; 
        int right = n; 
 
        while (left < right) { 
            int mid = left + (right - left) / 2; // Calculate mid-point 
            if (isBadVersion(mid)) { 
                right = mid; // Move right pointer to mid 
            } else { 
                left = mid + 1; // Move left pointer to mid + 1 
            } 
        } 
        return left; // The first bad version 
    } 
     
    public static void main(String[] args) { 
        VersionControl vc = new VersionControl(); 
        int n = 5; // Total versions 
        int firstBad = vc.firstBadVersion(n); 
        System.out.println("The first bad version is: " + firstBad); 
    }
}
