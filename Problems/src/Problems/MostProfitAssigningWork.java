package Problems;

import java.util.Arrays;

public class MostProfitAssigningWork {

    /**
     * LeetCode #826. Most Profit Assigning Work.
     *
     * Complexity - O(N*logN + M*logN), N = difficulty.length = profit.length, M = worker.length
     * Memory - O(N)
     *
     * @param difficulty - an array of positive integers.
     * @param profit - an array of positive integers. difficulty.length = profit.length
     * @param worker - an array of positive integers.
     * @return - the maximum profit after assigning all the workers.
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] combined = new int[difficulty.length][2];

        for (int i = 0; i < combined.length; i++) {
            combined[i][0] = difficulty[i];
            combined[i][1] = profit[i];
        }

        Arrays.sort(combined, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int prevMaxProfit = 0;
        for (int i = 0; i < combined.length; i++) {
            prevMaxProfit = Math.max(prevMaxProfit, combined[i][1]);
            combined[i][1] = prevMaxProfit;
        }

        int totalProfit = 0;

        for (int workerAbility : worker) {
            if (workerAbility >= combined[0][0]) {
                int idx = binSearch(combined, workerAbility);
                totalProfit += combined[idx][1];
            }
        }

        return totalProfit;
    }

    private int binSearch(int[][] arr, int target) {
        int left = 0, right = arr.length-1, middle;

        while (left < right) {
            middle = right - (right-left) / 2;

            if (arr[middle][0] > target) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        return left;
    }
}
