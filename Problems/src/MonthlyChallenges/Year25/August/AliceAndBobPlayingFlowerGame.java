package MonthlyChallenges.Year25.August;

public class AliceAndBobPlayingFlowerGame {

    /**
     * LeetCode №3021. Alice and Bob Playing Flower Game.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @param m - a positive integer.
     * @return - the number of possible pairs (x, y) that allows Alice to win.
     */
    public long flowerGame(int n, int m) {
        long oddsN = n / 2L;
        long evensN = n - oddsN;

        long oddsM = m / 2L;
        long evensM = m - oddsM;

        return oddsN * evensM + oddsM * evensN;
    }
}
