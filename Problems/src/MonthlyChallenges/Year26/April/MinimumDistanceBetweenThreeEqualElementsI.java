package MonthlyChallenges.Year26.April;

import java.util.HashMap;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElementsI {

    /**
     * LeetCode №3740. Minimum Distance Between Three Equal Elements I.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
     * The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value
     * of x.
     *
     * @param nums - an array of integers.
     * @return - an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.
     */
    public int minimumDistance(int[] nums) {
        int minDistance = Integer.MAX_VALUE;

        Map<Integer, int[]> triplets = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            if (!triplets.containsKey(number)) {
                int[] triplet = new int[]{i, 0, 0};
                triplets.put(number, triplet);
            } else {
                int[] triplet = triplets.get(number);

                if (triplet[1] == 0) {
                    triplet[1] = i;
                } else if (triplet[2] == 0) {
                    triplet[2] = i;

                    minDistance = Math.min(minDistance, getAbsDistance(triplet));
                } else {
                    addIndex(triplet, i);

                    minDistance = Math.min(minDistance, getAbsDistance(triplet));
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int getAbsDistance(int[] indices) {
        return indices[2] + indices[2] - indices[0] - indices[0];
    }

    private void addIndex(int[] indices, int index) {
        indices[0] = indices[1];
        indices[1] = indices[2];
        indices[2] = index;
    }
}
