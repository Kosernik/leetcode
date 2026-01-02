package MonthlyChallenges.Year21.February21;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray solution = new ShortestUnsortedContinuousSubarray();
        solution.testFindUnsortedSubarray();
    }

    /**
     * LeetCode #581.
     * <p>
     * Returns the length of a continuous subarray that if it will be sorted, then the whole array will be sorted in
     * ascending order.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - non-empty array of integers.
     * @return - the length of a subarray, that needs to be sorted.
     */
    public int findUnsortedSubarray(int[] nums) {
        int leftIdx = 0;

        while (leftIdx < (nums.length - 1) && nums[leftIdx] <= nums[leftIdx + 1]) {
            leftIdx++;
        }

        if (leftIdx == nums.length - 1) return 0;

        int rightIdx = nums.length - 1;

        while (nums[rightIdx] >= nums[rightIdx - 1]) {
            rightIdx--;
        }

        int[] minMax = getMinMax(nums, leftIdx, rightIdx);

        while (leftIdx >= 0 && nums[leftIdx] > minMax[0]) leftIdx--;
        while (rightIdx < nums.length && nums[rightIdx] < minMax[1]) rightIdx++;

        return rightIdx - leftIdx - 1;
    }

    private int[] getMinMax(int[] nums, int left, int right) {
        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            res[0] = Math.min(res[0], nums[i]);
            res[1] = Math.max(res[1], nums[i]);
        }

        return res;
    }

    private void testFindUnsortedSubarray() {
        int[][] tests = {
                {2, 6, 4, 8, 10, 9, 15},
                {1, 2, 3, 4},
                {1},
                {1, 2, 3, 4, 6, 5},
                {1, 2, 3, 4, 6, 5, 7, 8},
                {1, 2, 3, 4, 6, 6, 5, 7, 8},
                {9, 8, 7, 6, 5, 4, 3, 2, 1},
                {2, 1},
                {2, 1, 1},
                {2, 2, 1},
                {1, 2, 3, 3, 5, 4, 4, 6, 6, 7},
                {1, 2, 3, 3, 5, 4, 6, 6, 7},
        };
        int[] results = {
                5,
                0,
                0,
                2,
                2,
                3,
                9,
                2,
                3,
                3,
                3,
                2
        };

        for (int i = 0; i < tests.length; i++) {
            int res = findUnsortedSubarray(tests[i]);
            System.out.println("Test # " + i + "\t" + (res == results[i]));
        }
    }
}
