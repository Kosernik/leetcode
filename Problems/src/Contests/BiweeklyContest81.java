package Contests;

public class BiweeklyContest81 {

    public static void main(String[] args) {
        BiweeklyContest81 solution = new BiweeklyContest81();

        solution.test("Hello world!");
    }

    private void test(String input) {
        System.out.println(input);
    }

    //  1
    public int countAsterisks(String s) {
        int result = 0;
        boolean count = true;

        char[] letters = s.toCharArray();
        for (char ch : letters) {
            if (ch == '|') {
                count = !count;
            } else if (ch == '*' && count) {
                result++;
            }
        }

        return result;
    }

    //  2
    private int[][] unionFind;
    public long countPairs(int n, int[][] edges) {
        unionFind = new int[n][2];
        for (int i = 0; i < n; i++) {
            unionFind[i][0] = i;
            unionFind[i][1] = 1;
        }

        connectNodes(edges);

        long result = 0;
        for (int i = 0; i < n; i++) {
            if (unionFind[i][0] == i) {
                result += ((long) unionFind[i][1] * (n - unionFind[i][1]));
            }
        }
        return result / 2;
    }

    private void connectNodes(int[][] edges) {
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
    }
    private void union(int first, int second) {
        int parentFirst = find(first);
        int parentSecond = find(second);

        if (parentFirst == parentSecond) return;

        unionFind[parentSecond][0] = parentFirst;
        unionFind[parentFirst][1] += unionFind[parentSecond][1];
    }
    private int find(int node) {
        while (unionFind[node][0] != node) {
            unionFind[node][0] = unionFind[unionFind[node][0]][0];
            node = unionFind[node][0];
        }
        return node;
    }


}
