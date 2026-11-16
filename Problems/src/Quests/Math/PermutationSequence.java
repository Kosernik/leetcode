package Quests.Math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();

        int n0 = 3, k0 = 3;
        String answer0 = "213";
        String result0 = solution.getPermutation(n0, k0);
        System.out.println(result0.equals(answer0));

        int n1 = 4, k1 = 9;
        String answer1 = "2314";
        String result1 = solution.getPermutation(n1, k1);
        System.out.println(result1.equals(answer1));

        int n2 = 3, k2 = 1;
        String answer2 = "123";
        String result2 = solution.getPermutation(n2, k2);
        System.out.println(result2.equals(answer2));

        int n3 = 4, k3 = 7;
        String answer3 = "2134";
        String result3 = solution.getPermutation(n3, k3);
        System.out.println(result3.equals(answer3));

        int n4 = 3, k4 = 6;
        String answer4 = "321";
        String result4 = solution.getPermutation(n4, k4);
        System.out.println(result4.equals(answer4));

        int n5 = 4, k5 = 20;
        String answer5 = "4132";
        String result5 = solution.getPermutation(n5, k5);
        System.out.println(result5.equals(answer5));
    }


    private final int[] factorials = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    /**
     * LeetCode №60. Permutation Sequence.
     *
     * @param n - a positive integer. 1 <= n <= 9.
     * @param k - a positive integer. 1 <= k <= n!.
     * @return -the k-th permutation sequence of digits 1,2,3,...,n.
     */
    public String getPermutation(int n, int k) {
        List<Character> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            digits.add((char) ('0' + i));
        }

        return helper(n, k, digits);
    }

    private String helper(int n, int k, List<Character> digits) {
        if (n == 1) {
            return String.valueOf(digits.get(0));
        }

        int groupSize = factorials[n - 1];
        int charIdx = (k - 1) / groupSize;

        char startDigit = digits.get(charIdx);
        digits.remove(charIdx);

        return String.valueOf(startDigit).concat(helper(n - 1, Math.max(1, k - groupSize * charIdx), digits));
    }
}
