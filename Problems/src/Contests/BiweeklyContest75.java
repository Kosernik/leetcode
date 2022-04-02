package Contests;

public class BiweeklyContest75 {

    public static void main(String[] args) {
        BiweeklyContest75 solution = new BiweeklyContest75();
    }

    //  1
    public int minBitFlips(int start, int goal) {
        int result = 0;
        if (start == goal) return result;

        for (int i = 0; i < 31; i++) {
            if (getLastBit(start) != getLastBit(goal)) {
                result++;
            }
            start = start >> 1;
            goal = goal >> 1;
        }
        return result;
    }

    private int getLastBit(int number) {
        return number & 1;
    }

    //  2
    public int triangularSum(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] summed = new int[nums.length-1];

        for (int i = 0; i < nums.length-1; i++) {
            summed[i] = (nums[i] + nums[i+1]) % 10;
        }

        return triangularSum(summed);
    }

    //  3
    public long numberOfWays(String s) {
        if (s.length() == 3) {
            if (s.equals("101") || s.equals("010")) return 1;
            return 0;
        }
        long result = 0L;
        int length = s.length();

        char[] digits = s.toCharArray();
        long[] countZeroBefore = new long[length+1];
        long[] countOnesBefore = new long[length+1];

        long[] countZeroAfter = new long[length+1];
        long[] countOnesAfter = new long[length+1];

        for (int i = 0; i < length; i++) {
            if (digits[i] == '0') {
                countZeroBefore[i+1] = countZeroBefore[i] + 1;
                countOnesBefore[i+1] = countOnesBefore[i];
            } else {
                countZeroBefore[i+1] = countZeroBefore[i];
                countOnesBefore[i+1] = countOnesBefore[i] + 1;
            }
        }

        for (int i = length-1; i >= 0; i--) {
            if (digits[i] == '0') {
                countZeroAfter[i] = countZeroAfter[i+1] + 1;
                countOnesAfter[i] = countOnesAfter[i+1];
            } else {
                countZeroAfter[i] = countZeroAfter[i+1];
                countOnesAfter[i] = countOnesAfter[i+1] + 1;
            }
        }

        for (int i = 1; i < length-1; i++) {
            if (digits[i] == '0') {
                result += countOnesBefore[i] * countOnesAfter[i];
            } else {
                result += countZeroBefore[i] * countZeroAfter[i];
            }
        }

        return result;
    }

    //  4
    public long sumScoresTLE(String s) {
        long result = s.length();

        char[] word = s.toCharArray();

        for (int i = 1; i < word.length; i++) {
            if (word[i] == word[0]) {
                result += lengthOfCommonPrefix(word, i);
            }
        }

        return result;
    }

    private long lengthOfCommonPrefix(char[] word, int secondIdx) {
        long result = 0L;
        int idx = 0;
        while (secondIdx < word.length) {
            if (word[idx] != word[secondIdx]) return result;
            result++;
            idx++;
            secondIdx++;
        }
        return result;
    }
}
