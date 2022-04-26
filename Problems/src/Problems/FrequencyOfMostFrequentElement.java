package Problems;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement {

    /**
     * LeetCode #1838. Frequency of the Most Frequent Element.
     *
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @param k - a positive integer.
     * @return - the maximum possible frequency of an element after performing at most 'k' increment operations.
     */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long[] prefixSums = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i+1] = prefixSums[i] + nums[i];
        }

        int result = 1;

        for (int i = 0; i < nums.length; i++) {
            int curRes = getRes(nums, k, i, prefixSums);
            result = Math.max(result, curRes);
        }

        return result;
    }

    private int getRes(int[] nums, int k, int idx, long[] prefixSums) {
        int left = 0, right = idx, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            long curSum = prefixSums[idx] - prefixSums[middle];

            if (curSum + k >= ((long) nums[idx]) * (idx - middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return idx - left + 1;
    }
}
