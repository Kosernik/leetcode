package MonthlyChallenges.Year23.January;

import java.util.Arrays;

public class MaximumIceCreamBars {

    /**
     * LeetCode #1833. Maximum Ice Cream Bars.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param costs - an array of costs of each ice cream.
     * @param coins - the total number of coins to spend.
     * @return - the maximum number of ice cream bars you can buy with coins.
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int numberOfIceBars = 0;
        int coinsSpent = 0;

        for (int cost : costs) {
            coinsSpent += cost;
            if (coinsSpent > coins) {
                return numberOfIceBars;
            }
            numberOfIceBars++;
        }

        return numberOfIceBars;
    }
}
