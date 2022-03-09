package Problems;

public class MergeStringsAlternately {

    /**
     * LeetCode #1768. Merge Strings Alternately.
     *
     * Complexity - O(N1 + N2), N1 = word1.length(), N2 = word2.length().
     * Memory - O(N1 + N2)
     *
     * @param word1 - a string, word1.length() > 0.
     * @param word2 - a string, word2.length() > 0.
     * @return - the string produced by merging input strings in alternating order.
     */
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        char[] mergedArrays = mergeArrays(w1, w2);
        return new String(mergedArrays);
    }

    private char[] mergeArrays(char[] w1, char[] w2) {
        char[] merged = new char[w1.length + w2.length];

        int first = 0;
        int second = 0;
        int resultIdx = 0;
        boolean order = true;

        while (first < w1.length && second < w2.length) {
            if (order) {
                merged[resultIdx] = w1[first++];
            } else {
                merged[resultIdx] = w2[second++];
            }
            order = !order;
            resultIdx++;
        }

        while (first < w1.length) {
            merged[resultIdx++] = w1[first++];
        }
        while (second < w2.length) {
            merged[resultIdx++] = w2[second++];
        }

        return merged;
    }
}
