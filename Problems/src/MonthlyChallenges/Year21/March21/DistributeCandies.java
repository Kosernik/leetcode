package MonthlyChallenges.Year21.March21;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    /**
     * LeetCode #575.
     * <p>
     * Returns the maximum number of different types of candies that can be eaten if maximum n / 2 of them can be eaten.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param candyType - array of integers representing the type of a candy.
     * @return - the maximum number of different types of candies that can be eaten.
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandies = new HashSet<>();

        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }

        return Math.min(uniqueCandies.size(), candyType.length / 2);
    }
}
