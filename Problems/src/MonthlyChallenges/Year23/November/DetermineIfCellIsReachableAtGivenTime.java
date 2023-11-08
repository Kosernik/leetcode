package MonthlyChallenges.Year23.November;

public class DetermineIfCellIsReachableAtGivenTime {

    /**
     * LeetCode #2849. Determine if a Cell Is Reachable at a Given Time.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param sx - x-coordinate of the starting cell.
     * @param sy - y-coordinate of the starting cell.
     * @param fx - x-coordinate of the target cell.
     * @param fy - y-coordinate of the target cell.
     * @param t  - the time of arrival.
     * @return - true if it is possible to go from the start to the target in exactly t-time. False - otherwise.
     */
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        int xDist = Math.abs(sx - fx);
        int yDist = Math.abs(sy - fy);

        return t >= Math.max(xDist, yDist);
    }
}
