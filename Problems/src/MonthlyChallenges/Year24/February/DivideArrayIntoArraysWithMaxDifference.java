package MonthlyChallenges.Year24.February;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {

    /**
     * LeetCode №2966. Divide Array Into Arrays With Max Difference.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param nums - an array of integers. nums.length is a multiple of 3.
     * @param k    - the maximum difference of any two elements in one array.
     * @return - a 2D array containing all the arrays.
     * If it is impossible to satisfy the conditions, returns an empty array.
     * And if there are multiple answers, returns any of them.
     */
    public int[][] divideArray(int[] nums, int k) {
        int length = nums.length;
        int resLength = length / 3;
        int[][] result = new int[resLength][];
        Arrays.sort(nums);

        for (int i = 0, idx = 0; i < resLength; i++, idx += 3) {
            int[] curTriplet = new int[3];
            curTriplet[0] = nums[idx];
            curTriplet[1] = nums[idx + 1];
            curTriplet[2] = nums[idx + 2];

            if (curTriplet[2] - curTriplet[0] > k) {
                return new int[0][];
            }
            result[i] = curTriplet;
        }

        return result;
    }
}
