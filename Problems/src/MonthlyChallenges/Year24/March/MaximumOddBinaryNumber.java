package MonthlyChallenges.Year24.March;

public class MaximumOddBinaryNumber {

    /**
     * LeetCode №2864. Maximum Odd Binary Number.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of '0' and '1'. s that contains at least one '1'.
     * @return - a string representing the maximum odd binary number that can be created from the given combination.
     */
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        char[] letters = s.toCharArray();
        for (char c : letters) {
            if (c == '1') {
                count++;
            }
        }

        for (int i = 0; i < count - 1; i++) {
            letters[i] = '1';
        }
        for (int i = count - 1; i < letters.length - 1; i++) {
            letters[i] = '0';
        }
        letters[letters.length - 1] = '1';

        return new String(letters);
    }
}
