package MonthlyChallenges.Year22.January;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {

    /**
     * LeetCode #84. Largest Rectangle in Histogram.
     *
     * @param heights - an array of non-negative integers.
     * @return - the area of the largest rectangle.
     */
    public int largestRectangleArea(int[] heights) {
        int largestArea = heights[0];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= heights.length; i++) {
            int curHeight;
            if (i == heights.length) {
                curHeight = 0;
            } else {
                curHeight = heights[i];
            }

            if (stack.isEmpty() || curHeight >= heights[stack.peek()]) {
                stack.push(i);
            }
            else {
                int prevIdx = stack.pop();
                int curLength;
                if (stack.isEmpty()) {
                    curLength = i;
                } else {
                    curLength = i - 1 - stack.peek();
                }

                largestArea = Math.max(largestArea, curLength * heights[prevIdx]);
                i -= 1;
            }
        }

        return largestArea;
    }
}
