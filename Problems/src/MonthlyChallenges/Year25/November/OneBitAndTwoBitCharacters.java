package MonthlyChallenges.Year25.November;

public class OneBitAndTwoBitCharacters {

    /**
     * LeetCode №717. 1-bit and 2-bit Characters.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param bits - an array of 0 and 1.
     * @return - true if the last character must be a one-bit character. False - otherwise.
     */
    public boolean isOneBitCharacter(int[] bits) {
        int maxLength = bits.length - 1;

        int idx = 0;

        while (idx < maxLength) {
            if (bits[idx] == 1) {
                idx++;
                if (idx == maxLength) return false;
            }

            idx++;
        }

        return true;
    }
}
