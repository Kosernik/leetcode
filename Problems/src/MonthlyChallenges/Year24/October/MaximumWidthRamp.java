package MonthlyChallenges.Year24.October;

import java.util.ArrayDeque;

public class MaximumWidthRamp {
    public static void main(String[] args) {
        MaximumWidthRamp solution = new MaximumWidthRamp();

        int[] test0 = {6, 0, 8, 2, 1, 5};
        System.out.println(solution.maxWidthRamp(test0) == 4);
    }

    /**
     * LeetCode №962. Maximum Width Ramp.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j].
     * The width of such a ramp is j - i.
     *
     * @param nums - an array of integers.
     * @return - the maximum width of a ramp in nums. If there is no ramp in nums, returns 0.
     */
    public int maxWidthRamp(int[] nums) {
        int length = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(length - 1);

        for (int i = length - 2; i > 0; i--) {
            if (nums[i] > nums[stack.peek()]) stack.push(i);
        }

        int maxWidth = 0;

        for (int i = 0; i < length - 1; i++) {
            if (maxWidth > (length - i) || stack.isEmpty()) return maxWidth;
            if (nums[i] > nums[stack.peek()]) continue;

            int curNum = nums[i];
            int curWidth = stack.peek() - i;

            while (!stack.isEmpty() && curNum <= nums[stack.peek()]) {
                curWidth = stack.peek() - i;
                stack.pop();
            }

            maxWidth = Math.max(maxWidth, curWidth);
        }

        return maxWidth;
    }
}
