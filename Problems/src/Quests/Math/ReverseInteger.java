package Quests.Math;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger sol = new ReverseInteger();

        System.out.println(sol.reverse(1534236469));
        System.out.println(sol.reverse(-2147483412) + " " + -2143847412);
    }

    /**
     * LeetCode №7. Reverse Integer
     *
     * @param x - an integer.
     * @return - x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer
     * range [-2^31, 2^31 - 1], then returns 0.
     */
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) return 0;

        if (x < 0) return -1 * reverse(-x);

        int original = x;
        int mirrored = 0;

        while (original > 0) {
            mirrored = mirrored * 10 + original % 10;

            original /= 10;

            if (mirrored < 0 || mirrored > 214_748_364 && original > 0) return 0;
        }

        return mirrored;
    }
}
