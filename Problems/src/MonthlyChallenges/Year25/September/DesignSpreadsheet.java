package MonthlyChallenges.Year25.September;

import java.util.HashMap;
import java.util.Map;

public class DesignSpreadsheet {
    public static void main(String[] args) {
        DesignSpreadsheet solution = new DesignSpreadsheet();
        solution.test();
    }

    public void test() {
        //["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]
        //[__________[3], __["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ____["A1"], _["=A1+B2"]]

        System.out.println("Initializing");
        Spreadsheet test0 = new Spreadsheet(3);

        System.out.println("Getting value for (5 + 7)");
        System.out.println(test0.getValue("=5+7") == 12);

        System.out.println("Setting value for cell A1");
        test0.setCell("A1", 10);
        System.out.println(test0.getCellValue(1, 0) == 10);

        System.out.println("Getting value for (A1 + 6)");
        System.out.println(test0.getValue("=A1+6") == 16);

        System.out.println("Setting value for cell B2");
        test0.setCell("B2", 15);
        System.out.println(test0.getCellValue(2, 1) == 15);

        System.out.println("Getting value for (A1 + B2)");
        System.out.println(test0.getValue("=A1+B2") == 25);

        System.out.println("Resetting value for A1 to 0");
        test0.resetCell("A1");
        System.out.println(test0.getCellValue(1, 0) == 0);

        System.out.println("Getting value for (A1 + B2)");
        System.out.println(test0.getValue("=A1+B2") == 15);
    }

    /**
     * LeetCode №3484. Design Spreadsheet.
     */
    class Spreadsheet {
        //  [column -> [row -> value]]
        private final Map<Integer, Map<Integer, Integer>> table;

        public Spreadsheet(int rows) {
            this.table = new HashMap<>();
        }

        public void setCell(String cell, int value) {
            int[] coordinates = parseCell(cell);
            int row = coordinates[0], column = coordinates[1];

            if (!table.containsKey(column)) {
                table.put(column, new HashMap<>());
            }

            table.get(column).put(row, value);
        }

        public void resetCell(String cell) {
            int[] coordinates = parseCell(cell);
            int row = coordinates[0], column = coordinates[1];

            if (table.containsKey(column)) {
                table.get(column).remove(row);
            }
        }

        public int getValue(String formula) {
            int first = 0;
            int second = 0;

            int idx = 1;

            if (Character.isAlphabetic(formula.charAt(idx))) {
                int column = formula.charAt(idx) - 'A';
                idx++;
                int row = 0;

                while (formula.charAt(idx) != '+') {
                    row = row * 10 + (formula.charAt(idx) - '0');
                    idx++;
                }

                first = getCellValue(row, column);
            } else {
                while (formula.charAt(idx) != '+') {
                    first = first * 10 + (formula.charAt(idx) - '0');
                    idx++;
                }
            }
            idx++;

            if (Character.isAlphabetic(formula.charAt(idx))) {
                int column = formula.charAt(idx) - 'A';
                idx++;
                int row = 0;

                while (idx < formula.length()) {
                    row = row * 10 + (formula.charAt(idx) - '0');
                    idx++;
                }

                second = getCellValue(row, column);
            } else {
                while (idx < formula.length()) {
                    second = second * 10 + (formula.charAt(idx) - '0');
                    idx++;
                }
            }

            return first + second;
        }

        private int getCellValue(int row, int column) {
            if (!table.containsKey(column)) return 0;
            return table.get(column).getOrDefault(row, 0);
        }

        /**
         * Parses string name of a cell end returns numeric indices of the cell.
         *
         * @param cell - a string representation of a cell coordinate. Example: "G435"
         * @return - a pair {row, column} of indices of the cell.
         */
        private int[] parseCell(String cell) {
            int column = cell.charAt(0) - 'A';

            int row = 0;

            for (int i = 1; i < cell.length(); i++) {
                row = row * 10 + (cell.charAt(i) - '0');
            }

            return new int[]{row, column};
        }
    }
}
