package MonthlyChallenges.Year22.April;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    private int[] unionFind;

    /**
     * LeetCode #1584. Min Cost to Connect All Points.
     *
     *
     * @param points - an array of coordinates of points.
     * @return - the cost of minimum spanning tree in graph with all points.
     */
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        unionFind = new int[length];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < length-1; i++) {
            int[] pointFirst = points[i];
            unionFind[i] = i;

            for (int j = i+1; j < length; j++) {
                int[] pointSecond = points[j];
                int cost = Math.abs(pointFirst[0] - pointSecond[0]) + Math.abs(pointFirst[1] - pointSecond[1]);
                Edge edge = new Edge(i, j, cost);
                priorityQueue.offer(edge);
            }
        }
        unionFind[length-1] = length-1;

        int result = 0;

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();

            if (union(edge.vertexA, edge.vertexB)) {
                result += edge.edgeCost;
            }
        }

        return result;
    }

    private int find(int vertex) {
        int parent = vertex;

        while (unionFind[parent] != parent) {
            parent = unionFind[parent];
        }

        return parent;
    }

    private boolean union(int vertexA, int vertexB) {
        int vAParent = find(vertexA);
        int vBParent = find(vertexB);

        if (vAParent == vBParent) {
            return false;   // Both vertices are already in the same union.
        }

        unionFind[vBParent] = vAParent;    // Connecting two unions.

        return true;
    }

    class Edge implements Comparable<Edge>{
        int edgeCost;
        int vertexA;
        int vertexB;

        public Edge(int vertexA, int vertexB, int edgeCost) {
            this.vertexA = vertexA;
            this.vertexB = vertexB;
            this.edgeCost = edgeCost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.edgeCost, o.edgeCost);
        }
    }
}
