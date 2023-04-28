package MonthlyChallenges.Year23.April;

public class SimilarStringGroups {
    private int[] parents;

    /**
     * LeetCode #839. Similar String Groups.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param strs - a string of words. All words in strs have the same length and are anagrams of each other.
     * @return - the number of groups of similar words.
     */
    public int numSimilarGroupsSlow(String[] strs) {
        this.parents = new int[strs.length];
        for (int i = 0; i < this.parents.length; i++) {
            this.parents[i] = i;
        }

        for (int i = 1; i < strs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (areSimilar(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < this.parents.length; i++) {
            if (this.parents[i] == i) {
                result++;
            }
        }
        return result;
    }

    /**
     * LeetCode #839. Similar String Groups.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param strs - a string of words. All words in strs have the same length and are anagrams of each other.
     * @return - the number of groups of similar words.
     */
    public int numSimilarGroups(String[] strs) {
        this.parents = new int[strs.length];
        for (int i = 0; i < this.parents.length; i++) {
            this.parents[i] = i;
        }

        char[][] words = new char[strs.length][];
        words[0] = strs[0].toCharArray();

        for (int i = 1; i < strs.length; i++) {
            words[i] = strs[i].toCharArray();

            for (int j = i - 1; j >= 0; j--) {
                if (areSimilar(words[i], words[j])) {
                    union(i, j);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < this.parents.length; i++) {
            if (this.parents[i] == i) {
                result++;
            }
        }
        return result;
    }

    private void union(int firstIdx, int secondIdx) {
        int firstParent = find(firstIdx);
        int secondParent = find(secondIdx);

        if (firstParent == secondParent) return;

        this.parents[firstParent] = secondParent;
    }

    private int find(int idx) {
        if (this.parents[idx] == idx) {
            return idx;
        }
        return find(this.parents[idx]);
    }

    private boolean areSimilar(String word, String candidate) {
        int wrongPlacedLetters = 0;
        char wordChar = ' ';
        char candidateChar = ' ';

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != candidate.charAt(i)) {
                wrongPlacedLetters++;
                if (wrongPlacedLetters > 2) {
                    return false;
                } else if (wrongPlacedLetters == 1) {
                    wordChar = word.charAt(i);
                    candidateChar = candidate.charAt(i);
                } else {
                    if (wordChar != candidate.charAt(i) || candidateChar != word.charAt(i)) {
                        return false;
                    }
                }
            }
        }

        return wrongPlacedLetters == 0 || wrongPlacedLetters == 2;
    }

    private boolean areSimilar(char[] word, char[] candidate) {
        int wrongPlacedLetters = 0;
        char wordChar = ' ';
        char candidateChar = ' ';

        for (int i = 0; i < word.length; i++) {
            if (word[i] != candidate[i]) {
                wrongPlacedLetters++;
                if (wrongPlacedLetters > 2) {
                    return false;
                } else if (wrongPlacedLetters == 1) {
                    wordChar = word[i];
                    candidateChar = candidate[i];
                } else {
                    if (wordChar != candidate[i] || candidateChar != word[i]) {
                        return false;
                    }
                }
            }
        }

        return wrongPlacedLetters == 0 || wrongPlacedLetters == 2;
    }
}
