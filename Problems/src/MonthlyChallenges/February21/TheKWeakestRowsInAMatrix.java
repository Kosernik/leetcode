package MonthlyChallenges.February21;

import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
    /**
     * LeetCode #1337.
     *
     *
     * @param mat - m*n matrix of '1' and '0'.
     * @param k - a positive integer, not greater than mat.length.
     * @return - array of size K of indexes of the weakest rows in a matrix.
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        // {number of soldiers, row index}
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a,b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0])
        );

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;

            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) break;
                else soldiers++;
            }

            heap.add(new int[] {soldiers, i});
            while (heap.size() > k) heap.poll();
        }

        int[] result = new int[k];
        int idx = k-1;

        while (!heap.isEmpty()) {
            result[idx] = heap.poll()[1];
            idx--;
        }

        return result;
    }
}
