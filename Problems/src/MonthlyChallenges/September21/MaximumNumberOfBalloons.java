package MonthlyChallenges.September21;

public class MaximumNumberOfBalloons {
    /**
     * LeetCode #1189. Maximum Number of Balloons.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param text - a string of lower case English letters.
     * @return - the maximum number of strings "ballon" that can be formed with chars of input string "text".
     */
    public int maxNumberOfBalloons(String text) {
        int bCount = 0;
        int aCount = 0;
        int lCount = 0;
        int oCount = 0;
        int nCount = 0;

        for (char ch : text.toCharArray()) {
            if (ch == 'b') bCount++;
            else if (ch == 'a') aCount++;
            else if (ch == 'l') lCount++;
            else if (ch == 'o') oCount++;
            else if (ch == 'n') nCount++;
        }
        lCount /=2;
        oCount /=2;

        return Math.min(Math.min(bCount, aCount), Math.min(lCount, Math.min(oCount, nCount)));
    }
}
