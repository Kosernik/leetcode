package MonthlyChallenges.Year23.June;

public class KRadiusSubarrayAverages {

    /**
     * LeetCode #2090. K Radius Subarray Averages.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - the radius.
     * @return - an array of averages of sub-arrays with the radius 'k'.
     */
    public int[] getAverages(int[] nums, int k) {
        int length = nums.length;
        int width = k + k + 1;

        int[] averages = new int[length];
        long[] sums = new long[length + 1];

        for (int i = 0; i < length; i++) {
            averages[i] = -1;
            sums[i + 1] = sums[i] + nums[i];
        }

        for (int i = k; i < (length - k); i++) {
            long average = (sums[i + k + 1] - sums[i - k]) / width;
            averages[i] = (int) average;
        }

        return averages;
    }
}
