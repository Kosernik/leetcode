package MonthlyChallenges.Year25.April;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarraysInArray {

    /**
     * LeetCode №2799. Count Complete Subarrays in an Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A subarray is complete if the number of distinct elements in the subarray is equal to the number of distinct
     * elements in the whole array.
     *
     * @param nums - an array of positive integers.
     * @return - the number of complete subarrays.
     */
    public int countCompleteSubarrays(int[] nums) {
        int count = 0;

        Set<Integer> distinctElements = new HashSet<>();
        for (int number : nums) distinctElements.add(number);

        int distinct = distinctElements.size();
        int length = nums.length;

        int left = 0;
        Map<Integer, Integer> curElements = new HashMap<>();

        for (int right = 0; right < length; right++) {
            curElements.put(nums[right], curElements.getOrDefault(nums[right], 0) + 1);

            while (curElements.size() == distinct) {
                count += (length - right);

                int prev = nums[left];
                int prevCount = curElements.get(prev);

                if (prevCount == 1) {
                    curElements.remove(prev);
                } else {
                    curElements.put(prev, prevCount - 1);
                }

                left++;
            }
        }

        return count;
    }
}
