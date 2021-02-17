package MonthlyChallenges.February21;

public class ContainerWithMostWater {
    /**
     * LeetCode #11.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param height - array of positive integers representing the height of the columns.
     * @return - maximum area of a rectangle in an array.
     */
    public int maxArea(int[] height) {
        int max = 0;

        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int currArea = (right-left) * Math.min(height[left], height[right]);
            max = Math.max(max, currArea);

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                if (height[left+1] <= height[right-1]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return max;
    }
}
