package MonthlyChallenges.Year24.June;

public class PatchingArray {

    /**
     * LeetCode №330. Patching Array.
     *
     * @param nums - an array of positive integers sorted in ascending order.
     * @param n    - the required sum range.
     * @return - the minimum number of patches required.
     */
    public int minPatches(int[] nums, int n) {
        int added = 0;

        long maxAvailable = 0;
        int usedIdx = 0;

        while (maxAvailable < n) {
            long needed = maxAvailable + 1;
            if (usedIdx < nums.length && nums[usedIdx] <= needed) {
                maxAvailable += nums[usedIdx];
                usedIdx++;
            } else {
                maxAvailable += needed;
                added++;
            }
        }

        return added;
    }
}
