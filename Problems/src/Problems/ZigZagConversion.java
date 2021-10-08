package Problems;

public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion solution = new ZigZagConversion();
        String test0 = "PAYPALISHIRING";
        System.out.println(solution.convert(test0, 3));
    }

    /**
     * LeetCode #6. ZigZag Conversion.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string.
     * @param numRows - positive integer.
     * @return - a string "s" after writing it in a zigzag pattern.
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] lines = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) lines[i] = new StringBuilder();

        boolean down = true;
        int curLine = 0;

        for (char ch : s.toCharArray()) {
            lines[curLine].append(ch);

            if (curLine == 0) down = true;
            else if (curLine+1 == numRows) down = false;

            curLine = getLineNumber(curLine, numRows, down);
        }

        for (int i = 1; i < numRows; i++) {
            lines[0].append(lines[i]);
        }
        return lines[0].toString();
    }

    private static int getLineNumber(int line, int numRows, boolean down) {
        if (line+1 == numRows) return line-1;
        if (line == 0) return line+1;
        if (down) return line+1;
        return line-1;
    }
}
