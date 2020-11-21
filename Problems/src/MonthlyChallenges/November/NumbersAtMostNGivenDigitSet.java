package MonthlyChallenges.November;

public class NumbersAtMostNGivenDigitSet {
    public static void main(String[] args) {
        NumbersAtMostNGivenDigitSet solution = new NumbersAtMostNGivenDigitSet();

        String[] tst0 = {"1","4","9"};
        int n0 = 1_000_000_000;
        System.out.println(solution.atMostNGivenDigitSet(tst0, n0) + ", should be: " + 29523);

        System.out.println("\n-------------");
        String[] tst1 = {"1","2","3"};
        int n1 = 123456789;
        System.out.println(solution.atMostNGivenDigitSet(tst1, n1) + ", should be: " + 14214);

        System.out.println("\n-------------");
        String[] tst2 = {"1","3","5","7"};
        int n2 = 100;
        System.out.println(solution.atMostNGivenDigitSet(tst2, n2) + ", should be: " + 20);

        System.out.println("\n-------------");
        String[] tst3 = {"1","2","3"};
        int n3 = 223;
        System.out.println(solution.atMostNGivenDigitSet(tst3, n3) + ", should be: " + 27);

        System.out.println("\n-------------");
        String[] tst4 = {"1","2","3"};
        int n4 = 123;
        System.out.println(solution.atMostNGivenDigitSet(tst4, n4) + ", should be: " + 18);
    }

    /**
     * LeetCode #902
     * @param digits - array of digits from 1 to 9, represented as strings.
     * @param n - max number
     * @return - total number of possible integers.
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        if (digits == null || digits.length == 0) return 0;

//        int[] parsedDigits = new int[digits.length];
//        for (int i = 0; i < digits.length; i++) {
//            parsedDigits[i] = digits[i].charAt(0) - '0';
//        }

        String parsedN = String.valueOf(n);
        int lengthOfN = parsedN.length();
        int result = 0;
        int numberOfDigits = digits.length;

        for (int i = 1; i < lengthOfN; i++) {
            result += (int) Math.pow(numberOfDigits, i);
        }
//
//        int numOfDigitsInN = (int) Math.log10(n);
//        int result = 0;
//        for (int i = 1; i <= numOfDigitsInN; i++) {
//            result += (int) Math.pow(digits.length, i);
//        }
//
//        System.out.println("Pre res: " + result);

        for (int i = 0; i < lengthOfN; i++) {
            boolean sameDigit = false;

            for (String digit : digits) {
                if (digit.charAt(0) < parsedN.charAt(i)) {
                    result += (int) Math.pow(numberOfDigits, lengthOfN - i - 1);
                } else if (digit.charAt(0) == parsedN.charAt(i)) {
                    sameDigit = true;
                }
            }
            if (!sameDigit) return result;
        }
//
//        if (n > (int) Math.pow(10, numOfDigitsInN)) {
//            int firstDigit = n / ((int) Math.pow(10, numOfDigitsInN));
//            int numOfCombins = (int) Math.pow(digits.length, numOfDigitsInN);
//            System.out.println("Number of combinations: " + numOfCombins);
//            for (int digit : parsedDigits) {
//                if (digit < firstDigit) {
//                    result += numOfCombins;
//                } else if (digit == firstDigit) {
//
//                }
//            }
//        }
        return result+1;
    }


    public int atMostNGivenDigitSetTLE(String[] digits, int n) {
        if (digits == null || digits.length == 0) return 0;

        int result = 0;
        int[] parsedDigits = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            parsedDigits[i] = digits[i].charAt(0) - '0';
        }

        for (int number : parsedDigits) {
            result += backtrack(number, parsedDigits, n);
        }
        return result;
    }

    private int backtrack (int number, int[] parsedDigits, int n) {
        if (number > n) return 0;
        else if (number == n) return 1;

        int currRes = 1;

        for (int digit : parsedDigits) {
            currRes += backtrack(number*10 + digit, parsedDigits, n);
        }

        return currRes;
    }
}
