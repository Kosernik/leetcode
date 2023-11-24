package MonthlyChallenges.Year23.November;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {

    /**
     * LeetCode №1561. Maximum Number of Coins You Can Get.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param piles - an array of integers representing sizes of the piles.
     * @return - the maximum number of coins that you can have.
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int maxResult = 0;

        for (int i = 0, idx = piles.length - 2; i < piles.length / 3; i++, idx -= 2) {
            maxResult += piles[idx];
        }

        return maxResult;
    }
}
