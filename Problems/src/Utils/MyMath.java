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

    /**
     * Flips a bit at position.
     *
     * @param number - an integer.
     * @param bitIdx - an index at which the bit should be flipped.
     * @return - the number after flipping a bit at 'bitIdx' position.
     */
    public static int flipBit(int number, int bitIdx) {
        return number ^ (1 << bitIdx);
    }

    /**
     * Computes the power of big numbers. Result is returned modulo.
     *
     * @param base   - the number that needs to be powered.
     * @param power  - the exponent.
     * @param MODULO - an integer modulo.
     * @return - base raised to the power.
     */
    public static long pow(long base, long power, int MODULO) {
        if (power == 0) {
            return 1L;
        } else if (power == 1) {
            return base;
        }

        long result = pow(base, power / 2, MODULO);
        result = result * result % MODULO;

        if (power % 2 == 1) {
            result = result * base % MODULO;
        }

        return result;
    }
}
