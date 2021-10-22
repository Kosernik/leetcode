package Problems;


public class PerfectNumber {

    /**
     * LeetCode #507. Perfect Number.
     *
     * @param num - a positive integer. 1 <= num <= 100_000_000.
     * @return - true - if "num" is a perfect number, false - otherwise.
     */
    public boolean checkPerfectNumber(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8_128 || num == 33_550_336;
    }
}
