package MonthlyChallenges.Year23.August;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    /**
     * LeetCode #68. Text Justification.
     *
     * @param words    - an array of words.
     * @param maxWidth - the maximum width of a line. words[i].length <= maxWidth
     * @return - a list of left-justified lines of words.
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        List<Integer> usedWords = new ArrayList<>();
        int curWordsLength = 0;

        for (int i = 0; i < words.length; i++) {
            int candidateLength = curWordsLength + usedWords.size() + words[i].length();

            if (candidateLength > maxWidth) {   // Can`t place current word on a line
                String currentLine = getJustifiedLine(words, maxWidth, usedWords, curWordsLength);

                result.add(currentLine);
                usedWords.clear();
                usedWords.add(i);
                curWordsLength = words[i].length();
            } else {    // Valid line
                usedWords.add(i);
                curWordsLength += words[i].length();
            }
        }

        if (!usedWords.isEmpty()) {
            StringBuilder lastLine = new StringBuilder();
            for (int idx : usedWords) {
                lastLine.append(words[idx]);
                lastLine.append(" ");
            }

            if (lastLine.length() < maxWidth) {
                lastLine.append(" ".repeat(maxWidth - lastLine.length()));
            }
            result.add(lastLine.substring(0, maxWidth));
        }
        return result;
    }

    private String getJustifiedLine(String[] words, int maxWidth, List<Integer> usedWords, int curWordsLength) {
        StringBuilder currentLine = new StringBuilder();

        if (usedWords.size() == 1) {
            String word = words[usedWords.get(0)];
            currentLine.append(word);
            String spaces = " ".repeat(maxWidth - word.length());
            currentLine.append(spaces);
            return currentLine.toString();
        }

        int spaces = maxWidth - curWordsLength;
        int minNumberOfSpaces = spaces / (usedWords.size() - 1);
        String spaceString = " ".repeat(Math.max(0, minNumberOfSpaces));
        int extraSpaces = spaces - (minNumberOfSpaces * (usedWords.size() - 1));

        for (int idx : usedWords) {
            currentLine.append(words[idx]);
            currentLine.append(spaceString);
            if (extraSpaces > 0) {
                currentLine.append(" ");
                extraSpaces--;
            }
        }

        return currentLine.substring(0, maxWidth);
    }
}
