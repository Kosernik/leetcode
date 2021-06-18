package MonthlyChallenges.June21;

import java.util.Arrays;

public class RangeSumQueryMutable {
    public static void main(String[] args) {
        int[] test0 = {1,3,5};
        RangeSumQueryMutable solution = new RangeSumQueryMutable(test0);
        System.out.println(solution.sumRange(0,2));
        solution.update(1,2);
        System.out.println(solution.sumRange(0,2));
    }

    private final int[] nums;
    private final int[] blockSums;
    private final int numberOfBlocks;

    /**
     * Leetcode #307.
     *
     * @param nums - an array of integers.
     */
    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.numberOfBlocks = (int) Math.ceil(Math.sqrt(nums.length));
        this.blockSums = fillSumsArray(this.numberOfBlocks);
    }

    public void update(int index, int val) {
        updateSumsArray(index, val);
        this.nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int leftBlock = left / this.numberOfBlocks;
        int rightBlock = right / this.numberOfBlocks;

        int sum = 0;
        if (leftBlock == rightBlock) {
            for (int i = left; i <= right; i++) {
                sum += this.nums[i];
            }
        } else {
            for (int i = left; i <= (leftBlock+1) * this.numberOfBlocks-1; i++) {
                sum += this.nums[i];
            }

            for (int i = leftBlock+1; i < rightBlock; i++) {
                sum += this.blockSums[i];
            }

            for (int i = rightBlock * this.numberOfBlocks; i <= right; i++) {
                sum += this.nums[i];
            }
        }
        return sum;
    }

    private void updateSumsArray(int index, int newVal) {
        int diff = newVal - this.nums[index];
        this.blockSums[index / this.numberOfBlocks]  += diff;
    }

    private int[] fillSumsArray(int size) {
        int[] sums = new int[size];
        for (int i = 0; i < this.nums.length; i++) {
            sums[i/size] += this.nums[i];
        }
        return sums;
    }
}
