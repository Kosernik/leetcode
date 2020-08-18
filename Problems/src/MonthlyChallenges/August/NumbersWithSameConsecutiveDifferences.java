package MonthlyChallenges.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences solution = new NumbersWithSameConsecutiveDifferences();

        int[] tst0 = solution.numsSameConsecDiff(3, 7);
        System.out.println(Arrays.toString(tst0));

        int[] tst1 = solution.numsSameConsecDiff(2, 1);
        System.out.println(Arrays.toString(tst1));

        int[] tst2 = solution.numsSameConsecDiff(2, 0);
        System.out.println(Arrays.toString(tst2));

    }

    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            fillListWithNumbers(N, K, numbers, i, 1, i);
        }

        int[] res = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            res[i] = numbers.get(i);
        }
        return res;
    }

    private void fillListWithNumbers(int N, int K, List<Integer> numbers, int number, int index, int prevDigit) {
        if (index >= N) {
            numbers.add(number);
            return;
        }

        int currNumber = number * 10;

        for (int i = 0; i <= 9; i++) {
            if (Math.abs(prevDigit - i) == K) {
                fillListWithNumbers(N, K, numbers, currNumber + i, index+1, i);
            }
        }
    }
}
