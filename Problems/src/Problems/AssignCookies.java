package Problems;

import java.util.Arrays;

public class AssignCookies {
    /**
     * LeetCode #455. Assign Cookies.
     *
     * Complexity - O(GlogG + SlogS). G - g.length, S - s.length.
     * Memory - O(G + S), O(1)-for inplace sorting.
     *
     * @param g - an array of positive integers.
     * @param s - an array of positive integers.
     * @return - the number of content children.
     */
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;

        Arrays.sort(g);Arrays.sort(s);

        int numberOfKids = 0;

        int idxKids = 0;
        int idxCookie = 0;

        while (idxKids < g.length && idxCookie < s.length) {
            if (g[idxKids] <= s[idxCookie]) {
                numberOfKids++;
                idxKids++;
                idxCookie++;
            } else {
                while (idxCookie < s.length && g[idxKids] > s[idxCookie]) {
                    idxCookie++;
                }
            }
        }

        return numberOfKids;
    }
}
