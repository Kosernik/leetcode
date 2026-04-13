package MonthlyChallenges.Year26.April;

public class MinimumDistanceToTargetElement {

    /**
     * LeetCode №1848. Minimum Distance to the Target Element.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums   - an array of integers.
     * @param target - an integer. It is guaranteed that target exists in nums.
     * @param start  - starting index.
     * @return - minimum absolute value abs(i - start) such that nums[i] == target.
     */
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                minDistance = Math.min(minDistance, Math.abs(i - start));
            }
        }

        return minDistance;
    }
}
