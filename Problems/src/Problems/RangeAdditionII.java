package Problems;

public class RangeAdditionII {

    /**
     * LeetCode #598. Range Addition II.
     *
     * Complexity - O(N). N = ops.length.
     * Memory - O(1)
     *
     * @param m - the dimension of a matrix. Positive integer.
     * @param n - the dimension of a matrix. Positive integer.
     * @param ops - an array of operations. 0 <= ops.length.
     * @return - the number of maximum integers in the matrix after performing all the operations.
     */
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) return m*n;
        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;

        for (int[] operation : ops) {
            minM = Math.min(minM, operation[0]);
            minN = Math.min(minN, operation[1]);
        }

        return minN * minM;
    }
}
