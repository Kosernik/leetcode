package MonthlyChallenges.Year25.October;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaximumTotalDamageWithSpellCasting {
    public static void main(String[] args) {
        MaximumTotalDamageWithSpellCasting solution = new MaximumTotalDamageWithSpellCasting();

        int[] power0 = {1, 1, 3, 4};
        long result0 = 6;
        System.out.println(solution.maximumTotalDamage(power0) == result0);

        System.out.println();
        int[] power1 = {7, 1, 6, 6};
        long result1 = 13;
        System.out.println(solution.maximumTotalDamage(power1) == result1);
    }

    /**
     * LeetCode №3186. Maximum Total Damage With Spell Casting.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param power - an array of positive integers.
     * @return - the maximum possible total damage that a magician can cast.
     */
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int pow : power) {
            counts.put(pow, counts.getOrDefault(pow, 0) + 1);
        }

        int[][] uniques = new int[counts.size() + 1][2];
        uniques[0] = new int[]{-1, 0};
        int idx = 1;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            uniques[idx] = new int[]{entry.getKey(), entry.getValue()};
            idx++;
        }

        Arrays.sort(uniques, Comparator.comparingInt(a -> a[0]));

        long[] dp = new long[uniques.length];

        long prevMax = 0L;

        for (int i = 1, j = 1; i < uniques.length; i++) {
            while (j < i && (uniques[j][0] < uniques[i][0] - 2)) {
                prevMax = Math.max(prevMax, dp[j]);
                j++;
            }

            dp[i] = prevMax + (long) uniques[i][0] * uniques[i][1];
        }

        long result = 0L;
        for (int i = dp.length - 1, j = 0; i >= 0 && j < 3; i--, j++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
