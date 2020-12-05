package MonthlyChallenges.December;

public class CanPlaceFlowers {

    /**
     * LeetCode #605.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param flowerbed - array of digits 0 and 1.
     * @param n - number of flowers to plant.
     * @return - true - if it is possible to plant all flowers, false - otherwise.
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;

        int flowersLeft = n;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i-1 < 0 || flowerbed[i-1] == 0) && (i+1 >= flowerbed.length || flowerbed[i+1] == 0)) {
                    flowerbed[i] = 1;
                    flowersLeft--;
                    if (flowersLeft == 0) return true;
                }
            }
        }

        return false;
    }
}
