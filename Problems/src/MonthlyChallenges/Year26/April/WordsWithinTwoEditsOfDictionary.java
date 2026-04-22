package MonthlyChallenges.Year26.April;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary {

    /**
     * LeetCode №2452. Words Within Two Edits of Dictionary.
     *
     * @param queries    - an array of strings of lowercase english letters.
     * @param dictionary - an array of strings of lowercase english letters. queries[i].length = dictionary[j].length.
     * @return - a list of all words from queries, that match with some word from dictionary after a maximum of two edits.
     * Returns the words in the same order they appear in queries.
     */
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int MAX_EDITS = 2;
        List<String> result = new ArrayList<>();

        Trie dictionaryTrie = buildTrie(dictionary);

        for (String query : queries) {
            if (canGetWord(query, dictionaryTrie, MAX_EDITS)) {
                result.add(query);
            }
        }

        return result;
    }

    private boolean canGetWord(String candidate, Trie dictionaryTrie, int maxEdits) {
        return dfs(candidate, 0, maxEdits, dictionaryTrie);
    }

    private boolean dfs(String candidate, int idx, int edits, Trie node) {
        if (idx >= candidate.length()) return true;

        int letterIdx = candidate.charAt(idx) - 'a';

        if (node.children[letterIdx] != null) {
            if (dfs(candidate, idx + 1, edits, node.children[letterIdx])) {
                return true;
            }
        }

        if (edits > 0) {
            for (int nextIdx = 0; nextIdx < 26; nextIdx++) {
                if (nextIdx == letterIdx) continue;

                if (node.children[nextIdx] != null &&
                        dfs(candidate, idx + 1, edits - 1, node.children[nextIdx])) {
                    return true;
                }
            }
        }

        return false;
    }

    private Trie buildTrie(String[] dictionary) {
        Trie root = new Trie();

        for (String word : dictionary) {
            addWordToTrie(word, root);
        }

        return root;
    }

    private void addWordToTrie(String word, Trie root) {
        for (int i = 0; i < word.length(); i++) {
            int letterIdx = word.charAt(i) - 'a';

            if (root.children[letterIdx] == null) {
                root.children[letterIdx] = new Trie();
            }

            root = root.children[letterIdx];
        }

        root.children = null;
    }

    static class Trie {
        Trie[] children = null;

        Trie() {
            this.children = new Trie[26];
        }
    }
}
