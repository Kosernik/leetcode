package ExploreCards.Trie;

public class WordDictionary {
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */

    private final TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode currNode = root;
        for (char letter : word.toCharArray()) {
            if (currNode.children[letter-'a'] == null) {
                currNode.children[letter-'a'] = new TrieNode();
            }
            currNode = currNode.children[letter-'a'];
        }
        currNode.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one
     * letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        return search(word, root);
    }
    private boolean search(String word, TrieNode startNode) {
        char[] letters = word.toCharArray();
        TrieNode currNode = startNode;

        for (int i = 0; i < word.length(); i++) {

            if (letters[i] == '.') {
                if (i == (word.length()-1)) {
                    for (int child = 0; child < 26; child++) {
                        if (currNode.children[child] != null && currNode.children[child].isWord) {
                            return true;
                        }
                    }
                    return false;
                }

                for (int child = 0; child < 26; child++) {
                    if (currNode.children[child] != null && search(word.substring(i+1, word.length()), currNode.children[child])) {
                        return true;
                    }
                }
                return false;
            } else {
                if (currNode.children[letters[i]-'a'] == null) return false;
                currNode = currNode.children[letters[i]-'a'];
            }
        }
        return currNode.isWord;
    }

    class TrieNode {
        boolean isWord = false;
        TrieNode[] children;
        TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}
