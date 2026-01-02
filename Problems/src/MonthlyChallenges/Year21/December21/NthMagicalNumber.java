package MonthlyChallenges.Year21.December21;

public class NthMagicalNumber {
    public static void main(String[] args) {
        NthMagicalNumber solution = new NthMagicalNumber();

        System.out.println(solution.nthMagicalNumber(3, 6, 4));
    }

    /**
     * LeeCode #878. Nth Magical Number.
     *
     * @param n - the number of required integer. n >= 1
     * @param a - a positive integer.
     * @param b - a positive integer.
     * @return - the n-th magical integer that is divisible by either a or b.
     */
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD = 1_000_000_007;
        long left = Math.min(a, b);
        long right = Long.MAX_VALUE;

        int lcmAB = lcm(a, b);

        while (left < right) {

            long middle = (right - left) / 2 + left;

            long numOfNumbers = countNumbers(a, b, middle, lcmAB);

            if (numOfNumbers >= n) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return (int) (left % MOD);
    }

    // Counts the number of integers in a range 1 to middle that are divisible by a or b.
    private long countNumbers(int a, int b, long middle, int lcmAB) {
        return middle / a + middle / b - middle / lcmAB;
    }

    private static int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
}
