package MonthlyChallenges.Year21.August21;

public class RangeSumQueryImmutable {

    private final int[] sums;

    // LeetCode #303.
    public RangeSumQueryImmutable(int[] nums) {
        this.sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return this.sums[right + 1] - this.sums[left];
    }
}
