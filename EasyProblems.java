import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Grinding easy problems and calculating the time complexity  
 * 
 * Source: leetcode.com
 */
public class EasyProblems {


    /**
     * Write a program that outputs the string representation of numbers from 1 to n.
     * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
     * For numbers which are multiples of both three and five output “FizzBuzz”.
     * 
     * Time Complexity : O(n)
     */
    public static List<String> fizzBuzz(int n) {
        
        ArrayList<String> fb = new ArrayList<String>();
        
        for (int i = 1; i < n+1; i++) {
            
            if (i % 3 == 0 && i % 5 == 0)
                fb.add("FizzBuzz");
            else if (i % 5 == 0) 
                fb.add("Buzz");
            else if (i % 3 == 0)
                fb.add("Fizz");
            else 
                fb.add(""+i);
        }
        
        return fb;
        
    }

    /**
     * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
     * 
     * Time Complexity : O(n+n) = O(2n) = O(n)
     */
    public static int firstUniqChar(String s) {
        
        int[] count = new int[26];
        int n = s.length();
        
        for (int i = 0; i < n; i++) { // O(n)
            count[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < n; i++) {   // O(n)
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }
        
        return -1;
    }


    /**
     * Given two arrays, write a function to compute their intersection.
     * 
     * Time complexity: O(n)
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        // sorting ASC
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {  // O(n)

            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                arr.add(nums1[i]);
                i++; j++;
            }
        }

        int[] result = new int[arr.size()];

        for (i = 0; i<arr.size(); i++) { // O(n)
            result[i] = arr.get(i); // arr.get -> O(1)
        }   
        return result;
    }

    /**
     * Write a function that reverses a string. The input string is given as an array of characters char[].
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     * You may assume all the characters consist of printable ascii characters.
     * 
     * Time Complexity : O(n)
    */ 
    public static void reverseString(char[] s) {

        int i = s.length-1;
        int j = 0;
        char tmp;
        while (i >= j) {    // O(n)
            // swap
            tmp = s[i];
            s[i--] = s[j];
            s[j++] = tmp;
        }
    }

    /**
     * Given an integer n, return true if it is a power of three. Otherwise, return false.
     * An integer n is a power of three, if there exists an integer x such that n == 3x.
     * 
     * Time complexity : O(n)
     */
    public static boolean isPowerOfThree(int n) {

        if (n > 1) {
            while (n % 3 == 0) {    // O(n)
                n /= 3;
            }
        }
        return n == 1;
    }

    /**
     * Given an array nums, write a function to move all 0's to the end of it while 
     * maintaining the relative order of the non-zero elements.
     * 
     * Time complexity: O(n)
     * 
     * [0,1,0,3,12] -> [1,3,12,0,0]
    */

    public static void moveZeroes(int[] nums) {
        int temp;
        int j = 0;
        for (int i = 0; i < nums.length; i++) { // O(n)
            if (nums[i] != 0) {
                // swap
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String args[]) {

        long start = System.nanoTime();

        // intersect(new int[]{1,2,2,1},new int[]{2,2});
        // reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        // System.out.println(isPowerOfThree(45));
        moveZeroes(new int[]{0,1,0,3,12});

        long end = System.nanoTime();
        System.out.println("execution time : " + (end-start) + " ns");
    }
}