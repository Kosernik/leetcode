package MonthlyChallenges.December;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII solution = new RemoveDuplicatesFromSortedArrayII();
        solution.testRemoveDuplicates();
    }

    /**
     *  LeetCode #80.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - array of integers, not null.
     * @return - the "resulting" length of the modified array.
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int currIdx = 1;
        boolean duplicate = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[currIdx-1] == nums[i]) {
                if (!duplicate) {
                    duplicate = true;
                    nums[currIdx++] = nums[i];
                }
            } else {
                nums[currIdx++] = nums[i];
                duplicate = false;
            }

        }

        return currIdx;
    }

    private void testRemoveDuplicates() {
        int[][] tests = {
                {1,1,1,2,2,3},
                {0,0,1,1,1,1,2,3,3},
                {},
                {1},
                {1,1}
        };

        for (int[] test : tests) {
            System.out.println("Original array:\t" + Arrays.toString(test));
            System.out.println(removeDuplicates(test));
            System.out.println("Modified array:\t" + Arrays.toString(test));
            System.out.println("----");
        }
    }
}
