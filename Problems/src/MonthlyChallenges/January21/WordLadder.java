package MonthlyChallenges.January21;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

    }

    /**
     * LeetCode #127.
     *
     * @param beginWord - start string of english lower case letters.
     * @param endWord - target string of english lower case letters.
     * @param wordList - a list of words without duplicates.
     * @return - minimum number of steps to reach "endWord" by changing 1 symbol in "beginWord" at a time.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int steps = 1;
        int length = beginWord.length();

        while (!queue.isEmpty()) {
            for (int q = queue.size(); q > 0; q--) {
                String curr = queue.poll();

                for (int i = 0; i < length; i++) {
                    char[] letters = curr.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        letters[i] = ch;
                        String nextWord = new String(letters);

                        if (nextWord.equals(endWord)) return steps + 1;

                        if (words.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                }
            }
            steps++;
        }

        return 0;
    }
}
