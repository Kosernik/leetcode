package MonthlyChallenges.Year23.August;

public class ExcelSheetColumnTitle {

    /**
     * LeetCode #168. Excel Sheet Column Title.
     *
     * @param columnNumber - the number of a column in an Excel sheet. 1-indexed. (A -> 1, Z -> 26, AA -> 27)
     * @return - the title of hte column
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            int remainder = (columnNumber - 1) % 26;
            char letter = (char) ('A' + remainder);

            result.append(letter);

            if (columnNumber > 26) {
                columnNumber = (columnNumber - 1) / 26;
            } else {
                break;
            }
        }

        result.reverse();
        return result.toString();
    }
}
