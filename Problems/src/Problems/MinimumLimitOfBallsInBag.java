package Problems;

import java.util.Arrays;

public class MinimumLimitOfBallsInBag {
    public static void main(String[] args) {
        MinimumLimitOfBallsInBag solution = new MinimumLimitOfBallsInBag();

        int[] test2 = {2,3,4,5,6,7,8,9};
        int maxOperations2 = 6;

        System.out.println(solution.minimumSize(test2, maxOperations2));
    }

    /**
     * LeetCode #1760. Minimum Limit of Balls in a Bag.
     *
     * Complexity - (NlogN)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @param maxOperations - the maximum number of operations.
     * @return - the maximum number of balls in a bag after performing operations.
     */
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        if (maxOperations == 0) return nums[nums.length-1];

        int minSize = maxOperations >= nums.length ? 1 : nums[nums.length-maxOperations-1];
        int maxSize = nums[nums.length-1];

        while (minSize < maxSize) {
            int middle = (maxSize - minSize) / 2 + minSize;

            if (isEnoughOperations(middle, maxOperations, nums)) {
                maxSize = middle;
            } else {
                minSize = middle+1;
            }
        }

        return minSize;
    }

    private boolean isEnoughOperations(int target, int maxOperations, int[] nums) {
        int curNumOfOperations = 0;

        for (int i = nums.length-1; i >= 0 && nums[i] > target; i--) {
            curNumOfOperations += (Math.ceil(nums[i] / (double) target)-1);
            if (curNumOfOperations > maxOperations) return false;
        }

        return true;
    }
}
