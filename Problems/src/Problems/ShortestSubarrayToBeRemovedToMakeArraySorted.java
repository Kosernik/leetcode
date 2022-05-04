package Problems;

import java.util.ArrayDeque;


public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        ShortestSubarrayToBeRemovedToMakeArraySorted solution = new ShortestSubarrayToBeRemovedToMakeArraySorted();

        int[] test0 = {1,2,3,10,4,2,3,5};
        System.out.println(solution.findLengthOfShortestSubarray(test0));
    }

    /**
     * LeetCode #1574. Shortest Subarray to be Removed to Make Array Sorted.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param arr - an array of non-negative integers.
     * @return - the length of the shortest subarray to remove such that the remaining elements in arr are non-decreasing.
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int length = arr.length;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(0);
        for (int i = 1; i < length; i++) {
            if (arr[stack.peekLast()] > arr[i]) break;
            stack.offerLast(i);
        }

        if (stack.size() == length) return 0;

        int result = length - stack.size();
        int prevMin = arr[length-1];

        for (int i = length-1; i >= 0; i--) {
            if (arr[i] > prevMin) break;
            prevMin = arr[i];

            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                stack.removeLast();
            }

            if (stack.isEmpty()) {
                result = Math.min(result, i);
            } else {
                result = Math.min(result, i - stack.peekLast() - 1);
            }
        }

        return result;
    }
}
