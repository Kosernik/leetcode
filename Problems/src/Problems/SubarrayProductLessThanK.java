package Problems;

public class SubarrayProductLessThanK {

    /**
     * LeetCode #713. Subarray Product Less Than K.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @param k - the maximum allowed product.
     * @return - the number of contiguous subarrays where the product of all the elements in the subarray is strictly
     *           less than "k".
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;

        int product = 1;
        int startIdx = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];

            while (startIdx < i && product >= k) {
                product /= nums[startIdx];
                startIdx++;
            }

            if (startIdx <= i && product < k) {
                result += i - startIdx + 1;
            }
        }

        return result;
    }
}
