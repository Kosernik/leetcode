package Utils;

public class MyMath {
    /**
     * Greatest Common Divider
     *
     * @param a - a positive integer.
     * @param b - a positive integer.
     * @return - the greatest common divider.
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


    /**
     * Least Common Multiple
     *
     * @param a - a positive integer.
     * @param b - a positive integer.
     * @return - the least common multiple.
     */
    public static int lcm(int a, int b) {
        long product = (long) a * b;

        return (int) (product / gcd(a, b));
    }
}
