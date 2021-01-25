package MonthlyChallenges.January21;

public class CheckIfAllOnesAreAtLeastLengthKPlacesAway {
    /**
     * LeetCode #1437.
     *
     * Checks if all 1`s in a given array are at least "K" places away from each other.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - array of 0`s and 1`s.
     * @param k - required distance between 1`s.
     * @return - True if all 1's are at least k places away from each other, otherwise - False.
     */
    public boolean kLengthApart(int[] nums, int k) {
        if (nums.length == 1 || k == 0) return true;

        int currDist = k;

        for (int number : nums) {
            if (number == 1) {
                if (currDist < k) {
                    return false;
                } else {
                    currDist = -1;
                }
            }
            currDist++;
        }

        return true;
    }
}
