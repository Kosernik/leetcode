package MonthlyChallenges.November21;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * LeetCode #238. Product of Array Except Self.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - an array where 'result'[i] is equal to the product of all the elements of 'nums' except 'nums'[i].
     */
    public int[] productExceptSelf(int[] nums) {
        long totalProduct = 1;
        boolean foundZero = false;
        int zeroIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (number == 0) {
                if (foundZero) {
                    return arrayOfZeroes(nums.length);
                } else {
                    foundZero = true;
                    zeroIdx = i;
                }
            } else {
                totalProduct *= number;
            }
        }

        if (foundZero) {
            return arrayOfZeroesExceptOne(nums.length, zeroIdx, (int) totalProduct);
        } else {
            int[] result = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                result[i] = (int) (totalProduct / nums[i]);
            }

            return result;
        }
    }

    private int[] arrayOfZeroesExceptOne(int length, int idx, int totalProduct) {
        int[] result = new int[length];
        Arrays.fill(result, 0);
        result[idx] = totalProduct;
        return result;
    }

    private int[] arrayOfZeroes(int length) {
        int[] zeroes = new int[length];
        Arrays.fill(zeroes, 0);
        return zeroes;
    }
}
