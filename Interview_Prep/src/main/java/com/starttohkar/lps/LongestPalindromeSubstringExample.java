package com.starttohkar.lps;

/**
 *An example to find the longest palindromic substring in a given string using the expand around center approach.
 *
 * Algorithm:
 * 1. Initialize two pointers, start and end, to track the start and end indices of the longest palindromic substring found so far.
 * 2. Iterate through each character in the string, treating each character (and the space between characters) as a potential center of a palindrome.
 * 3. For each center, expand outwards to check for palindromic substrings. There are two cases to consider: odd-length palindromes (centered at a single character) and even-length palindromes (centered between two characters).
 * 4. For each expansion, calculate the length of the palindrome found and update the start and end pointers if a longer palindrome is found.
 * 5. After checking all potential centers, return the substring defined by the start and end pointers as the longest palindromic substring.
 *
 *
 * explain in line no 41 to 43:
 * In lines 41 to 43, we are checking if the length of the palindrome found (maxLen) is greater than the length of the currently recorded longest palindrome (end - start).
 * If it is, we update the start and end indices to reflect the new longest palindrome. The calculation for the new start index is done by subtracting half of the length of the palindrome (adjusted for odd/even length) from the current center index (i).
 * The end index is updated by adding half of the length of the palindrome to the current center index. This ensures that we correctly capture the boundaries of the longest palindromic substring found so far.
 *
 *
 * Time Complexity:
 * The time complexity of this algorithm is O(n^2), where n is the length of the input string. This is because for each character in the string, we may potentially expand outwards to check for palindromic substrings, which can take linear time in the worst case.
 * Space Complexity:
 * The space complexity of this algorithm is O(1), as we only use a constant amount of extra space to store the start and end indices of the longest palindromic substring found so far.
 *
 *
 *
 * Pseudocode
 * Step-by-Step Algorithm (Pseudocode)
 *
 * Initialize START = 0, END = 0
 *
 * For each index I from 0 to LENGTH(String) - 1:
 *
 *     // Step 1: Check for Odd Palindromes
 *     LEN1 = ExpandOutwards(String, left = I, right = I)
 *
 *     // Step 2: Check for Even Palindromes
 *     LEN2 = ExpandOutwards(String, left = I, right = I + 1)
 *
 *     // Step 3: Get the largest palindrome found at this center
 *     MAX_LEN = MAX(LEN1, LEN2)
 *
 *     // Step 4: If it is larger than our previous record, update pointers
 *     If MAX_LEN > (END - START + 1):
 *         START = I - (MAX_LEN - 1) / 2
 *         END = I + MAX_LEN / 2
 *
 * Return Substring from START to END
 *
 */
public class LongestPalindromeSubstringExample {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindromes (e.g., "aba", center is 'b')
            int len1 = expandFromMiddle(s, i, i);

            // Case 2: Even-length palindromes (e.g., "abba", center is between 'b' and 'b')
            int len2 = expandFromMiddle(s, i, i + 1);

            // Find the maximum of both cases
            int maxLen = Math.max(len1, len2);

            // Update indices if a longer palindrome is found
            if (maxLen > (end - start)) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromMiddle(String s, int left, int right) {
        // Expand outwards as long as characters match and indices are valid
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Returns the length of the palindrome found
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstringExample lps = new LongestPalindromeSubstringExample();
        String input = "babad";
        String longestPalindrome = lps.longestPalindrome(input);
        System.out.println("Longest Palindromic Substring of \"" + input + "\" is: \"" + longestPalindrome + "\"");// Output could be "bab" or "aba" since both are valid palindromic substrings of the same length.

        // Additional test cases
        String input2 = "cbbd";
        String longestPalindrome2 = lps.longestPalindrome(input2);
        System.out.println("Longest Palindromic Substring of \"" + input2 + "\" is: \"" + longestPalindrome2 + "\"");// Output: "bb"

        String input3 = "a";
        String longestPalindrome3 = lps.longestPalindrome(input3);
        System.out.println("Longest Palindromic Substring of \"" + input3 + "\" is: \"" + longestPalindrome3 + "\"");//

        String input4 = "ac";
        String longestPalindrome4 = lps.longestPalindrome(input4);
        System.out.println("Longest Palindromic Substring of \"" + input4 + "\" is: \"" + longestPalindrome4 + "\"");//

        //more complex test case
        String input5 = "forgeeksskeegfor";
        String longestPalindrome5 = lps.longestPalindrome(input5);
        System.out.println("Longest Palindromic Substring of \"" + input5 + "\" is: \"" + longestPalindrome5 + "\"");// Output: "geeksskeeg"

    }
}
