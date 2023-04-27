package MonthlyChallenges.Year23.April;

public class BulbSwitcher {

    /**
     * LeetCode #319. Bulb Switcher.
     * <p>
     * Complexity - O(sqrt(n))
     * Memory - O(1)
     *
     * @param n - a non-negative integer.
     * @return - the number of turned on switches.
     */
    public int bulbSwitch(int n) {
        if (n <= 1) return n;

        int result = 0;
        int num = 1;
        while (num < 46341) {   //  46341 * 46341 = 2_147_488_281 (Integer overflow)
            if (num * num > n) {
                break;
            }

            result++;
            num++;
        }

        return result;
    }
}
