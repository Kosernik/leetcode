package Problems;

public class MonotonicArray {

    /**
     * LeetCode #896. Monotonic Array.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - True if nums is either monotone increasing or monotone decreasing. False - otherwise.
     */
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) return true;

        if (nums[0] < nums[nums.length-1]) {
            return isMonoIncreasing(nums);
        } else if (nums[0] > nums[nums.length-1]) {
            return isMonoDecreasing(nums);
        } else {
            return isEqual(nums);
        }
    }

    private boolean isMonoIncreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) return false;
        }
        return true;
    }

    private boolean isMonoDecreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) return false;
        }
        return true;
    }

    private boolean isEqual(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) return false;
        }
        return true;
    }
}
