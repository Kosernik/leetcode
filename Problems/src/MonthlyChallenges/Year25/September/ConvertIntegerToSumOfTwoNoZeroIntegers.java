package MonthlyChallenges.Year25.September;

import java.util.Arrays;

public class ConvertIntegerToSumOfTwoNoZeroIntegers {
    public static void main(String[] args) {
        ConvertIntegerToSumOfTwoNoZeroIntegers solution = new ConvertIntegerToSumOfTwoNoZeroIntegers();

        int wrongCounter = 0;
        for (int n = 2; n <= 10_000; n++) {
            int[] result = solution.getNoZeroIntegers(n);

            if ((result[0] + result[1]) != n || !hasNoZeroes(result[0]) || !hasNoZeroes(result[1])) {
                System.out.println("Wrong result for: " + n + ", got " + Arrays.toString(result));
                wrongCounter++;
            }
        }
        System.out.println("Done! Wrong results: " + wrongCounter);
    }


    /**
     * LeetCode №1317. Convert Integer to the Sum of Two No-Zero Integers.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param n - a positive integer. n >= 2.
     * @return - a pair of two positive integers without 0 digits in them, whose sum is equals n.
     */
    public int[] getNoZeroIntegers(int n) {
        int first = 1;

        while (true) {
            if (hasNoZeroes(first) && hasNoZeroes(n - first)) {
                return new int[]{first, n - first};
            }
            first++;
        }
    }

    private static boolean hasNoZeroes(int number) {
        while (number > 0) {
            if (number % 10 == 0) return false;
            number /= 10;
        }

        return true;
    }
}
