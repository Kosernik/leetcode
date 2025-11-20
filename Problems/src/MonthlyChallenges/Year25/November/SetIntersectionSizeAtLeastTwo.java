package MonthlyChallenges.Year25.November;

import java.util.Arrays;

public class SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        SetIntersectionSizeAtLeastTwo solution = new SetIntersectionSizeAtLeastTwo();

        System.out.println();
        int[][] test0 = {
                {1, 3}, {3, 7}, {8, 9}
        };
        int result0 = 5;
        System.out.println(solution.intersectionSizeTwo(test0) == result0);

        System.out.println();
        int[][] test1 = {
                {1, 3}, {1, 4}, {2, 5}, {3, 5}
        };
        int result1 = 3;
        System.out.println(solution.intersectionSizeTwo(test1) == result1);

        System.out.println();
        int[][] test2 = {
                {1, 2}, {2, 3}, {2, 4}, {4, 5}
        };
        int result2 = 5;
        System.out.println(solution.intersectionSizeTwo(test2) == result2);

        System.out.println();
        int[][] test3 = {
                {2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}
        };
        int result3 = 5;
        System.out.println(solution.intersectionSizeTwo(test3) == result3);

        System.out.println();
        int[][] test4 = {
                {1, 3}, {3, 7}, {5, 7}, {7, 8}
        };
        int result4 = 5;
        System.out.println(solution.intersectionSizeTwo(test4) == result4);

        System.out.println();
        int[][] test5 = {
                {1, 2}, {0, 3}, {2, 3}
        };
        int result5 = 3;
        System.out.println(solution.intersectionSizeTwo(test5) == result5);

        System.out.println();
        int[][] test6 = {
                {8, 15}, {12, 14}, {12, 14}
        };
        int result6 = 2;
        System.out.println(solution.intersectionSizeTwo(test6) == result6);
    }

    /**
     * LeetCode №757. Set Intersection Size At Least Two.
     * <p>
     * Complexity - O(NLogN)
     * Memory - O(1)
     *
     * @param intervals - a 2d array. intervals[i].length = 2. intervals[i][j] >= 0.
     * @return - the minimum possible size of a containing set.
     */
    public int intersectionSizeTwo(int[][] intervals) {
        int result = 0;

        Arrays.sort(intervals,
                (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0])
        );

        int prePrevNumber = -2, prevNumber = -1;

        for (int[] interval : intervals) {
            int curStart = interval[0], curEnd = interval[1];

            if (curStart <= prePrevNumber) {
                continue;
            } else if (curStart <= prevNumber) {
                result += 1;
                prePrevNumber = prevNumber;
                prevNumber = curEnd;
            } else {
                result += 2;
                prePrevNumber = curEnd - 1;
                prevNumber = curEnd;
            }
        }

        return result;
    }
}
