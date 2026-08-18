package MonthlyChallenges.Year26.August;

public class FindLargestAlmostMissingInteger {

    private final int MAX_NUMBER = 50;

    /**
     * LeetCode №3471. Find the Largest Almost Missing Integer.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * * An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.
     *
     * @param nums - an array of integers. 0 <= nums[i] <= 50
     * @param k    - the size of a subarray.
     * @return - the largest almost missing integer from nums. If no such integer exists, returns -1.
     */
    public int largestInteger(int[] nums, int k) {
        if (k == 1) {
            return getLargestUnique(nums);
        } else if (k == nums.length) {
            return getLargest(nums);
        }

        int left = nums[0], right = nums[nums.length - 1];
        if (left == right) return -1;
        boolean foundLeft = false, foundRight = false;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == left) {
                foundLeft = true;
            } else if (nums[i] == right) {
                foundRight = true;
            }
        }

        if (foundLeft && foundRight) {
            return -1;
        } else if (foundLeft) {
            return right;
        } else if (foundRight) {
            return left;
        } else {
            return Math.max(left, right);
        }
    }

    private int getLargestUnique(int[] numbers) {
        int[] counts = new int[MAX_NUMBER + 1];

        for (int number : numbers) {
            counts[number]++;
        }

        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] == 1) return i;
        }

        return -1;
    }

    private int getLargest(int[] numbers) {
        int max = numbers[0];

        for (int number : numbers) max = Math.max(max, number);

        return max;
    }
}
