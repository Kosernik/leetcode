package MonthlyChallenges.Year22.September;

public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations solution = new SatisfiabilityOfEqualityEquations();

        String[] test0 = {"f==a", "a==b", "f!=e", "a==c", "b==e", "c==f"};
        System.out.println(solution.equationsPossible(test0) == false);

        String[] test1 = {"a==b", "e==c", "b==c", "a!=e"};
        System.out.println(solution.equationsPossible(test1) == false);
    }

    /**
     * LeetCode #990. Satisfiability of Equality Equations.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param equations - an array of equations "xi==yi" or "xi!=yi", xi and yi are lowercase letters
     * @return - true if it is possible to assign integers to variable names so as to satisfy all the given equations,
     * or false otherwise.
     */
    public boolean equationsPossible(String[] equations) {
        for (String eq : equations) {
            if (eq.charAt(1) == '!') continue;
            int first = eq.charAt(0) - 'a';
            int second = eq.charAt(3) - 'a';
            union(first, second);
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') continue;
            int first = eq.charAt(0) - 'a';
            int second = eq.charAt(3) - 'a';

            if (find(first) == find(second)) return false;
        }

        return true;
    }

    private final int[] unionGraph = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};

    private int find(int node) {
        if (unionGraph[node] == node) {
            return node;
        } else {
            return find(unionGraph[node]);
        }
    }

    private void union(int first, int second) {
        int parentFirst = find(first);
        int parentSecond = find(second);

        if (parentFirst != parentSecond) {
            unionGraph[parentSecond] = parentFirst;
        }
    }
}
