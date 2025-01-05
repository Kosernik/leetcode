package MonthlyChallenges.Year25.January;

public class ShiftingLettersII {

    /**
     * LeetCode №2381. Shifting Letters II.
     * <p>
     * Complexity - O(N*M), N = s.length, M = shifts.length.
     * Memory - O(N)
     *
     * @param s      - a string of lowercase english letters.
     * @param shifts - an array of shift intervals(inclusive). shifts[i][2] = 1 means shift forward,
     *               shifts[i][2] = 0 means shift backward.
     * @return - the final string after all shifts to s are applied.
     */
    public String shiftingLettersTLE(String s, int[][] shifts) {
        char[] letters = s.toCharArray();

        for (int[] shift : shifts) {
            int direction = shift[2] == 1 ? 1 : 25;
            for (int i = shift[0]; i <= shift[1]; i++) {
                letters[i] = (char) (((letters[i] - 'a') + direction) % 26 + 'a');
            }
        }

        return new String(letters);
    }

    /**
     * LeetCode №2381. Shifting Letters II.
     * <p>
     * Complexity - O(N+M), N = s.length, M = shifts.length.
     * Memory - O(N)
     *
     * @param s      - a string of lowercase english letters.
     * @param shifts - an array of shift intervals(inclusive). shifts[i][2] = 1 means shift forward,
     *               shifts[i][2] = 0 means shift backward.
     * @return - the final string after all shifts to s are applied.
     */
    public String shiftingLetters(String s, int[][] shifts) {
        int[] shiftCount = new int[s.length() + 1];

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                shiftCount[shift[0]]++;
                shiftCount[shift[1] + 1] += 25;
            } else {
                shiftCount[shift[0]] += 25;
                shiftCount[shift[1] + 1]++;
            }
        }

        char[] letters = s.toCharArray();
        int numberOfShifts = 0;

        for (int i = 0; i < letters.length; i++) {
            numberOfShifts = (numberOfShifts + shiftCount[i]) % 26;

            if (numberOfShifts != 0) {
                letters[i] = (char) (((letters[i] - 'a') + numberOfShifts) % 26 + 'a');
            }
        }

        return new String(letters);
    }
}
