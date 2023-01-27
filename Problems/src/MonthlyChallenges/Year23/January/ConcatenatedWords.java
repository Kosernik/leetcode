package MonthlyChallenges.Year23.January;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    public static void main(String[] args) {
        ConcatenatedWords solution = new ConcatenatedWords();

        String[] test1 = {"cat", "dog", "catdog"};
        System.out.println(solution.findAllConcatenatedWordsInADict(test1));
    }

    /**
     * LeetCode #472. Concatenated Words.
     * <p>
     * Complexity - O(N*M), N = words.length, M = average length of a word.
     * Memory - (N*M)
     *
     * @param words - an array of unique strings. Each string contains only lower case english letters.
     * @return - all the concatenated words in the given list of words.
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        for (String word : words) {
            checkWord(word, root, result);
        }
        return result;
    }

    private void checkWord(String word, TrieNode root, List<String> result) {
        if (isConcatenated(word.toCharArray(), 0, root, 1)) {
            result.add(word);
        }
    }

    private boolean isConcatenated(char[] word, int idx, TrieNode root, int numberOfWords) {
        if (idx >= word.length) return false;

        TrieNode node = root;

        for (int i = idx; i < word.length; i++) {
            char letter = word[i];

            if (node.children[letter - 'a'] == null) return false;

            node = node.children[letter - 'a'];

            if (node.isWord) {
                if (isConcatenated(word, i + 1, root, numberOfWords + 1)) {
                    return true;
                }
            }
        }

        return node.isWord && numberOfWords > 1;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            addWord(word, root);
        }
        return root;
    }

    private void addWord(String word, TrieNode root) {
        for (char letter : word.toCharArray()) {
            if (root.children[letter - 'a'] == null) {
                root.children[letter - 'a'] = new TrieNode();
            }
            root = root.children[letter - 'a'];
        }
        root.isWord = true;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;

        TrieNode() {

        }
    }
}
