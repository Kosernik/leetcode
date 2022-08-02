package MonthlyChallenges.Year22.August;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    /**
     * LeetCode #378. K-th Smallest Element in a Sorted Matrix.
     * <p>
     * Complexity - O(N)
     * Memory - O(k)
     *
     * @param matrix - a square array. Each of the rows and columns is sorted in ascending order.
     * @param k      - the number of the required element. 1 <= k < matrix.length * matrix[i].length.
     * @return - the k-th smallest element in matrix.
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int side = Math.min(matrix.length, k);

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                int curValue = matrix[i][j];
                if (maxHeap.size() < k) {
                    maxHeap.offer(curValue);
                } else {
                    if (maxHeap.peek() < curValue) {
                        break;
                    } else {
                        maxHeap.offer(curValue);
                        maxHeap.poll();
                    }
                }
            }
        }

        return maxHeap.peek();
    }
}
