package MonthlyChallenges.Year21.September21;

public class SlowestKey {
    /**
     * LeetCode #1629. Slowest Key.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param releaseTimes - an array of positive integers, representing the time of pressing a key.
     * @param keysPressed  - a string of pressed keys.
     * @return - the key with the longest duration or the lexicographically largest key if there are multiple keys with
     * the same duration.
     */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int prev = 0;
        int longestDuration = Integer.MIN_VALUE;
        char result = keysPressed.charAt(0);

        for (int i = 0; i < releaseTimes.length; i++) {
            int curDuration = releaseTimes[i] - prev;
            if (curDuration > longestDuration) {
                longestDuration = curDuration;
                result = keysPressed.charAt(i);
            } else if (curDuration == longestDuration) {
                result = result < keysPressed.charAt(i) ? keysPressed.charAt(i) : result;
            }
            prev = releaseTimes[i];
        }

        return result;
    }
}
