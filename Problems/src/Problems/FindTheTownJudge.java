package Problems;

public class FindTheTownJudge {

    /**
     * LeetCode #997. Find the Town Judge.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n - the number of people in a town.
     * @param trust - an array of pairs representing trusts, trust[i] = {a, b}, 'a' - the index of a person who trusts
     *              the person 'b'.
     * @return - the label of the town judge if the town judge exists and can be identified, or -1 otherwise.
     */
    public int findJudge(int n, int[][] trust) {
        //  inTrust[i] is the number of people who trusts the person 'i'.
        int[] inTrust = new int[n+1];
        // outTrust[i] is the number of people who the person 'i' trusts.
        int[] outTrust = new int[n+1];
        inTrust[0] = -1;
        outTrust[0] = -1;

        for (int[] t : trust) {
            //  t[0] -trusts-> t[1]
            inTrust[t[1]]++;
            outTrust[t[0]]++;
        }

        for (int i = 1; i < inTrust.length; i++) {
            if (inTrust[i] == n-1 && outTrust[i] == 0) return i;
        }
        return -1;
    }
}
