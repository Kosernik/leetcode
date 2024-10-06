package MonthlyChallenges.Year24.October;

public class SentenceSimilarityIII {
    /**
     * LeetCode №1813. Sentence Similarity III.
     * <p>
     * Complexity - O(N) N - maximum length of sentence1 and sentence2. M - minimum length of sentence1 and sentence2.
     * Memory - O(N+M)
     * <p>
     * Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty)
     * inside one of these sentences such that the two sentences become equal. Note that the inserted sentence must be
     * separated from existing words by spaces.
     *
     * @param sentence1 - a string of words, each word is separated by a single space.
     * @param sentence2 - a string of words, each word is separated by a single space.
     * @return - true if sentence1 and sentence2 are similar. False - otherwise.
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() == sentence2.length()) {
            return sentence1.equals(sentence2);
        }

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int length1 = words1.length, length2 = words2.length;

        if (length1 == length2) {
            return false;
        } else if (length1 < length2) {
            String[] tempWords = words1;
            int tempLength = length1;

            words1 = words2;
            words2 = tempWords;

            length1 = length2;
            length2 = tempLength;
        }

        int firstIdx = 0, secondIdx = 0;

        if (words1[firstIdx].equals(words2[secondIdx]) && words1[length1 - 1].equals(words2[length2 - 1])) {
            //  second index should meet length index
            int firstEnd = length1 - 1;
            int secondEnd = length2 - 1;

            while (secondIdx < (length2 - 1) && words1[firstIdx].equals(words2[secondIdx])) {
                firstIdx++;
                secondIdx++;
            }
            while (secondEnd > 0 && words1[firstEnd].equals(words2[secondEnd])) {
                firstEnd--;
                secondEnd--;
            }

            return secondIdx >= secondEnd;
        } else if (words1[firstIdx].equals(words2[secondIdx])) {
            //  second index should go to end
            while (firstIdx < length1 && secondIdx < length2 && words1[firstIdx].equals(words2[secondIdx])) {
                firstIdx++;
                secondIdx++;
            }

            return secondIdx == length2;
        } else {
            // second index should go to 0
            firstIdx = length1 - 1;
            secondIdx = length2 - 1;
            while (secondIdx >= 0 && words1[firstIdx].equals(words2[secondIdx])) {
                firstIdx--;
                secondIdx--;
            }

            return secondIdx == -1;
        }
    }
}
