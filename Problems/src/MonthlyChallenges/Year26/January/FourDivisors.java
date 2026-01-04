package MonthlyChallenges.Year26.January;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourDivisors {
    public static void main(String[] args) {
        FourDivisors solution = new FourDivisors();

        int[] test0 = {21, 4, 7};
        int result0 = 32;
        System.out.println(solution.sumFourDivisors(test0) == result0);
    }

    /**
     * LeetCode #1390. Four Divisors.
     *
     * @param nums - an array of positive integers.
     * @return - the sum of divisors of the integers in nums that have exactly four divisors.
     */
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        Map<Integer, Integer> computed = new HashMap<>();

        for (int number : nums) {
            if (computed.containsKey(number)) {
                sum += computed.get(number);
                continue;
            }

            int curSum = getSumIfFourDivisors(number);
            computed.put(number, curSum);

            sum += curSum;
        }

        return sum;
    }

    private int getSumIfFourDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        divisors.add(number);

        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if ((number % i) == 0) {
                divisors.add(i);
                if (number / i != i) {
                    divisors.add(number / i);
                }

                if (divisors.size() > 4) return 0;
            }
        }

        if (divisors.size() < 4) return 0;
        return divisors.get(0) + divisors.get(1) + divisors.get(2) + divisors.get(3);
    }
}
