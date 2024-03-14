package MonthlyChallenges.Year24.March;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        BinarySubarraysWithSum solution = new BinarySubarraysWithSum();

        int[] test0 = {1, 0, 1, 0, 1};
        System.out.println(solution.numSubarraysWithSum(test0, 2));
    }

    /**
     * LeetCode №930. Binary Subarrays With Sum.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of 0 and 1.
     * @param goal - a target sum.
     * @return - the number of non-empty subarrays with a sum goal.
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> sumsCount = new HashMap<>();
        int curSum = 0;
        int result = 0;

        for (int number : nums) {
            curSum += number;

            if (curSum == goal) {
                result++;
            }

            result += sumsCount.getOrDefault(curSum - goal, 0);

            sumsCount.put(curSum, sumsCount.getOrDefault(curSum, 0) + 1);
        }

        return result;
    }
}
