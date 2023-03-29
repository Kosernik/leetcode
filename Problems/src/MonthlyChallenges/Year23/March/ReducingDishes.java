package MonthlyChallenges.Year23.March;

import java.util.Arrays;

public class ReducingDishes {
    public static void main(String[] args) {
        ReducingDishes solution = new ReducingDishes();

        int[] test0 = {-1, -8, 0, 5, -9};
        System.out.println(solution.maxSatisfaction(test0));
    }


    /**
     * LeetCode #1402. Reducing Dishes.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param satisfaction - an array of satisfaction coefficients for dishes.
     * @return - the maximum sum of like-time coefficient.
     */
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int result = 0;
        int previouslyCooked = 0;

        for (int i = satisfaction.length - 1; i >= 0 && (satisfaction[i] + previouslyCooked) > 0; i--) {
            previouslyCooked += satisfaction[i];
            result += previouslyCooked;
        }

        return result;
    }
}
