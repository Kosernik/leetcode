package MonthlyChallenges.November;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LongestMountainInArray {
    public static void main(String[] args) {
        LongestMountainInArray solution = new LongestMountainInArray();
        int[] tst = {2,1,4,7,3,2,5};
        System.out.println(solution.longestMountain(tst));

        System.out.println("---");
        int[] tst1 = {1,2,3,4,3,4,5,6,5,4,3,2,1};
        System.out.println(solution.longestMountain(tst1));
    }


    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;

        int startIdx = 1;
        while (startIdx < A.length && A[startIdx-1] > A[startIdx]) startIdx++;
        if (startIdx >= A.length-1) return 0;

        int i = startIdx;

        while (i < A.length && A[i] > A[i-1]) {
            i++;
        }
        if (i == A.length) {
            return 0;
        }
        else if (A[i] == A[i-1]) {
            return longestMountain(subArr(A, i));
        }

        while (i < A.length && A[i] < A[i-1]) {
            i++;
        }
        if (i == A.length) {
            return i - startIdx+1;
        }
        return Math.max(i - startIdx+1, longestMountain(subArr(A, i-1)));
    }

    private int[] subArr(int[] A, int start){
        int[] subA = new int[A.length - start];
        if (subA.length >= 0) System.arraycopy(A, start, subA, 0, subA.length);
        return subA;
    }

}
