package MonthlyChallenges.Year25.September;

import java.util.Arrays;

public class MinimumScoreTriangulationOfPolygon {
    public static void main(String[] args) {
        MinimumScoreTriangulationOfPolygon solution = new MinimumScoreTriangulationOfPolygon();

        int[] values0 = {1, 2, 3};
        int result0 = 6;
        System.out.println(solution.minScoreTriangulation(values0) == result0);

        int[] values1 = {3, 7, 4, 5};
        int result1 = 144;
        System.out.println(solution.minScoreTriangulation(values1) == result1);

        int[] values2 = {1, 3, 1, 4, 1, 5};
        int result2 = 13;
        System.out.println(solution.minScoreTriangulation(values2) == result2);
    }

    /**
     * LeetCode №1039. Minimum Score Triangulation of Polygon.
     * <p>
     * Complexity - O(N^3)
     * Memory - O(N^2)
     *
     * @param values - an array of values of each vertex in a polygon.
     * @return - the minimum possible score that you can achieve with some triangulation of the polygon.
     */
    public int minScoreTriangulation(int[] values) {
        long[][] computed = new long[values.length][values.length];
        for (long[] row : computed) Arrays.fill(row, -1);

        return (int) dpHelper(0, values.length - 1, values, computed);
    }

    private long dpHelper(int start, int end, int[] values, long[][] computed) {
        if (computed[start][end] != -1) {
            return computed[start][end];
        }

        int length = end > start ? (end - start + 1) : (end + values.length - start + 1);

        if (length < 3) {
            computed[start][end] = 0;
            return computed[start][end];
        } else if (length == 3) {
            computed[start][end] = getScore(start, (start + 1) % values.length, end, values);
            return computed[start][end];
        }

        computed[start][end] = Long.MAX_VALUE;

        for (int thirdVertex = start + 1; thirdVertex < end; thirdVertex = (thirdVertex + 1) % values.length) {
            long curTriangleScore = getScore(start, end, thirdVertex, values);

            long oneHalfScore = dpHelper(start, thirdVertex, values, computed);
            long otherHalfScore = dpHelper(thirdVertex, end, values, computed);

            computed[start][end] = Math.min(computed[start][end], curTriangleScore + oneHalfScore + otherHalfScore);
        }

        return computed[start][end];
    }

    private static long getScore(int first, int second, int third, int[] values) {
        return values[first] * (long) values[second] * values[third];
    }
}
