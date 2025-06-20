package MonthlyChallenges.Year25.June;

public class MaximumManhattanDistanceAfterKChanges {

    /**
     * LeetCode №3443. Maximum Manhattan Distance After K Changes.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of characters 'N', 'S', 'W' and 'E'.
     * @param k - a non-negative integer.
     * @return -  the maximum Manhattan distance from the origin that can be achieved at any time using at most k changes
     * while performing the movements in order.
     */
    public int maxDistance(String s, int k) {
        int maxDist = 0;

        int N = 0, S = 0, W = 0, E = 0;

        for (char direction : s.toCharArray()) {
            if (direction == 'N') {
                N++;
            } else if (direction == 'S') {
                S++;
            } else if (direction == 'W') {
                W++;
            } else {
                E++;
            }

            int curDistance = 0;

            int availableK = k;
            int change;

            if (N > S) {
                change = Math.min(S, availableK);
                curDistance += (N - S) + change * 2;
            } else {
                change = Math.min(N, availableK);
                curDistance += (S - N) + change * 2;
            }
            availableK -= change;

            if (W > E) {
                change = Math.min(E, availableK);
                curDistance += (W - E) + change * 2;
            } else {
                change = Math.min(W, availableK);
                curDistance += (E - W) + change * 2;
            }

            maxDist = Math.max(maxDist, curDistance);
        }

        return maxDist;
    }
}
