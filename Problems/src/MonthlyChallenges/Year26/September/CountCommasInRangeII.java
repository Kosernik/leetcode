package MonthlyChallenges.Year26.September;

public class CountCommasInRangeII {
    public static void main(String[] args) {
        CountCommasInRangeII solution = new CountCommasInRangeII();

        long[] tests = {
                1002, 998, 1_002_000, 91_002_000, 610_052_000, 6_100_520_700L, 61_005_207_020L, 1_000_000_000_998L,
                1_000_000_000_000_000L, 613_005_207_020L, 3_613_005_207_020L, 43_613_005_207_020L, 543_613_005_207_020L
        };
        long[] results = {
                3, 0, 1003002, 181003002, 1219103002, 17300561103L, 182014620063L, 2998999002996L,
                3998998998999005L, 1838014620063L, 13451019827084L, 173451019827084L, 2173451019827084L
        };

        if (tests.length != results.length) {
            System.out.println("Почини тесты!!!");
            return;
        }

        for (int i = 0; i < tests.length; i++) {
            long res = solution.countCommas(tests[i]);
            System.out.println(i + " ? " + (res == results[i]));
            if (res != results[i]) {
                System.out.println(tests[i] + "\n" + res + "\n" + results[i] + ", diff = " + (res - results[i]));
                System.out.println();
            }
        }
        
        System.out.println("Done!");
    }

    /**
     * LeetCode №3871. Count Commas in Range.
     *
     * @param n - a positive integer. 1 <= n <= 10^15
     * @return - the total number of commas used when writing all integers from [1, n] (inclusive) in standard number
     * formatting.
     */
    public long countCommas(long n) {
        if (n < 1_000L) {
            return 0;
        } else if (n < 1_000_000L) {
            return n - 999;
        } else if (n < 1_000_000_000L) {
            return 999_000 + (n - 999_999) * 2;
        } else if (n < 1_000_000_000_000L) {
            return (n - 999_999_999) * 3 + 999_000_000L * 2 + 999_000;
        } else if (n < 1_000_000_000_000_000L) {
            return (n - 999_999_999_999L) * 4 + 999_000_000_000L * 3 + 999_000_000L * 2 + 999_000;
        } else {
            return 5 + countCommas(n - 1);
        }
    }
}
