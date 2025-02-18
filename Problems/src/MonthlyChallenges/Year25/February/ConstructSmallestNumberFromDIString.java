package MonthlyChallenges.Year25.February;

public class ConstructSmallestNumberFromDIString {

    /**
     * LeetCode №2375. Construct Smallest Number From DI String.
     *
     * @param pattern - a string of 'D' and 'I'.
     * @return - the lexicographically smallest possible string num.
     */
    public String smallestNumber(String pattern) {
        int[] number = new int[pattern.length() + 1];

        char[] patternLetters = pattern.toCharArray();

        boolean[] usedDigits = new boolean[10];

        for (int i = 1; i <= 9; i++) {
            number[0] = i;
            usedDigits[i] = true;

            if (constructNumber(1, number, patternLetters, usedDigits)) {
                StringBuilder result = new StringBuilder();
                for (int digit : number) {
                    result.append(digit);
                }
                return result.toString();
            }

            usedDigits[i] = false;
        }

        return "";
    }

    private boolean constructNumber(int idx, int[] number, char[] pattern, boolean[] usedDigits) {
        if (idx == number.length) return true;

        if (number[idx] != 0) return constructNumber(idx + 1, number, pattern, usedDigits);

        int prevDigit = number[idx - 1];
        char command = pattern[idx - 1];

        if (command == 'D') {
            if (prevDigit == 1) return false;

            for (int candidate = prevDigit - 1; candidate >= 1; candidate--) {
                if (!usedDigits[candidate]) {
                    usedDigits[candidate] = true;
                    number[idx] = candidate;

                    if (constructNumber(idx + 1, number, pattern, usedDigits)) {
                        return true;
                    }

                    number[idx] = 0;
                    usedDigits[candidate] = false;
                }
            }
        } else {    // command == 'I
            if (prevDigit == 9) return false;

            for (int candidate = prevDigit + 1; candidate <= 9; candidate++) {
                if (!usedDigits[candidate]) {
                    usedDigits[candidate] = true;
                    number[idx] = candidate;

                    if (constructNumber(idx + 1, number, pattern, usedDigits)) {
                        return true;
                    }

                    number[idx] = 0;
                    usedDigits[candidate] = false;
                }
            }
        }

        return false;
    }
}
