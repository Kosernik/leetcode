package Problems;

public class FindNearestPointThatHasSameXorYCoordinate {

    /**
     * LeetCode #1779. Find Nearest Point That Has the Same X or Y Coordinate.
     *
     * Complexity - O(N), N = points.length.
     * Memory - O(1)
     *
     * @param x - an integer representing X-coordinate on a Cartesian grid.
     * @param y - an integer representing Y-coordinate on a Cartesian grid.
     * @param points - an array of points on a Cartesian grid.
     * @return - the smallest index of a valid point with the smallest Manhattan distance from the point with x,y
     *           coordinates.
     *           A point is valid if it shares the same x-coordinate or the same y-coordinate as the start point.
     *           If there are now valid points, -1 is returned.
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int point = -1;
        int bestDistance = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int curDist = Integer.MAX_VALUE;

            if (points[i][0] == x) {
                curDist = Math.abs(y - points[i][1]);
            }
            if (points[i][1] == y) {
                curDist = Math.abs(x - points[i][0]);
            }

            if (curDist < bestDistance) {
                point = i;
                bestDistance = curDist;
            }
        }

        return point;
    }
}
