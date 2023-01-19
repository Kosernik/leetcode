package MonthlyChallenges.Year23.January;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        SubarraySumsDivisibleByK solution = new SubarraySumsDivisibleByK();

        int[] testNums0 = {4, 5, 0, -2, -3, 1};
        int testK0 = 5;

        System.out.println(solution.subarraysDivByK(testNums0, testK0) == 7);
    }

    /**
     * LeetCode #974. Subarray Sums Divisible by K.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - a positive integer.
     * @return - the number of non-empty subarrays that have a sum divisible by k.
     */
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> sumsCount = new HashMap<>();
        sumsCount.put(0, 1);

        int sum = 0;
        int result = 0;

        for (int num : nums) {
            sum = (sum + num % k + k) % k;

            result += sumsCount.getOrDefault(sum, 0);
            sumsCount.put(sum, sumsCount.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
