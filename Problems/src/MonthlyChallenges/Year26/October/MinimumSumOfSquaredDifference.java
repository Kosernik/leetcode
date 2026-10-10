package MonthlyChallenges.Year26.October;

import java.util.Arrays;

public class MinimumSumOfSquaredDifference {
    public static void main(String[] args) {
        MinimumSumOfSquaredDifference solution = new MinimumSumOfSquaredDifference();

        System.out.println("Test 0");
        int[] nums1_0 = {1, 4, 10, 11}, nums2_0 = {5, 8, 6, 9};
        int k1_0 = 1, k2_0 = 1;
        long answer_0 = 38;
        long result_0 = solution.minSumSquareDiff(nums1_0, nums2_0, k1_0, k2_0);
        System.out.println(result_0 == answer_0);

        System.out.println();
        System.out.println("Test 1");
        int[] nums1_1 = {1, 4, 10, 12}, nums2_1 = {5, 8, 6, 9};
        int k1_1 = 1, k2_1 = 1;
        long answer_1 = 43;
        long result_1 = solution.minSumSquareDiff(nums1_1, nums2_1, k1_1, k2_1);
        System.out.println(result_1 == answer_1);

        System.out.println();
        System.out.println("Test 2");
        int[] nums1_2 = {1}, nums2_2 = {10};
        int k1_2 = 3, k2_2 = 1;
        long answer_2 = 25;
        long result_2 = solution.minSumSquareDiff(nums1_2, nums2_2, k1_2, k2_2);
        System.out.println(result_2 == answer_2);

        System.out.println();
        System.out.println("Test 3");
        int[] nums1_3 = {1, 4, 10, 12}, nums2_3 = {5, 8, 6, 9};
        int k1_3 = 10, k2_3 = 5;
        long answer_3 = 0;
        long result_3 = solution.minSumSquareDiff(nums1_3, nums2_3, k1_3, k2_3);
        System.out.println(result_3 == answer_3);

        System.out.println();
        System.out.println("Test 4");
        int[] nums1_4 = {19, 18, 19, 18, 18, 19, 19}, nums2_4 = {1, 0, 1, 0, 0, 1, 1};
        int k1_4 = 10, k2_4 = 33;
        long answer_4 = 985;
        long result_4 = solution.minSumSquareDiff(nums1_4, nums2_4, k1_4, k2_4);
        System.out.println(result_4 == answer_4);
    }

    /**
     * LeetCode №2333. Minimum Sum of Squared Difference.
     * <p>
     * Complexity - O(NlogN), N = nums1.length = nums2.length.
     * Memory - O(N)
     * <p>
     * The sum of squared difference of arrays nums1 and nums2 is defined as the sum of
     * (nums1[i] - nums2[i]) * (nums1[i] - nums2[i]) for each 0 <= i < N.
     * You can modify any of the elements of nums1 by +1 or -1 at most k1 times. Similarly, you can modify any of the
     * elements of nums2 by +1 or -1 at most k2 times.
     *
     * @param nums1 - an array of non-negative integers.
     * @param nums2 - an array of non-negative  integers. nums1.length = nums2.length.
     * @param k1    - a non-negative integer representing the maximum change operations in nums1.
     * @param k2    - a non-negative integer representing the maximum change operations in nums2.
     * @return - the minimum sum of squared difference after modifying array nums1 at most k1 times and modifying
     * array nums2 at most k2 times.
     */
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int length = nums1.length;
        long k = k1 + k2;
        Integer[] diffs = new Integer[length + 1];

        long totalSum = 0;
        for (int i = 0; i < length; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            totalSum += diffs[i];
        }

        if (totalSum <= k) return 0;

        diffs[length] = 0;
        Arrays.sort(diffs, (a, b) -> Integer.compare(b, a));

        for (int i = 1; i <= length; i++) {
            long curCost = (diffs[i - 1] - diffs[i]) * (long) i;

            if (curCost >= k) {
                long minChange = k / i;
                long remainder = k % i;
                long partChangedDiff = diffs[i - 1] - minChange;

                long result = partChangedDiff * partChangedDiff * (i - remainder) +
                        (partChangedDiff - 1) * (partChangedDiff - 1) * remainder;

                for (int j = i; j < length; j++) {
                    result += (long) diffs[j] * diffs[j];
                }

                return result;
            }

            k -= curCost;
        }

        return 0;
    }
}
