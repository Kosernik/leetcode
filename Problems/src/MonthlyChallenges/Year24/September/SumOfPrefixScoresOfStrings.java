package MonthlyChallenges.Year24.September;

public class SumOfPrefixScoresOfStrings {

    /**
     * LeetCode №2416. Sum of Prefix Scores of Strings.
     * <p>
     * Complexity - O(N*M), N = words.length, M = words[i].length
     * Memory - O(N^M)
     *
     * @param words- an array of strings, each string consists of lowercase english letters.
     * @return - an array sums of size n where sums[i] is the sum of scores of every non-empty prefix of words[i].
     */
    public int[] sumPrefixScores(String[] words) {
        int[] sums = new int[words.length];

        Trie root = buildTrie(words);

        for (int i = 0; i < words.length; i++) {
            int sum = 0;
            char[] letters = words[i].toCharArray();
            Trie node = root;

            for (char letter : letters) {
                node = node.children[letter - 'a'];
                sum += node.prefixCount;
            }

            sums[i] = sum;
        }
        
        return sums;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();

        for (String word : words) {
            addToTrie(root, word);
        }

        return root;
    }

    private void addToTrie(Trie root, String word) {
        for (char letter : word.toCharArray()) {
            if (root.children[letter - 'a'] == null) {
                root.children[letter - 'a'] = new Trie();
            }

            root = root.children[letter - 'a'];
            root.prefixCount++;
        }
    }

    static class Trie {
        Trie[] children;
        int prefixCount = 0;

        Trie() {
            children = new Trie[26];
        }
    }
}
