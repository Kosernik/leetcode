package MonthlyChallenges.Year24.December;

import java.util.Arrays;

public class FinalPricesWithSpecialDiscountInShop {
    public static void main(String[] args) {
        FinalPricesWithSpecialDiscountInShop solution = new FinalPricesWithSpecialDiscountInShop();

        int[] test = {8, 7, 4, 2, 8, 1, 7, 7, 10, 1};
        System.out.println(Arrays.toString(solution.finalPrices(test)));
    }

    /**
     * LeetCode №1475. Final Prices With a Special Discount in a Shop.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(1)
     *
     * @param prices - an array of integers.
     * @return - an array prices after applying discounts.
     */
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];

        for (int i = 0; i < result.length - 1; i++) {
            int curPrice = prices[i];

            for (int j = i + 1; j < result.length; j++) {
                if (prices[j] <= curPrice) {
                    curPrice -= prices[j];
                    break;
                }
            }

            result[i] = curPrice;
        }

        result[result.length - 1] = prices[prices.length - 1];
        return result;
    }
}
