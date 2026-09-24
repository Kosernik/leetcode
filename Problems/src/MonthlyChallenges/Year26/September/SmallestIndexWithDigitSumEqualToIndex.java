package MonthlyChallenges.Year26.September;

public class SmallestIndexWithDigitSumEqualToIndex {

    /**
     * LeetCode №3550. Smallest Index With Digit Sum Equal to Index.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of non-negative integers.
     * @return - the smallest index i such that the sum of the digits of nums[i] is equal to i.
     * If no such index exists, returns -1.
     */
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (getSumOfDigits(nums[i]) == i) {
                return i;
            }
        }

        return -1;
    }

    private int getSumOfDigits(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
