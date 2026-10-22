package MonthlyChallenges.Year26.October;

import java.util.Arrays;

public class MinimumOperationsToSortPermutation {
    public static void main(String[] args) {
        MinimumOperationsToSortPermutation solution = new MinimumOperationsToSortPermutation();

        int[][] tests = {
                {0, 2, 1},
                {1, 0, 2},
                {2, 0, 1, 3},
                {0, 3, 4, 2, 1},
                {2, 1, 0, 7, 6, 5, 4, 3},
                {8, 9, 0, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 0, 1, 2},
                {0, 4, 3, 2, 1},
                {0},
                {0, 1},
                {1, 0}
        };
        int[] results = {2, 2, -1, -1, 4, 2, 5, 2, 0, 0, 1};

        if (tests.length != results.length) {
            System.out.println("Wrong number of tests and results");
            return;
        }

        for (int i = 0; i < tests.length; i++) {
            int curRes = solution.minOperations(tests[i]);

            if (curRes != results[i]) {
                System.out.println("Test " + (i + 1) + " " + Arrays.toString(tests[i]) + ", got: " + curRes + ", result: " + results[i]);
            }
        }
        System.out.println("Done!");
    }

    /**
     * LeetCode №3942. Minimum Operations to Sort a Permutation.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * Only the following operations are allowed to sort the array:
     * * Reverse the entire array.
     * * Rotate Left by One: Move the first element to the end of the array, and rest elements to left by one position.
     *
     * @param nums - a permutation of the integers from 0 to n - 1. n = nums.length
     * @return - an integer denoting the minimum number of operations required to sort the array in increasing order.
     * If it is not possible to sort the array using only the given operations, returns -1.
     */
    public int minOperations(int[] nums) {
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int nextIdx = (i + 1) % nums.length;
                int prevIdx = (i - 1 + nums.length) % nums.length;

                if (nums[nextIdx] == 1) {
                    if (prevIdx > i) {
                        prevIdx = 0;
                    }
                    if (!isIncreasing(0, prevIdx, nums) || !isIncreasing(i, nums.length - 1, nums)) {
                        return -1;
                    } else {
                        //  [***01*] -rev> [*10***] -rot> [****10] -rev> [01****]
                        //int revRotRev = 1 + (nums.length - i) + 1;
                        //  [***01*] -rot> [01****]
                        //int rot = i;
                        return Math.min(i, nums.length - i + 2);
                    }
                } else if (nums[prevIdx] == 1) {
                    if (prevIdx > i) {
                        prevIdx = 0;
                    }
                    if (!isDecreasing(0, prevIdx, nums) || !isDecreasing(i + 1, nums.length - 1, nums)) {
                        return -1;
                    } else {
                        //  [*10***] -rev> [***01*] -rot> [01****]
                        //int revRot = 1 + (nums.length - i - 1);
                        //  [*10***] -rot> [****10] -rev> [01****]
                        //int rotRev = i + 2;
                        return Math.min(i + 2, nums.length - i);
                    }
                } else {
                    return -1;
                }
            }
        }

        return -1;
    }

    private boolean isIncreasing(int start, int end, int[] numbers) {
        if (start >= numbers.length || start == end) return true;
        for (int i = start + 1; i <= end; i++) {
            if ((numbers[i] - 1) != numbers[i - 1]) return false;
        }
        return true;
    }

    private boolean isDecreasing(int start, int end, int[] numbers) {
        if (start >= numbers.length || start == end) return true;
        for (int i = start + 1; i <= end; i++) {
            if ((numbers[i] + 1) != numbers[i - 1]) return false;
        }
        return true;
    }
}
