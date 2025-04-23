package MonthlyChallenges.Year25.April;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {
    public static void main(String[] args) {
        CountLargestGroup solution = new CountLargestGroup();

        int n0 = 13, result0 = 4;
        System.out.println(solution.countLargestGroup(n0) + " ? " + result0);
    }

    /**
     * LeetCode №1399. Count Largest Group.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n - a positive integer.
     * @return - the number of groups that have the largest size.
     */
    public int countLargestGroup(int n) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int curSum = getSum(i);
            counts.put(curSum, counts.getOrDefault(curSum, 0) + 1);
        }

        int largestGroupSize = 0;
        int largestGroup = 0;

        for (int count : counts.values()) {
            if (count > largestGroupSize) {
                largestGroupSize = count;
                largestGroup = 1;
            } else if (count == largestGroupSize) {
                largestGroup++;
            }
        }

        return largestGroup;
    }

    private int getSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
