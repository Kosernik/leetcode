package Problems;

public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        CountNegativeNumbersInSortedMatrix solution = new CountNegativeNumbersInSortedMatrix();

        int[][] tests = new int[8][];
        int[] results = new int[8];

        int[] test0 = {7,6,3,0,-1,-2};
        tests[0] = test0;
        results[0] = 3;

        int[] test1 = {7,6,3,-1,-1,-2};
        tests[1] = test1;
        results[1] = 2;

        int[] test2 = {7,6,3,0,-1};
        tests[2] = test2;
        results[2] = 3;

        int[] test3 = {7,6,3,-1,-1};
        tests[3] = test3;
        results[3] = 2;

        int[] test4 = {7,6,3,0,-1,-2,-3};
        tests[4] = test4;
        results[4] = 3;

        int[] test5 = {7,6,3,-1,-1,-2,-3};
        tests[5] = test5;
        results[5] = 2;

        int[] test6 = {-1,-1,-2,-3};
        tests[6] = test6;
        results[6] = 0;

        int[] test7 = {4,3,2,1};
        tests[7] = test7;
        results[7] = 3;

        for (int i = 0; i < tests.length; i++) {
            System.out.println("Test " + (i+1) + " " + (solution.binarySearchInReverse(tests[i], 0) == results[i]));
        }
        System.out.println("Done");
    }

    /**
     * LeetCode #1351. Count Negative Numbers in a Sorted Matrix
     *
     * Complexity - O(NlogM), N = grid.length, M = grid[0].length
     * Memory - O(1)
     *
     * @param grid - a 2d square matrix which is sorted in non-increasing order both row-wise and column-wise.
     * @return - the number of negative numbers in grid.
     */
    public int countNegatives(int[][] grid) {
        int result = 0;
        int width = grid[0].length;

        for (int[] row : grid) {
            int idx = binarySearchInReverse(row, 0);
            result += (width - idx - 1);
            if (idx == 0 && row[0] < 0) {
                result++;
            }
        }

        return result;
    }

    private int binarySearchInReverse(int[] arr, int target) {
        int left = 0, right = arr.length-1, middle;

        while (left < right) {
            if (right-left == 1) {
                return arr[right] >= target ? right : left;
            }
            middle = (right - left) / 2 + left;

            if (arr[middle] >= target) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }
}
