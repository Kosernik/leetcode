package MonthlyChallenges.March21;

public class IntegerToRoman {

    /**
     * LeetCode #12.
     *
     * Converts an integer into a roman number.
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param num - an integer, 1 <= num <= 3999.
     * @return - roman representation of a number.
     */
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        while (num >= 1000) {
            result.append('M');
            num -= 1000;
        }
        if (num >= 900) {
            result.append("CM");
            num -= 900;
        }

        while (num >= 500) {
            result.append('D');
            num -= 500;
        }
        if (num >= 400) {
            result.append("CD");
            num -= 400;
        }

        while (num >= 100) {
            result.append("C");
            num -= 100;
        }
        if (num >= 90) {
            result.append("XC");
            num -= 90;
        }

        while (num >= 50) {
            result.append('L');
            num -= 50;
        }
        if (num >= 40) {
            result.append("XL");
            num -= 40;
        }

        while (num >= 10) {
            result.append("X");
            num -= 10;
        }
        if (num >= 9) {
            result.append("IX");
            num -= 9;
        }

        while (num >= 5) {
            result.append("V");
            num -= 5;
        }
        if (num >= 4) {
            result.append("IV");
            num -= 4;
        }

        while (num >= 1) {
            result.append("I");
            num -= 1;
        }

        return result.toString();
    }
}
