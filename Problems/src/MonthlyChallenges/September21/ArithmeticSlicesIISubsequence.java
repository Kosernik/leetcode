package MonthlyChallenges.September21;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {
    // LeetCode #446. Arithmetic Slices II - Subsequence.
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        long result = 0;
        Map<Integer, Integer>[] counts = new Map[n];

        for (int i = 0; i < n; i++) {
            counts[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long)nums[i] - (long)nums[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int)delta;
                int sum = counts[j].getOrDefault(diff, 0);
                int origin = counts[i].getOrDefault(diff, 0);
                counts[i].put(diff, origin + sum + 1);
                result += sum;
            }
        }
        return (int)result;
    }
}
