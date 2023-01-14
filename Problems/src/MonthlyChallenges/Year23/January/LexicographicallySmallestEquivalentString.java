package MonthlyChallenges.Year23.January;

public class LexicographicallySmallestEquivalentString {

    private final char[] parents = new char[26];

    /**
     * LeetCode #1061. Lexicographically Smallest Equivalent String.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s1      - a string of lowercase English letters.
     * @param s2      - a string of lowercase English letters. s1.length = s2.length
     * @param baseStr - a string of lowercase English letters.
     * @return - the lexicographically smallest equivalent string of baseStr by using the equivalency information
     * from s1 and s2.
     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        initParents();

        char[] s1Letters = s1.toCharArray();
        char[] s2Letters = s2.toCharArray();
        for (int i = 0; i < s1Letters.length; i++) {
            union(s1Letters[i], s2Letters[i]);
        }

        char[] result = baseStr.toCharArray();
        for (int i = 0; i < result.length; i++) {
            result[i] = parents[find(result[i])];
        }

        return new String(result);
    }

    private int find(char letter) {
        if (parents[letter - 'a'] == letter) {
            return letter - 'a';
        }
        return find(parents[letter - 'a']);
    }

    private void union(char first, char second) {
        int firstParentIdx = find(first);
        int secondParentIdx = find(second);

        if (firstParentIdx == secondParentIdx) {
            return;// firstParentIdx;
        }

        if (parents[firstParentIdx] < parents[secondParentIdx]) {
            parents[secondParentIdx] = parents[firstParentIdx];
        } else {
            parents[firstParentIdx] = parents[secondParentIdx];
        }
    }

    private void initParents() {
        for (int i = 0; i < 26; i++) {
            parents[i] = (char) (i + 'a');
        }
    }
}
