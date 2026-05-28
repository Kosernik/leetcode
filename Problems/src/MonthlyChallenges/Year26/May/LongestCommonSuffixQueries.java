package MonthlyChallenges.Year26.May;

public class LongestCommonSuffixQueries {

    /**
     * LeetCode №3093. Longest Common Suffix Queries.
     *
     * @param wordsContainer - an array of strings. Each string consists only of lowercase English letters.
     * @param wordsQuery     - an array of strings. Each string consists only of lowercase English letters.
     * @return - an array of integers result, where result[i] is the index of the string in wordsContainer that has the
     * longest common suffix with wordsQuery[i].
     */
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie root = buildTrie(wordsContainer);

        int[] result = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            Trie node = root;

            String query = wordsQuery[i];
            int curRes = -1;

            for (int j = query.length() - 1; j >= 0; j--) {
                int charIdx = query.charAt(j) - 'a';

                if (node.children[charIdx] == null) {
                    curRes = node.idx;
                    break;
                }

                node = node.children[charIdx];
            }

            if (curRes == -1) {
                curRes = node.idx;
            }
            result[i] = curRes;
        }

        return result;
    }

    private Trie buildTrie(String[] wordsContainer) {
        Trie root = new Trie();

        int minLength = wordsContainer[0].length();
        int minIdx = 0;

        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];

            addToTrie(word, i, root);

            if (word.length() < minLength) {
                minLength = word.length();
                minIdx = i;
            }
        }

        root.length = minLength;
        root.idx = minIdx;

        return root;
    }

    private void addToTrie(String word, int idx, Trie root) {
        int length = word.length();

        for (int i = length - 1; i >= 0; i--) {
            int charIdx = word.charAt(i) - 'a';

            if (root.children[charIdx] == null) {
                root.children[charIdx] = new Trie();
            }

            root = root.children[charIdx];

            if (length < root.length) {
                root.length = length;
                root.idx = idx;
            }
        }
    }

    static class Trie {
        Trie[] children;

        int length;
        int idx;

        Trie() {
            children = new Trie[26];
            length = Integer.MAX_VALUE;
            idx = -1;
        }
    }
}
