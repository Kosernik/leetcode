package MonthlyChallenges.Year25.March;

public class MaximumCandiesAllocatedToKChildren {

    /**
     * LeetCode №2226. Maximum Candies Allocated to K Children.
     * <p>
     * Complexity - (logM*N), M = Max(candies), N = candies.length.
     * Memory - O(1)
     *
     * @param candies - an array of positive integers.
     * @param k       - the total number of kids.
     * @return - the maximum number of candies each child can get.
     */
    public int maximumCandies(int[] candies, long k) {
        int left = 0, right = getMaxValue(candies);
        int middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            if (canSplit(middle, candies, k)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private boolean canSplit(int numberOfCandies, int[] candies, long k) {
        long kidsRemaining = k;

        for (int candy : candies) {
            kidsRemaining -= candy / numberOfCandies;

            if (kidsRemaining <= 0) return true;
        }

        return false;
    }

    private int getMaxValue(int[] numbers) {
        int maxValue = numbers[0];

        for (int number : numbers) maxValue = Math.max(maxValue, number);

        return maxValue;
    }
}
