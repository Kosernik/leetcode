package MonthlyChallenges.Year23.November;

import Utils.TextInputParser;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging {
    public static void main(String[] args) {
        MaximumElementAfterDecreasingAndRearranging solution = new MaximumElementAfterDecreasingAndRearranging();

        int[] test = TextInputParser.parseText("TestArr.txt");
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(test));
    }

    /**
     * LeetCode №1846. Maximum Element After Decreasing and Rearranging.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param arr - an array of positive integers.
     * @return - the maximum possible value of an element in arr after performing the operations to satisfy the
     * conditions.
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], prev + 1);
            prev = arr[i];
        }

        return prev;
    }
}
