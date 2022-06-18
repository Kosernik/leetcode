package MonthlyChallenges.Year22.June;

public class PrefixAndSuffixSearch {

    /**
     * LeetCode #745. Prefix and Suffix Search.
     */
    class WordFilter {
        private final TrieNode root = new TrieNode();

        public WordFilter(String[] words) {
            buildTrie(words);
        }

        public int f(String prefix, String suffix) {
            TrieNode node = root;

            for (char letter : suffix.toCharArray()) {
                if (node.children[letter-'a'] == null) return -1;
                node = node.children[letter-'a'];
            }

            if (node.children[26] == null) return -1;
            node = node.children[26];

            for (char letter : prefix.toCharArray()) {
                if (node.children[letter-'a'] == null) return -1;
                node = node.children[letter-'a'];
            }
            return node.idx;
        }

        private void buildTrie(String[] words) {
            int idx = 0;
            for (String word : words) {
                addWordToTrie(word, idx);
                idx++;
            }
        }

        private void addWordToTrie(String word, int idx) {
            for (int i = 0; i < word.length(); i++) {
                String suffix = word.substring(i);
                addWithSuffix(suffix, word, idx);
            }
        }

        private void addWithSuffix(String suffix, String word, int idx) {
            TrieNode node = root;

            for (char letter : suffix.toCharArray()) {
                if (node.children[letter-'a'] == null) {
                    node.children[letter-'a'] = new TrieNode();
                }
                node = node.children[letter-'a'];
            }

            if (node.children[26] == null) {
                node.children[26] = new TrieNode();
            }
            node = node.children[26];

            for (char letter : word.toCharArray()) {
                if (node.children[letter-'a'] == null) {
                    node.children[letter-'a'] = new TrieNode();
                }
                node = node.children[letter-'a'];
                if (word.length() > node.maxLength) {
                    node.idx = idx;
                }
            }
        }


        class TrieNode {
            TrieNode[] children;
            int maxLength = 0;
            int idx = -1;

            TrieNode() {
                children = new TrieNode[27];
            }
        }
    }
}
