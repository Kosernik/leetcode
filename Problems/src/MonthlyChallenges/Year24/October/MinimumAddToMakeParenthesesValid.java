package MonthlyChallenges.Year24.October;

public class MinimumAddToMakeParenthesesValid {

    /**
     * LeetCode №921. Minimum Add to Make Parentheses Valid.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of '(' and ')'.
     * @return - the minimum number of additions required to make s valid.
     */
    public int minAddToMakeValid(String s) {
        int additions = 0;
        int currentBalance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currentBalance++;
            } else {
                if (currentBalance == 0) {
                    additions++;
                } else {
                    currentBalance--;
                }
            }
        }

        return additions + currentBalance;
    }
}
