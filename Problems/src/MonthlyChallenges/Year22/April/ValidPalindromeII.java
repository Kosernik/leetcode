package MonthlyChallenges.Year22.April;

public class ValidPalindromeII {

    /**
     * LeetCode #680. Valid Palindrome II.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string.
     * @return - true - if the "s" can be palindrome after deleting at most one character from it. False - otherwise.
     */
    public boolean validPalindrome(String s) {
        if (s.length() <= 1) return true;

        char[] letters = s.toCharArray();
        return validRemoveLeft(letters) || validRemoveRight(letters);
    }

    private boolean validRemoveRight(char[] s) {
        int left = 0;
        int right = s.length-1;
        boolean foundDifferent = false;

        while (left < right) {
            if (s[left] == s[right]) {
                right--;
            } else {
                if (foundDifferent) return false;
                foundDifferent = true;
            }
            left++;
        }

        return true;
    }

    private boolean validRemoveLeft(char[] s) {
        int left = 0;
        int right = s.length-1;
        boolean foundDifferent = false;

        while (left < right) {
            if (s[left] == s[right]) {
                left++;
            } else {
                if (foundDifferent) return false;
                foundDifferent = true;
            }
            right--;
        }

        return true;
    }
}
