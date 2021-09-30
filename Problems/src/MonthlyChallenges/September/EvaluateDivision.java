package MonthlyChallenges.September;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();

        List<List<String>> testEq0 = new ArrayList<>();
        testEq0.add(Arrays.asList("a", "b"));
        testEq0.add(Arrays.asList("b", "c"));
        double[] testVals0 = {2.0,3.0};
        List<List<String>> testQu0 = new ArrayList<>();
        testQu0.add(Arrays.asList("a","c"));
        testQu0.add(Arrays.asList("b","a"));
        testQu0.add(Arrays.asList("a","e"));
        testQu0.add(Arrays.asList("a","a"));
        testQu0.add(Arrays.asList("x","x"));

        System.out.println(Arrays.toString(solution.calcEquation(testEq0, testVals0, testQu0)));
    }

    /**
     * LeetCode #399. Evaluate Division.
     *
     *
     * @param equations - a list of equations where equations[i] = [Ai, Bi].
     * @param values - an array of values where values[i] = Ai / Bi.
     * @param queries - a list of queries where queries[j] = [Cj, Dj]
     * @return - an array of answers Cj / Dj = ? for each query or -1.0 if there is no answer.
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);

            List<Pair> curListA = graph.getOrDefault(eq.get(0), new ArrayList<>());
            curListA.add(new Pair(eq.get(1), values[i]));
            graph.put(eq.get(0), curListA);

            List<Pair> curListB = graph.getOrDefault(eq.get(1), new ArrayList<>());
            curListB.add(new Pair(eq.get(0), 1.0 / values[i]));
            graph.put(eq.get(1), curListB);
        }

        double[] result = new double[queries.size()];

        for (int q = 0; q < queries.size(); q++) {
            List<String> curQ = queries.get(q);
            String first = curQ.get(0);
            String second = curQ.get(1);
            if (!graph.containsKey(first) || !graph.containsKey(second)) {
                result[q] = -1.0;
            } else if (first.equals(second)){
                result[q] = 1.0;
            } else {
                boolean found = false;
                for (Pair pair : graph.get(first)) {
                    if (pair.name.equals(second)) {
                        result[q] = pair.value;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Map<String, String> path = new HashMap<>();
                    if (bfs(graph, path, first, second, new HashSet<>())) {
                        result[q] = computeValue(graph, path, first, second);
                    } else {
                        result[q] = -1.0;
                    }
                }
            }
        }

        return result;
    }
    private double computeValue(Map<String, List<Pair>> graph, Map<String, String> path, String first, String second) {
        String node = second;
        double result = 1.0;

        while (!node.equals(first)) {
            String A = path.get(node);
            for (Pair pair : graph.get(A)) {
                if (pair.name.equals(node)) {
                    result *= pair.value;
                    break;
                }
            }
            node = A;
        }

        return result;
    }

    private boolean bfs(Map<String, List<Pair>> graph, Map<String, String> path, String node, String second,
                        Set<String> visited) {
        if (node.equals(second)) return true;

        for (Pair pair : graph.get(node)) {
            if (!visited.contains(pair.name)) {
                visited.add(pair.name);
                path.put(pair.name, node);
                if (bfs(graph, path, pair.name, second, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    class Pair {
        String name;
        double value;
        public Pair (String name, double value) {
            this.name = name;
            this.value = value;
        }
    }
}
