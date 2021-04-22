package MonthlyChallenges.April21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrickWall {
    public static void main(String[] args) {
        BrickWall solution = new BrickWall();
        List<List<Integer>> test0 = new ArrayList<>();
        // [1,2,2,1],
        // [3,1,2],
        // [1,3,2],
        // [2,4],
        // [3,1,2],
        // [1,3,1,1]
        List<Integer> row0 = new ArrayList<>();
        row0.add(1);row0.add(2);row0.add(2);row0.add(1);
        List<Integer> row1 = new ArrayList<>();
        row1.add(3);row1.add(1);row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);row2.add(3);row2.add(2);
        List<Integer> row3 = new ArrayList<>();
        row3.add(2);row3.add(4);
        List<Integer> row4 = new ArrayList<>();
        row4.add(3);row4.add(1);row4.add(2);
        List<Integer> row5 = new ArrayList<>();
        row5.add(1);row5.add(3);row5.add(1);row5.add(1);

        test0.add(row0);test0.add(row1);test0.add(row2);test0.add(row3);test0.add(row4);test0.add(row5);

        System.out.println(solution.leastBricks(test0));

        List<List<Integer>> test1 = new ArrayList<>();
        //[1,1],
        // [2],
        // [1,1]
        List<Integer> row01 = new ArrayList<>();
        row01.add(1);row01.add(1);
        List<Integer> row11 = new ArrayList<>();
        row11.add(2);
        List<Integer> row21 = new ArrayList<>();
        row21.add(1);row21.add(1);
        test1.add(row01);test1.add(row11);test1.add(row21);

        System.out.println(solution.leastBricks(test1));

    }

    /**
     * LeetCode #554.
     *
     * Complexity - O(N)
     * Memory - O(M)
     * N - total number of bricks, M - height of the wall.
     *
     * @param wall - a list of lists of integers representing bricks in a wall.
     * @return - the minimum number of bricks crossed by a vertical line.
     */
    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();
        int width = 0;
        for (int brick : wall.get(0)) width += brick;

        int[] rowsLengths = new int[height];
        int[] indexesOfBricks = new int[height];

        for (int row = 0; row < height; row++) {
            rowsLengths[row] = wall.get(row).get(0);
        }

        int result = height;
        int currIndex = 1;

        while (currIndex < width) {
            int currResult = height;
            int nextIdx = width;

            for (int row = 0; row < height; row++) {
                if (rowsLengths[row] == currIndex) {
                    currResult--;
                    rowsLengths[row] += wall.get(row).get(++indexesOfBricks[row]);
                }
                nextIdx = Math.min(nextIdx, rowsLengths[row]);
            }

            currIndex = nextIdx;
            result = Math.min(result, currResult);
        }

        return result;
    }
}
