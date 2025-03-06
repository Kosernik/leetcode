package MonthlyChallenges.Year25.March;

public class FindMissingAndRepeatedValues {

    /**
     * LeetCode №2965. Find Missing and Repeated Values.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param grid - a 2d matrix of size M*M with values in the range [1, M^2].
     *             Each integer appears exactly once except X which appears twice and Y which is missing.
     * @return - an array of size 2 where result[0] = X and result[1] = Y.
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int size = grid.length * grid.length;
        boolean[] seen = new boolean[size + 1];

        long sum = 0L;
        int[] result = new int[2];

        for (int[] ints : grid) {
            for (int num : ints) {
                if (seen[num]) {
                    result[0] = num;
                }
                sum += num;
                seen[num] = true;
            }
        }

        long totalSum = (long) size * (size + 1) / 2;

        int diff = (int) (totalSum - sum);

        result[1] = result[0] + diff;

        return result;
    }
}
