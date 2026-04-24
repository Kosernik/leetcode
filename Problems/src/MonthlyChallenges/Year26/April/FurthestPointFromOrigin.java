package MonthlyChallenges.Year26.April;

public class FurthestPointFromOrigin {

    /**
     * LeetCode №2833. Furthest Point From Origin.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * In the i-th move, you can choose one of the following directions:
     * * move to the left if moves[i] = 'L' or moves[i] = '_'
     * * move to the right if moves[i] = 'R' or moves[i] = '_'
     *
     * @param moves - a string of characters 'L', 'R' and '_'
     * @return - the distance from the origin of the furthest point you can get to after n moves.
     */
    public int furthestDistanceFromOrigin(String moves) {
        char MOVE_LEFT = 'L', MOVE_RIGHT = 'R', MOVE_ANYWHERE = '_';
        int left = 0, right = 0, anyDirection = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == MOVE_LEFT) {
                left++;
            } else if (moves.charAt(i) == MOVE_RIGHT) {
                right++;
            } else { // if (moves.charAt(i) == MOVE_ANYWHERE)
                anyDirection++;
            }
        }

        return Math.abs(left - right) + anyDirection;
    }
}
