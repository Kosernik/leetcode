package MonthlyChallenges.Year26.November;

public class StoneRemovalGame {

    /**
     * LeetCode №3360. Stone Removal Game.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - the number of stones in a pile.
     * @return - true if Alice wins the game and false otherwise.
     */
    public boolean canAliceWin(int n) {
        if (n < 10) {
            return false;
        } else if (n < 19) {
            return true;
        } else if (n < 27) {
            return false;
        } else if (n < 34) {
            return true;
        } else if (n < 40) {
            return false;
        } else if (n < 45) {
            return true;
        } else if (n < 49) {
            return false;
        } else if (n < 52) {
            return true;
        } else if (n < 54) {
            return false;
        } else {
            return n < 55;
        }
    }
}
