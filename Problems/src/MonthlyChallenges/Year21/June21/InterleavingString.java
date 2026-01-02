package MonthlyChallenges.Year21.June21;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString solution = new InterleavingString();

        String testS1 = "aabcc";
        String testS2 = "dbbca";
        String testS3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(testS1, testS2, testS3));
    }

    /**
     * LeetCode #97.
     */
    private Map<String, Boolean> computed;

    public boolean isInterleave(String s1, String s2, String s3) {
        computed = new HashMap<>();
        return helper(s1, s2, s3);
    }

    public boolean helper(String s1, String s2, String s3) {
        if (s1 == null && s2 == null) return false;
        else if (s1 == null || s1.length() == 0) {
            return s2.equals(s3);
        } else if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        } else if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (this.computed.containsKey(s1 + "*" + s2)) {
            return this.computed.get(s1 + "*" + s2);
        }

        int idxS1 = 0;
        int idxS2 = 0;
        int idxS3 = 0;

        while (idxS1 < s1.length() && idxS2 < s2.length() && s1.charAt(idxS1) != s2.charAt(idxS2)) {
            if (s1.charAt(idxS1) == s3.charAt(idxS3)) {
                idxS1++;
                idxS3++;
            } else if (s2.charAt(idxS2) == s3.charAt(idxS3)) {
                idxS2++;
                idxS3++;
            } else {
                this.computed.put(s1 + "*" + s2, false);
                return false;
            }
        }

        if (idxS1 == s1.length()) {
            boolean res = s2.substring(idxS2).equals(s3.substring(idxS3));
            this.computed.put(s1 + "*" + s2, res);
            return res;
        } else if (idxS2 == s2.length()) {
            boolean res = s1.substring(idxS1).equals(s3.substring(idxS3));
            this.computed.put(s1 + "*" + s2, res);
            return res;
        }

        if (s1.charAt(idxS1) == s2.charAt(idxS2)) {
            if (s1.charAt(idxS1) != s3.charAt(idxS3)) {
                this.computed.put(s1 + "*" + s2, false);
                return false;
            } else {
                boolean res = helper(s1.substring(idxS1 + 1), s2.substring(idxS2), s3.substring(idxS3 + 1))
                        || helper(s1.substring(idxS1), s2.substring(idxS2 + 1), s3.substring(idxS3 + 1));
                this.computed.put(s1 + "*" + s2, res);
                return res;
            }
        } else {
            this.computed.put(s1 + "*" + s2, false);
            return false;
        }
    }
}
