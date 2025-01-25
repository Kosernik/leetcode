package MonthlyChallenges.Year25.January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MakeLexicographicallySmallestArrayBySwappingElements {

    /**
     * LeetCode №2948. Make Lexicographically Smallest Array by Swapping Elements.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     * <p>
     * In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if
     * |nums[i] - nums[j]| <= limit.
     *
     * @param nums  - an array of integers.
     * @param limit - a positive integer.
     * @return - the lexicographically smallest array that can be obtained by performing the operation any number of times.
     */
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int length = nums.length;
        int[] result = new int[length];

        int[][] sorted = new int[length][2];
        for (int i = 0; i < length; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));

        List<Integer> indices = new ArrayList<>();
        int prev = sorted[0][0];
        for (int i = 0; i < length; i++) {
            if ((sorted[i][0] - prev) > limit) {
                addToResult(result, indices, i - indices.size(), sorted);
                indices.clear();
            }

            prev = sorted[i][0];
            indices.add(sorted[i][1]);
        }

        addToResult(result, indices, length - indices.size(), sorted);

        return result;
    }

    private void addToResult(int[] result, List<Integer> indices, int startIdx, int[][] sorted) {
        indices.sort(Integer::compare);

        for (int insertIdx : indices) {
            result[insertIdx] = sorted[startIdx][0];
            startIdx++;
        }
    }
}
