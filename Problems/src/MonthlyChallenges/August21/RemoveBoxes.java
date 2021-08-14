package MonthlyChallenges.August21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveBoxes {
    public static void main(String[] args) {
        RemoveBoxes solution = new RemoveBoxes();

//        int[] testArr = {0,1,2,3,4,5,6};
//        int[] testArr1 = {0,1,2,3,4,5,6,7,8,9};
//
//        int[] test0 = solution.getArray(testArr, 2, 5);
//        System.out.println(Arrays.toString(test0));
//        int[] test1 = solution.getArray(testArr, 0, 5);
//        System.out.println(Arrays.toString(test1));
//        int[] test2 = solution.getArray(testArr, 2, 6);
//        System.out.println(Arrays.toString(test2));

        int[][] tests = {
                {1,3,2,2,2,3,4,3,1},
                {1,2,3,4,5,6,9,2,4,5,5,3,6,9,7,5,2,1,6,8}
        };

        System.out.println(solution.removeBoxes(tests[1]));
    }

    // LeetCode #546.
    public int removeBoxes(int[] boxes) {
        int length = boxes.length;
        int[][][] computed = new int[length][length][length];
        return dpRemoveBoxes(boxes, 0, length-1, 0, computed);
    }

    private int dpRemoveBoxes(int[] boxes, int left, int right, int stash, int[][][] computed) {
        if (left > right) return 0;
        if (computed[left][right][stash] > 0) return computed[left][right][stash];

        int originalLeft = left, originalStash = stash;
        while (left+1 <= right && boxes[left+1] == boxes[left]) {
            left++;
            stash++;
        }

        int result = (stash+1) * (stash+1) +  dpRemoveBoxes(boxes, left+1, right, 0, computed);

        for (int movedLeft = left+1; movedLeft <= right; movedLeft++) {
            if (boxes[left] == boxes[movedLeft]) {
                result = Math.max(
                        result,
                        dpRemoveBoxes(boxes, left+1, movedLeft-1, 0, computed)
                                + dpRemoveBoxes(boxes, movedLeft, right, stash+1, computed));
            }
        }

        computed[originalLeft][right][originalStash] = result;
        return result;
    }


    private Map<String, Integer> computed;
    public int removeBoxesTLE(int[] boxes) {
        this.computed = new HashMap<>();
        return helper(boxes);
    }

    private int helper(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }
        else if (boxes.length == 1) {
            this.computed.put(Arrays.toString(boxes), 1);
            return 1;
        }
        else if (this.computed.containsKey(Arrays.toString(boxes))) return this.computed.get(Arrays.toString(boxes));

        int idx = 0;
        int result = 0;
        int length = boxes.length;

        while (idx < length) {
            int curNumber = boxes[idx];
            int endIdx = idx;

            while (endIdx < length && boxes[endIdx] == curNumber) {
                endIdx++;
            }
            endIdx--;

            int curResult = (endIdx - idx + 1) * (endIdx - idx + 1) + helper(getArray(boxes, idx, endIdx));
            result = Math.max(result, curResult);

            idx = endIdx+1;
        }

        this.computed.put(Arrays.toString(boxes), result);
        return result;
    }

    private int[] getArray(int[] boxes, int startIdx, int endIdx) {
        int[] result = new int[boxes.length - (endIdx - startIdx + 1)];

        if (startIdx > 0) System.arraycopy(boxes, 0, result, 0, startIdx);
        if ((endIdx+1) < boxes.length) System.arraycopy(boxes, endIdx+1, result, startIdx, boxes.length - endIdx - 1);

        return result;
    }
}
