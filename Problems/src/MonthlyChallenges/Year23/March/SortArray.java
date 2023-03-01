package MonthlyChallenges.Year23.March;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        SortArray solution = new SortArray();

        int[] test1 = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(test1));

        int[] sorted = solution.sortArray(test1);
        System.out.println(Arrays.toString(sorted));
    }


    /**
     * LeetCode #912. Sort an Array.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - sorted array.
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        return sortArray(nums, 0, nums.length - 1);
    }

    private int[] sortArray(int[] nums, int start, int end) {
        if (start == end) {
            return nums;
        }

        int middle = (end - start) / 2 + start;

        sortArray(nums, start, middle);
        sortArray(nums, middle + 1, end);

        return mergeSubarrays(nums, start, middle, middle + 1, end);
    }

    private int[] mergeSubarrays(int[] nums, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        int idx = firstStart;
        int[] temp = new int[secondEnd - firstStart + 1];

        for (int i = 0; i < temp.length; i++) {
            int number;
            if (firstStart > firstEnd) {
                number = nums[secondStart++];
            } else if (secondStart > secondEnd) {
                number = nums[firstStart++];
            } else if (nums[firstStart] > nums[secondStart]) {
                number = nums[secondStart++];
            } else {
                number = nums[firstStart++];
            }
            temp[i] = number;
        }

        for (int number : temp) {
            nums[idx] = number;
            idx++;
        }

        return nums;
    }
}
