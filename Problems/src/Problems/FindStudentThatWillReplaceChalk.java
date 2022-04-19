package Problems;

public class FindStudentThatWillReplaceChalk {

    /**
     * LeetCode #1894. Find the Student that Will Replace the Chalk.
     *
     * Complexity - O(N + logN)
     * Memory - O(N)
     *
     * @param chalk - an array of positive integers representing the amount of chalk needed to solve a problem for
     *              student i.
     * @param k - a positive integer representing the total amount of chalk.
     * @return - the index of a student that will replace the chalk.
     */
    public int chalkReplacer(int[] chalk, int k) {
        long[] preSum = new long[chalk.length];
        preSum[0] = chalk[0];

        for (int i = 1; i < chalk.length; i++) {
            preSum[i] = preSum[i-1] + chalk[i];
        }

        k %= preSum[preSum.length-1];

        return binSearch(preSum, k);
    }

    private int binSearch(long[] arr, int target) {
        int left = 0, right = arr.length-1, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (arr[middle] <= target) {
                left = middle+1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}
