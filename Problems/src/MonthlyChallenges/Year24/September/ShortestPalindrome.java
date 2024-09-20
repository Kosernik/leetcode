package MonthlyChallenges.Year24.September;

public class ShortestPalindrome {
    public static void main(String[] args) {
        ShortestPalindrome solution = new ShortestPalindrome();

        String test0 = "aacecaaa";
        System.out.println(solution.shortestPalindrome(test0).equals("aaacecaaa"));

        String test1 = "abcd";
        System.out.println(solution.shortestPalindrome(test1).equals("dcbabcd"));
    }

    /**
     * LeetCode №214. Shortest Palindrome.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param s - a string.
     * @return - the shortest palindrome that is possible to make from s by adding characters in front of it.
     */
    public String shortestPalindrome(String s) {
        char[] letters = s.toCharArray();

        int idx = letters.length - 1;

        while (idx >= 0) {
            if (isPalindrome(letters, 0, idx)) {
                return buildPalindrome(letters, idx, s);
            }
            idx--;
        }

        return "";
    }

    private String buildPalindrome(char[] letters, int idx, String original) {
        StringBuilder builder = new StringBuilder();

        for (int i = letters.length - 1; i > idx; i--) {
            builder.append(letters[i]);
        }

        builder.append(original);

        return builder.toString();
    }

    private boolean isPalindrome(char[] letters, int start, int end) {
        while (start < end) {
            if (letters[start] != letters[end]) return false;
            start++;
            end--;
        }

        return true;
    }
}
