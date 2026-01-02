package MonthlyChallenges.Year21.January21;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] test0 = {3, 2, 1};
        solution.nextPermutation(test0);
        System.out.println(Arrays.toString(test0));
    }

    // LeetCode #31.
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        else if (nums.length == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {

                int idx = getIndexOfLargerNumber(nums, nums[i]);
                swap(nums, i, idx);

                reverseSubArray(nums, i + 1, nums.length - 1);
                return;
            }
        }
        reverseSubArray(nums, 0, nums.length - 1);
    }

    private int getIndexOfLargerNumber(int[] nums, int number) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > number) return i;
        }
        return 0;
    }

    private void reverseSubArray(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
