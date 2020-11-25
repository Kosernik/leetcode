package MonthlyChallenges.November;

public class SmallestIntegerDivisibleByK {
    /**
     * LeetCode #1015.
     *
     * @param K
     * @return
     */
    public int smallestRepunitDivByK(int K) {
        if (K == 1) return 1;
        else if (K % 2 == 0) return -1;
        else if (K % 5 == 0) return -1;

        int remainder = 0;
        for (int N = 1; N <= K; N++) {
            remainder = (remainder * 10 + 1) % K;
            if (remainder == 0) return N;
        }

        return -1;
    }
}
