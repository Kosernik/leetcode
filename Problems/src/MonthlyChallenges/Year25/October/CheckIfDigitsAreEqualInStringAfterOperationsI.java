package MonthlyChallenges.Year25.October;

public class CheckIfDigitsAreEqualInStringAfterOperationsI {

    /**
     * LeetCode №3461. Check If Digits Are Equal in String After Operations I.
     *
     * @param s - a string of only digits.
     * @return - true if after performing operations the final two digits in s are the same. Otherwise, returns false.
     */
    public boolean hasSameDigits(String s) {
        int[] digits = convertToInts(s);

        while (digits.length > 2) {
            int[] nextDigits = new int[digits.length - 1];

            for (int i = 0; i < digits.length - 1; i++) {
                nextDigits[i] = (digits[i] + digits[i + 1]) % 10;
            }

            digits = nextDigits;
        }

        return digits[0] == digits[1];
    }

    private static int[] convertToInts(String s) {
        int[] digits = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }

        return digits;
    }
}
