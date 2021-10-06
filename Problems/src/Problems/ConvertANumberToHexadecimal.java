package Problems;

public class ConvertANumberToHexadecimal {
    //"0"
    //"1a"
    //"ffffffff"    -
    //"fffffffe"    -
    //"1"
    //"fffffa6f"    -
    //"80000000"    -
    //"7fffffff"
    public static void main(String[] args) {
        ConvertANumberToHexadecimal solution = new ConvertANumberToHexadecimal();
        int[] tests = {0, 26, -1, -2, 1, -1425, -2147483648, 2147483647};

        for (int test : tests) {
            System.out.println(test + " - " + solution.toHex(test));
        }
    }

    /**
     * LeetCode #405. Convert a Number to Hexadecimal.
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param num - an integer.
     * @return - a string of a hexadecimal representation of "num".
     */
    public String toHex(int num) {
        if (num == 0) return "0";
        boolean negative = num < 0;

        StringBuilder res = new StringBuilder();
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        for (int i = 0; i < 8; i++) {
            int curCount = 0;
            for (int j = 0; j < 4; j++) {
                if ((num & 1) == 1) {
                    curCount += (int) Math.pow(2, j);
                }
                num = num >> 1;
            }

            res.append(hexDigits[curCount]);
        }

        res.reverse();

        if (negative) return res.toString();
        int startIdx = 0;
        while (res.charAt(startIdx) == '0') startIdx++;

        return res.substring(startIdx);
    }
}
