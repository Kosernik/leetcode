package MonthlyChallenges.Year25.January;

public class MinimumLengthOfStringAfterOperations {

    /**
     * LeetCode №3223. Minimum Length of String After Operations.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of lowercase english letters.
     * @return - the minimum length of the final string s.
     */
    public int minimumLength(String s) {
        int[] counts = new int[26];

        for (char letter : s.toCharArray()) {
            counts[letter - 'a']++;
        }

        int minLength = 0;

        for (int count : counts) {
            if (count >= 3) {
                if (count % 2 == 0) {
                    minLength += 2;
                } else {
                    minLength += 1;
                }
            } else {
                minLength += count;
            }
        }

        return minLength;
    }
}
