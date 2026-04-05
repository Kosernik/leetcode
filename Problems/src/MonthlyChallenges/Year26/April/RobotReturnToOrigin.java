package MonthlyChallenges.Year26.April;

public class RobotReturnToOrigin {

    /**
     * LeetCode №657. Robot Return to Origin.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param moves - a string of characters 'L', 'R', 'U' and 'D'.
     * @return - true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
     */
    public boolean judgeCircle(String moves) {
        int horizontalChange = 0, verticalChange = 0;

        for (int i = 0; i < moves.length(); i++) {
            char direction = moves.charAt(i);
            if (direction == 'L') {
                horizontalChange++;
            } else if (direction == 'R') {
                horizontalChange--;
            } else if (direction == 'U') {
                verticalChange++;
            } else {    //  direction == 'D'
                verticalChange--;
            }
        }

        return horizontalChange == 0 && verticalChange == 0;
    }
}
