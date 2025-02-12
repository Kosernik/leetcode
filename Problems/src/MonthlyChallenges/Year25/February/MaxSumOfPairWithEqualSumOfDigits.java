package MonthlyChallenges.Year25.February;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        MaxSumOfPairWithEqualSumOfDigits solution = new MaxSumOfPairWithEqualSumOfDigits();

        int[] test = {18, 43, 36, 13, 7, 72};
        System.out.println(solution.maximumSum(test) == 108);
    }

    /**
     * LeetCode №2342. Max Sum of a Pair With Equal Sum of Digits.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @return - the maximum value of nums[i] + nums[j], such that the sum of digits of the number nums[i] is equal to
     * that of nums[j] and i != j.
     */
    public int maximumSum(int[] nums) {
        int result = -1;

        Map<Integer, int[]> sameDigits = new HashMap<>();

        for (int number : nums) {
            int sum = getSumOfDigits(number);

            if (!sameDigits.containsKey(sum)) {
                int[] pair = {number, 0};
                sameDigits.put(sum, pair);
            } else {
                int[] pair = sameDigits.get(sum);
                updatePair(number, pair);

                result = Math.max(result, pair[0] + pair[1]);
            }
        }

        return result;
    }

    private void updatePair(int candidate, int[] pair) {
        if (candidate > pair[0]) {
            pair[1] = pair[0];
            pair[0] = candidate;
        } else if (candidate > pair[1]) {
            pair[1] = candidate;
        }
    }

    private int getSumOfDigits(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
