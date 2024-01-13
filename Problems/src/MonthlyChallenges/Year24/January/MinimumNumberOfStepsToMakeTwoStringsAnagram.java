package MonthlyChallenges.Year24.January;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    /**
     * LeetCode №1347. Minimum Number of Steps to Make Two Strings Anagram.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of lowercase english letters.
     * @param t - a string of lowercase english letters.
     * @return - the minimum number of steps to make t an anagram of s.
     */
    public int minSteps(String s, String t) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        int steps = 0;
        for (char ch : t.toCharArray()) {
            if (counts[ch - 'a'] == 0) {
                steps++;
            } else {
                counts[ch - 'a']--;
            }
        }

        return steps;
    }
}
