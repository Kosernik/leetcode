package Problems;

public class Base7 {

    /**
     * LeetCode #504. Base 7.
     *
     * @param num - an integer.
     * @return - the string representation of "num" in base 7.
     */
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();

        boolean negative = num < 0;
        while (num != 0) {
            result.append(Math.abs(num % 7));
            num /= 7;
        }

        if (negative) result.append("-");
        result.reverse();
        return result.toString();
    }
}
