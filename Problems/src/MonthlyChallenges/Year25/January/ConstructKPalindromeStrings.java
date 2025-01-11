package MonthlyChallenges.Year25.January;

public class ConstructKPalindromeStrings {
    public static void main(String[] args) {
        ConstructKPalindromeStrings solution = new ConstructKPalindromeStrings();

        String testS = "qlkzenwmmnpkopu";
        int testK = 15;
        boolean testResult = true;
        System.out.println(solution.canConstruct(testS, testK) == testResult);
    }

    /**
     * LeetCode №1400. Construct K Palindrome Strings.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of lowercase english letters.
     * @param k - the required number of palindromes.
     * @return - true if you can use all the characters in s to construct k palindrome strings or false otherwise.
     */
    public boolean canConstruct(String s, int k) {
        int[] counts = new int[26];
        for (char letter : s.toCharArray()) {
            counts[letter - 'a']++;
        }

        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 == 1) {
                oddCount++;
                counts[i]--;
            }
            evenCount += counts[i];
        }

        if (oddCount > k) return false;
        k -= oddCount;

        return evenCount >= k;
    }
}
