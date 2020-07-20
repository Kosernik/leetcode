package ExploreCards.Trie;

import java.util.List;

public class ReplaceWords {
    private TrieNode root;
    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.length() == 0) return sentence;
        buildTrie(dict);
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            builder.append(getRootOrWord(word));
            builder.append(' ');
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    private void buildTrie(List<String> dict) {
        this.root = new TrieNode();
        for (String word : dict) {
            addWord(word);
        }
    }
    private String getRootOrWord(String word) {
        TrieNode currNode = root;
        char[] letters = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (currNode.isWord) {
                return word.substring(0, i);
            } else if (currNode.children[letters[i] - 'a'] == null) {
                return word;
            }
            currNode = currNode.children[letters[i] - 'a'];
        }
        return word;
    }
    private void addWord(String word) {
        TrieNode currNode = root;
        for (char ch : word.toCharArray()) {
            if (currNode.children[ch - 'a'] == null) {
                currNode.children[ch - 'a'] = new TrieNode();
            }
            currNode = currNode.children[ch - 'a'];
        }
        currNode.isWord = true;
    }

    class TrieNode {
        boolean isWord = false;
        TrieNode[] children;
        TrieNode () {
            this.children = new TrieNode[26];
        }
    }
}
