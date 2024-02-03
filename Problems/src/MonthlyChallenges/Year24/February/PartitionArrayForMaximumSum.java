package MonthlyChallenges.Year24.February;

public class PartitionArrayForMaximumSum {

    /**
     * LeetCode №1043. Partition Array for Maximum Sum.
     * <p>
     * Complexity - O(N*k), N = arr.length.
     * Memory - O(N)
     *
     * @param arr - an array of integers.
     * @param k   - the maximum length of a subarray.
     * @return - the largest sum of the given array after partitioning.
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dpArr = new int[arr.length + 1];

        for (int i = 1; i <= arr.length; i++) {
            int maxVal = 0;
            int bestSum = 0;

            for (int j = 1; j <= k; j++) {
                if (i - j < 0) continue;

                maxVal = Math.max(maxVal, arr[i - j]);
                bestSum = Math.max(bestSum, dpArr[i - j] + maxVal * j);
            }

            dpArr[i] = bestSum;
        }

        return dpArr[arr.length];
    }
}
