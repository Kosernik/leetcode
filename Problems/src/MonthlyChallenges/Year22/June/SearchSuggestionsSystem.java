package MonthlyChallenges.Year22.June;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

    /**
     * LeetCode #1268. Search Suggestions System.
     *
     * Complexity - O(N + M), N = products.length, M = searchWord.length()
     * Memory - O(N)
     *
     * @param products - an array of strings of english lowercase letters.
     * @param searchWord - a string of english lowercase letters.
     * @return - the list of suggested words for each letter in searchWord.
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        TrieNode node = buildTrie(products);

        List<List<String>> result = new ArrayList<>();

        for (char letter : searchWord.toCharArray()) {
            if (node == null || node.children[letter - 'a'] == null) {
                result.add(new ArrayList<>());
                node = null;
            } else {
                node = node.children[letter - 'a'];
                result.add(node.suggestions);
            }
        }

        return result;
    }


    private TrieNode buildTrie(String[] products) {
        TrieNode head = new TrieNode();

        for (String word : products) {
            addWordToTrie(word, head);
        }

        return head;
    }

    private void addWordToTrie(String word, TrieNode head) {
        TrieNode node = head;

        for (char letter : word.toCharArray()) {
            if (node.children[letter - 'a'] == null) {
                node.children[letter - 'a'] = new TrieNode();
            }
            node = node.children[letter - 'a'];

            if (node.suggestions.size() < 3) {
                node.suggestions.add(word);
            }
        }
    }

    class TrieNode {
        TrieNode[] children;
        List<String> suggestions;

        TrieNode() {
            children = new TrieNode[26];
            suggestions = new ArrayList<>();
        }
    }
}
