package Problems;

public class NimGame {
    /**
     * LeetCode #292. Nim Game.
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - the number of stones.
     * @return - the result of playing a game of Nim. True - first player wins, false - second player wins.
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
