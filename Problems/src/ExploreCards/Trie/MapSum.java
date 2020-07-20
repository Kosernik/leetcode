package ExploreCards.Trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    /**
     * Implement a MapSum class with insert, and sum methods.
     *
     * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer
     * represents the value. If the key already existed, then the original key-value pair will be overridden to the new
     * one.
     *
     * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the
     * pairs' value whose key starts with the prefix.
     */

    private final TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        if (key == null || key.length() == 0) return;
        TrieNode currNode = this.root;
        int currCharIdx = 0;
        while (currCharIdx < key.length()) {
            char currChar = key.charAt(currCharIdx);
            currNode.sum += val;
            if (!currNode.children.containsKey(currChar)) {
                TrieNode nextNode = new TrieNode();
                currNode.children.put(currChar, nextNode);
            }
            currNode = currNode.children.get(currChar);
            currCharIdx++;
        }
        if (currNode.isKey) {
            updateSum(key, currNode.val);
        }

        currNode.isKey = true;
        currNode.sum = currNode.sum + val - currNode.val;
        currNode.val = val;
    }

    public int sum(String prefix) {
        TrieNode currNode = this.root;
        int currCharIdx = 0;
        while (currCharIdx < prefix.length()) {
            char currChar = prefix.charAt(currCharIdx);
            if (!currNode.children.containsKey(currChar)) {
                return (int) currNode.sum;
            }
            currNode = currNode.children.get(currChar);
            currCharIdx++;
        }
        return (int) currNode.sum;
    }

    private void updateSum(String key, int oldVal) {
        TrieNode currNode = this.root;
        int currCharIdx = 0;
        while (currCharIdx < key.length()) {
            currNode.sum -= oldVal;
            currNode = currNode.children.get(key.charAt(currCharIdx));
            currCharIdx++;
        }
    }

    class TrieNode {
        private boolean isKey = false;
        private final Map<Character, TrieNode> children;
        private int val = 0;
        private double sum = 0;

        TrieNode () {
            this.children = new HashMap<>();
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */