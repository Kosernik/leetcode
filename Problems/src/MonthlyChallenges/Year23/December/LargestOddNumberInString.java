package MonthlyChallenges.Year23.December;

public class LargestOddNumberInString {

    /**
     * LeetCode №1903. Largest Odd Number in String.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param num - a string of digits without leading zeroes.
     * @return - the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty
     * string "" if no odd integer exists.
     */
    public String largestOddNumber(String num) {
        int endIdx = num.length() - 1;

        while (endIdx >= 0) {
            if (Character.getNumericValue(num.charAt(endIdx)) % 2 == 0) {
                endIdx--;
            } else {
                break;
            }
        }

        return num.substring(0, endIdx + 1);
    }
}
