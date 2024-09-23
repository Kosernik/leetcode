package MonthlyChallenges.Year24.September;

public class ExtraCharactersInString {
    public static void main(String[] args) {
        ExtraCharactersInString solution = new ExtraCharactersInString();

        String testS0 = "leetscode";
        String[] testDictionary0 = {"leet", "code", "leetcode"};
        System.out.println(solution.minExtraChar(testS0, testDictionary0) == 1);
    }

    /**
     * LeetCode №2707. Extra Characters in a String.
     * <p>
     * Complexity - O()
     * Memory - O()
     *
     * @param s          - a string of lowercase english letters.
     * @param dictionary - an array of strings, each string in dictionary consists of lowercase english letters.
     * @return - the minimum number of extra characters left over if you break up s optimally.
     */
    public int minExtraChar(String s, String[] dictionary) {
        char[] letters = s.toCharArray();

        int[] dp = new int[letters.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        Trie root = buildTrie(dictionary);

        for (int i = 0; i < letters.length; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            Trie node = root;
            int rightIdx = i;

            while (node != null && rightIdx < letters.length) {
                node = node.children[letters[rightIdx] - 'a'];

                if (node != null && node.isWord) {
                    dp[rightIdx + 1] = Math.min(dp[rightIdx + 1], dp[i]);
                }

                rightIdx++;
            }
        }

        return dp[s.length()];
    }

    private Trie buildTrie(String[] dictionary) {
        Trie root = new Trie();

        for (String word : dictionary) {
            addWordToTrie(word, root);
        }

        return root;
    }

    private void addWordToTrie(String word, Trie root) {
        Trie node = root;

        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new Trie();
            }
            node = node.children[ch - 'a'];
        }

        node.isWord = true;
    }

    static class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }
}
