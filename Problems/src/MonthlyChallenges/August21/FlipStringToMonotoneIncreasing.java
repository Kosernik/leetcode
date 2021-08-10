package MonthlyChallenges.August21;

import java.util.Arrays;

public class FlipStringToMonotoneIncreasing {
    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing solution = new FlipStringToMonotoneIncreasing();

        String test0 = "00110";
        System.out.println(solution.minFlipsMonoIncr(test0));
    }

    // LeetCode #926.
    public int minFlipsMonoIncr(String s) {
        int length = s.length();
        int[] zeroesAfter = new int[length+1];

        for (int i = length-1; i >= 0; i--) {
            zeroesAfter[i] = zeroesAfter[i+1];
            if (s.charAt(i) == '0') {
                zeroesAfter[i] += 1;
            }
        }

        int result = length;
        int ones = 0;

        for (int i = 0; i < length; i++) {
            int curRes = ones + zeroesAfter[i+1];
            result = Math.min(result, curRes);
            if (s.charAt(i) == '1') ones++;
        }

        return result;
    }
}
