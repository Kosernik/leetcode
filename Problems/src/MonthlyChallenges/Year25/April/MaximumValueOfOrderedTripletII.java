package MonthlyChallenges.Year25.April;

public class MaximumValueOfOrderedTripletII {

    /**
     * LeetCode №2874. Maximum Value of an Ordered Triplet II.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
     *
     * @param nums - an array of integers.
     * @return - the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets
     * have a negative value, returns 0.
     */
    public long maximumTripletValue(int[] nums) {
        int length = nums.length;
        int[] prevMax = new int[length];
        prevMax[0] = nums[0];

        int[] nextMax = new int[length];
        nextMax[length - 1] = nums[length - 1];

        for (int i = 1, j = length - 2; i < length; i++, j--) {
            prevMax[i] = Math.max(prevMax[i - 1], nums[i]);
            nextMax[j] = Math.max(nextMax[j + 1], nums[j]);
        }

        long maxTriplet = 0L;

        for (int i = 1; i < length - 1; i++) {
            long curTriplet = ((long) prevMax[i - 1] - nums[i]) * nextMax[i + 1];

            maxTriplet = Math.max(maxTriplet, curTriplet);
        }

        return maxTriplet;
    }
}
