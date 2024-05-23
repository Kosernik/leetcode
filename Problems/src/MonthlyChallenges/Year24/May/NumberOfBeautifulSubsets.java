package MonthlyChallenges.Year24.May;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBeautifulSubsets {
    public static void main(String[] args) {
        NumberOfBeautifulSubsets solution = new NumberOfBeautifulSubsets();

        int[] test4 = {2, 4, 6, 8};
        int k4 = 2;

        System.out.println(solution.beautifulSubsets(test4, k4));
    }

    /**
     * LeetCode №2597. The Number of Beautiful Subsets.
     * <p>
     * Complexity - O(2^N)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @param k    - a positive integer.
     * @return - the number of non-empty beautiful subsets of the array nums.
     */
    public int beautifulSubsets(int[] nums, int k) {
        return backtrack(0, nums, k, new HashMap<>());
    }

    private int backtrack(int idx, int[] nums, int k, Map<Integer, Integer> used) {
        if (idx >= nums.length) return 0;

        int result = 0;

        int curNumber = nums[idx];
        if (used.getOrDefault(curNumber - k, 0) == 0 && used.getOrDefault(curNumber + k, 0) == 0) {
            used.put(curNumber, used.getOrDefault(curNumber, 0) + 1);

            result += backtrack(idx + 1, nums, k, used) + 1;

            used.put(curNumber, used.get(curNumber) - 1);
        }

        result += backtrack(idx + 1, nums, k, used);

        return result;
    }
}
