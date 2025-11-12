package Utils;

public class MyUtility {

    /**
     * Greatest Common Divider
     *
     * @param a - a positive integer.
     * @param b - a positive integer.
     * @return - the greatest common divider.
     */
    public static int gcd(int a, int b) {
        // Euclidean algorithm iteratively
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    /**
     * Greatest Common Divider
     *
     * @param a - a positive integer.
     * @param b - a positive integer.
     * @return - the greatest common divider.
     */
    public static int gcdRecursive(int a, int b) {
        if (b == 0) return a;
        return gcdRecursive(b, a % b);
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

    /**
     * Checks if a given letter is a lowercase english vowel.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param letter - a char.
     * @return - true if a given letter is a lowercase english vowel, false - otherwise.
     */
    public static boolean isLowerCaseVowel(char letter) {
        // 0x104111 = bitmask for vowels = 0b00000000000100000100000100010001
        // (letter - 97) = (letter - 'a')
        // >> shift bitmask to the index of a given letter
        return ((0x104111 >> (letter - 97)) & 1) == 1;
    }

    /**
     * Checks if a given letter is an uppercase english vowel.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param letter - a char.
     * @return - true if a given letter is a uppercase english vowel, false - otherwise.
     */
    public static boolean isUpperCaseVowel(char letter) {
        // 0x104111 = bitmask for vowels = 0b00000000000100000100000100010001
        // (letter - 65) = (letter - 'A')
        // >> shift bitmask to the index of a given letter
        return ((0x104111 >> (letter - 65)) & 1) == 1;
    }

    /**
     * Checks if a given letter is an english vowel.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param letter - a char.
     * @return - true if a given letter is an english vowel, false - otherwise.
     */
    public static boolean isVowel(char letter) {
        return ((0x104111 >> (letter - 97)) & 1) == 1 || ((0x104111 >> (letter - 65)) & 1) == 1;
    }
}
