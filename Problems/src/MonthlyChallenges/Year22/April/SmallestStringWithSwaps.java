package MonthlyChallenges.Year22.April;

import java.util.*;

public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        SmallestStringWithSwaps solution = new SmallestStringWithSwaps();

        String testS0 = "vbjjxgdfnru";
        //  [[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]
        //
        List<List<Integer>> testPairs0 = new ArrayList<>();

        List<Integer> a = new ArrayList<>(); a.add(8); a.add(6);
        testPairs0.add(a);
        List<Integer> b = new ArrayList<>(); b.add(3); b.add(4);
        testPairs0.add(b);
        List<Integer> c = new ArrayList<>(); c.add(5); c.add(2);
        testPairs0.add(c);
        List<Integer> d = new ArrayList<>(); d.add(5); d.add(5);
        testPairs0.add(d);
        List<Integer> e = new ArrayList<>(); e.add(3); e.add(5);
        testPairs0.add(e);
        List<Integer> f = new ArrayList<>(); f.add(7); f.add(10);
        testPairs0.add(f);
        List<Integer> g = new ArrayList<>(); g.add(6); g.add(0);
        testPairs0.add(g);
        List<Integer> h = new ArrayList<>(); h.add(10); h.add(0);
        testPairs0.add(h);
        List<Integer> i = new ArrayList<>(); i.add(7); i.add(1);
        testPairs0.add(i);
        List<Integer> j = new ArrayList<>(); j.add(4); j.add(8);
        testPairs0.add(j);
        List<Integer> k = new ArrayList<>(); k.add(6); k.add(2);
        testPairs0.add(k);

        System.out.println(solution.smallestStringWithSwaps(testS0, testPairs0).equals("bdfgjjnuvrx"));
    }


    private int[] unionFind;
    private int[] unionSize;

    /**
     * LeetCode #1202. Smallest String With Swaps.
     *
     * @param s - a string of lower case English letters.
     * @param pairs - a list of pairs of indices.
     * @return - the lexicographically smallest string that 's' can be changed to after using the swaps.
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs == null || pairs.size() == 0 || s == null || s.length() <= 1) return s;

        char[] word = s.toCharArray();
        char[] resultWord = new char[s.length()];

        unionFind = new int[s.length()];
        unionSize = new int[s.length()];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
            unionSize[i] = 1;
        }

        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> unions = new HashMap<>();

        for (int i = 0; i < unionFind.length; i++) {
            int parent  = find(i);
            unions.putIfAbsent(parent, new ArrayList<>());

            List<Integer> neighbours = unions.get(parent);
            neighbours.add(i);
        }

        for (List<Integer> indexes : unions.values()) {
            List<Character> letters = new ArrayList<>();
            for (int idx : indexes) letters.add(word[idx]);

            Collections.sort(letters);

            for (int i = 0; i < indexes.size(); i++) {
                resultWord[indexes.get(i)] = letters.get(i);
            }
        }

        return new String(resultWord);
    }

    private void union(int first, int second) {
        int firstParent = find(first);
        int secondParent = find(second);

        if (firstParent != secondParent) {
            if (unionSize[firstParent] >= unionSize[secondParent]) {
                unionFind[secondParent] = firstParent;
                unionSize[firstParent] += unionSize[secondParent];
            } else {
                unionFind[firstParent] = secondParent;
                unionSize[secondParent] += unionSize[firstParent];
            }
        }
    }

    private int find(int x) {
        int parent = x;
        while (unionFind[parent] != parent) {
            parent = unionFind[parent];
        }
        return parent;
    }
}
