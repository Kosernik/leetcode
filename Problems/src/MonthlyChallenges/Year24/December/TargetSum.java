package MonthlyChallenges.Year24.December;

public class TargetSum {
    public static void main(String[] args) {
        TargetSum solution = new TargetSum();

        int[] test0 = {1, 1, 1, 1, 1};
        int target0 = 3;
        System.out.println(solution.findTargetSumWays(test0, target0));
    }

    /**
     * LeetCode №494. Target Sum.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(1)
     *
     * @param nums   - an array of integers.
     * @param target - the target sum.
     * @return - the number of different expressions that concatenates to the target.
     */
    public int findTargetSumWays(int[] nums, int target) {
        return backTrack(0, 0, nums, target);
    }

    private int backTrack(int index, int sum, int[] nums, int target) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else return 0;
        }

        int curResult = backTrack(index + 1, sum + nums[index], nums, target);
        curResult += backTrack(index + 1, sum - nums[index], nums, target);

        return curResult;
    }
}
