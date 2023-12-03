package MonthlyChallenges.Year23.December;

public class MinimumTimeVisitingAllPoints {

    /**
     * LeetCode №1266. Minimum Time Visiting All Points.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param points - an array of coordinates of points on a 2d plane.
     * @return - the minimum time in seconds to visit all the points in the order given by points.
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;

        for (int i = 1; i < points.length; i++) {
            int deltaX = Math.abs(points[i][0] - points[i - 1][0]);
            int deltaY = Math.abs(points[i][1] - points[i - 1][1]);
            int minDelta = Math.min(deltaX, deltaY);

            result += deltaX + deltaY - minDelta;
        }

        return result;
    }
}
