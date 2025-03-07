package MonthlyChallenges.Year25.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimeNumbersInRange {
    public static void main(String[] args) {
        ClosestPrimeNumbersInRange solution = new ClosestPrimeNumbersInRange();

        int left0 = 10, right0 = 29;
        System.out.println(Arrays.toString(solution.closestPrimes(left0, right0)));
    }

    /**
     * LeetCode №2523. Closest Prime Numbers in Range.
     * <p>
     * Complexity - O(R), R = right
     * Memory - O(R)
     *
     * @param left  - minimum value of a prime.
     * @param right - maximum value of a prime.
     * @return - a pair of primes num1 and num2 whose difference is the minimum amongst all other pairs of primes
     * between left and right. If there are multiple pairs satisfying these conditions, returns the one with the
     * smallest num1 value. If no such numbers exist, returns [-1, -1].
     */
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = getPrimes(left, right);

        int bestDiff = Integer.MAX_VALUE;
        int[] result = {-1, -1};
        if (primes.size() <= 1) return result;

        int prev = primes.get(0);

        for (int i = 1; i < primes.size(); i++) {
            int curPrime = primes.get(i);

            int diff = curPrime - prev;

            if (diff < bestDiff) {
                result[0] = prev;
                result[1] = curPrime;
                bestDiff = diff;

                if (diff <= 2) return result;
            }

            prev = curPrime;
        }

        return result;
    }

    private List<Integer> getPrimes(int minPrime, int maxPrime) {
        List<Integer> primes = new ArrayList<>();

        boolean[] isNotPrime = new boolean[maxPrime + 1];
        for (int i = 2; i <= maxPrime; i++) {
            if (isNotPrime[i]) continue;

            if (i >= minPrime) primes.add(i);

            int number = i;
            while (true) {
                number += i;
                if (number <= 0 || number > maxPrime) break;
                isNotPrime[number] = true;
            }
        }

        return primes;
    }
}
