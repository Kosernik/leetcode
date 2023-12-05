package MonthlyChallenges.Year23.December;

public class CountOfMatchesInTournament {

    /**
     * LeetCode №1688. Count of Matches in Tournament.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - the number of teams.
     * @return - the number of matches played in the tournament until a winner is decided.
     */
    public int numberOfMatches(int n) {
        int matches = 0;

        while (n > 1) {
            matches += n / 2;
            n = (int) Math.ceil(n / 2.0);
        }

        return matches;
    }
}
