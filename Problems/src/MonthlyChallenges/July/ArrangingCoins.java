package MonthlyChallenges.July;

public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        int[] tests = {5, 8, 12, 7, 1, Integer.MAX_VALUE};
        int[] results = {2, 3, 4, 3, 1, 65535};
        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int currResult = arrangingCoins.arrangeCoins(tests[i]);
            if (currResult != results[i]) {
                failed++;
                System.out.println("Failed test № " + (i+1) + ", result is: " + currResult + ", should be: " + results[i]);
            }
        }
        System.out.println("Success rate is: " + (tests.length - failed)*100/tests.length + "%");

        int differentResults = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (i % 1_000_000 == 0) {
                System.out.println(i + " tests run");
            }
            int mathResult = arrangingCoins.arrangeCoins(i);
            int binSearchResult = arrangingCoins.arrangeCoinsBinarySearch(i);
            if (mathResult != binSearchResult) {
                differentResults++;
                System.out.println("Got different results for " + i + ", " + mathResult + " " + binSearchResult);
            }
        }
        System.out.println("Number of different results: " + differentResults);
    }

    /**
     * LeetCode #441. Arranging Coins.
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @return - the number of complete rows.
     */
    public int arrangeCoins(int n) {
        // n ~ k*(k+1)/2
        // 2n ~ k^2 + k
        // k^2 + k - 2n ~ 0
        // Ищем дискриминант и решаем квадратное уравнение, нужна целая часть положительного корня уравнения.
        double disc = Math.sqrt(1 + 8L * n);
        return (int) (disc / 2 - 0.5);
    }


    /**
     * LeetCode #441. Arranging Coins.
     *
     * Complexity - O(logN), N = n
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @return - the number of complete rows.
     */
    public int arrangeCoinsBinarySearch(int n) {
        int left = 1, right = Math.min(n, 65535), middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (left == middle) {
                if (getNumberOfCoins(right) <= n) {
                    return right;
                } else {
                    return left;
                }
            }

            if (getNumberOfCoins(middle) == n) {
                return middle;
            } else if (getNumberOfCoins(middle) > n) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        return left;
    }
    private int getNumberOfCoins(int height) {
        return (int) (((long)height * ((long)height + 1)) / 2L);
    }
}
