package MonthlyChallenges.Year22.December;

import java.util.*;

public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        LongestSubsequenceWithLimitedSum solution = new LongestSubsequenceWithLimitedSum();

        System.out.println("Test 0");
        int[] nums0 = {4,5,2,1};
        int[] queries0 = {3,10,21};
        System.out.println(Arrays.toString(solution.answerQueries(nums0, queries0)));
        System.out.println();

        System.out.println("Test 1");
        int[] nums1 = {2,3,4,5};
        int[] queries1 = {1};
        System.out.println(Arrays.toString(solution.answerQueries(nums1, queries1)));
        System.out.println();
    }

    /**
     * LeetCode #2389. Longest Subsequence With Limited Sum.
     *
     * @param nums - an array of positive integers.
     * @param queries - an array of positive integers.
     * @return - an array of lengths of the longest subsequences
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int idx = Arrays.binarySearch(prefixSum, queries[i]);
            result[i] = Math.abs(idx + 1);
        }

        return result;
    }
}
