package MonthlyChallenges.Year23.December;

import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    /**
     * LeetCode №1637. Widest Vertical Area Between Two Points Containing No Points.
     * <p>
     * Complexity- O(NlogN)
     * Memory - O(1)
     *
     * @param points - an array of points on a plane.
     * @return - the widest vertical area between two points such that no points are inside the area.
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        int result = 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < points.length; i++) {
            int curWidth = points[i][0] - points[i - 1][0];
            result = Math.max(result, curWidth);
        }

        return result;
    }
}
