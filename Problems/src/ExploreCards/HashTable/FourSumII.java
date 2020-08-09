package ExploreCards.HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class FourSumII {
    public static void main(String[] args) {
        FourSumII solution = new FourSumII();
        solution.testFourSumCount();
    }

    private void testFourSumCount() {

        int lower = -268435456;
        int upper = 268435456;
        for (int i = 0; i < 4; i++) {
            System.out.print("[");
            for (int r = 0; r < 25; r++) {
                int num = ThreadLocalRandom.current().nextInt(lower, upper);
                System.out.print(num + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null ||
            A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) return 0;

        Map<Long, Integer> sumsFromAandB = new HashMap<>();
        int count = 0;
        for (int a : A) {
            for (int b : B) {
                long currSum = (long) a + b;
                if (sumsFromAandB.containsKey(currSum)) {
                    sumsFromAandB.put(currSum, sumsFromAandB.get(currSum) + 1);
                } else {
                    sumsFromAandB.put(currSum, 1);
                }
            }
        }

        for (int c : C) {
            for (int d : D) {
                long currSum = (long) c + d;
                if (sumsFromAandB.containsKey(-currSum)) {
                    count += sumsFromAandB.get(-currSum);
                }
            }
        }

        return count;
    }
}
