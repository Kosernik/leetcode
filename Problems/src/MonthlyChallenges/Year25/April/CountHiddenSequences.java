package MonthlyChallenges.Year25.April;

public class CountHiddenSequences {
    public static void main(String[] args) {
        CountHiddenSequences solution = new CountHiddenSequences();

        int[] diff1 = {3, -4, 5, 1, -2};
        int lower1 = -4, upper1 = 5;
        int result1 = 4;
        System.out.println(solution.numberOfArrays(diff1, lower1, upper1) + " ? " + result1);
    }

    /**
     * LeetCode №2145. Count the Hidden Sequences.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param differences - an array of integers. differences[i] = hidden[i + 1] - hidden[i]
     * @param lower       - the lower bound (inclusive) of a possible hidden sequence.
     * @param upper       - the upper bound (inclusive) of a possible hidden sequence.
     * @return - the number of possible hidden sequences there are. If there are no possible sequences, returns 0.
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prev = lower;
        long min = lower, max = lower;

        for (int difference : differences) {
            long curNumber = difference + prev;

            min = Math.min(min, curNumber);
            max = Math.max(max, curNumber);

            prev = curNumber;
        }

        max += lower - min;

        if (max > upper) {
            return 0;
        } else {
            return upper - (int) max + 1;
        }
    }
}
