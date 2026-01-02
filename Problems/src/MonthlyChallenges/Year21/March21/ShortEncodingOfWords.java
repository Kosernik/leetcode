package MonthlyChallenges.Year21.March21;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingOfWords {
    /**
     * LeetCode #820.
     * <p>
     * Complexity - O(N).
     * Memory - O(N).
     *
     * @param words - array of strings of english lower-case letters, may contain duplicates.
     * @return - the length of the shortest reference string.
     */
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        Set<String> uniques = new HashSet<>();

        int uniqueWords = 0;
        int length = 0;

        for (String word : words) {
            if (uniques.contains(word)) continue;
            addToTrie(word, root);
            uniqueWords++;
            length += word.length();
            uniques.add(word);
        }

        ArrayDeque<TrieNode> trieTraversal = new ArrayDeque<>();
        trieTraversal.add(root);

        while (!trieTraversal.isEmpty()) {
            TrieNode node = trieTraversal.removeFirst();

            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (node.isWord) {
                        length -= node.length;
                        uniqueWords--;
                        node.length = 0;
                        node.isWord = false;
                    }
                    trieTraversal.addLast(node.children[i]);
                }
            }
        }

        return length + uniqueWords;
    }

    private void addToTrie(String word, TrieNode root) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i) - 'a'];
        }

        node.isWord = true;
        node.length = word.length();
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
        int length = 0;

        public TrieNode() {
        }
    }
}
