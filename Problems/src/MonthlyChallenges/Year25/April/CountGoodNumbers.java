package MonthlyChallenges.Year25.April;

public class CountGoodNumbers {
    public static void main(String[] args) {
        CountGoodNumbers solution = new CountGoodNumbers();

        System.out.println(solution.countGoodNumbers(1L) == 5);

        System.out.println();
        System.out.println(solution.countGoodNumbers(4L) == 400);

        System.out.println();
        System.out.println(solution.countGoodNumbers(50L) == 564908303);

        System.out.println();
        System.out.println(solution.countGoodNumbers(10000000000L) == 176203868);
    }

    /**
     * LeetCode №1922. Count Good Numbers.
     * <p>
     * Complexity - O(logN)
     * Memory - O(1)
     *
     * @param n - a positive long number.
     * @return - the total number of good digit strings of length n. Result is modulo 1_000_000_007.
     */
    public int countGoodNumbers(long n) {
        int MODULO = 1_000_000_007;

        int EVEN_DIGITS = 5;
        int ODD_DIGITS = 4;

        long oddIdxs = n / 2L;
        long evenIdxs = n - oddIdxs;

        long count = pow(EVEN_DIGITS, evenIdxs, MODULO);

        long oddPower = pow(ODD_DIGITS, oddIdxs, MODULO);
        count = (count * oddPower) % MODULO;

        return (int) count;
    }

    private long pow(long base, long power, int MODULO) {
        if (power == 0) {
            return 1L;
        } else if (power == 1) {
            return base;
        }

        long result = pow(base, power / 2, MODULO);
        result = result * result % MODULO;

        if (power % 2 == 1) {
            result = result * base % MODULO;
        }

        return result;
    }
}
