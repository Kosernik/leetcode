package MonthlyChallenges.Year21.April21;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle solution = new Triangle();
        List<List<Integer>> test0 = new ArrayList<>();
        //[ [2], [3,4],  [6,5,7],    [4,1,8,3]]
        List<Integer> level0 = new ArrayList<>();
        level0.add(2);
        List<Integer> level1 = new ArrayList<>();
        level1.add(3);
        level1.add(4);
        List<Integer> level2 = new ArrayList<>();
        level2.add(6);
        level2.add(5);
        level2.add(7);
        List<Integer> level3 = new ArrayList<>();
        level3.add(4);
        level3.add(1);
        level3.add(8);
        level3.add(3);
        test0.add(level0);
        test0.add(level1);
        test0.add(level2);
        test0.add(level3);

        System.out.println(solution.minimumTotal(test0));
    }

    /**
     * LeetCode #120.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param triangle - a list of lists of integers.
     * @return - the minimum path sum from top to bottom.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> row = new ArrayList<>();
        row.add(0);

        for (List<Integer> currentRow : triangle) {
            List<Integer> nextRow = new ArrayList<>();

            for (int i = 0; i < currentRow.size(); i++) {
                int left = i == 0 ? Integer.MAX_VALUE : row.get(i - 1);
                int right = i == row.size() ? Integer.MAX_VALUE : row.get(i);
                nextRow.add(currentRow.get(i) + Math.min(left, right));
            }
            row = nextRow;
        }

        int result = Integer.MAX_VALUE;
        for (int val : row) result = Math.min(result, val);

        return result;
    }
}
