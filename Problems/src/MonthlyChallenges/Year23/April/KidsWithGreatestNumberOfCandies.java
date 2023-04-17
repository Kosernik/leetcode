package MonthlyChallenges.Year23.April;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {

    /**
     * LeetCode #1431. Kids With the Greatest Number of Candies.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param candies      - an array of positive integers representing the number of candies each child have.
     * @param extraCandies - the number of extra candies, a positive integer.
     * @return - a boolean array result of length n, where result[i] is true if, after giving the i-th kid all the
     * extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int max = getMaxCandies(candies);
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(Boolean.TRUE);
            } else {
                result.add(Boolean.FALSE);
            }
        }
        return result;
    }

    private int getMaxCandies(int[] candies) {
        int max = candies[0];
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }
}
