package MonthlyChallenges.Year25.April;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfGoodSubarrays {

    /**
     * LeetCode №2537. Count the Number of Good Subarrays.
     *
     * @param nums - an array of integers.
     * @param k    - the minimum number of pairs.
     * @return - the number of good subarrays of nums.
     */
    public long countGood(int[] nums, int k) {
        int length = nums.length;
        long count = 0;

        int sameNumbers = 0;
        int right = 0;

        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : nums) {
            while (sameNumbers < k && right < length) {
                int rightNumber = nums[right];
                int rightCount = counts.getOrDefault(rightNumber, 0);

                sameNumbers += rightCount;
                counts.put(rightNumber, rightCount + 1);

                right++;
            }

            if (sameNumbers >= k) {
                count += length - right + 1;
            }

            int leftCount = counts.get(number) - 1;
            counts.put(number, leftCount);

            sameNumbers -= leftCount;
        }

        return count;
    }
}
