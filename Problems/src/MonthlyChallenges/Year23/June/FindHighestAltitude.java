package MonthlyChallenges.Year23.June;

public class FindHighestAltitude {

    /**
     * LeetCode #1732. Find the Highest Altitude.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param gain - the difference between point [i-1] and [i]. Starting height = 0;
     * @return - the highest altitude.
     */
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int height = 0;

        for (int heightChange : gain) {
            height += heightChange;
            maxAltitude = Math.max(maxAltitude, height);
        }

        return maxAltitude;
    }
}
