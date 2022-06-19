import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
     * TODO https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/ 
        Given an integer array nums where the elements are sorted in ascending order, 
        convert it to a height-balanced binary search tree.

        A height-balanced binary tree is a binary tree in which the depth of 
        the two subtrees of every node never differs by more than one.
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
    
        // 1 2 3 4 5 6 7
        int mid = nums.length/2; 

        TreeNode root = new TreeNode();
        root.val = nums[mid];

        root.left = new TreeNode();
        root.left.val = nums[mid-1];

        root.right = new TreeNode();
        root.right.val = nums[mid+1];
        
        return root;
    }

    /** 
     * 
        TODO https://leetcode.com/problems/greatest-common-divisor-of-strings/
        For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

        Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.


        O (n * n^(1/2)) --> O(n)
     */
    public static String gcdOfStrings(String str1, String str2) {

        if (str1.equals(str2)) {    // O(n) todo remove?
            return str1;
        }

        
        // str1 ABABAB , str2 ABAB

        int str1Len = str1.length();
        int str2Len = str2.length();


        if (str1Len % str2Len == 0) {
            
        }

        for (int i = 0; i < str1.length(); i++) {

            

        }

        

        String gcd = "";

        


        return gcd;
    }


    /** 
        A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each of the words consists of only uppercase and lowercase English letters (no punctuation).

        For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
        You are given a sentence s​​​​​​ and an integer k​​​​​​. You want to truncate s​​​​​​ such that it contains only the first k​​​​​​ words. Return s​​​​​​ after truncating it.
    */
    public static String truncateSentence(String s, int k) {

        char c;
        StringBuilder result = new StringBuilder(); // doesn't recreate string over and over in a loop
        int spaceCount = 0;

        for (int i = 0; i < s.length(); i++) {  // O(n)

            c = s.charAt(i);    // O(1)

            if (c == ' ') {
                spaceCount++;
            }

            if (spaceCount == k) {
                break;
            }

            result.append(c);   // O(1)
        }

        return result.toString();
    }


    // You are given an array of strings words (0-indexed).

    // In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].

    // Return true if you can make every string in words equal using any number of operations, and false otherwise.
    public static boolean makeEqual(String[] words) {

        StringBuilder wordsStr = new StringBuilder();

        for (int i = 0; i < words.length; i++) { // O(n)

            wordsStr.append(words[i]);  // O(1)
        }

        if (wordsStr.length() % words.length != 0) {
            return false;
        }

        int[] charCount = new int[26];
        char c;

        for (int i = 0; i < wordsStr.length(); i++) {

            c = wordsStr.charAt(i);

            charCount[c - 'a']++;
        }

        for (int i = 0; i < charCount.length; i++) {

            if (charCount[i] % words.length != 0) {
                return false;
            } 
        }

        return true;
    }


    // Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

    // A substring is a contiguous sequence of characters within a string.

    public static int maxLengthBetweenEqualCharacters(String s) {
        
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char c;
        int max = -1;
        
        for (int i = 0; i < s.length(); i++) {

            c = s.charAt(i);

            if (hashMap.containsKey(c)) {

                max = Math.max(max, i - 1 - hashMap.get(c));  

            } else {

                hashMap.put(c, i);
            }
        }

        return max;
    }


    // Given a binary string s, return true if the longest contiguous segment of 1's is strictly longer than the longest contiguous segment of 0's in s, or return false otherwise.
    // For example, in s = "110100010" the longest continuous segment of 1s has length 2, and the longest continuous segment of 0s has length 3.
    // Note that if there are no 0's, then the longest continuous segment of 0's is considered to have a length 0. The same applies if there is no 1's
    public static boolean checkZeroOnes(String s) {

        if (s == '1' + "") {
            return true;
        }

        char c1;
        char c2;
        int max0 = 0;
        int max1 = 0;
        int count = 1;

        for (int i = 0; i < s.length(); i++) {

            c1 = s.charAt(i);

            if (c1 == '0' && max0 < count) {
                max0 = count;
            }

            if (c1 == '1' && max1 < count) {
                max1 = count;
            }

            if (i == s.length()-1) {
                break;
            }

            c2 = s.charAt(i+1);

            if (c1 != c2) {
                count = 1;
            } else {
                count++;
            }
        }

        return max1 > max0;
    }


	// A binary tree is uni-valued if every node in the tree has the same value.

	// Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
	public static boolean isUnivalTree(TreeNode root) {
		MutableBoolean isUnivalTree = new MutableBoolean(true);
		isUnival(root, root.val, isUnivalTree);
		return isUnivalTree.getValue();
    }

	private static void isUnival(TreeNode node, int rootVal, MutableBoolean isUnivalTree) {

		if (node == null) {
			return;
		}

		if (node.val != rootVal) {
			isUnivalTree.setValue(false);
			return;
		}

		isUnival(node.left, rootVal, isUnivalTree);
		isUnival(node.right, rootVal, isUnivalTree);
	}

	private static class MutableBoolean {

		private boolean value;

		public MutableBoolean(boolean value) {
			this.value = value;
		}

		public boolean getValue() {
			return this.value;
		}

		public void setValue(boolean value) {
			this.value = value;
		}

	}

    
    public static void main(String args[]) {

        long start = System.nanoTime();

		TreeNode root = new TreeNode(1);
		TreeNode chidl1 = new TreeNode(1);
		TreeNode chidl2 = new TreeNode(1);
		TreeNode chidl3 = new TreeNode(1);
		root.left = chidl1;
		root.left.right = chidl2;
		root.right = chidl3;
        System.out.println(isUnivalTree(root));
        
        long end = System.nanoTime();

        System.out.println("execution time : " + (end-start)+ " ns");
    }
} 
