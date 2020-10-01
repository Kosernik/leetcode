package MonthlyChallenges.September;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> indexes = new HashMap<>();
        Map<Integer, String> names = new HashMap<>();

        int idx = 0;
        for (List<String> eq : equations) {
            if (!indexes.containsKey(eq.get(0))) {
                indexes.put(eq.get(0), idx);
                names.put(idx, eq.get(0));
                idx++;
            }
            if (!indexes.containsKey(eq.get(1))) {
                indexes.put(eq.get(1), idx);
                names.put(idx, eq.get(1));
                idx++;
            }
        }

        Double[][] graph = new Double[idx+1][idx+1];

        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            graph[indexes.get(first)][indexes.get(second)] = values[i];
            graph[indexes.get(second)][indexes.get(first)] = 1 / values[i];
        }

        List<Double> result = new ArrayList<>();

        for (List<String> query : queries) {
            String first = query.get(0);
            String second = query.get(1);
            if (!indexes.containsKey(first) || !indexes.containsKey(second)) {
                result.add(-1.0);
            } else if (first.equals(second)){
                result.add(1.0);
            } else {
                result.add(bfs(indexes.get(first), indexes.get(second), graph));
            }
        }

        double[] res = new double[result.size()];
        int i = 0;
        for (Double r : result) {
            res[i++] = r;
        }
        return res;
    }

    private double bfs(int idxFirst, int idxSecond, Double[][] graph) {
        if (graph[idxFirst][idxSecond] != null) return graph[idxFirst][idxSecond];
        else {
            Double result = null;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < graph.length; i++) {
                if (graph[idxFirst][i] != null) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int currIndex = queue.poll();
                if (currIndex == idxSecond) {

                }
            }
        }
    }
}
