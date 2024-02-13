package MonthlyChallenges.Year24.February;

public class FindFirstPalindromicStringInArray {

    /**
     * LeetCode №2108. Find First Palindromic String in the Array.
     * <p>
     * Complexity - O(N*M), N = words.length, M = words[i].length()
     * Memory - O(1)
     *
     * @param words - an array of strings.
     * @return - the first palindromic string in the array. If there is no such string, returns an empty string "".
     */
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return "";
    }


    /**
     * Checks if the string is a palindrome.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param word - a string.
     * @return - true - if word is a palindrome, false - otherwise.
     */
    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
