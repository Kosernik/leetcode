package MonthlyChallenges.Year21.September21;

public class NthTribonacciNumber {
    /**
     * LeetCode #1137. N-th Tribonacci Number.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param n - an index of a tribonacci number.
     * @return - n-th tribonacci number.
     */
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int minusThree = 0;
        int minusTwo = 1;
        int minusOne = 1;
        int res = 2;

        for (int fib = 3; fib <= n; fib++) {
            res = minusOne + minusTwo + minusThree;
            minusThree = minusTwo;
            minusTwo = minusOne;
            minusOne = res;
        }

        return res;
    }
}
