package MonthlyChallenges.Year21.September21;

public class PartitionToKEqualSumSubsets {
    /**
     * LeetCode #698. Partition to K Equal Sum Subsets.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(k)
     *
     * @param nums - an array of positive integers. 1 <= nums.length <= 16. 1 <= nums[i] <= 10^4.
     * @param k    - the number of subsets.
     * @return - true - if it is possible to divide nums into k-parts whose sums are all equal. false - otherwise.
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int element : nums) sum += element;

        if (sum % k != 0) return false;

        int[] sums = new int[k];
        int target = sum / k;

        return backtrack(nums, sums, 0, target);
    }

    private boolean backtrack(int[] nums, int[] sums, int idx, int target) {
        if (idx >= nums.length) {
            return allEqualTarget(sums, target);
        }
        for (int i = 0; i < sums.length; i++) {
            sums[i] += nums[idx];
            if (sums[i] <= target && backtrack(nums, sums, idx + 1, target)) return true;
            sums[i] -= nums[idx];
        }
        return false;
    }

    private boolean allEqualTarget(int[] sums, int target) {
        for (int element : sums) {
            if (element != target) return false;
        }
        return true;
    }
}
