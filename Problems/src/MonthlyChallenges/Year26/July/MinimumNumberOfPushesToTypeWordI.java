package MonthlyChallenges.Year26.July;

public class MinimumNumberOfPushesToTypeWordI {

    /**
     * LeetCode №3014. Minimum Number of Pushes to Type Word I.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param word - a string containing distinct lowercase English letters.
     * @return - the minimum number of pushes needed to type word after remapping the keys.
     */
    public int minimumPushes(String word) {
        int fullGroups = word.length() / 8;
        int remainder = word.length() % 8;

        return 8 * getSum(fullGroups) + remainder * (fullGroups + 1);
    }

    private int getSum(int end) {
        return end * (end + 1) / 2;
    }
}
