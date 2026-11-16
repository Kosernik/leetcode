package MonthlyChallenges.Year26.November;

public class CalculateDigitSumOfString {
    public static void main(String[] args) {
        CalculateDigitSumOfString solution = new CalculateDigitSumOfString();

        String s0 = "11111222223";
        int k0 = 3;
        String answer0 = "135";
        String result0 = solution.digitSum(s0, k0);
        System.out.println(result0 + " " + answer0);

        String s1 = "00000000";
        int k1 = 3;
        String answer1 = "000";
        String result1 = solution.digitSum(s1, k1);
        System.out.println(result1 + " " + answer1);

        String s2 = "11100011222223";
        int k2 = 3;
        String answer2 = "711";
        String result2 = solution.digitSum(s2, k2);
        System.out.println(result2 + " " + answer2);
    }

    /**
     * LeetCode №2243. Calculate Digit Sum of a String.
     * <p>
     * A round can be completed if the length of s is greater than k. In one round, do the following:
     * *   1. Divide s into consecutive groups of size k such that the first k characters are in the first group, the
     * next k characters are in the second group, and so on. Note that the size of the last group can be smaller than k.
     * *   2. Replace each group of s with a string representing the sum of all its digits. For example, "346" is
     * replaced with "13" because 3 + 4 + 6 = 13.
     * *   3. Merge consecutive groups together to form a new string. If the length of the string is greater than k,
     * repeat from step 1.
     *
     * @param s - a string of digit characters.
     * @param k - a positive integer. k > 1.
     * @return - s after all rounds have been completed.
     */
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i += k) {
            int number = 0;

            for (int j = i; j < s.length() && j < (i + k); j++) {
                number += s.charAt(j) - '0';
            }

            if (number == 0) {
                builder.append('0');
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while (number > 0) {
                temp.append((char) ('0' + number % 10));
                number /= 10;
            }
            builder.append(temp.reverse());
        }

        return digitSum(builder.toString(), k);
    }
}
