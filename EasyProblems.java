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

    private EasyProblems() {
    }

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


    /** 
     * TODO https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
     * 
     *  No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

        Given an integer n, return a list of two integers [A, B] where:

        A and B are No-Zero integers.
        A + B = n
        The test cases are generated so that there is at least one valid solution. If there are many valid solutions you can return any of them.

        Constraints:
            - 2 <= n <= 10^4
     */
    public static int[] getNoZeroIntegers(int n) {

        return new int[2]; 
    }



    /**
     * TODO Improve solution https://leetcode.com/problems/roman-to-integer/
        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9. 
        X can be placed before L (50) and C (100) to make 40 and 90. 
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.

     */
    public static int romanToInt(String s) {

        int val = 0;
        int i = 0;

        char currChar;
        char nextChar = 'Z';
        String combinedChars;

        while (i < s.length()) {
            
            currChar = s.charAt(i);

            if (i < s.length() - 1) {
                nextChar = s.charAt(i+1);
            }

            combinedChars = "" + currChar + nextChar;
            
            switch(combinedChars) {
                case "IV":
                    val+=4;
                    i+=2;
                    continue;
                case "IX":
                    val+=9;
                    i+=2;
                    continue;
                case "XL":
                    val+=40;
                    i+=2;
                    continue;
                case "XC":
                    val+=90;
                    i+=2;
                    continue;
                case "CD":
                    val+=400;
                    i+=2;
                    continue;
                case "CM":
                    val+=900;
                    i+=2;
                    continue;
            }

            switch(currChar) {
                case 'I': 
                    val++;
                    i++;
                    break;
                case 'V':
                    val+=5;
                    i++;
                    break;
                case 'X':
                    val+=10;
                    i++;
                    break;
                case 'L':
                    val+=50;
                    i++;
                    break;
                case 'C':
                    val+=100;
                    i++;
                    break;
                case 'D':
                    val+=500;
                    i++;
                    break;
                case 'M':
                    val+=1000;
                    i++;
                    break;
                default:
                    System.out.println("Character " + currChar + " is not valid");
                    i = s.length();
            }
        }
        
        return val;
    }


    /**
        TODO without converting to String https://leetcode.com/problems/palindrome-number/
        Given an integer x, return true if x is palindrome integer.

        An integer is a palindrome when it reads the same backward as forward.

        For example, 121 is a palindrome while 123 is not.
     */
    public static boolean isPalindrome(int x) {

        String numberString = x + "";

        char leftChar;
        char rightChar;
    
        for (int i = 0; i < numberString.length()/2; i++) { // O(n)

            leftChar = numberString.charAt(i);  // O(1)
            
            rightChar = numberString.charAt(numberString.length()-1-i); // O(1) + O(1) = O(1)

            if (leftChar != rightChar) {
                return false;
            }
        }

        return true;
    }

    /**
        Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".
     */
    public static String longestCommonPrefix(String[] strs) {

        String commonPrefix = "";

        if (strs.length == 0) {
            return commonPrefix;
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String str1 = strs[0];
        String str2;
        char char1;
        char char2;
        int i = 1;
        int j = 0;

        while (true) {

            str2 = strs[i++ % strs.length];

            if (j >= str1.length() || j >= str2.length()) {
                break;
            }

            char1 = str1.charAt(j);
            char2 = str2.charAt(j);

            
            if (char1 != char2) {
                return commonPrefix;
            }

            if (i == strs.length) {
                commonPrefix+=char1;
                j++;
            }

            i = (i % strs.length) + 1;
        }

        return commonPrefix;
    }


    /**
     * TODO correct solution : https://leetcode.com/problems/valid-parentheses/
        Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

            - Open brackets must be closed by the same type of brackets.
            - Open brackets must be closed in the correct order.

     */
    public static boolean isValid(String s) {
        
        boolean openParenthesis = false;
        boolean openBracket = false;
        boolean openCrochet = false;

        char currChar;

        for (int i = 0; i < s.length(); i++) {

            currChar = s.charAt(i);
            
            switch (currChar) {
                case '(':
                    openParenthesis = true;
                    break;
                case ')':
                    openParenthesis = false;
                    break;
                case '{':
                    openBracket = true;
                    break;
                case '}':
                    openBracket = false;
                    break;
                case '[':
                    openCrochet = true;
                    break;
                case ']':
                    openCrochet = false;
                    break;
                default:
                    System.out.println("invalid character" + s);
                    return false;
            }
        }

        return !(openParenthesis || openBracket || openCrochet);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
 
    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traversal(result, root);
        return result;
    }

    private static void traversal(List<Integer> result, TreeNode node) {

        if (node == null) {
            return;
        }

        traversal(result, node.left);
        result.add(node.val);
        traversal(result, node.right);
    }

    /** 
     * 
     * TODO https://leetcode.com/problems/remove-duplicates-from-sorted-array/
        Given an integer array nums sorted in non-decreasing order, 
        remove the duplicates in-place such that each unique element appears only once. 
        The relative order of the elements should be kept the same.

        Since it is impossible to change the length of the array in some languages, 
        you must instead have the result be placed in the first part of the array nums. 
        More formally, if there are k elements after removing the duplicates, 
        then the first k elements of nums should hold the final result.
        It does not matter what you leave beyond the first k elements.

        Return k after placing the final result in the first k slots of nums.

        Do not allocate extra space for another array. 
        You must do this by modifying the input array in-place with O(1) extra memory.
     */
    public static int removeDuplicates(int[] nums) {
        
        int k = 0;

        for (int i = nums.length-1; i > 0; i--) {

            int current = nums[i];
            int left = nums[i-1];

            if (left == current) {
                nums[i] = nums[i+1];
                nums[i+1] = current;
                k++;
            }
        }

        return k;
    }

    public static void main(String args[]) {

        long start = System.nanoTime();
        
        int[] t = new int[]{0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(t));
        
        for (int i : t) {
            System.out.print(i + ",");
        }

        long end = System.nanoTime();

        System.out.println("execution time : " + (end-start)+ " ns");
    }
} 