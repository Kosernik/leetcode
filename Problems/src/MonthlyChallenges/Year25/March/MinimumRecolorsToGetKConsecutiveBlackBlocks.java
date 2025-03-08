package MonthlyChallenges.Year25.March;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    /**
     * LeetCode №2379. Minimum Recolors to Get K Consecutive Black Blocks.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param blocks - a string of chars 'W' and 'B'. W means it is a white block, B means it is a black block.
     * @param k      - the required length of consecutive black blocks.
     * @return - the minimum number of recolors.
     */
    public int minimumRecolors(String blocks, int k) {
        char[] blocksChars = blocks.toCharArray();
        char whiteBlock = 'W';
        int whiteBlocksCount = 0;

        for (int i = 0; i < k; i++) {
            if (blocksChars[i] == whiteBlock) whiteBlocksCount++;
        }

        int minRecolors = whiteBlocksCount;

        for (int i = k; i < blocksChars.length; i++) {
            if (blocksChars[i] == whiteBlock) {
                whiteBlocksCount++;
            }
            if (blocksChars[i - k] == whiteBlock) {
                whiteBlocksCount--;
            }

            minRecolors = Math.min(minRecolors, whiteBlocksCount);
        }

        return minRecolors;
    }

    /**
     * LeetCode №2379. Minimum Recolors to Get K Consecutive Black Blocks.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param blocks - a string of chars 'W' and 'B'. W means it is a white block, B means it is a black block.
     * @param k      - the required length of consecutive black blocks.
     * @return - the minimum number of recolors.
     */
    public int minimumRecolorsAlt(String blocks, int k) {
        char whiteBlock = 'W';
        int whiteBlocksCount = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == whiteBlock) whiteBlocksCount++;
        }

        int minRecolors = whiteBlocksCount;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == whiteBlock) {
                whiteBlocksCount++;
            }
            if (blocks.charAt(i - k) == whiteBlock) {
                whiteBlocksCount--;
            }

            minRecolors = Math.min(minRecolors, whiteBlocksCount);
        }

        return minRecolors;
    }
}
