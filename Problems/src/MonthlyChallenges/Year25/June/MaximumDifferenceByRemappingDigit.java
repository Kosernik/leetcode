package MonthlyChallenges.Year25.June;

public class MaximumDifferenceByRemappingDigit {
    public static void main(String[] args) {
        MaximumDifferenceByRemappingDigit solution = new MaximumDifferenceByRemappingDigit();

        int[] tests = {11891, 90, 9, 1, 100000000, 49984047, 911};
        int[] results = {99009, 99, 9, 9, 900000000, 90009090, 988};

        if (tests.length == results.length) {
            for (int i = 0; i < tests.length; i++) {
                System.out.println(solution.minMaxDifference(tests[i]) == results[i]);
            }
        } else {
            System.out.println("Wrong tests");
        }
    }

    /**
     * LeetCode №2566. Maximum Difference by Remapping a Digit.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param num - a positive integer. 1 <= num <= 100_000_000
     * @return - the difference between the maximum and minimum values Bob can make by remapping exactly one digit in num.
     */
    public int minMaxDifference(int num) {
        int first = getFirst(num);
        int firstNonNine = first == 9 ? getFirstNonNine(num) : first;

        int max = 0;
        int min = 0;

        int multiplier = 1;
        while (num > 0) {
            int digit = num % 10;

            if (digit != first) {
                min += digit * multiplier;
            }
            if (digit == firstNonNine) {
                max += 9 * multiplier;
            } else {
                max += digit * multiplier;
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
