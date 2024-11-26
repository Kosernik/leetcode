package MonthlyChallenges.Year24.November;

public class FindChampionII {

    /**
     * LeetCode №2924. Find Champion II.
     * <p>
     * Complexity - O(M+N), M = edges.length, N = n.
     * Memory - O(N)
     *
     * @param n     - the total number of teams.
     * @param edges - a directed acyclic graph. edges[i] = [teamA, teamB] means teamA is stronger than teamB.
     * @return -the champion of the tournament or -1 if there is no single champion.
     */
    public int findChampion(int n, int[][] edges) {
        boolean[] lost = new boolean[n];

        for (int[] edge : edges) {
            lost[edge[1]] = true;
        }

        int champion = -1;
        int teams = 0;

        for (int i = 0; i < lost.length; i++) {
            if (!lost[i]) {
                teams++;
                if (teams > 1) return -1;
                champion = i;
            }
        }

        return teams == 1 ? champion : -1;
    }
}
