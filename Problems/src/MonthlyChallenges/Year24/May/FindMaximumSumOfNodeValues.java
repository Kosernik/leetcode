package MonthlyChallenges.Year24.May;

import java.util.Arrays;

public class FindMaximumSumOfNodeValues {

    /**
     * LeetCode №3068. Find the Maximum Sum of Node Values.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums  - an array of values of nodes in a tree.
     * @param k     - a positive integer.
     * @param edges - an array of edges between nodes in a tree.
     * @return - the maximum possible sum of the values it is possible to achieve by performing the operation of xor-ing
     * values of both neighbouring nodes of any edge in a tree any number of times.
     */
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long result = 0L;

        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            diff[i] = (nums[i] ^ k) - nums[i];
        }

        Arrays.sort(diff);

        for (int i = nums.length - 2; i >= 0; i -= 2) {
            int curDiff = diff[i + 1] + diff[i];
            if (curDiff > 0) {
                result += curDiff;
            }
        }

        return result;
    }

}
