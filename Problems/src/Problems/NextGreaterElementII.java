package Problems;

import java.util.ArrayDeque;

public class NextGreaterElementII {

    /**
     * LeetCode #503. Next Greater Element II.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - an array of the next greater elements in a circular array.
     *           If there is no greater element for nums[i], then result[i] = -1.
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;;
        int[] result = new int[length];

        ArrayDeque<Integer> allStack = new ArrayDeque<>();
        allStack.push(nums[length-1]);
        for (int i = length-2; i >= 0; i--) {
            while (!allStack.isEmpty() && allStack.peek() <= nums[i]) allStack.pop();

            allStack.push(nums[i]);
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = length-1; i >= 0; i--) {
            int curNum = nums[i];

            while (!stack.isEmpty() && stack.peek() <= curNum) stack.pop();

            if (stack.isEmpty()) {
                int best = -1;
                for (int element : allStack) {
                    if (element > curNum) {
                        best = element;
                        break;
                    }
                }
                result[i] = best;
            } else {
                result[i] = stack.peek();
            }

            stack.push(curNum);
        }

        return result;
    }
}
