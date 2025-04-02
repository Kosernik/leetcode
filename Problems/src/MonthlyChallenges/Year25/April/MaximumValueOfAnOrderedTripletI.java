package MonthlyChallenges.Year25.April;

public class MaximumValueOfAnOrderedTripletI {

    /**
     * LeetCode №2873. Maximum Value of an Ordered Triplet I.
     * <p>
     * Complexity - O(N^3)
     * Memory - O(1)
     * <p>
     * The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
     *
     * @param nums - an array of integers.
     * @return - the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets
     * have a negative value, returns 0.
     */
    public long maximumTripletValue(int[] nums) {
        int length = nums.length;
        long maxValue = 0;

        for (int i = 0; i < length - 2; i++) {
            int first = nums[i];

            for (int j = i + 1; j < length - 1; j++) {
                long difference = first - nums[j];

                for (int k = j + 1; k < length; k++) {
                    long curVal = difference * nums[k];

                    maxValue = Math.max(maxValue, curVal);
                }
            }
        }

        return maxValue;
    }
}
