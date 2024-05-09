package MonthlyChallenges.Year24.May;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {

    /**
     * LeetCode №3075. Maximize Happiness of Selected Children.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N*) - depends on the sorting algorithm.
     *
     * @param happiness - an array of positive integers.
     * @param k         - the number of children to select.
     * @return - the maximum sum of the happiness values of the selected children you can achieve by selecting 'k'
     * children.
     */
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long result = 0L;

        for (int idx = happiness.length - 1, decrement = 0; k > 0; idx--, k--, decrement++) {
            result += Math.max(happiness[idx] - decrement, 0);
        }

        return result;
    }
}
