package MonthlyChallenges.Year25.July;

import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithCertainSum {

    /**
     * LeetCode №1865. Finding Pairs With a Certain Sum.
     */
    class FindSumPairs {
        long[] nums2numbers;

        Map<Integer, Integer> nums1Counts;
        Map<Long, Integer> nums2Counts;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1Counts = new HashMap<>();
            for (int number : nums1) {
                nums1Counts.put(number, nums1Counts.getOrDefault(number, 0) + 1);
            }

            this.nums2numbers = new long[nums2.length];

            this.nums2Counts = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                long number = nums2[i];

                nums2Counts.put(number, nums2Counts.getOrDefault(number, 0) + 1);
                nums2numbers[i] = number;
            }
        }

        public void add(int index, int val) {
            long prev = nums2numbers[index];

            nums2Counts.put(prev, nums2Counts.get(prev) - 1);

            prev += val;

            nums2Counts.put(prev, nums2Counts.getOrDefault(prev, 0) + 1);

            nums2numbers[index] = prev;
        }

        public int count(int tot) {
            int count = 0;

            for (Map.Entry<Integer, Integer> entry : nums1Counts.entrySet()) {
                long target = tot - entry.getKey();

                count += entry.getValue() * nums2Counts.getOrDefault(target, 0);
            }

            return count;
        }
    }
}
