package MonthlyChallenges.Year25.August;

import java.util.*;

public class RearrangingFruits {
    public static void main(String[] args) {
        RearrangingFruits solution = new RearrangingFruits();

        int[] basket1_0 = {4, 2, 2, 2};
        int[] basket2_0 = {1, 4, 1, 2};
        System.out.println(solution.minCost(basket1_0, basket2_0) == 1);

        int[] basket1_1 = {4, 2, 2, 2};
        int[] basket2_1 = {2, 4, 1, 1};
        System.out.println(solution.minCost(basket1_1, basket2_1) == 1);

        int[] basket1_2 = {4, 2, 2, 2, 2};
        int[] basket2_2 = {2, 4, 1, 1, 1};
        System.out.println(solution.minCost(basket1_2, basket2_2) == -1);

        int[] basket1_3 = {84, 80, 43, 8, 80, 88, 43, 14, 100, 88};
        int[] basket2_3 = {32, 32, 42, 68, 68, 100, 42, 84, 14, 8};
        System.out.println(solution.minCost(basket1_3, basket2_3) == 48);
    }

    /**
     * LeetCode №2561. Rearranging Fruits.
     *
     * @param basket1 - an array of integers.
     * @param basket2 - an array of integers. basket1.length = bastet2.length.
     * @return - the minimum cost to make both the baskets equal or -1 if impossible.
     */
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> balanceMap = new HashMap<>();

        int minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < basket1.length; i++) {
            int number1 = basket1[i];
            int number2 = basket2[i];

            minNumber = Math.min(minNumber, Math.min(number1, number2));

            if (number1 != number2) {
                balanceMap.put(number1, balanceMap.getOrDefault(number1, 0) + 1);
                balanceMap.put(number2, balanceMap.getOrDefault(number2, 0) - 1);
            }
        }

        long result = 0L;
        List<Integer> numbers = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : balanceMap.entrySet()) {
            int number = entry.getKey();
            int balance = entry.getValue();
            if (balance % 2 == 1) return -1L;

            for (int i = 0; i < Math.abs(balance) / 2; i++) {
                numbers.add(number);
            }
        }
        minNumber *= 2;

        Collections.sort(numbers);
        for (int i = 0; i < numbers.size() / 2; i++) {
            result += Math.min(minNumber, numbers.get(i));
        }

        return result;
    }
}
