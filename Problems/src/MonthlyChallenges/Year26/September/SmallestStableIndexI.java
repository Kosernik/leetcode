package MonthlyChallenges.Year26.September;

public class SmallestStableIndexI {

    /**
     * LeetCode №3903. Smallest Stable Index I.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * For each index i, its instability score is defined as max(nums[0..i]) - min(nums[i..n - 1]).
     * An index i is called stable if its instability score is less than or equal to k.
     *
     * @param nums - an array of non-negative integers.
     * @param k    - a non-negative integer.
     * @return - the smallest stable index. If no such index exists, returns -1.
     */
    public int firstStableIndex(int[] nums, int k) {
        int length = nums.length;

        int[] postfixMin = new int[length];
        postfixMin[length - 1] = nums[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            postfixMin[i] = Math.min(nums[i], postfixMin[i + 1]);
        }

        int maxVal = nums[0];

        for (int i = 0; i < length; i++) {
            maxVal = Math.max(maxVal, nums[i]);

            int instabilityScore = maxVal - postfixMin[i];

            if (instabilityScore <= k) {
                return i;
            }
        }

        return -1;
    }
}
