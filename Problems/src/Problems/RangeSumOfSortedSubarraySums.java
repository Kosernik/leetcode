package Problems;

import java.util.Arrays;

public class RangeSumOfSortedSubarraySums {
    public static void main(String[] args) {
        RangeSumOfSortedSubarraySums solution = new RangeSumOfSortedSubarraySums();

        int[] test0 = {1,2,3,4};
        System.out.println(solution.rangeSum(test0, test0.length, 1, 5));
    }


    /**
     * LeetCode #1508. Range Sum of Sorted Subarray Sums.
     *
     * Complexity - O(N^2)
     * Memory - O(N^2)
     *
     * @param nums - an array of positive integers.
     * @param n - the length of nums.
     * @param left - the left index (1-indexed).
     * @param right - the right index (1-indexed) inclusive.
     * @return - the sum of the numbers from index left to index right modulo (10^9) + 7.
     */
    public int rangeSum(int[] nums, int n, int left, int right) {
        if (nums.length == 1) return nums[0];
        int MODULO = 1_000_000_007;

        int[] sums = new int[n*(n+1)/2];
        int[] prefixSums = new int[n+1];

        for (int i = 0; i < n; i++) {
            prefixSums[i+1] = prefixSums[i] + nums[i];
            sums[i] = nums[i];
        }

        int idx = n;
        for (int start = 0; start < n-1; start++) {
            for (int end = start+1; end < n; end++) {
                sums[idx++] = prefixSums[end+1] - prefixSums[start];
            }
        }

        Arrays.sort(sums);

        int result = 0;
        for (int i = left-1; i < right; i++) {
            result = (result + sums[i]) % MODULO;
        }

        return result;
    }
}
