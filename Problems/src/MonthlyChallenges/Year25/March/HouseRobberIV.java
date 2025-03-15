package MonthlyChallenges.Year25.March;

public class HouseRobberIV {

    /**
     * LeetCode №2560. House Robber IV.
     * <p>
     * Complexity - O(NlogM), N = nums.length, M = max(nums).
     * Memory - O(1)
     * <p>
     * The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
     *
     * @param nums - an array of positive integers.
     * @param k    - the minimum number of houses to rob.
     * @return - the minimum capability of the robber out of all the possible ways to steal at least k houses.
     */
    public int minCapability(int[] nums, int k) {
        int left = 0, right = Integer.MAX_VALUE, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (canRob(middle, nums, k)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private boolean canRob(int candidate, int[] houses, int minHouses) {
        int housesRobbed = 0;

        for (int i = 0; i < houses.length; i++) {
            if (houses[i] <= candidate) {
                housesRobbed++;
                i++;
            }

            if (housesRobbed == minHouses) return true;
        }

        return false;
    }
}
