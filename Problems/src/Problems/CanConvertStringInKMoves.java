package Problems;

import java.util.Arrays;

public class CanConvertStringInKMoves {
    public static void main(String[] args) {
        CanConvertStringInKMoves solution = new CanConvertStringInKMoves();
//        String test0s = "input";
//        String test0t = "ouput";
//        System.out.println(solution.canConvertString(test0s, test0t, 9));

        solution.testCanConvertString();
    }

    /**
     * Checks if it is possible to convert string "s" into "t" in "k" moves.
     * At each move "i" (1 <= i <= k) it is possible to:
     * - choose any previously unused letter and shift it "i"-times. Shifting 7-times letter 'd'->'k', letter 'y'->'f'.
     * - do nothing.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string to convert, not null.
     * @param t - desired string, not null.
     * @param k - number of given moves.
     * @return - True if it is possible to change string "s" into "t" in "k" moves, False - otherwise.
     */
    public boolean canConvertString(String s, String t, int k) {
        if (s.equals(t)) return true;
        else if (s.length() != t.length()) return false;

        // Creating an array with number of shifts left.
        // countShifts[i] - number of shifts by "i" still available.
        int[] countShifts = new int[26];
        // Calculating number of repeating shifts (shift by 1 is the same as shift by 27)
        int repeats = k / 26;
        Arrays.fill(countShifts, repeats);
        // Adding shifts that was not counted after previous step.
        for (int i = 1; i <= k%26; i++) {
            countShifts[i]++;
        }

        for (int i = 0; i < s.length(); i++) {
            // Calculating the difference between current characters. Adding 26 before mod operation to deal with
            // negative result.
            int currShift = (t.charAt(i) - s.charAt(i) + 26) % 26;

            if (currShift == 0) continue;
            countShifts[currShift]--;
            if (countShifts[currShift] < 0) return false;
        }

        return true;
    }


    private void testCanConvertString() {
        String[][] testStrings = {
                {"input", "ouput"},
                {"abc", "bcd"},
                {"aab", "bbb"},
                {"abc", "abcd"},
                {"qsxkjbfz", "xyfirptk"}
        };
        int[] testKs = {9,10,27,1000,73};
        boolean[] results = {true, false, true, false, true};

        int failed = 0;

        for (int i = 0; i < results.length; i++) {
            if (results[i] != canConvertString(testStrings[i][0], testStrings[i][1], testKs[i])) {
                failed++;
                System.out.println("Wrong result for test #: " + i);
                System.out.println("s: " + testStrings[i][0] + ", t: " + testStrings[i][1] + ", k = " + testKs[i]);
                System.out.println("Got: " + !results[i] + ", instead of: " + results[i]);
            }
        }

        System.out.println("Success rate: " + (results.length - failed) * 100.0 / results.length);
    }
}
