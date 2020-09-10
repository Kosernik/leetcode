package MonthlyChallenges.September;

public class BullsAndCows {
    public static void main(String[] args) {
        BullsAndCows solution = new BullsAndCows();

        String test0Secret = "1807"; String test0guess ="7810"; String test0result = "1A3B";
        String test1Secret = "1123"; String test1guess ="0111"; String test1result = "1A1B";

        System.out.println(solution.getHint(test0Secret, test0guess).equals(test0result));
        System.out.println(solution.getHint(test1Secret, test1guess).equals(test1result));
    }

    /**
     * Returns number of "bulls" and "cows".
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param secret - secret combination of digits. Not null.
     * @param guess - guessed combination of digits. Not null, same length as secret.
     * @return - number of bulls followed by "A" and number of cows followed by "B".
     */
    public String getHint(String secret, String guess) {
        int[] counts = new int[10];

        char[] secretDigits = secret.toCharArray();
        char[] guessDigits = guess.toCharArray();

        for (char ch : secretDigits) {
            counts[ch - '0']++;
        }

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secretDigits.length; i++) {
            if (secretDigits[i] == guessDigits[i]) {
                bulls++;
            }
            if (counts[guessDigits[i] - '0'] > 0) {
                cows++;
                counts[guessDigits[i] - '0']--;
            }
        }

        return bulls + "A" + (cows-bulls) + "B";
    }
}
