package ExploreCards.Trie;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (words == null || words.length <= 1) return pairs;

        TrieNode root = buildTrie(words);

        for (String word : words) {
            // TODO
        }

        return pairs;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        fillTrie(root, words);
        return root;
    }
    private void fillTrie(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode currNode = root;
            for (char letter : word.toCharArray()) {
                if (!currNode.children.containsKey(letter)) {
                    currNode.children.put(letter, new TrieNode());
                }
                currNode = currNode.children.get(letter);
            }
            currNode.word = word;
        }
    }
    class TrieNode {
        String word;
        Map<Character, TrieNode> children;
        TrieNode () {
            children = new HashMap<>();
        }
    }

    // TLE
    public List<List<Integer>> palindromePairsBrute(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (words == null || words.length <= 1) return pairs;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (isPalindromes(words[i], words[j])) {
                    List<Integer> currPair = new ArrayList<>();
                    currPair.add(i);currPair.add(j);

                    pairs.add(currPair);
                }
            }
        }

        return pairs;
    }

    private boolean isPalindromes(String left, String right) {
        char[] leftLetters = left.toCharArray();
        char[] rightLetters = right.toCharArray();

        char[] letters = new char[leftLetters.length+rightLetters.length];
        System.arraycopy(leftLetters, 0, letters, 0, leftLetters.length);
        System.arraycopy(rightLetters, 0, letters, leftLetters.length, rightLetters.length);

        int leftIdx = 0, rightIdx = letters.length-1;
        for (int i = 0, length = (leftLetters.length+rightLetters.length)/2; i < length; i++) {
            if (letters[leftIdx] != letters[rightIdx]) return false;
            leftIdx++;
            rightIdx--;
        }

        return true;
    }
}
