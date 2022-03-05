package Problems;

public class SignOfProductOfArray {

    /**
     * LeetCode #1822. Sign of the Product of an Array.
     *
     * Compplexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - 1 - if the product of all numbers in 'nums' is positive.
     *           0 - if the product of all numbers in 'nums' equals 0.
     *           -1 - if the product of all numbers in 'nums' is negative..
     */
    public int arraySign(int[] nums) {
        int countNegative = 0;

        for (int number : nums) {
            if (number == 0) return 0;
            if (number < 0) countNegative++;
        }

        return countNegative % 2 == 0 ? 1 : -1;
    }
}
