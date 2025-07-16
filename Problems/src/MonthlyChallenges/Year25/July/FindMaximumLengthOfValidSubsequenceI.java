package MonthlyChallenges.Year25.July;

public class FindMaximumLengthOfValidSubsequenceI {

    /**
     * LeetCode №3201. Find the Maximum Length of Valid Subsequence I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * A subsequence sub of nums with length x is called valid if it satisfies:
     * * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
     *
     * @param nums - an array of positive integers.
     * @return - the length of the longest valid subsequence of nums.
     */
    public int maximumLength(int[] nums) {
        int oddsCount = nums[0] % 2;

        int alternatingLength = 1;

        int prevEven = oddsCount;

        for (int i = 1; i < nums.length; i++) {
            int curRemainder = nums[i] % 2;
            if (curRemainder != prevEven) {
                alternatingLength++;
                prevEven = nums[i] % 2;
            }

            oddsCount += curRemainder;
        }

        return Math.max(alternatingLength, Math.max(nums.length - oddsCount, oddsCount));
    }


    /**
     * LeetCode №3201. Find the Maximum Length of Valid Subsequence I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * A subsequence sub of nums with length x is called valid if it satisfies:
     * * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
     *
     * @param nums - an array of positive integers.
     * @return - the length of the longest valid subsequence of nums.
     */
    public int maximumLengthOld(int[] nums) {
        int evenOddLength = getMaxEvenOdd(nums);

        int alternatingOdd = getMaxLengthAlternating(nums);

        return Math.max(evenOddLength, alternatingOdd);
    }

    private int getMaxLengthAlternating(int[] nums) {
        int length = 1;

        int prevEven = nums[0] % 2;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != prevEven) {
                length++;
                prevEven = nums[i] % 2;
            }
        }

        return length;
    }

    private int getMaxEvenOdd(int[] nums) {
        int odds = 0;

        for (int number : nums) {
            odds += number % 2;
        }

        return Math.max(nums.length - odds, odds);
    }
}
