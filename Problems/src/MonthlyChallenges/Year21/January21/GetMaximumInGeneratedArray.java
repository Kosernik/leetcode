package MonthlyChallenges.Year21.January21;

public class GetMaximumInGeneratedArray {
    public static void main(String[] args) {
        GetMaximumInGeneratedArray solution = new GetMaximumInGeneratedArray();
        System.out.println(solution.getMaximumGenerated(7));
    }

    // LeetCode #1646.
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;

        int max = 1;
        int[] array = new int[n + 1];
        array[1] = 1;

        for (int i = 1; (2 * i + 1) <= n; i++) {
            array[2 * i] = array[i];
            array[2 * i + 1] = array[i] + array[i + 1];
            max = Math.max(max, array[2 * i]);
            max = Math.max(max, array[2 * i + 1]);
        }

        return max;
    }
}
