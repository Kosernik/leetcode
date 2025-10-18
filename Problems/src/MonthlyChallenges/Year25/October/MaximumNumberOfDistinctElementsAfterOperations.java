package MonthlyChallenges.Year25.October;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MaximumNumberOfDistinctElementsAfterOperations {
    public static void main(String[] args) {
        MaximumNumberOfDistinctElementsAfterOperations solution = new MaximumNumberOfDistinctElementsAfterOperations();

        int[] nums0 = {1, 2, 2, 3, 3, 4};
        int k0 = 2;
        int result0 = 6;
        System.out.println(solution.maxDistinctElements(nums0, k0) == result0);
    }

    /**
     * LeetCode №3397. Maximum Number of Distinct Elements After Operations.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     * An operation: Add an integer in the range [-k, k] to the element at most once.
     *
     * @param nums - an array of positive integers. 1 <= nums[i] <= 10e9
     * @param k    - a non-negative integer. 0 <= k <= 10e9
     * @return - the maximum possible number of distinct elements in nums after performing the operations.
     */
    public int maxDistinctElements(int[] nums, int k) {
        NavigableMap<Integer, Integer> counts = new TreeMap<>();
        for (int number : nums) counts.put(number, counts.getOrDefault(number, 0) + 1);

        int distincts = 0;

        int prev = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();

            int curStart = Math.max(prev + 1, number - k);
            int curEnd = Math.min(number + k, curStart + count - 1);

            int curLength = curEnd - curStart + 1;

            distincts += curLength;

            prev = curEnd;
        }

        return distincts;
    }
}
