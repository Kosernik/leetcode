package MonthlyChallenges.Year24.July;

public class CrawlerLogFolder {

    /**
     * LeetCode №1598. Crawler Log Folder.
     * <p>
     * Complexity - O(N), N = logs.length.
     * Memory - O(1)
     *
     * @param logs - an array of operations
     * @return -the minimum number of operations needed to go back to the main folder after the change folder operations.
     */
    public int minOperations(String[] logs) {
        int result = 0;

        for (String log : logs) {
            if (log.startsWith(".")) {
                if (log.charAt(1) == '.') {
                    result = Math.max(0, result - 1);
                }
            } else {
                result++;
            }
        }

        return result;
    }
}
