package MonthlyChallenges.Year23.December;

public class MaximumProductDifferenceBetweenTwoPairs {
    public static void main(String[] args) {
        MaximumProductDifferenceBetweenTwoPairs solution = new MaximumProductDifferenceBetweenTwoPairs();

        int[] test0 = {5, 6, 2, 7, 4};
        System.out.println(solution.maxProductDifference(test0) == 34);
    }

    /**
     * LeetCode №1913. Maximum Product Difference Between Two Pairs.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @return - the maximum product difference between two pairs.
     */
    public int maxProductDifference(int[] nums) {
        int minVal = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int secondMax = Integer.MIN_VALUE, maxVal = Integer.MIN_VALUE;

        for (int number : nums) {
            if (number < minVal) {
                secondMin = minVal;
                minVal = number;
            } else if (number < secondMin) {
                secondMin = number;
            }
            if (number > maxVal) {
                secondMax = maxVal;
                maxVal = number;
            } else if (number > secondMax) {
                secondMax = number;
            }
        }

        return (maxVal * secondMax) - (minVal * secondMin);
    }
}
