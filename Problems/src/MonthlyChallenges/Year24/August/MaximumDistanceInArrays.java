package MonthlyChallenges.Year24.August;

import java.util.List;

public class MaximumDistanceInArrays {

    /**
     * LeetCode #624. Maximum Distance in Arrays.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param arrays - a list of lists of integers. Each list is sorted in ascending order.
     * @return - the maximum distance in arrays.
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int[][] mins = new int[2][2];
        mins[0][0] = Integer.MAX_VALUE;
        mins[1][0] = Integer.MAX_VALUE;

        int[][] maxs = new int[2][2];
        maxs[0][0] = Integer.MIN_VALUE;
        maxs[1][0] = Integer.MIN_VALUE;

        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> curList = arrays.get(i);

            int curMin = curList.get(0);

            if (curMin < mins[0][0]) {
                mins[1][0] = mins[0][0];
                mins[1][1] = mins[0][1];

                mins[0][0] = curMin;
                mins[0][1] = i;
            } else if (curMin < mins[1][0]) {
                mins[1][0] = curMin;
                mins[1][1] = i;
            }

            int curMax = curList.get(curList.size() - 1);

            if (curMax > maxs[0][0]) {
                maxs[1][0] = maxs[0][0];
                maxs[1][1] = maxs[0][1];

                maxs[0][0] = curMax;
                maxs[0][1] = i;
            } else if (curMax > maxs[1][0]) {
                maxs[1][0] = curMax;
                maxs[1][1] = i;
            }
        }

        int result;

        if (mins[0][1] != maxs[0][1]) {
            result = maxs[0][0] - mins[0][0];
        } else {
            result = Math.max(maxs[0][0] - mins[1][0], maxs[1][0] - mins[0][0]);
        }

        return result;
    }
}
