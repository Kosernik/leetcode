package MonthlyChallenges.Year24.April;

public class FreedomTrail {

    /**
     * LeetCode №514. Freedom Trail.
     * <p>
     * Complexity - O(M * N^2), N = ring.length, M = key.length.
     * Memory - O(N*M)
     *
     * @param ring - a string of english lowercase letters representing the ring.
     * @param key  - a string of english lowercase letters representing the key.
     * @return - the minimum number of steps to spell all the characters in the keyword.
     */
    public int findRotateSteps(String ring, String key) {
        char[] lettersRing = ring.toCharArray();
        char[] lettersKey = key.toCharArray();

        int[][] computed = new int[ring.length()][key.length()];

        return helper(lettersRing, lettersKey, 0, 0, computed);
    }

    private int helper(char[] lettersRing, char[] lettersKey, int ringIdx, int keyIdx, int[][] computed) {
        if (keyIdx == lettersKey.length) {
            return 0;
        }
        if (computed[ringIdx][keyIdx] != 0) {
            return computed[ringIdx][keyIdx];
        }
        char currentKey = lettersKey[keyIdx];

        if (lettersRing[ringIdx] == currentKey) {
            computed[ringIdx][keyIdx] = 1 + helper(lettersRing, lettersKey, ringIdx, keyIdx + 1, computed);
        } else {
            int clockSpin = 1;
            int clockRingIdx = ringIdx;

            for (; clockSpin < lettersRing.length; clockSpin++) {
                clockRingIdx = (ringIdx + clockSpin) % lettersRing.length;
                if (lettersRing[clockRingIdx] == currentKey) {
                    break;
                }
            }

            int counterClockSpin = 1;
            int counterClockRingIdx = ringIdx;

            for (; counterClockSpin < lettersRing.length; counterClockSpin++) {
                counterClockRingIdx = (ringIdx - counterClockSpin + lettersRing.length) % lettersRing.length;
                if (lettersRing[counterClockRingIdx] == currentKey) {
                    break;
                }
            }

            int leftRes = clockSpin + 1 + helper(lettersRing, lettersKey, clockRingIdx, keyIdx + 1, computed);
            int rightRes = counterClockSpin + 1 + helper(lettersRing, lettersKey, counterClockRingIdx, keyIdx + 1, computed);

            computed[ringIdx][keyIdx] = Math.min(leftRes, rightRes);
        }

        return computed[ringIdx][keyIdx];
    }
}
