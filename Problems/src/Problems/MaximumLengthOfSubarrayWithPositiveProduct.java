package Problems;

public class MaximumLengthOfSubarrayWithPositiveProduct {
    public static void main(String[] args) {
        MaximumLengthOfSubarrayWithPositiveProduct solution = new MaximumLengthOfSubarrayWithPositiveProduct();

        int[] test = {70,-18,75,-72,-69,-84,64,-65,0,-82,62,54,-63,-85,53,-60,-59,29,32,59,-54,-29,-45,0,-10,22,42,-37,-16,0,-7,-76,-34,37,-10,2,-59,-24,85,45,-81,56,86};
        System.out.println(solution.getMaxLen(test));
    }

    /**
     * LeetCode #1567. Maximum Length of Subarray With Positive Product.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the maximum length of a subarray with positive product.
     */
    public int getMaxLen(int[] nums) {
        int maxLength = 0;

        int leftProductSign = 0;
        int leftLength = 0;
        int rightProductSign = 0;
        int rightLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int leftMult = Integer.compare(nums[i], 0);
            leftProductSign = (leftProductSign == 0 ? 1 : leftProductSign) * leftMult;
            if (leftProductSign == 0) {
                leftLength = 0;
            } else {
                leftLength++;
                if (leftProductSign > 0) {
                    maxLength = Math.max(maxLength, leftLength);
                }
            }

            int rightMult = Integer.compare(nums[nums.length - i - 1], 0);
            rightProductSign = (rightProductSign == 0 ? 1 : rightProductSign) * rightMult;
            if (rightProductSign == 0) {
                rightLength = 0;
            } else {
                rightLength++;
                if (rightProductSign > 0) {
                    maxLength = Math.max(maxLength, rightLength);
                }
            }
        }

        return maxLength;
    }
}
