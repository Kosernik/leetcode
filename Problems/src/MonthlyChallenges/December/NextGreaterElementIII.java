package MonthlyChallenges.December;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextGreaterElementIII {

    /**
     * LeetCode #556.
     * (BruteForce solution)
     *
     * Generates the smallest integer which has exactly the same digits existing in the integer "n" and is greater in
     * value than "n".
     *
     * @param n - positive integer.
     * @return - the smallest integer which has exactly the same digits existing in the integer "n" and is greater in
     * value than "n".
     */
    public int nextGreaterElementBrute(int n) {
        List<Integer> digits = new ArrayList<>();

        int num = n;
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }

        Set<Long> numbers = new HashSet<>();
        int res = Integer.MAX_VALUE;
        generate(digits, numbers, n, 0);

        if (numbers.size() == 0) return -1;
        else {
            for (long number : numbers) {
                res = Math.min(res, (int) number);
            }
            return res;
        }
    }

    private void generate(List<Integer> digits, Set<Long> numbers, int n, long number) {
        if (digits.size() == 0) {
            if (number > n && number <= Integer.MAX_VALUE) numbers.add(number);
        } else {
            number *= 10;
            for (int i = 0; i < digits.size(); i++) {
                int digit = digits.get(i);
                digits.remove(i);
                number += digit;

                generate(digits, numbers, n, number);

                number -= digit;
                digits.add(i, digit);
            }
        }
    }
}
