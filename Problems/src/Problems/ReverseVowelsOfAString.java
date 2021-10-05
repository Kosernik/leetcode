package Problems;

public class ReverseVowelsOfAString {
    /**
     * LeetCode #345. Reverse Vowels of a String.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of printable ASCII characters.
     * @return - the given string afters reversing all the vowels.
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;

        StringBuilder result = new StringBuilder();
        int rightIdx = s.length()-1;

        char[] letters = s.toCharArray();

        for (char ch : letters) {
            if (isVowel(ch)) {
                while (!isVowel(letters[rightIdx])) rightIdx--;
                result.append(letters[rightIdx--]);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
}
