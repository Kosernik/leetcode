package MonthlyChallenges.Year25.October;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyOfElementAfterPerformingOperationsII {

    /**
     * LeetCode №3347. Maximum Frequency of an Element After Performing Operations II.
     *
     * @param nums          - an array of integers.
     * @param k             - a non-negative integer.
     * @param numOperations - the number of operations. 0 <= numOperations <= nums.length.
     * @return - the maximum possible frequency of any element in nums after performing the operations.
     */
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int result = 0;

        int length = nums.length;
        Arrays.sort(nums);

        Map<Integer, Integer> counts = new HashMap<>();

        int left = 0, right = 0;
        for (int number : nums) {
            while (right < length && nums[right] <= number + k) {
                counts.put(nums[right], counts.getOrDefault(nums[right], 0) + 1);
                right++;
            }
            while (left < length && nums[left] < number - k) {
                counts.put(nums[left], counts.get(nums[left]) - 1);
                left++;
            }

            int curResult = Math.min(right - left, counts.getOrDefault(number, 0) + numOperations);
            result = Math.max(result, curResult);
        }

        for (left = 0, right = 0; right < length; right++) {
            while (((long) nums[left] + k + k) < nums[right]) {
                left++;
            }

            result = Math.max(result, Math.min(right - left + 1, numOperations));
        }

        return result;
    }
}
