package Problems;

import java.util.ArrayDeque;

public class DecodeString {

    /**
     * LeetCode #394. Decode String.
     *
     *
     * @param s - encoded string.
     * @return - decoded string.
     */
    public String decodeString(String s) {
        ArrayDeque<Integer> repeats = new ArrayDeque<>();
        ArrayDeque<StringBuilder> unrepeatedStrings = new ArrayDeque<>();
        repeats.push(1);
        unrepeatedStrings.push(new StringBuilder(""));

        char[] letters = s.toCharArray();
        int idx = 0;

        while (idx < letters.length) {
            if (Character.isDigit(letters[idx])) {
                int curRepeat = 0;
                while (idx < letters.length && Character.isDigit(letters[idx])) {
                    curRepeat = curRepeat * 10 + (letters[idx]-'0');
                    idx++;
                }
                repeats.push(curRepeat);
                idx--;
            } else if (letters[idx] == '[') {
                unrepeatedStrings.push(new StringBuilder());
            } else if (letters[idx] == ']') {
                StringBuilder currentBuilder = unrepeatedStrings.pop();
                int curRepeats = repeats.pop();

                String repeated = repeatString(currentBuilder.toString(), curRepeats);
                unrepeatedStrings.peek().append(repeated);
            } else {
                unrepeatedStrings.peek().append(letters[idx]);
            }
            idx++;
        }

        return unrepeatedStrings.peek().toString();
    }

    private String repeatString(String word, int repeats) {
        return String.valueOf(word).repeat(Math.max(0, repeats));
    }
}
