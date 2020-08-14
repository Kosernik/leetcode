package MonthlyChallenges.August;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        solution.testLongestPalindrome();
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] charCount = new int[52];

        for (char letter : s.toCharArray()) {
            if (letter >= 'a' && letter <= 'z') {
                charCount[letter - 'a']++;
            } else if (letter >= 'A' && letter <= 'Z') {
                charCount[(letter - 'A') + 26]++;
            }
        }

        int length = 0;
        boolean odd = false;

        for (int i = 0; i < 52; i++) {
            if (charCount[i] % 2 == 0) {
                length += charCount[i];
            } else {
                odd = true;
                length += (charCount[i] - 1);
            }
        }
        if (odd) length++;
        return length;
    }

    private void testLongestPalindrome() {
        String[] tests = {"abccccdd","", null, new String(), "abcd", "AaBbCcDd", "AaA","AAAaaaBBbbCCcc"};
        int[] results = {7, 0, 0, 0, 1, 1, 3, 13};

        int failed = 0;

        for (int i = 0; i < tests.length; i++) {
            int currResult = longestPalindrome(tests[i]);
            if (currResult != results[i]) {
                failed++;
                System.out.println("Failed test # " + i + " - " + tests[i]);
                System.out.println("Got: " + currResult + ", instead of: " + results[i]);
            }
        }

        System.out.println("Success rate: " + ((tests.length - failed) * 100.0 / tests.length));
    }
}
