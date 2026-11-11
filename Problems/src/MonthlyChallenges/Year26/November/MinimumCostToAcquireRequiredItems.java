package MonthlyChallenges.Year26.November;

public class MinimumCostToAcquireRequiredItems {

    /**
     * LeetCode №3789. Minimum Cost to Acquire Required Items.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param cost1    - the cost of an item of type1. Contributes 1 unit to the type 1 requirement only.
     * @param cost2    - the cost of an item of type2. Contributes 1 unit to the type 2 requirement only.
     * @param costBoth - the cost of an item of type3. Contributes 1 unit to both type 1 and type 2 requirements.
     * @param need1    - the required number of units of type 1.
     * @param need2    - the required number of units of type 2.
     * @return - the minimum total cost to collect at least need1 units of type 1 and at least need2 units of type 2.
     */
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long result;

        if ((cost1 + cost2) >= costBoth) {
            long min = Math.min(need1, need2);

            result = min * costBoth;

            if (need1 > min) {
                long diff = need1 - min;
                result += diff * Math.min(cost1, costBoth);
            }
            if (need2 > min) {
                long diff = need2 - min;
                result += diff * Math.min(cost2, costBoth);
            }
        } else {
            result = cost1 * (long) need1 + cost2 * (long) need2;
        }

        return result;
    }
}
