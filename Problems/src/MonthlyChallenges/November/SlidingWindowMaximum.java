package MonthlyChallenges.November;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SlidingWindowMaximum {

    /**
     * LeetCode #239.
     *
     * @param nums - array of integers.
     * @param k - size of the sliding window.
     * @return - array of max values.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 || k == 1) return nums;

        int[] result = new int[nums.length - k + 1];

        TreeMap<Integer, Integer> pq = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            if (!pq.containsKey(nums[i])) {
                pq.put(nums[i], 0);
            }
            pq.put(nums[i], pq.get(nums[i]) + 1);
        }

        result[0] = pq.lastKey();
        int resIdx = 1;

        for (int i = k; i < nums.length; i++) {
            int prev = nums[i-k];
            if (pq.get(prev) > 1) {
                pq.put(prev, pq.get(prev) - 1);
            } else {
                pq.remove(prev);
            }

            if (!pq.containsKey(nums[i])) {
                pq.put(nums[i], 1);
            } else {
                pq.put(nums[i], pq.get(nums[i]) + 1);
            }

            result[resIdx++] = pq.lastKey();
        }

        return result;
    }


}
