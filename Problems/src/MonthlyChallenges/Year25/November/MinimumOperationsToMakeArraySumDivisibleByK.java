package MonthlyChallenges.Year25.November;

public class MinimumOperationsToMakeArraySumDivisibleByK {

    /**
     * LeetCode №3512. Minimum Operations to Make Array Sum Divisible by K.
     *
     * @param nums - an array of positive integers.
     * @param k    - a positive integer.
     * @return - the minimum number of operations required to make the sum of the array divisible by k.
     */
    public int minOperations(int[] nums, int k) {
        if (k == 1) return 0;
        int sum = 0;

        for (int number : nums) sum += number;

        return sum % k;
    }
}
