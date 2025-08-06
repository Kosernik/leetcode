package MonthlyChallenges.Year25.August;

import java.util.Arrays;

public class FruitsIntoBasketsIII {
    public static void main(String[] args) {
        FruitsIntoBasketsIII solution = new FruitsIntoBasketsIII();

        int[] fruits1 = {3, 6, 1};
        int[] baskets1 = {6, 4, 7};
        int result1 = 0;
        System.out.println(solution.numOfUnplacedFruits(fruits1, baskets1) == result1);
    }

    /**
     * LeetCode №3479. Fruits Into Baskets III.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param fruits  - an array of positive integers.
     * @param baskets - an array of positive integers. fruits.length = baskets.length.
     * @return - the number of fruit types that remain unplaced after all possible allocations are made.
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int length = fruits.length;
        int segLength = (int) Math.pow(2, Math.ceil(Math.log(length) / Math.log(2))) - 1;
        int[] segTree = new int[segLength + length];
        Arrays.fill(segTree, -1);

        for (int i = segLength, j = 0; j < length; i++, j++) {
            segTree[i] = baskets[j];
        }

        fillTree(0, segTree);

        int result = 0;

        for (int fruit : fruits) {
            if (!deleteIfPresent(fruit, 0, segLength, segTree)) {
                result++;
            }
        }

        return result;
    }

    private boolean deleteIfPresent(int target, int idx, int length, int[] segTree) {
        if (idx >= segTree.length || segTree[idx] < target) {
            return false;
        } else if (idx >= length) {
            if (segTree[idx] >= target) {
                segTree[idx] = -1;
                return true;
            } else {
                return false;
            }
        }

        int leftIdx = getLeftChildIdx(idx);
        int rightIdx = getRightChildIdx(idx);

        if (segTree[leftIdx] >= target) {
            boolean foundInLeftPart = deleteIfPresent(target, leftIdx, length, segTree);

            int rightVal = rightIdx >= segTree.length ? -1 : segTree[rightIdx];
            segTree[idx] = Math.max(segTree[leftIdx], rightVal);
            return true;
        } else {
            boolean foundInRightPart = deleteIfPresent(target, rightIdx, length, segTree);

            if (foundInRightPart) {
                segTree[idx] = Math.max(segTree[leftIdx], segTree[rightIdx]);
                return true;
            }
        }

        return false;
    }

    private int fillTree(int idx, int[] segTree) {
        if (idx >= segTree.length) return Integer.MIN_VALUE;
        else if (segTree[idx] != -1) return segTree[idx];

        int leftMax = fillTree(getLeftChildIdx(idx), segTree);
        int rightMax = fillTree(getRightChildIdx(idx), segTree);

        segTree[idx] = Math.max(leftMax, rightMax);
        return segTree[idx];
    }

    private int getLeftChildIdx(int nodeIdx) {
        return 2 * nodeIdx + 1;
    }

    private int getRightChildIdx(int nodeIdx) {
        return 2 * nodeIdx + 2;
    }
}
