package MonthlyChallenges.September;

import java.util.Arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray solution = new MaximumProductSubarray();
        solution.testMaxProduct();
    }

    private void testMaxProduct() {
        int[][][] tests = {
                {{2, 3, -2, 4}, {6}},
                {{-2, 0, -1}, {0}},
                {{}, {0}},
                {{-2}, {-2}},
                {{1, 2, 3, 4, 6, 1, 0, 2, 5, 7, 8, 3}, {1680}},
                {{1, 2, 3, -4, 6, 1, 0, 2, 5, -7, 8, 3}, {24}},
                {{1, 2, -3, 4, -6, 1, 0, 2, 5, 7, 8, -3}, {560}},
                {{1, 2, -3, 4, -6, 1, 0, 2, -5, 7, 8, -3}, {1680}},
                {{1, 2, 3, 4, -6, 1, 0, 2, -5, 7, 8, -3}, {1680}}
        };

        int failedBrute = 0;
        int failed = 0;

        for (int[][] test : tests) {
            if (maxProductBrute(test[0]) != test[1][0]) {
                failedBrute++;
                System.out.println("Wrong answer for test: \t" + Arrays.toString(test[0]));
                System.out.println("Got: " + maxProductBrute(test[0]) + ", instead of: " + test[1][0]);
            }
            if (maxProduct(test[0]) != test[1][0]) {
                failed++;
                System.out.println("Wrong answer for test: \t" + Arrays.toString(test[0]));
                System.out.println("Got: " + maxProduct(test[0]) + ", instead of: " + test[1][0]);
            }
        }

        System.out.println("Success rate for bruteforce solution: " + (tests.length - failedBrute) * 100.0 / tests.length);
        System.out.println("Success rate: " + (tests.length - failed) * 100.0 / tests.length);
    }

    /**
     * Finding the contiguous subarray within an array (containing at least one number) which has the largest product.
     *
     * @param nums - array of integers
     * @return - maximum product
     */
    public int maxProductBrute(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        int length = nums.length;

        int max = nums[0];

        for (int i = 1; i < length; i++) {
            int currProd = nums[i];
            max = Math.max(max, currProd);
            int idx = i - 1;
            while (idx >= 0) {
                if (currProd == 0) break;
                currProd *= nums[idx--];
                max = Math.max(max, currProd);
            }
        }
        return max;
    }

    /**
     * LeetCode #152. Maximum Product Subarray.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - array of integers
     * @return - maximum product.
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        int result = nums[0];

        int leftProduct = 0;
        int rightProduct = 0;

        for (int i = 0; i < nums.length; i++) {
            leftProduct = (leftProduct == 0 ? 1 : leftProduct) * nums[i];
            rightProduct = (rightProduct == 0 ? 1 : rightProduct) * nums[nums.length - i - 1];
            result = Math.max(result, Math.max(leftProduct, rightProduct));
        }

        return result;
    }
}
