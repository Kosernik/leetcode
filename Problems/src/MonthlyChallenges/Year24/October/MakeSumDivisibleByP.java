package MonthlyChallenges.Year24.October;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {

    /**
     * LeetCode №1590. Make Sum Divisible by P.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @param p    - a positive integer.
     * @return -  the length of the smallest subarray that you need to remove to make the sum of the remaining elements
     * divisible by p. If it is not possible returns -1.
     */
    public int minSubarray(int[] nums, int p) {
        int sumModP = 0;

        for (int num : nums) {
            sumModP = (sumModP + num) % p;
        }

        sumModP = sumModP % p;
        if (sumModP == 0) return 0;

        Map<Integer, Integer> indices = new HashMap<>();
        indices.put(0, -1);

        int curSum = 0;
        int length = nums.length;

        for (int i = 0; i < nums.length; i++) {
            curSum = (curSum + nums[i]) % p;

            int remainder = (curSum - sumModP + p) % p;

            if (indices.containsKey(remainder)) {
                length = Math.min(length, i - indices.get(remainder));
            }
            indices.put(curSum, i);
        }

        if (length == nums.length) return -1;
        return length;
    }
}
