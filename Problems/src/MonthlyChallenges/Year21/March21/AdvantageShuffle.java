package MonthlyChallenges.Year21.March21;

import java.util.*;

public class AdvantageShuffle {
    /**
     * LeetCode #870.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param A - array of integers
     * @param B - array of integers, A.length = B.length.
     * @return - a permutation of "A" that maximizes its advantage with respect to "B".
     */
    public int[] advantageCount(int[] A, int[] B) {
        int[] ASorted = A.clone();
        int[] BSorted = B.clone();

        Arrays.sort(ASorted);
        Arrays.sort(BSorted);

        Map<Integer, List<Integer>> pairs = new HashMap<>();
        List<Integer> unused = new ArrayList<>();

        int aIdx = 0;
        for (int b = 0, length = BSorted.length; b < length; b++) {
            while (aIdx < length && ASorted[aIdx] <= BSorted[b]) {
                unused.add(ASorted[aIdx]);
                aIdx++;
            }
            if (aIdx == length) break;
            List<Integer> vals = pairs.getOrDefault(BSorted[b], new ArrayList<>());
            vals.add(ASorted[aIdx]);
            pairs.put(BSorted[b], vals);
            aIdx++;
        }

        int[] result = new int[A.length];
        int idxUnused = 0;
        for (int i = 0; i < result.length; i++) {
            if (pairs.containsKey(B[i])) {
                List<Integer> values = pairs.get(B[i]);
                result[i] = values.remove(values.size() - 1);
                if (values.size() == 0) {
                    pairs.remove(B[i]);
                } else {
                    pairs.put(B[i], values);
                }
            } else {
                result[i] = unused.get(idxUnused);
                idxUnused++;
            }
        }

        return result;
    }
}
