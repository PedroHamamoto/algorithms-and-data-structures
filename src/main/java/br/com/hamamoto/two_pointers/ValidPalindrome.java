package br.com.hamamoto.two_pointers;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome"> LeetCode problem </a>
 * - Valid Palindrome
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;

        while (left <= right) {
            var leftChar = s.charAt(left);
            var rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                if (Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
