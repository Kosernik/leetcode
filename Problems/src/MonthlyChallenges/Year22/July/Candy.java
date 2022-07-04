package MonthlyChallenges.Year22.July;

import java.util.Arrays;

public class Candy {

    /**
     * LeetCode #135. Candy.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param ratings -an array of non-negative integers.
     * @return - the minimum number of candies you need to have to distribute the candies to the children.
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        int result = candies[candies.length-1];
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            result += candies[i];
        }

        return result;
    }
}
