package Problems;

public class SingleElementInSortedArray {

    /**
     * LeetCode #540. Single Element in a Sorted Array.
     *
     * Complexity - O(logN)
     * Memory - O(1)
     *
     * @param nums - a sorted array consisting of only integers where every element appears exactly twice, except for
     *             one element which appears exactly once.
     * @return - the single element that appears only once.
     */
    public int singleNonDuplicate(int[] nums) {
        int leftIdx = 0, rightIdx = nums.length-1, middle;

        while (leftIdx < rightIdx) {
            middle = (rightIdx + leftIdx) / 2;
            if (middle % 2 == 1) middle--;

            if (nums[middle] == nums[middle+1]) {
                leftIdx = middle+2;
            } else {
                rightIdx = middle;
            }
        }

        return nums[leftIdx];
    }

    /**
     * LeetCode #540. Single Element in a Sorted Array.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - a sorted array consisting of only integers where every element appears exactly twice, except for
     *             one element which appears exactly once.
     * @return - the single element that appears only once.
     */
    public int singleNonDuplicateLinear(int[] nums) {
        int result = 0;

        for (int number : nums) result ^= number;

        return result;
    }
}
