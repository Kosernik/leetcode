package MonthlyChallenges.Year24.October;

public class SeparateBlackAndWhiteBalls {

    /**
     * LeetCode №2938. Separate Black and White Balls.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of '0' and '1'. 0 - white ball, 1 - black ball.
     * @return - the minimum number of steps to group all the black balls to the right and all the white balls to the left.
     */
    public long minimumSteps(String s) {
        long steps = 0L;

        int whiteIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                steps += (i - whiteIdx);
                whiteIdx++;
            }
        }

        return steps;
    }
}
