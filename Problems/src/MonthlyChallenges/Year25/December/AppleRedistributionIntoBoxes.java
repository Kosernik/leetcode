package MonthlyChallenges.Year25.December;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {

    /**
     * LeetCode №3074. Apple Redistribution into Boxes.
     * <p>
     * Complexity - O(N + M*logM), N = apple.length, M = capacity.length
     * Memory - O(1)
     *
     * @param apple    - an array of positive integers.
     * @param capacity - an array of positive integers.
     * @return - the minimum number of boxes you need to select to redistribute all apples.
     */
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);

        int totalApples = getSum(apple);
        for (int i = capacity.length - 1; i >= 0; i--) {
            totalApples -= capacity[i];

            if (totalApples <= 0) {
                return capacity.length - i;
            }
        }

        return capacity.length;
    }

    private int getSum(int[] apple) {
        int sum = 0;
        for (int a : apple) sum += a;
        return sum;
    }
}
