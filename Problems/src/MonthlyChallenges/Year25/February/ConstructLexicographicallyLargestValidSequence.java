package MonthlyChallenges.Year25.February;

import java.util.Arrays;

public class ConstructLexicographicallyLargestValidSequence {
    public static void main(String[] args) {
        ConstructLexicographicallyLargestValidSequence solution = new ConstructLexicographicallyLargestValidSequence();

        int test1 = 20;
        System.out.println(Arrays.toString(solution.constructDistancedSequence(test1)));
    }


    /**
     * LeetCode №1718. Construct the Lexicographically Largest Valid Sequence.
     *
     * @param n - a positive integer. 1 <= n <= 20
     * @return - the lexicographically largest valid sequence.
     */
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[n * 2 - 1];

        backtrack(0, result, new boolean[n + 1], n);

        return result;
    }

    private boolean backtrack(int idx, int[] sequence, boolean[] usedNumbers, int number) {
        if (idx == sequence.length) return true;

        if (sequence[idx] != 0) return backtrack(idx + 1, sequence, usedNumbers, number);

        for (int candidate = number; candidate >= 1; candidate--) {
            if (usedNumbers[candidate]) continue;

            usedNumbers[candidate] = true;
            sequence[idx] = candidate;

            if (candidate == 1) {
                if (backtrack(idx + 1, sequence, usedNumbers, number)) {
                    return true;
                }
            } else if (candidate + idx < sequence.length && sequence[candidate + idx] == 0) {
                sequence[candidate + idx] = candidate;

                if (backtrack(idx + 1, sequence, usedNumbers, number)) {
                    return true;
                }

                sequence[candidate + idx] = 0;
            }

            sequence[idx] = 0;
            usedNumbers[candidate] = false;
        }

        return false;
    }
}
