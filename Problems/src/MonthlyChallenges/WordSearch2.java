package MonthlyChallenges;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    public static void main(String[] args) {

    }

    boolean[][] visitedChars;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> existingWords = new ArrayList<>();
        // Проходим по массиву слов и ищем каждое из них на доске
        for (String word : words) {
            if (ifExists(board, word)) {
                // Слово найдено, добавляем его в результат
                existingWords.add(word);
            }
        }
        return existingWords;
    }

    /**
     * Метод проверяет есть ли данное слово на доске
     * @param board Доска из букв
     * @param word Искомое слово
     * @return True - если слово есть на доске, False - если данного слова нет на доске
     */
    private boolean ifExists (char[][] board, String word) {
        // Реинициализация таблицы использованных букв
        visitedChars = new boolean[board.length][board[0].length];
        char firstChar = word.charAt(0);
        // Проход по доске в поисках первой буквы слова
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == firstChar) {
                    if (backTrackSearch(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Бэктрэк-рекурсивный поиск слова на доске
     * @param board Доска из букв, из которых
     * @param word Искомое слово
     * @param row Номер строки
     * @param col Номур колонки
     * @param index Индекс буквы в слове
     * @return True - если слово есть на доске, False - если данного слова нет на доске
     */
    private boolean backTrackSearch(char[][] board, String word, int row, int col, int index) {
        // Все буквы найдены, возращаем True
        if (word.length() == index) {
            return true;
        }
        // Проверка на: выход за пределы доски, соответствие буквы на доске и буквы в слове, была-ли уже использована данная ячейка на доске
        if (0 > row || row >= board.length || 0 > col || col >= board[0].length || board[row][col] != word.charAt(index) || visitedChars[row][col]) {
            return false;
        }
        // Помечаем ячейку как использованную
        visitedChars[row][col] = true;
        // Ищем следующую букву искомого слова на соседних ячейках
        if (backTrackSearch(board, word, row+1, col, index+1) ||
                backTrackSearch(board, word, row-1, col, index+1) ||
                backTrackSearch(board, word, row, col+1, index+1) ||
                backTrackSearch(board, word, row, col-1, index+1)){
            // Один из вызовов метода вернул True, следовательно слово найдено на доске
            return true;
        }
        // Помечаем ячейку как неиспользованную
        visitedChars[row][col] = false;
        // Слово отсутствует на доске
        return false;
    }
}
