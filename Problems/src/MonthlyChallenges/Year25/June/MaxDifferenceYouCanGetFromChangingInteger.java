package MonthlyChallenges.Year25.June;

public class MaxDifferenceYouCanGetFromChangingInteger {

    /**
     * LeetCode №1432. Max Difference You Can Get From Changing an Integer.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param num - a positive integer. 1 <= num <= 100_000_000.
     * @return - the max difference.
     */
    public int maxDiff(int num) {
        int first = getFirst(num);
        int nonNine = getFirstNonNine(num);
        int nonZeroOne = getFirstNonZeroOrOne(num);

        int minDigit;
        if (first == 1) {
            minDigit = 0;
        } else {
            minDigit = 1;
        }

        int max = 0;
        int min = 0;
        int multiplier = 1;

        while (num > 0) {
            int digit = num % 10;

            if (digit == nonNine) {
                max += 9 * multiplier;
            } else {
                max += digit * multiplier;
            }

            if (digit == nonZeroOne) {
                min += minDigit * multiplier;
            } else {
                min += digit * multiplier;
            }

            num /= 10;
            multiplier *= 10;
        }

        return max - min;
    }

    private static int getFirstNonNine(int number) {
        int nonNine = 0;

        while (number > 0) {
            int digit = number % 10;
            if (digit != 9) {
                nonNine = digit;
            }
            number /= 10;
        }

        return nonNine;
    }

    private static int getFirstNonZeroOrOne(int number) {
        int result = 0;

        while (number > 0) {
            int digit = number % 10;
            if (digit > 1) {
                result = digit;
            }
            number /= 10;
        }

        return result;
    }

    private static int getFirst(int num) {
        int first;

        if (num < 10) {
            first = num;
        } else if (num < 100) {
            first = num / 10;
        } else if (num < 1_000) {
            first = num / 100;
        } else if (num < 10_000) {
            first = num / 1_000;
        } else if (num < 100_000) {
            first = num / 10_000;
        } else if (num < 1_000_000) {
            first = num / 100_000;
        } else if (num < 10_000_000) {
            first = num / 1_000_000;
        } else if (num < 100_000_000) {
            first = num / 10_000_000;
        } else {
            first = num / 100_000_000;
        }
        return first;
    }
}
