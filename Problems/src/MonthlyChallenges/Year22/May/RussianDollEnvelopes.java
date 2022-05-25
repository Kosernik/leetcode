package MonthlyChallenges.Year22.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        RussianDollEnvelopes solution = new RussianDollEnvelopes();

        int[][] test2 = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        System.out.println(solution.maxEnvelopes(test2) == 5);

        int[][] test3 = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        System.out.println(solution.maxEnvelopes(test3) == 3);
    }


    /**
     * LeetCode #354. Russian Doll Envelopes.
     *
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param envelopes - a 2d array of positive integers.
     * @return - the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < envelopes.length; i++) {
            int[] envelope = envelopes[i];
            if (indexes.isEmpty() || isSecondBigger(envelopes[indexes.get(indexes.size()-1)], envelope)) {
                indexes.add(i);
            } else {
                int idx = binSearch(envelopes, envelope, indexes);
                indexes.set(idx, i);
            }
        }

        return indexes.size();
    }

    private int binSearch(int[][] envelopes, int[] envelope, List<Integer> indexes) {
        int left = 0, right = indexes.size()-1, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (isSecondBigger(envelopes[indexes.get(middle)], envelope)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private boolean isSecondBigger(int[] envelopeFirst, int[] envelopeSecond) {
        return envelopeSecond[0] > envelopeFirst[0] && envelopeSecond[1] > envelopeFirst[1];
    }
}
