package MonthlyChallenges.Year22.October;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        ContinuousSubarraySum solution = new ContinuousSubarraySum();

        int[] test0nums = {23, 2, 4, 6, 7};
        int test0k = 6;
        System.out.println(solution.checkSubarraySum(test0nums, test0k));

        int[] test1nums = {23, 2, 6, 4, 7};
        int test1k = 6;
        System.out.println(solution.checkSubarraySum(test1nums, test1k));

        int[] test2nums = {23, 2, 6, 4, 7};
        int test2k = 13;
        System.out.println(solution.checkSubarraySum(test2nums, test2k));
    }

    /**
     * LeetCode #523. Continuous Subarray Sum.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of non-negative integers.
     * @param k    - a positive integer.
     * @return - True if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k,
     * or False otherwise.
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) return false;
        if (k == 1) return true;

        Map<Integer, Integer> modules = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            modules.put((sum % k), i);
        }

        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int prevModulo = sum % k;

            if (modules.containsKey(prevModulo) && modules.get(prevModulo) > i) {
                return true;
            }

            sum += nums[i];
        }

        return false;
    }
}
