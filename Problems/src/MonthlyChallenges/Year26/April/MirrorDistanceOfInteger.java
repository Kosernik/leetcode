package MonthlyChallenges.Year26.April;

public class MirrorDistanceOfInteger {

    /**
     * LeetCode №3783. Mirror Distance of an Integer.
     * <p>
     * Complexity - O(M), M = number of digits of n in decimal system.
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @return - the absolute difference between n and reverse of n.
     */
    public int mirrorDistance(int n) {
        return Math.abs(n - getReversed(n));
    }

    private int getReversed(int number) {
        int reversed = 0;

        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }

        return reversed;
    }
}
