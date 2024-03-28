package MonthlyChallenges.Year24.March;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static void main(String[] args) {
        LengthOfLongestSubarrayWithAtMostKFrequency solution = new LengthOfLongestSubarrayWithAtMostKFrequency();

        int[] test = {1, 2, 2, 1, 3};
        int testK = 1;

        System.out.println(solution.maxSubarrayLength(test, testK));
    }


    /**
     * LeetCode №2958. Length of Longest Subarray With at Most K Frequency.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - the maximum allowed frequency of a number.
     * @return - the length of the longest subarray of nums where the frequency of each element in this subarray is
     * less than or equal to k.
     */
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLength = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        int startIdx = 0, endIdx = 0;

        while (endIdx < nums.length) {
            int curNumber = nums[endIdx];
            int prevCount = counts.getOrDefault(curNumber, 0);

            while (startIdx <= endIdx && prevCount == k) {
                if (nums[startIdx] == curNumber) {
                    prevCount--;
                }

                counts.put(nums[startIdx], counts.get(nums[startIdx]) - 1);
                startIdx++;
            }

            counts.put(curNumber, prevCount + 1);

            maxLength = Math.max(maxLength, endIdx - startIdx + 1);

            endIdx++;
        }

        return maxLength;
    }
}
