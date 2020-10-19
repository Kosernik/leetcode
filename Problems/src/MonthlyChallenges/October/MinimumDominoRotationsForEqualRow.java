package MonthlyChallenges.October;

public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] A, int[] B) {
        int result = -1;

        int[] counts = new int[7];
        int target = 0;
        int sameNumsNeeded = A.length;
        boolean gotAllNums = false;

        for (int i = 0 ; i < A.length; i++) {
            counts[A[i]]++;
            counts[B[i]]++;
            if (A[i] == B[i]) {
                counts[B[i]]--;
            }
        }

        for (int i = 1; i < 7; i++) {
            if (counts[i] >= sameNumsNeeded) {
                gotAllNums = true;
                target = i;
                break;
            }
        }
        if (!gotAllNums) return result;
        return numberOfSwaps(A, B, target);
    }

    private int numberOfSwaps(int[] A, int[] B, int target) {
        int num = 0;
        int skipped = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                skipped++;
            }
            else if (A[i] != target) {
                num++;
            }
        }
        return Math.min(num, (A.length-skipped-num));
    }
}
