package MonthlyChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();
        solution.testWordBreak();
    }
    private void testWordBreak() {
        String[] testStrings = {"catsanddog", "pineapplepenapple", "catsandog", "a"};
        String[][] testWords = {
                {"cat", "cats", "and", "sand", "dog"},
                {"apple", "pen", "applepen", "pine", "pineapple"},
                {"cats", "dog", "sand", "and", "cat"},
                {"a"}};

        for (int i = 0; i < testWords.length; i++) {
            System.out.println("Test # " + i);
            List<String> currResult = wordBreak(testStrings[i], Arrays.asList(testWords[i]));

            for (String str : currResult) {
                System.out.println(str);
            }
        }
    }

    boolean[] usedChars = new boolean[26];
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList<>();
        if (s == null || s.length() == 0) return sentences;

        TrieNode root = buildTree(wordDict);
        for (char ch : s.toCharArray()) {
            if (!usedChars[ch-'a']) return sentences;
        }

        if (root.letters[s.charAt(0) - 'a'] == null) return sentences;
        Character[] currSentence = new Character[s.length()*2];
        breakIntoWords(s.toCharArray(), 0, root, root, sentences, currSentence, 0);
        return sentences;
    }

    private void breakIntoWords(char[] letters, int index, TrieNode root, TrieNode node, List<String> sentences,
                                Character[] currSentence, int sentenceIndex) {

        if (index == letters.length) {
            if (node.word == null) return;
            sentences.add(buildStringFromArray(currSentence, sentenceIndex));
            return;
        }

        TrieNode currNode = node.letters[letters[index] - 'a'];
        if (currNode == null) return;

        if (currNode.word != null) {
            currSentence[sentenceIndex] = letters[index];
            currSentence[sentenceIndex + 1] = ' ';
            breakIntoWords(letters, index + 1, root, root, sentences, currSentence, sentenceIndex+2);
            currSentence[sentenceIndex + 1] = null;
        }

        currSentence[sentenceIndex] = letters[index];
        breakIntoWords(letters, index+1, root, currNode, sentences, currSentence, sentenceIndex+1);
        currSentence[sentenceIndex] = null;
    }

    private String buildStringFromArray(Character[] currSentence, int sentenceIndex) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sentenceIndex; i++) {
            builder.append(currSentence[i]);
        }
        return builder.toString();
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

            currNode.word = word;
        }

        return root;
    }

    class TrieNode {
        String word = null;
        TrieNode[] letters;
        TrieNode() {
            letters = new TrieNode[26];
        }
    }
}
