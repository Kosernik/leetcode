package Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak solution = new WordBreak();

        String test0S = "applepenapple";
        List<String> test0wordDict = new ArrayList<>();
        test0wordDict.add("apple"); test0wordDict.add("pen");

        System.out.println(solution.wordBreak(test0S, test0wordDict));

        String test1S = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> test1wordDict = new ArrayList<>();
        test1wordDict.add("aa"); test1wordDict.add("aaa");test1wordDict.add("aaaa"); test1wordDict.add("aaaaa");
        test1wordDict.add("aaaaaa"); test1wordDict.add("aaaaaaa");test1wordDict.add("aaaaaaaa");
        test1wordDict.add("aaaaaaaaa"); test1wordDict.add("aaaaaaaaaa"); test1wordDict.add("ba");

        System.out.println(solution.wordBreak(test1S, test1wordDict));
    }


    /**
     * LeetCode #139. Word Break.
     *
     * @param s - a string of english lowercase letters.
     * @param wordDict - a list of unique strings of english lowercase letters.
     * @return - True - if "s" can be segmented into a space-separated sequence of one or more "wordDict" words.
     *           False - otherwise.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> setDict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && setDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    // Array of letters that appear in words of wordDict
    boolean[] usedChars = new boolean[26];
    TrieNode trie;

    public boolean wordBreakTLE(String s, List<String> wordDict) {
        trie = buildTree(wordDict);

        // Checking if all letters of "s" are present in wordDict
        for (char ch : s.toCharArray()) {
            if (!usedChars[ch-'a']) return false;
        }

        return wordBreakHelper(s);
    }

    private boolean wordBreakHelper(String s) {
        if (s == null || s.length() == 0) return true;

        TrieNode node = trie.letters[s.charAt(0)-'a'];

        for (int i = 0; i < s.length(); i++) {
            if (node == null) {
                return false;
            }

            if (node.isWord) {
                if (wordBreakHelper(s.substring(i+1))) return true;
            }

            if (i+1 == s.length()) {
                return false;
            }
            node = node.letters[s.charAt(i+1)-'a'];
        }

        return false;
    }

    private TrieNode buildTree(List<String> wordDict){
        TrieNode root = new TrieNode();

        for (String word : wordDict) {
            TrieNode currNode = root;

            for (char ch : word.toCharArray()) {
                usedChars[ch - 'a'] = true;
                if (currNode.letters[ch - 'a'] == null) {
                    currNode.letters[ch - 'a'] = new TrieNode();
                }
                currNode = currNode.letters[ch - 'a'];
            }

            currNode.isWord = true;
        }

        return root;
    }

    static class TrieNode {
        Boolean isWord = false;
        TrieNode[] letters;
        TrieNode() {
            letters = new TrieNode[26];
        }
    }
}
