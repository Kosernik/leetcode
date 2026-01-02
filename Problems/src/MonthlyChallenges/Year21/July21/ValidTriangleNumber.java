package MonthlyChallenges.Year21.July21;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        ValidTriangleNumber solution = new ValidTriangleNumber();

        int[] test0 = {2, 2, 3, 4};
        System.out.println(solution.triangleNumber(test0));
    }

    // LeetCode #611.
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] == 0) return 0;

        int result = 0;
        int startIdx = binarySearchLeftMost(nums, 1);
        startIdx = startIdx >= 0 ? startIdx : getIdx(startIdx);

        for (int i = startIdx; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int minLength = nums[j] - nums[i] + 1;
                int maxLength = nums[i] + nums[j] - 1;

                int lessThenMin = binarySearchLeftMost(nums, minLength);
                lessThenMin = lessThenMin >= 0 ? lessThenMin : getIdx(lessThenMin);
                int lessThenMax = binarySearchRightMost(nums, maxLength);

                int numberOfSides = lessThenMax - lessThenMin + 1;
                if (minLength <= nums[i] && nums[i] <= maxLength) numberOfSides -= 1;
                if (minLength <= nums[j] && nums[j] <= maxLength) numberOfSides -= 1;

                result += numberOfSides;
            }
        }

        return result / 3;
    }

    private int getIdx(int binSearchResult) {
        return (-binSearchResult - 1);
    }

    private int binarySearchLeftMost(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (left >= nums.length || nums[left] != target) return (-left - 1);
        return left;
    }

    private int binarySearchRightMost(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right - 1;
    }
}
