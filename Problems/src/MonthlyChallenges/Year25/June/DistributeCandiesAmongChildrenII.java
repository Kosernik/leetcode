package MonthlyChallenges.Year25.June;

public class DistributeCandiesAmongChildrenII {

    /**
     * LeetCode №2929. Distribute Candies Among Children II.
     *
     * @param n     - the total number of candies.
     * @param limit - the maximum number of candies per child.
     * @return - the total number of ways to distribute n candies among 3 children such that no child gets more than
     * limit candies.
     */
    public long distributeCandies(int n, int limit) {
        if (limit * 3 < n) {
            return 0;
        } else if (limit * 3 == n) {
            return 1;
        }

        long result = 0L;

        for (int i = 0; i <= Math.min(n, limit); i++) {
            result += Math.max(0, Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1);
        }

        return result;
    }
}
