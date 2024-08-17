package MonthlyChallenges.Year24.August;

public class MaximumNumberOfPointsWithCost {

    /**
     * LeetCode №1937. Maximum Number of Points with Cost.
     * <p>
     * Complexity - O(N*M), N = points.length, M = points[i].length.
     * Memory - O(M)
     *
     * @param points - a 2d matrix.
     * @return - the maximum number of points with cost.
     */
    public long maxPoints(int[][] points) {
        int width = points[0].length;
        long[] prevPoints = new long[width];

        for (int row = 0; row < points.length; row++) {
            long[] leftMax = new long[width];
            long[] rightMax = new long[width];
            long[] curPoints = new long[width];

            leftMax[0] = prevPoints[0];
            for (int i = 1; i < width; i++) {
                leftMax[i] = Math.max(leftMax[i - 1] - 1, prevPoints[i]);
            }

            rightMax[width - 1] = prevPoints[width - 1];
            for (int i = width - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1] - 1, prevPoints[i]);
            }

            for (int col = 0; col < width; col++) {
                curPoints[col] = points[row][col] + Math.max(leftMax[col], rightMax[col]);
            }

            prevPoints = curPoints;
        }

        long maxPoints = 0L;
        for (long point : prevPoints) {
            maxPoints = Math.max(maxPoints, point);
        }

        return maxPoints;
    }

    /**
     * LeetCode №1937. Maximum Number of Points with Cost.
     * <p>
     * Complexity - O(N*M*M), N = points.length, M = points[i].length.
     * Memory - O(M)
     *
     * @param points - a 2d matrix.
     * @return - the maximum number of points with cost.
     */
    public long maxPointsTLE(int[][] points) {
        int width = points[0].length;
        long[] prevPoints = new long[width];

        for (int row = 0; row < points.length; row++) {
            long[] curPoints = new long[width];

            for (int col = 0; col < width; col++) {
                long curBest = 0L;

                for (int c = 0; c < width; c++) {
                    curBest = Math.max(curBest, prevPoints[c] - Math.abs(c - col));
                }

                curPoints[col] = curBest + points[row][col];
            }

            prevPoints = curPoints;
        }

        long maxPoints = 0L;
        for (long point : prevPoints) {
            maxPoints = Math.max(maxPoints, point);
        }

        return maxPoints;
    }
}
