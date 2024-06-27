package MonthlyChallenges.Year24.June;

public class FindCenterOfStarGraph {

    /**
     * LeetCode №1791. Find Center of Star Graph.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param edges - an edges of a valid star graph.
     * @return - the center of a star graph.
     */
    public int findCenter(int[][] edges) {
        if (edges[1][0] == edges[0][0] || edges[1][0] == edges[0][1]) return edges[1][0];
        else return edges[1][1];
    }
}
