package MonthlyChallenges.November21;

import java.util.*;

public class NumberOfValidWordsForEachPuzzle {
    public static void main(String[] args) {
        NumberOfValidWordsForEachPuzzle solution = new NumberOfValidWordsForEachPuzzle();

        String[] test0words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] test0puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        List<Integer> test0result = solution.findNumOfValidWords(test0words, test0puzzles);

        for (Integer i : test0result) System.out.print(i + "\t");
        System.out.println();


        String[] test1words = {"apple","pleas","please"};
        String[] test1puzzles = {"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};
        List<Integer> test1result = solution.findNumOfValidWords(test1words, test1puzzles);

        for (Integer i : test1result) System.out.print(i + "\t");
        System.out.println();
    }

    /**
     * LeetCode #1178. Number of Valid Words for Each Puzzle.
     *
     * @param words - an array of strings, each word consist of lowercase English letters.
     * @param puzzles - an array of strings, each puzzle consist of lowercase English letters, does not contain repeated
     *               characters, puzzles[i].length == 7.
     * @return - an array "answer", where answer[i] is the number of words in the given word list words that is valid
     *              with respect to the puzzle puzzles[i].
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> bitMasks = new HashMap<>();
        for (String word : words) {
            int bitMask = getBitMask(word);
            bitMasks.put(bitMask, bitMasks.getOrDefault(bitMask, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (String puzzle : puzzles) {
            int firstLetter = 1 << (puzzle.charAt(0)-'a');
            int curCount = bitMasks.getOrDefault(firstLetter, 0);
            int puzzleBitMask = getBitMask(puzzle.substring(1));

            for(int subMask = puzzleBitMask; subMask > 0; subMask = (subMask-1) & puzzleBitMask) {
                curCount += bitMasks.getOrDefault(subMask | firstLetter, 0);
            }

            result.add(curCount);
        }

        return result;
    }

    private int getBitMask(String word) {
        int bitMask = 0;

        char[] letters = word.toCharArray();

        for (char letter : letters) {
            bitMask |= (1 << (letter - 'a'));
        }

        return bitMask;
    }
}
