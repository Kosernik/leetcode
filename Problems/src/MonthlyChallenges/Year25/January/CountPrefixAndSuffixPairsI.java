package MonthlyChallenges.Year25.January;

public class CountPrefixAndSuffixPairsI {

    /**
     * LeetCode №3042. Count Prefix and Suffix Pairs I.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(1)
     *
     * @param words - an array of strings.
     * @return - the number of prefix-and-suffix pairs.
     */
    public int countPrefixSuffixPairs(String[] words) {
        int result = 0;

        int length = words.length;

        for (int i = 0; i < length - 1; i++) {
            String candidate = words[i];

            for (int j = i + 1; j < length; j++) {
                if (isPrefixAndSuffix(candidate, words[j])) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isPrefixAndSuffix(String candidate, String word) {
        if (candidate.length() > word.length()) return false;

        int leftC = 0, rightC = candidate.length() - 1;
        int leftW = 0, rightW = word.length() - 1;

        while (rightC >= 0) {
            if (candidate.charAt(leftC) != word.charAt(leftW) || candidate.charAt(rightC) != word.charAt(rightW)) {
                return false;
            }

            leftC++;
            leftW++;
            rightC--;
            rightW--;
        }

        return true;
    }
}
