package MonthlyChallenges.Year22.September;

import java.util.Arrays;

public class BagOfTokens {

    /**
     * LeetCode #948. Bag of Tokens.
     * <p>
     * Complexity - O(Nlog)
     * Memory - O(1)
     *
     * @param tokens - an array of tokens.
     * @param power  - starting power.
     * @return - the maximum score.
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int result = 0;
        int left = 0, right = tokens.length - 1, score = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                score++;
                power -= tokens[left];
                left++;
                result = Math.max(result, score);
            } else if (score > 0) {
                score--;
                power += tokens[right];
                right--;
            } else {
                break;
            }
        }

        return result;
    }
}
