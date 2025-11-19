package Quests.Math;

public class PalindromeNumber {

    /**
     * LeetCode №9. Palindrome Number.
     * <p>
     * Complexity - O(logN)
     * Memory - O(1)
     *
     * @param x - an integer.
     * @return - true if x is a palindrome, false - otherwise.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x == 0) return true;

        int original = x;
        int mirrored = 0;

        while (original > 0) {
            mirrored = mirrored * 10 + original % 10;
            original /= 10;
        }

        return x == mirrored;
    }
}
