package MonthlyChallenges.Year24.June;

public class ScoreOfString {

    /**
     * LeetCode №3110. Score of a String.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string.
     * @return - the sum of the absolute difference between the ASCII values of adjacent characters.
     */
    public int scoreOfString(String s) {
        int score = 0;

        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            score += Math.abs(current - prev);
            prev = current;
        }

        return score;
    }
}
