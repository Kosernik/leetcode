package MonthlyChallenges.July;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        AllPathsFromSourceToTarget solution = new AllPathsFromSourceToTarget();
        int[][] test0 = {{1,2},{3},{3},{}};
        List<List<Integer>> result0 = solution.allPathsSourceTarget(test0);
        System.out.println("Testing");
        for (List<Integer> lst : result0) {
            System.out.println(lst.toString());
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) return paths;

        backtrackHelper(graph, paths, 0, graph.length, new ArrayList<>());

        return paths;
    }

    private void backtrackHelper (int[][] graph, List<List<Integer>> paths, int nodeNumber, int length, List<Integer> currentPath) {
        if (nodeNumber == length-1) {
            List<Integer> res = new ArrayList<>(currentPath);
            res.add(nodeNumber);
            paths.add(res);
        }
        currentPath.add(nodeNumber);

        for (int node : graph[nodeNumber]) {
            backtrackHelper(graph, paths, node, length, currentPath);
        }

        currentPath.remove(currentPath.size()-1);
    }
}
