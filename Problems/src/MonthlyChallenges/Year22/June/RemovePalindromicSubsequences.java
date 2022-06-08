package MonthlyChallenges.Year22.June;

public class RemovePalindromicSubsequences {

    /**
     * LeetCode #1332. Remove Palindromic Subsequences.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s -a string of 'a' and 'b'.
     * @return - the minimum number of steps to make the given string empty. In a single step it is possible to remove
     *           one palindromic subsequence from s.
     */
    public int removePalindromeSub(String s) {
        if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    private boolean isPalindrome(String word) {
        char[] letters = word.toCharArray();

        int start = 0, end = letters.length-1;

        while (start < end) {
            if (letters[start] != letters[end]) return false;
            start++;
            end--;
        }

        return true;
    }
}
