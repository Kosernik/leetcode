package MonthlyChallenges.Year21.March21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReorderedPowerOfTwo {
    /**
     * LeetCode #869.
     * <p>
     * Checks if it is possible to build a number that is a power of 2 by reordering digits in a number "N".
     * <p>
     * Complexity O(1)
     * Memory - O(1)
     *
     * @param N - a positive number, 1 <= N <= 1_000_000_000
     * @return - True - if it is possible to reorder digits in "N", such that the resulting number is a power of 2.
     * False - otherwise.
     */
    public boolean reorderedPowerOf2(int N) {
        Set<Integer> powers = new HashSet<>(Arrays.asList(
                1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432,
                67108864, 134217728, 268435456, 536870912));

        if (powers.contains(N)) return true;

        int[] digits = countDigits(N);
        int length = (int) Math.log10(N) + 1;

        for (Integer power : powers) {
            if (((int) Math.log10(power) + 1) == length) {
                if (isPower(power, digits)) return true;
            }
        }

        return false;
    }

    private boolean isPower(int number, int[] digits) {
        int[] digitsInNumber = countDigits(number);
        return compareArrays(digitsInNumber, digits);
    }

    private int[] countDigits(int number) {
        int[] digits = new int[10];

        while (number > 0) {
            digits[number % 10]++;
            number /= 10;
        }

        return digits;
    }

    private boolean compareArrays(int[] first, int[] second) {
        for (int i = 0; i < 10; i++) {
            if (first[i] != second[i]) return false;
        }
        return true;
    }
}
