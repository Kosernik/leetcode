package MonthlyChallenges.Year23.January;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {

    /**
     * LeetCode #452. Minimum Number of Arrows to Burst Balloons.
     * <p>
     * Complexity - O(NlogN + N)
     * Memory - O(1)
     *
     * @param points - a 2d array of balloons coordinates, where points[i][0] - left x-coordinate and points[i][1] -
     *               right x-coordinate. points[i][0] < points[i][1]
     * @return - the minimum number of arrows that must be shot to burst all balloons.
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;

        Arrays.sort(points, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        int numberOfArrows = 1;
        int endInterval = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int[] curBall = points[i];
            if (curBall[0] > endInterval) {
                numberOfArrows++;
                endInterval = curBall[1];
            } else {
                endInterval = Math.min(endInterval, curBall[1]);
            }
        }

        return numberOfArrows;
    }
}
