package MonthlyChallenges.Year21.January21;

public class CountSortedVowelStrings {
    // LeetCode #1641.
    public int countVowelStrings(int n) {
        if (n == 1) return 5;
        int[] letters = helper(n, 1, new int[]{1, 1, 1, 1, 1});

        int res = 0;
        for (int l : letters) res += l;
        return res;
    }

    private int[] helper(int n, int currentN, int[] letters) {
        if (currentN == n) return letters;

        int[] res = new int[5];
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                res[i] += letters[j];
            }
        }

        return helper(n, currentN + 1, res);
    }
}
