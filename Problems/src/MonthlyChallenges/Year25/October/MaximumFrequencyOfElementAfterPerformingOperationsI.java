package MonthlyChallenges.Year25.October;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyOfElementAfterPerformingOperationsI {
    public static void main(String[] args) {
        MaximumFrequencyOfElementAfterPerformingOperationsI solution = new MaximumFrequencyOfElementAfterPerformingOperationsI();

        int[] nums0 = {1, 4, 5};
        int k0 = 1, numOperations0 = 2;
        int result0 = 2;
        System.out.println(solution.maxFrequency(nums0, k0, numOperations0) == result0);

        int[] nums1 = {5, 11, 20, 20};
        int k1 = 5, numOperations1 = 1;
        int result1 = 2;
        System.out.println(solution.maxFrequency(nums1, k1, numOperations1) == result1);

        int[] nums2 = {5, 18, 20, 20, 30, 30, 29, 28, 31, 32, 27, 33};
        int k2 = 5, numOperations2 = 2;
        int result2 = 4;
        System.out.println(solution.maxFrequency(nums2, k2, numOperations2) == result2);

        int[] nums3 = {88, 53};
        int k3 = 27, numOperations3 = 2;
        int result3 = 2;
        System.out.println(solution.maxFrequency(nums3, k3, numOperations3) == result3);
    }

    /**
     * LeetCode №3346. Maximum Frequency of an Element After Performing Operations I.
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
            while (nums[left] + k + k < nums[right]) {
                left++;
            }

            result = Math.max(result, Math.min(right - left + 1, numOperations));
        }

        return result;
    }
}
