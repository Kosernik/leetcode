package MonthlyChallenges.Year24.March;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        MinimumLengthOfStringAfterDeletingSimilarEnds solution = new MinimumLengthOfStringAfterDeletingSimilarEnds();

        String test1 = "cabaabac";
        String test2 = "aabccabba";

        System.out.println(solution.minimumLength(test1) == 0);
        System.out.println("--------");
        System.out.println(solution.minimumLength(test2) == 3);
    }

    /**
     * LeetCode №1750. Minimum Length of String After Deleting Similar Ends.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string.
     * @return - the minimum length of s after deleting similar ends.
     */
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;

        while (true) {
            if (left > right) return 0;
            else if (left == right) return 1;

            char ending = s.charAt(left);
            if (ending != s.charAt(right)) return right - left + 1;

            while (left <= right && s.charAt(left) == ending) {
                left++;
            }
            while (right >= left && ending == s.charAt(right)) {
                right--;
            }
        }
    }
}
