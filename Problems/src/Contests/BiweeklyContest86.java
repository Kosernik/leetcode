package Contests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BiweeklyContest86 {

    public static void main(String[] args) {
        BiweeklyContest86 solution = new BiweeklyContest86();

    }

    //  1
    public boolean findSubarrays(int[] nums) {
        if (nums.length == 2) return false;

        Set<Integer> subSum = new HashSet<>();
        subSum.add(nums[0] + nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (!subSum.add(nums[i - 1] + nums[i])) {
                return true;
            }
        }

        return false;
    }


    //  2
    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base <= n - 2; base++) {
            List<Integer> converted = convertToBase(n, base);
            if (!isPalindrome(converted)) return false;
        }
        return true;
    }

    private List<Integer> convertToBase(int decimal, int base) {
        List<Integer> result = new ArrayList<>();

        while (decimal != 0) {
            result.add(decimal % base);
            decimal /= base;
        }

        return result;
    }

    private boolean isPalindrome(List<Integer> candidate) {
        int left = 0, right = candidate.size() - 1;

        while (left < right) {
            if (candidate.get(left++).intValue() != candidate.get(right--).intValue()) return false;
        }

        return true;
    }


    //  3
    public int maximumRows(int[][] mat, int cols) {
        if (cols == mat[0].length) return mat.length;

        int result = 0;
        int height = mat.length;
        int width = mat[0].length;

        List<Integer> binaryRows = new ArrayList<>();
        for (int[] row : mat) {
            int curBinaryRow = 0;
            for (int col = 0; col < width; col++) {
                if (row[col] == 1) {
                    curBinaryRow = curBinaryRow | (1 << col);
                }
            }
            binaryRows.add(curBinaryRow);
        }

        for (int mask = 1; mask < (int) Math.pow(2, width); mask++) {
            if (Integer.bitCount(mask) != cols) continue;

            int rowsSelected = height;
            for (int row : binaryRows) {
                boolean validRow = true;
                for (int i = 0; i < width; i++) {
                    if (!bitIsSet(mask, i) && bitIsSet(row, i)) {
                        validRow = false;
                        break;
                    }
                }
                if (!validRow) rowsSelected--;
            }

            result = Math.max(result, rowsSelected);
        }

        return result;
    }

    private boolean bitIsSet(int mask, int i) {
        return (mask & (1 << i)) != 0;
    }
}
