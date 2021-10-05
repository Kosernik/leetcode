package Problems;

public class UglyNumber {

    /**
     * LeetCode #263. Ugly Number.
     *
     * @param n - an integer.
     * @return - true - if 'n' is an ugly number. An ugly number is a positive integer whose prime factors are limited
     * to 2, 3, and 5.
     */
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int curNum = n;

        while (curNum % 2 == 0) {
            curNum /= 2;
        }
        while (curNum % 3 == 0) {
            curNum /= 3;
        }
        while (curNum % 5 == 0) {
            curNum /= 5;
        }

        return curNum == 1;
    }
}
