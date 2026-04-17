package MonthlyChallenges.Year26.April;

import java.util.HashMap;
import java.util.Map;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {

    /**
     * LeetCode №3761. Minimum Absolute Distance Between Mirror Pairs.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A mirror pair is a pair of indices (i, j) such that:
     * * 0 <= i < j < nums.length, and
     * * reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading
     * * zeros are omitted after reversing, for example reverse(120) = 21.
     *
     * @param nums - an array of positive integers.
     * @return - the minimum absolute distance between the indices of any mirror pair.
     * If no mirror pair exists, returns -1.
     */
    public int minMirrorPairDistance(int[] nums) {
        int result = nums.length;

        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (indices.containsKey(number)) {
                result = Math.min(result, i - indices.get(number));
            }

            indices.put(getInverseNumber(number), i);
        }

        return result == nums.length ? -1 : result;
    }

    private static int getInverseNumber(int number) {
        int inverse = 0;

        while (number > 0) {
            int remainder = number % 10;
            number /= 10;

            inverse = inverse * 10 + remainder;
        }

        return inverse;
    }
}
