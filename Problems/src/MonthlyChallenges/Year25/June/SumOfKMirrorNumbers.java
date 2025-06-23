package MonthlyChallenges.Year25.June;

import java.util.ArrayList;
import java.util.List;

public class SumOfKMirrorNumbers {
    public static void main(String[] args) {
        SumOfKMirrorNumbers solution = new SumOfKMirrorNumbers();

        System.out.println(solution.kMirror(2, 5) == 25);
        System.out.println(solution.kMirror(3, 7) == 499);
        System.out.println(solution.kMirror(7, 17) == 20_379_000);
    }

    long sum;
    int remaining;

    /**
     * LeetCode №2081. Sum of k-Mirror Numbers.
     *
     * @param k - a second base of a mirror number.
     * @param n - the total number of mirror numbers.
     * @return - the sum of the n smallest k-mirror numbers.
     */
    public long kMirror(int k, int n) {
        sum = 0L;
        remaining = n;

        for (int i = 1; i <= 9; i++) {
            List<Integer> converted = convertToBase(i, k);
            if (isPalindrome(converted)) {
                sum += i;
                remaining--;

                if (remaining == 0) break;
            }
        }

        helper(k, 1);

        return sum;
    }

    private void helper(int base, int length) {
        if (remaining == 0) return;

        int halfLength = (length - 1) / 2;
        long start = (long) Math.pow(10, halfLength);

        long multiplier = start * 10;

        for (long leftHalf = start; leftHalf < start * 10; leftHalf++) {
            long reversed = getReversed(leftHalf);
            long candidate = leftHalf * multiplier + reversed;

            List<Integer> converted = convertToBase(candidate, base);
            if (isPalindrome(converted)) {
                sum += candidate;
                remaining--;

                if (remaining == 0) return;
            }
        }

        for (long leftHalf = start; leftHalf < start * 10; leftHalf++) {
            long reversed = getReversed(leftHalf);

            for (int i = 0; i <= 9; i++) {
                long candidate = (leftHalf * 10 + i) * multiplier + reversed;

                List<Integer> converted = convertToBase(candidate, base);
                if (isPalindrome(converted)) {
                    sum += candidate;
                    remaining--;

                    if (remaining == 0) return;
                }
            }
        }

        helper(base, length + 2);
    }

    private long getReversed(long number) {
        long reversed = 0L;


        while (number > 0) {
            reversed *= 10;
            reversed += number % 10;

            number /= 10;
        }

        return reversed;
    }

    private List<Integer> convertToBase(long decimal, int base) {
        List<Integer> result = new ArrayList<>();

        while (decimal != 0) {
            result.add((int) (decimal % base));
            decimal /= base;
        }

        return result;
    }

    private boolean isPalindrome(List<Integer> candidate) {
        int left = 0, right = candidate.size() - 1;

        while (left < right) {
            if (candidate.get(left++).intValue() != candidate.get(right--).intValue()) return false;
        }

        return true;
    }

}
