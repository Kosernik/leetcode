package MonthlyChallenges.September21;

public class ShiftingLetters {
    /**
     * LeetCode #848. Shifting Letters.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of english lowercase letters.
     * @param shifts - an array of non-negative integers.
     * @return - the resulting string after performing all shifts.
     */
    public String shiftingLetters(String s, int[] shifts) {
        int length = s.length();
        int[] modShifts = new int[length];
        modShifts[length-1] = shifts[length-1] % 26;
        for (int i = length-2; i >= 0; i--) {
            modShifts[i] = (shifts[i] + modShifts[i+1]) % 26;
        }

        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            int curRes = ((s.charAt(i) - 'a') + modShifts[i]) % 26;
            result[i] = (char) ('a' + curRes);
        }

        return new String(result);
    }
}
