package MonthlyChallenges.Year23.November;

public class CountNumberOfHomogenousSubstrings {
    public static void main(String[] args) {
        CountNumberOfHomogenousSubstrings solution = new CountNumberOfHomogenousSubstrings();

        String test0 = "abbcccaa";
        System.out.println(solution.countHomogenous(test0) == 13);

        String test1 = "xy";
        System.out.println(solution.countHomogenous(test1) == 2);

        String test2 = "zzzzz";
        System.out.println(solution.countHomogenous(test2) == 15);
    }

    /**
     * LeetCode #1759. Count Number of Homogenous Substrings.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - non-empty string
     * @return - the number of homogenous substrings of s. Result is modulo 10e9+7
     */
    public int countHomogenous(String s) {
        int MODULO = 1_000_000_000 + 7;
        long result = 0L;

        char[] letters = s.toCharArray();
        int idx = 0;

        while (idx < letters.length) {
            char curChar = letters[idx];
            int endIdx = idx;
            while (endIdx < letters.length && letters[endIdx] == curChar) {
                endIdx++;
            }

            long length = endIdx - idx;
            long numberOfSubstrings = length * (length + 1) / 2;

            result = (result + numberOfSubstrings) % MODULO;
            idx = endIdx;
        }

        return (int) result;
    }
}
