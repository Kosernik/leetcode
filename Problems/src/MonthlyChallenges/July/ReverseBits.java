package MonthlyChallenges.July;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        solution.testReverseBits();
    }

    // you need treat n as an unsigned value
    public int reverseBitsAlt(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }

    /**
     * Разворачивает число.
     * @param n число, которое требуется развернуть
     * @return развернутое число
     */
    public int reverseBits(int n) {
        int reversedNumber = 0;

        for (int i = 0; i < 32; i++) {
            reversedNumber = setBit(reversedNumber, i, getBit(n, 31-i));
        }

        return reversedNumber;
    }

    // Изменяем бит
    private int setBit(int number, int idx, int digit) {
        if (digit == 1) {
            return number | 1 << idx;
        } else {
            return number & ~(1 << idx);
        }
    }
    // Читаем бит, находящийся по данному индексу
    private int getBit(int number, int idx) {return (number & (1<<idx))>>>idx;}

    private void testReverseBits() {
        String[] tests = {
                "00000010100101000001111010011100","00000000000000000000000000000000","11111111111111111111111111111111",
                "10101010101010101010101010101010","01010101010101010101010101010101","11111111111111110000000000000000",
                "00000000000000001111111111111111","11000000000000000000000000000000","00111111111111111111111111111111",
                "10000000000000000000000000000000","01111111111111111111111111111111","10000000000000000000000000000001",
                "01111111111111111111111111111110","11100111001111000001110100011011","00000000000000000000000000000001",
                "11111111111111111111111111111110"};
        String[] results = {
                "00111001011110000010100101000000","00000000000000000000000000000000","11111111111111111111111111111111",
                "01010101010101010101010101010101","10101010101010101010101010101010","00000000000000001111111111111111",
                "11111111111111110000000000000000","00000000000000000000000000000011","11111111111111111111111111111100",
                "00000000000000000000000000000001","00000000000000000000000000000001","10000000000000000000000000000001",
                "01111111111111111111111111111110","11011000101110000011110011100111","10000000000000000000000000000000",
                "01111111111111111111111111111111"};

        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int currTest = binaryToInteger(tests[i]);
            int curRes = reverseBits(currTest);

            if (curRes != Integer.reverse(currTest)) {
                failed++;
                System.out.println("Failed test #" + (i+1));
                System.out.println("Got: " + printBinary(curRes) + ", instead of: " + results[i]);
            }
        }

        System.out.println("Success rate: " + ((tests.length- failed)*100.0/tests.length));
    }

    public static int binaryToInteger(String binary){
        if (binary.length() < Integer.SIZE) return Integer.parseInt(binary, 2);

        int result = 0;
        byte[] bytes = binary.getBytes();

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 49) {
                result = result | (1 << (bytes.length - 1 - i));
            }
        }

        return result;
    }

    private static String printBinary(int number) {
        return String.format("%32s", Integer.toBinaryString(number)).replace(' ', '0');
    }
}
