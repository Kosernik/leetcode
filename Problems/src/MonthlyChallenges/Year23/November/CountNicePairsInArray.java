package MonthlyChallenges.Year23.November;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInArray {

    /**
     * LeetCode №1814. Count Nice Pairs in an Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of non-negative integers.
     * @return - the total number of nice pairs.
     */
    public int countNicePairs(int[] nums) {
        long pairs = 0;
        int MODULO = 1_000_000_000 + 7;
        Map<Integer, Integer> sums = new HashMap<>();

        for (int number : nums) {
            int curSum = number - getReversedInteger(number);
            int curPairs = sums.getOrDefault(curSum, 0);

            pairs = (pairs + curPairs) % MODULO;
            sums.put(curSum, curPairs + 1);
        }

        return (int) pairs;
    }

    private int getReversedInteger(int number) {
        int reversed = 0;

        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }

        return reversed;
    }
}
