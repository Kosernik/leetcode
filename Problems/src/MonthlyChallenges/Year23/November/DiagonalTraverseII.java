package MonthlyChallenges.Year23.November;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverseII {

    /**
     * LeetCode №1424. Diagonal Traverse II.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the diagonal traverse of the input array.
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> values = new ArrayList<>();
        for (int row = 0; row < nums.size(); row++) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                values.add(new int[]{nums.get(row).get(col), row, row + col});
            }
        }

        values.sort((a, b) -> a[2] != b[2] ? Integer.compare(a[2], b[2]) : Integer.compare(b[1], a[1]));

        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i)[0];
        }
        return result;
    }

    /**
     * LeetCode №1424. Diagonal Traverse II.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the diagonal traverse of the input array.
     */
    public int[] findDiagonalOrderTLE(List<List<Integer>> nums) {
        List<Integer> result = new ArrayList<>();
        int row = 0, height = nums.size();
        int col = 0;

        while (true) {
            int curRow = row;
            int curCol = col;
            boolean breakTheLoop = true;

            while (curRow >= 0) {
                if (curCol < nums.get(curRow).size()) {
                    result.add(nums.get(curRow).get(curCol));
                    breakTheLoop = false;
                }
                curRow--;
                curCol++;
            }

            if (breakTheLoop) break;
            if (row + 1 >= height) {
                col++;
            } else {
                row++;
                col = 0;
            }
        }

        int[] diagonalTraverse = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            diagonalTraverse[i] = result.get(i);
        }
        return diagonalTraverse;
    }
}
