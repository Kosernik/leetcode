package MonthlyChallenges.Year23.November;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightDialer {
    private final int MODULO = 1_000_000_000 + 7;
    private final List<List<Integer>> moves = getMoves();


    /**
     * LeetCode №935. Knight Dialer.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param n - the length of the number.
     * @return - the number of distinct phone numbers of length 'n'. The answer is modulo 10^9 + 7.
     */
    public int knightDialer(int n) {
        if (n == 1) return 10;

        long[] startingGrid = new long[10];
        Arrays.fill(startingGrid, 1);

        long[] computed = helper(1, n, startingGrid);

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + computed[i]) % MODULO;
        }

        return (int) result % MODULO;
    }

    private long[] helper(int curLength, int n, long[] computed) {
        if (curLength == n) return computed;
        long[] curCombinations = new long[10];

        for (int i = 0; i <= 9; i++) {
            for (int nextNumber : moves.get(i)) {
                curCombinations[i] = (curCombinations[i] + computed[nextNumber]) % MODULO;
            }
        }

        return helper(curLength + 1, n, curCombinations);
    }

    private static List<List<Integer>> getMoves() {
        List<List<Integer>> moves = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            moves.add(new ArrayList<>());
        }

        moves.get(0).add(4);
        moves.get(0).add(6);

        moves.get(1).add(6);
        moves.get(1).add(8);

        moves.get(2).add(7);
        moves.get(2).add(9);

        moves.get(3).add(4);
        moves.get(3).add(8);

        moves.get(4).add(3);
        moves.get(4).add(9);
        moves.get(4).add(0);

        moves.get(6).add(1);
        moves.get(6).add(7);
        moves.get(6).add(0);

        moves.get(7).add(2);
        moves.get(7).add(6);

        moves.get(8).add(1);
        moves.get(8).add(3);

        moves.get(9).add(2);
        moves.get(9).add(4);

        return moves;
    }
}
