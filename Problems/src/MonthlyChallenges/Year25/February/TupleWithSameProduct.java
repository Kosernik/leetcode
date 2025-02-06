package MonthlyChallenges.Year25.February;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public static void main(String[] args) {
        TupleWithSameProduct solution = new TupleWithSameProduct();

        int[] test0 = {2, 3, 4, 6};
        System.out.println(solution.tupleSameProduct(test0) == 8);
    }

    /**
     * LeetCode №1726. Tuple with Same Product.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N^2)
     *
     * @param nums - an array of distinct integers.
     * @return - the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums,
     * and a != b != c != d.
     */
    public int tupleSameProduct(int[] nums) {
        int result = 0;

        Map<Long, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            long number = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                long curProduct = number * nums[j];

                int curCount = counts.getOrDefault(curProduct, 0);

                //result += (curCount * 4);
                result += (curCount << 2);

                counts.put(curProduct, curCount + 2);
            }
        }

        return result;
    }
}
