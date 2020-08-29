package MonthlyChallenges.August;

import java.util.*;

public class PancakeSorting {
    public static void main(String[] args) {
        PancakeSorting solution = new PancakeSorting();

        int[] test0 = {3,2,4,1};
        System.out.println(solution.pancakeSort(test0).toString());

        int[] test1 = {10,7,3,8,4,1,9,5,6,2};
        System.out.println(solution.pancakeSort(test1).toString());
    }

    /**
     * Sorts an array of integers by reversing first k elements of an array and returns order of flips.
     * 
     * @param A - array of integers
     * @return - List of flip operations, 1-indexed
     */
    public List<Integer> pancakeSort(int[] A) {
        if (A == null || A.length <= 1) return new ArrayList<>();

        int length = A.length;
        int[] sortedArr = new int[length];

        for (int i = 1; i <= length; i++) {
            sortedArr[i-1] = i;
        }
        if (Arrays.equals(A, sortedArr)) return new ArrayList<>();

        List<Integer> order = new ArrayList<>();
        int rightBorder = length-1;

//        System.out.println(Arrays.toString(A));

        while (true) {
            int max = 1;
            int maxIdx = -1;
            for (int i = 0; i < rightBorder; i++) {
                if (A[i] > max) {
                    max = A[i];
                    maxIdx = i;
                }
            }
            if (maxIdx == -1 || max == 1) break;
            else {
                if (maxIdx > 0) {
                    order.add(maxIdx + 1);
                    flip(A, maxIdx);
                }
                order.add(max);
                flip(A, max-1);
                rightBorder--;

//                System.out.println("Max val: " + max + ", max index: " + maxIdx + ", right border: " + rightBorder);
//                System.out.println(Arrays.toString(A));
            }
        }

//        System.out.println(Arrays.toString(A));
        return order;
    }

    /**
     * Reverses first k+1 elements of an array.
     * @param A - array of integers.
     * @param k - index of the rightest element to revers, inclusive.
     */
    private void flip(int[] A, int k) {
        int left = 0;
        int right = k;
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }
}
