package MonthlyChallenges.January21;

import java.util.Arrays;

public class CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        CheckArrayFormationThroughConcatenation solution = new CheckArrayFormationThroughConcatenation();

        int[] tst00 = {15,88};
        int[][] tst01 = {{88},{15}};
        System.out.println(solution.canFormArray(tst00, tst01));
    }

    /**
     * Checks if it is possible to form an array "arr" by concatenating the arrays in "pieces" in any order.
     * LeetCode #1640.
     *
     * Complexity - O(N + MlogM)
     * N - size of "arr", M - size of "pieces"
     * Memory - O(MlogM)
     *
     * @param arr - array of distinct integers.
     * @param pieces - 2d array of distinct integers.
     * @return - True - if it is possible to form an array "arr" by concatenating the arrays in "pieces" in any order.
     *          False - otherwise.
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Arrays.sort(pieces, (a, b) -> Integer.compare(a[0], b[0]));

        int idx = 0;

        while (idx < arr.length) {
            int digitIdx = binSearch(pieces, arr[idx]);
            if (digitIdx == -1) return false;

            int length = pieces[digitIdx].length;

            for (int i = 0; i < length; i++) {
                if (arr[idx] != pieces[digitIdx][i]) return false;
                idx++;
            }
        }

        return true;
    }

    /**
     * Binary search of a target in a 2d array. Only values of 0-indexes of inner arrays are counted.
     *
     * @param pieces - 2d array of integers.
     * @param target - integer to find.
     * @return - index of an inner array, that starts with a target, or -1 if there is no such array.
     */
    private int binSearch(int[][] pieces, int target) {
        int left = 0;
        int right = pieces.length-1;
        int middle;

        while (left <= right) {
            middle = (right + left) / 2;
            if (pieces[middle][0] == target) {
                return middle;
            } else if (pieces[middle][0] > target) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }

        return -1;
    }
}
