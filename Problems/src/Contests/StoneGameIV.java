package Contests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StoneGameIV {
    /**
     * Alice and Bob take turns playing a game, with Alice starting first.
     *
     * Initially, there are n stones in a pile.  On each player's turn, that player makes a move consisting of removing
     * any non-zero square number of stones in the pile.
     *
     * Also, if a player cannot make a move, he/she loses the game.
     *
     * Given a positive integer n. Return True if and only if Alice wins the game otherwise return False, assuming both
     * players play optimally.
     *
     */

    public static void main(String[] args) {
        StoneGameIV solution = new StoneGameIV();
        solution.testWinnerSquareGame();
    }

    Map<Integer, Boolean> computed = new HashMap<>();

    public boolean winnerSquareGame(int n) {
        if (n == 0) return false;
        if (computed.containsKey(n)) return computed.get(n);

        int root = (int) Math.sqrt(n);
        if (root*root == n) {
            computed.put(n, true);
            return true;
        }

        int num = 1;
        while (num*num <= n) {
            int currSquare = num*num;
            boolean currRes = winnerSquareGame(n - currSquare);
            if (!currRes) {
                computed.put(n, true);
                return true;
            }
            computed.put(n, false);
            num++;
        }
        computed.put(n, false);
        return false;
    }

    private void testWinnerSquareGame() {
        int[] tests = {         1,     2,    4,     7,    17,   8, 1245,   3,  257};
        boolean[] results = {true, false, true, false, false,true, true,true,false};

        for (int i = 0; i < tests.length; i++) {
            System.out.println(winnerSquareGame(tests[i]) + " = " + results[i]);
        }
    }
}