package MonthlyChallenges.Year21.June21;

import java.util.Comparator;
import java.util.TreeMap;

public class JumpGameVI {
    /**
     * LeetCode #1696.
     *
     * @param nums - an array of integers.
     * @param k    - max distance of a jump.
     * @return - the maximum score.
     */
    public int maxResult(int[] nums, int k) {
        long[] scores = new long[nums.length];
        scores[0] = nums[0];

        //        value    count
        TreeMap<Long, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            long best = map.isEmpty() ? 0 : map.firstKey();
            scores[i] = best + nums[i];

            if (i >= k) {
                if (map.get(scores[i - k]) == 1) {
                    map.remove(scores[i - k]);
                } else {
                    map.put(scores[i - k], map.get(scores[i - k]) - 1);
                }
            }

            int currCount = map.getOrDefault(scores[i], 0);
            map.put(scores[i], currCount + 1);
        }

        return (int) scores[scores.length - 1];
    }
}
