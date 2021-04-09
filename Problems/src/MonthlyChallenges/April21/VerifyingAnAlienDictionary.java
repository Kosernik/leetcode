package MonthlyChallenges.April21;

public class VerifyingAnAlienDictionary {

    private final int[] letters = new int[26];

    /**
     * LeetCode #953.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param words - array of words of english lowercase letters.
     * @param order - a string representing the order of letters in an alphabet.
     * @return - true - if array "words" is sorted lexicographicaly, false - otherwise.
     */
    public boolean isAlienSorted(String[] words, String order) {
        fillLetters(letters, order);

        for (int i = 0; i < words.length-1; i++) {
            if (compareTwoWords(words[i], words[i+1]) > 0) return false;
        }

        return true;
    }

    private void fillLetters(int[] letters, String order) {
        int number = 0;
        for (char c : order.toCharArray()) {
            letters[c - 'a'] = number;
            number++;
        }
    }

    private int compareTwoWords(String first, String second) {
        int idxFirst = 0;
        int idxSecond = 0;

        while (true) {
            if (idxFirst >= first.length()) return -1;
            else if (idxSecond >= second.length()) return 1;
            else if (first.charAt(idxFirst) != second.charAt(idxSecond)) {
                return compareTwoLetters(first.charAt(idxFirst), second.charAt(idxSecond));
            }
            idxFirst++;
            idxSecond++;
        }
    }

    private int compareTwoLetters(char first, char second) {
        return Integer.compare(letters[first-'a'], letters[second-'a']);
    }
}
