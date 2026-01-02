package MonthlyChallenges.Year21.September21;

public class BreakAPalindrome {
    /**
     * LeetCode #1328. Break a Palindrome.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param palindrome - a palindrome string of english lowercase letters.
     * @return - a string that is not a palindrome and that it is the lexicographically smallest one possible, or empty
     * string.
     */
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) return "";
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) > 'a') {
                return palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
            }
        }

        char lastChar = palindrome.charAt(palindrome.length() - 1) == 'a' ? 'b' : 'a';
        return palindrome.substring(0, palindrome.length() - 1) + lastChar;
    }
}
