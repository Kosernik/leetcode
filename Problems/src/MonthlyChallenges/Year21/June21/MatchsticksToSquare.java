package MonthlyChallenges.Year21.June21;

public class MatchsticksToSquare {

    /**
     * LeetCode #473.
     *
     * @param matchsticks - an array of lengths of matchsticks.
     * @return - True - if it is possible to form a square using all sticks, False - otherwise.
     */
    public boolean makesquare(int[] matchsticks) {
        int perimeter = 0;
        for (int stick : matchsticks) perimeter += stick;
        if (perimeter % 4 != 0) return false;

        return helper(matchsticks, 0, new int[4], perimeter / 4);
    }

    private boolean helper(int[] sticks, int index, int[] sides, int sideLength) {
        if (index == sticks.length) {
            return sides[0] == sides[1] && sides[2] == sides[3] && sides[1] == sides[2];
        }

        for (int i = 0; i < 4; i++) {
            int currSide = sides[i] + sticks[index];
            if (currSide > sideLength) continue;
            sides[i] = currSide;
            if (helper(sticks, index + 1, sides, sideLength)) return true;
            sides[i] -= sticks[index];
        }
        return false;
    }
}
