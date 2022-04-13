package MonthlyChallenges.February21;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        TheKWeakestRowsInAMatrix solution = new TheKWeakestRowsInAMatrix();

        int[][] test0 = {
                {0,0,0,0},
                {1,0,0,0},
                {1,1,0,0},
                {1,1,1,0},
                {1,1,1,1}
        };
        System.out.println(Arrays.toString(solution.kWeakestRows(test0, 1)));
        System.out.println(Arrays.toString(solution.kWeakestRows(test0, 2)));
        System.out.println(Arrays.toString(solution.kWeakestRows(test0, 3)));
        System.out.println("--------------");

        int[][] test1 = {
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,0,0},
                {1,1,1,1,0},
                {1,1,1,1,1}
        };
        System.out.println(Arrays.toString(solution.kWeakestRows(test1, 1)));
        System.out.println(Arrays.toString(solution.kWeakestRows(test1, 2)));
        System.out.println(Arrays.toString(solution.kWeakestRows(test1, 3)));
        System.out.println("--------------");

        int[][] test2 = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        System.out.println(Arrays.toString(solution.kWeakestRows(test2, 3)));
        System.out.println("--------------");

        int[][] test3 = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}
        };
        System.out.println(Arrays.toString(solution.kWeakestRows(test3, 2)));
        System.out.println("--------------");
    }


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
            int soldiers = getSoldiersBinSearch(mat, i);

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

    private int getSoldiers(int[][] mat, int i) {
        int soldiers = 0;

        for (int j = 0; j < mat[0].length; j++) {
            if (mat[i][j] == 0) break;
            else soldiers++;
        }
        return soldiers;
    }

    private int getSoldiersBinSearch(int[][] mat, int i) {
        int left = 0, right = mat[i].length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (mat[i][middle] == 0) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }
}
