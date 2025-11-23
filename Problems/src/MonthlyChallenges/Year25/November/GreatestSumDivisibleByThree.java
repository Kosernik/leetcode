package MonthlyChallenges.Year25.November;

public class GreatestSumDivisibleByThree {

    /**
     * LeetCode №1262. Greatest Sum Divisible by Three.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @return - the maximum possible sum of elements of the array such that it is divisible by three.
     */
    public int maxSumDivThree(int[] nums) {
        int[] remainderOne = new int[2];
        int[] remainderTwo = new int[2];

        remainderOne[0] = Integer.MAX_VALUE;
        remainderOne[1] = Integer.MAX_VALUE;

        remainderTwo[0] = Integer.MAX_VALUE;
        remainderTwo[1] = Integer.MAX_VALUE;

        int totalSum = 0;

        for (int number : nums) {
            totalSum += number;

            int remainder = number % 3;
            if (remainder == 1) {
                helper(number, remainderOne);
            } else if (remainder == 2) {
                helper(number, remainderTwo);
            }
        }

        int toDelete = totalSum % 3;

        if (toDelete == 1) {
            int rOne = remainderOne[0];
            int sumTwo = remainderTwo[0] + remainderTwo[1];

            if (remainderTwo[0] != Integer.MAX_VALUE && remainderTwo[1] != Integer.MAX_VALUE && sumTwo % 3 == 1) {
                totalSum -= Math.min(rOne, sumTwo);
            } else {
                totalSum -= rOne;
            }
        } else if (toDelete == 2) {
            int sumOne = remainderOne[0] + remainderOne[1];
            int rTwo = remainderTwo[0];

            if (remainderOne[0] != Integer.MAX_VALUE && remainderOne[1] != Integer.MAX_VALUE && sumOne % 3 == 2) {
                totalSum -= Math.min(sumOne, rTwo);
            } else {
                totalSum -= rTwo;
            }
        }

        return totalSum;
    }

    private void helper(int candidate, int[] pair) {
        if (candidate < pair[0]) {
            pair[1] = pair[0];
            pair[0] = candidate;
        } else if (candidate < pair[1]) {
            pair[1] = candidate;
        }
    }
}
