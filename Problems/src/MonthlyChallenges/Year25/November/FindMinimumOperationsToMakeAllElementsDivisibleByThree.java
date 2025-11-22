package MonthlyChallenges.Year25.November;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {

    /**
     * LeetCode №3190. Find Minimum Operations to Make All Elements Divisible by Three.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @return - the minimum number of operations to make all elements of nums divisible by 3.
     */
    public int minimumOperations(int[] nums) {
        int operations = 0;

        for (int number : nums) {
            if (number % 3 != 0) {
                operations++;
            }
        }

        return operations;
    }
}
