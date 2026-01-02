package MonthlyChallenges.Year21.January21;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
    public static void main(String[] args) {
        SmallestStringWithAGivenNumericValue solution = new SmallestStringWithAGivenNumericValue();

        String tst0 = solution.getSmallestString(3, 27);
        System.out.println(tst0 != null ? tst0 : "null");

        String tst1 = solution.getSmallestString(5, 73);
        System.out.println(tst1 != null ? tst1 : "null");

        String tst2 = solution.getSmallestString(24, 552);
        System.out.println(tst2 != null ? tst2 : "null");

        String tst3 = solution.getSmallestString(67, 882);
        System.out.println(tst3 != null ? tst3 : "null");
    }

    // LeetCode #1663.
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        Arrays.fill(result, 'a');

        int value = k - n;
        for (int i = n - 1; i >= 0 && value > 0; i--) {
            result[i] += Math.min(25, value);
            value -= Math.min(25, value);
        }

        return new String(result);
    }
}
