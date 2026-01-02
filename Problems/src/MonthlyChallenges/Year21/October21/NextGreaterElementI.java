package MonthlyChallenges.Year21.October21;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    /**
     * LeetCode #496. Next Greater Element I.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param nums1 - a subset of "nums2".
     * @param nums2 - an array of unique integers.
     * @return - an array of next greater elements.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indices.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = getNextGreater(nums1[i], indices.get(nums1[i]) + 1, nums2);
        }

        return result;
    }

    private int getNextGreater(int value, int startIdx, int[] nums2) {
        while (startIdx < nums2.length) {
            if (nums2[startIdx] > value) return nums2[startIdx];
            startIdx++;
        }
        return -1;
    }
}
