package MonthlyChallenges.August;

import java.util.LinkedList;
import java.util.List;

public class StreamOfCharacters {

    /**
     * StreamChecker(words): Constructor, init the data structure with the given words.
     *
     * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest
     * to newest, including this letter just queried) spell one of the words in the given list.
     */
    class StreamChecker {

        private final Trie root;
        private final LinkedList<Character> stream;

        public StreamChecker(String[] words) {
            root = buildTrie(words);
            stream = new LinkedList<>();
        }

        public boolean query(char letter) {
            stream.addFirst(letter);

            return isInTrie();
        }

        private boolean isInTrie() {
            Trie node = root;
            for (char c : stream){
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
                if (node.isWord) return true;
            }
            return false;
        }

        private Trie buildTrie(String[] words) {
            Trie trie = new Trie();

            for (String word : words) {
                addWordToTrie(word, trie);
            }

            return trie;
        }

        private void addWordToTrie (String word, Trie trie) {
            if (word == null || word.length() == 0) return;

            char[] letters = word.toCharArray();
            Trie node = trie;

            for (int i = letters.length-1; i >= 0; i--) {
                if (node.children[letters[i]-'a'] == null) {
                    node.children[letters[i]-'a'] = new Trie();
                }
                node = node.children[letters[i]-'a'];
            }
            node.isWord = true;
        }

        class Trie {
            Trie[] children;
            boolean isWord = false;

            Trie() {
                children = new Trie[26];
            }
        }
    }
}
