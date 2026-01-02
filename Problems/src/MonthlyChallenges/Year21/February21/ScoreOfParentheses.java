package MonthlyChallenges.Year21.February21;


public class ScoreOfParentheses {

    //  () has score 1
    //  AB has score A + B, where A and B are balanced parentheses strings.
    //  (A) has score 2 * A, where A is a balanced parentheses string.

    /**
     * LeetCode #856.
     * <p>
     * Returns the score of a balanced parentheses string "S".
     * () has score 1
     * AB has score A + B, where A and B are balanced parentheses strings.
     * (A) has score 2 * A, where A is a balanced parentheses string.
     *
     * @param S - a balanced parentheses string of '(' and ')'.
     * @return - the score of a string "S".
     */
    public int scoreOfParentheses(String S) {
        if (S.length() == 2) return 1;

        int count = 0;
        int idx = 0;

        while (idx < S.length()) {
            if (S.charAt(idx) == '(') {
                count++;
            } else {
                count--;

                if (count == 0 && idx != (S.length() - 1)) {
                    return scoreOfParentheses(S.substring(0, idx + 1)) + scoreOfParentheses(S.substring(idx + 1));
                }
            }
            idx++;
        }

        return 2 * scoreOfParentheses(S.substring(1, S.length() - 1));
    }
}
