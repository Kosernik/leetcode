package MonthlyChallenges.Year24.September;

public class FindLengthOfLongestCommonPrefix {

    /**
     * LeetCode №3043. Find the Length of the Longest Common Prefix.
     * <p>
     * Complexity - O(N*S + M*S), N = arr1.length, M = arr2.length, S ~= arr1[i].length ~= arr2[i].length.
     * Memory - O(M*S)
     *
     * @param arr1 - an array of positive integers.
     * @param arr2 - an array of positive integers.
     * @return - the length of the longest common prefix among all pairs of integers (x, y) such that x belongs to arr1
     * and y belongs to arr2. If no common prefix exists among them, returns 0.
     */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return longestCommonPrefix(arr2, arr1);

        int longestPrefix = 0;

        Trie root = buildTrie(arr2);

        for (int number : arr1) {
            int curLength = getCommonPrefixLength(Integer.toString(number), root);

            longestPrefix = Math.max(longestPrefix, curLength);
        }

        return longestPrefix;
    }

    private int getCommonPrefixLength(String word, Trie root) {
        int length = 0;

        for (char letter : word.toCharArray()) {
            if (root.children[letter - '0'] == null) {
                return length;
            }

            length++;
            root = root.children[letter - '0'];
        }

        return length;
    }

    private Trie buildTrie(int[] numbers) {
        Trie root = new Trie();

        for (int word : numbers) {
            addWordToTrie(Integer.toString(word), root);
        }

        return root;
    }

    private void addWordToTrie(String word, Trie root) {
        Trie node = root;

        for (char ch : word.toCharArray()) {
            if (node.children[ch - '0'] == null) {
                node.children[ch - '0'] = new Trie();
            }
            node = node.children[ch - '0'];
        }
    }

    static class Trie {
        Trie[] children;

        Trie() {
            children = new Trie[10];
        }
    }
}
