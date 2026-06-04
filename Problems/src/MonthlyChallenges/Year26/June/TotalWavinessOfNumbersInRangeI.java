package MonthlyChallenges.Year26.June;

public class TotalWavinessOfNumbersInRangeI {

    /**
     * LeetCode №3751. Total Waviness of Numbers in Range I.
     * <p>
     * Complexity - O(M), M = num2 - num1.
     * Memory - O(1)
     * <p>
     * The waviness of a number is defined as the total count of its peaks and valleys:
     * * A digit is a peak if it is strictly greater than both of its immediate neighbors.
     * * A digit is a valley if it is strictly less than both of its immediate neighbors.
     * * The first and last digits of a number cannot be peaks or valleys.
     * * Any number with fewer than 3 digits has a waviness of 0.
     *
     * @param num1 - the start of the range (inclusive).
     * @param num2 - the end of the range (inclusive).
     * @return - the total sum of waviness for all numbers in the range [num1, num2].
     */
    public int totalWaviness(int num1, int num2) {
        int totalSum = 0;

        for (int i = num1; i <= num2; i++) {
            totalSum += countWaviness(i);
        }

        return totalSum;
    }

    private int countWaviness(int number) {
        if (number <= 100) return 0;

        int waviness = 0;
        char[] digits = String.valueOf(number).toCharArray();

        for (int i = 1; i < (digits.length - 1); i++) {
            if ((digits[i - 1] < digits[i] && digits[i] > digits[i + 1]) ||
                    (digits[i - 1] > digits[i] && digits[i] < digits[i + 1])) {
                waviness++;
            }
        }

        return waviness;
    }
}
