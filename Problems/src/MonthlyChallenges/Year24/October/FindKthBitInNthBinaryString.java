package MonthlyChallenges.Year24.October;

import java.util.ArrayList;
import java.util.List;

public class FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        FindKthBitInNthBinaryString solution = new FindKthBitInNthBinaryString();

        int testN1 = 4;
        int testK1 = 11;
        System.out.println(solution.findKthBit(testN1, testK1) == '1');
    }

    /**
     * LeetCode №1545. Find Kth Bit in Nth Binary String.
     * <p>
     * Complexity - O(N*K), N = n, K = k
     * Memory - O(K)
     *
     * @param n - the total number of operations
     * @param k - the number of the required bit, 1-based.
     * @return - the k-th bit in a resulting string.
     */
    public char findKthBit(int n, int k) {
        if (k == 1) return '0';
        if (k == 2) return '1';

        List<Character> binaryString = new ArrayList<>();
        binaryString.add('0');

        for (int i = 2; i <= n; i++) {
            int length = binaryString.size();

            binaryString.add('1');

            for (int j = length + 1, idx = length - 1; idx >= 0; j++, idx--) {
                if (binaryString.get(idx) == '0') {
                    binaryString.add('1');
                } else {
                    binaryString.add('0');
                }
            }

            if (binaryString.size() > k) {
                return binaryString.get(k - 1);
            }
        }

        return binaryString.get(k - 1);
    }
}
