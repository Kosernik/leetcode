package MonthlyChallenges.Year25.September;

public class MinimumOperationsToMakeArrayElementsZero {
    public static void main(String[] args) {
        MinimumOperationsToMakeArrayElementsZero solution = new MinimumOperationsToMakeArrayElementsZero();

        int[][] queries0 = {
                {1, 2}, {2, 4}
        };
        long result0 = 3L;
        System.out.println(solution.minOperations(queries0) == result0);
    }

    /**
     * LeetCode №3495. Minimum Operations to Make Array Elements Zero.
     *
     * @param queries - a 2d array of intervals.
     * @return - the minimum number of operations required to reduce all elements of the array to zero for each query.
     */
    public long minOperations(int[][] queries) {
        long operations = 0L;

        int[][] divisionsNeeded = new int[16][2];

        for (int i = 0, start = 1, divisions = 1; i < divisionsNeeded.length; i++, start *= 4, divisions++) {
            divisionsNeeded[i][0] = start;
            divisionsNeeded[i][1] = divisions;
        }

        for (int[] query : queries) {
            int left = query[0], right = query[1];
            long currentOperations = 0L;

            for (int i = 0; i < divisionsNeeded.length; i++) {
                if (divisionsNeeded[i][0] > right) break;

                int start = Math.max(left, divisionsNeeded[i][0]);
                int end = Math.min(right, divisionsNeeded[i + 1][0] - 1);

                if (end >= start) {
                    currentOperations += (end - start + 1L) * divisionsNeeded[i][1];
                }
            }

            operations += (currentOperations + 1) / 2;
        }

        return operations;
    }
}
