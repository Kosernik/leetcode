package MonthlyChallenges.Year25.August;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MaximumFruitsHarvestedAfterAtMostKSteps {
    public static void main(String[] args) {
        MaximumFruitsHarvestedAfterAtMostKSteps solution = new MaximumFruitsHarvestedAfterAtMostKSteps();

        int[][] fruits0 = {
                {2, 8}, {6, 3}, {8, 6}
        };
        int startPos0 = 5, k0 = 4;
        System.out.println(solution.maxTotalFruits(fruits0, startPos0, k0) == 9);

        System.out.println();
        int[][] fruits1 = {
                {0, 10000}
        };
        int startPos1 = 0, k1 = 200000;
        System.out.println(solution.maxTotalFruits(fruits1, startPos1, k1) == 10000);

        System.out.println();
        int[][] fruits2 = {
                {0, 7}, {7, 4}, {9, 10}, {12, 6}, {14, 8}, {16, 5}, {17, 8}, {19, 4}, {20, 1}, {21, 3}, {24, 3},
                {25, 3}, {26, 1}, {28, 10}, {30, 9}, {31, 6}, {32, 1}, {37, 5}, {40, 9}
        };
        int startPos2 = 21, k2 = 30;
        System.out.println(solution.maxTotalFruits(fruits2, startPos2, k2) == 71);
    }

    /**
     * LeetCode №2106. Maximum Fruits Harvested After at Most K Steps.
     *
     * @param fruits   - an array of pairs where fruits[i] = {coordinate, amount}. fruits is sorted by fruits[i][0] in
     *                 ascending order
     * @param startPos - the coordinate of a starting position.
     * @param k        - the maximum number of available steps.
     * @return - the maximum total number of fruits you can harvest.
     */
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int length = fruits.length;
        int leftMost = Math.max(0, startPos - k);
        int rightMost = Math.min(fruits[length - 1][0], startPos + k);

        NavigableMap<Integer, Integer> prefixSum = new TreeMap<>();
        int sum = 0;
        prefixSum.put(leftMost - 1, sum);

        for (int[] pair : fruits) {
            int coordinate = pair[0];

            if (coordinate < leftMost) continue;
            else if (coordinate > rightMost) break;

            sum += pair[1];
            prefixSum.put(coordinate, sum);
        }

        Map.Entry<Integer, Integer> goLeft = prefixSum.floorEntry(startPos);
        int maxResult = goLeft.getValue();

        Integer rightCoordinate = prefixSum.ceilingKey(rightMost);
        if (rightCoordinate != null) {
            maxResult = Math.max(maxResult, prefixSum.get(rightCoordinate) - prefixSum.lowerEntry(startPos).getValue());
        }

        for (Map.Entry<Integer, Integer> entry : prefixSum.entrySet()) {
            int curCoordinate = entry.getKey();
            if (curCoordinate < leftMost) continue;

            int pathLength = Math.abs(curCoordinate - startPos);
            int stepsRemaining = k - (pathLength + pathLength);

            int leftEnd, rightEnd;

            if (curCoordinate < startPos) { // Moved left
                leftEnd = curCoordinate;
                rightEnd = startPos;

                if (stepsRemaining > 0) {
                    rightEnd += stepsRemaining;
                }
            } else { // Moved right
                rightEnd = curCoordinate;
                leftEnd = startPos;

                if (stepsRemaining > 0) {
                    leftEnd -= stepsRemaining;
                    if (leftEnd < leftMost) leftEnd = leftMost;
                }
            }

            int rightSum = prefixSum.floorEntry(rightEnd).getValue();
            int leftSum = prefixSum.lowerEntry(leftEnd).getValue();
            int curResult = rightSum - leftSum;

            maxResult = Math.max(maxResult, curResult);
        }

        return maxResult;
    }
}
