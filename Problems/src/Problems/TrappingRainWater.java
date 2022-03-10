package Problems;

import java.util.ArrayDeque;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        int[][] tests = {
                {0,1,0,2,1,0,1,3,2,1,2,1},
                {4,2,0,3,2,5}
        };
        int[] results = {
                6,
                9
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println("Test #" + i + " - " + (solution.trap(tests[i]) == results[i]));
            System.out.println();
        }
    }

    /**
     * LeetCode #42. Trapping Rain Water.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param height - an array of non-negative integers.
     * @return - the amount of trapped water.
     */
    public int trap(int[] height) {
        int amountOfWater = 0;

        ArrayDeque<Integer> monoStack = new ArrayDeque<>();
        monoStack.push(0);

        for (int i = 1; i < height.length; i++) {
            if (height[i] == 0) continue;

            int prevHeight = 0;

            while (!monoStack.isEmpty() && height[monoStack.peek()] <= height[i]){
                int prevIdx = monoStack.pop();

                int curHeight = height[prevIdx] - prevHeight;
                prevHeight = height[prevIdx];
                int width = i - prevIdx - 1;

                amountOfWater += curHeight * width;
            }
            if (!monoStack.isEmpty()) {
                int curHeight = height[i] - prevHeight;
                int width = i - monoStack.peek() - 1;
                amountOfWater += curHeight * width;
            }

            monoStack.push(i);
        }

        return amountOfWater;
    }
}
