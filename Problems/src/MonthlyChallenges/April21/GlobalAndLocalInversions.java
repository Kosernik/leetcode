package MonthlyChallenges.April21;

import java.util.Arrays;

public class GlobalAndLocalInversions {
    public static void main(String[] args) {
        GlobalAndLocalInversions solution = new GlobalAndLocalInversions();

        int[] test0 = {1,0,2};
        System.out.println(solution.isIdealPermutation(test0));

        int[] test1 = {1,2,0};
        System.out.println(solution.isIdealPermutation(test1));
    }

    /**
     * leetCode #775.
     *
     * Checks if the number of global and local permutations in an array are equal.
     *
     * Complexity - O(N^2 / 2)
     * memory - O(N)
     *
     * @param A - permutation of an array of integers {0, 1, ..., N - 1}, where N is the length of A.
     * @return - true - if the number of global permutations equals the number of local permutations, false - otherwise.
     */
    public boolean isIdealPermutation(int[] A) {
        int localPermutations = 0;
        for (int i = 0; i < A.length-1; i++) {
            if (A[i] > A[i+1]) localPermutations++;
        }

        int[] smaller = new int[A.length];
        int globalPermutations = A[0];
        for (int i = 1; i < A.length; i++) {
            int currPermutations = 0;
            for (int j = i-1; j >= 0; j--) {
                if (A[j]+1 == A[i]) {
                    smaller[i] = currPermutations + smaller[j] + 1;
                    break;
                }
                if (A[j] < A[i]) currPermutations++;
            }
            if (smaller[i] == 0) {
                smaller[i] = currPermutations;
            }
            globalPermutations += A[i] - smaller[i];
            if (globalPermutations > localPermutations) return false;
        }

        return localPermutations == globalPermutations;
    }
}
