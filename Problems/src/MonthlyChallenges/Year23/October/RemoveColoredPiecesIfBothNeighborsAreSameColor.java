package MonthlyChallenges.Year23.October;

public class RemoveColoredPiecesIfBothNeighborsAreSameColor {

    /**
     * LeetCode #2038. Remove Colored Pieces if Both Neighbors are the Same Color.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param colors - a string of 'A' and 'B'.
     * @return - True - if the first player wins, false - if the second player wins.
     */
    public boolean winnerOfGame(String colors) {
        int aliceTurns = 0;
        int bobTurns = 0;

        char[] cols = colors.toCharArray();
        char prev = cols[0];

        for (int i = 1; i < (cols.length - 1); i++) {
            char curChar = cols[i];
            if (prev == curChar && curChar == cols[i + 1]) {
                if (curChar == 'A') {
                    aliceTurns++;
                } else {
                    bobTurns++;
                }
            }
            prev = curChar;
        }

        return aliceTurns > bobTurns;
    }
}
