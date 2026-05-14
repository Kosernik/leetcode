package MonthlyChallenges.Year26.May;

import java.util.Arrays;

public class CheckIfArrayIsGood {
    public static void main(String[] args) {
        CheckIfArrayIsGood solution = new CheckIfArrayIsGood();

        int[] nums0 = {2, 1, 3};
        boolean result0 = false;
        System.out.println(solution.isGood(nums0) == result0);

        int[] nums1 = {1, 3, 3, 2};
        boolean result1 = true;
        System.out.println(solution.isGood(nums1) == result1);

        int[] nums2 = {1, 1};
        boolean result2 = true;
        System.out.println(solution.isGood(nums2) == result2);

        int[] nums3 = {3, 4, 4, 1, 2, 1};
        boolean result3 = false;
        System.out.println(solution.isGood(nums3) == result3);

        int[] nums4 = {1, 3, 13, 2};
        boolean result4 = false;
        System.out.println(solution.isGood(nums4) == result4);

        int[] nums5 = {1, 3, 3, 2, 2};
        boolean result5 = false;
        System.out.println(solution.isGood(nums5) == result5);

        int[] nums6 = {1, 4, 3, 2, 5};
        boolean result6 = false;
        System.out.println(solution.isGood(nums6) == result6);

        int[] nums7 = {1, 1, 2};
        boolean result7 = false;
        System.out.println(solution.isGood(nums7) == result7);
    }

    /**
     * LeetCode №2784. Check if Array is Good.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(logN)
     *
     * @param nums - an array of integers.
     * @return - true if nums is a good array, false - otherwise.
     */
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != (i + 1)) return false;
        }

        return nums[nums.length - 1] == nums.length - 1;
    }
}
