package MonthlyChallenges;

import java.util.Arrays;

public class PrisonCellsAfterNDays {
    public static void main(String[] args) {
        PrisonCellsAfterNDays solution = new PrisonCellsAfterNDays();
        solution.testPrisonAfterNDays();
    }

    /**
     * Метод возвращает расположение арестантов в тюрьме из 8 камер после N-дней
     * Если в двух соседних камерах есть арестанты или они обе пустые, то на следующий день в данной камере появляется
     * новый арестант.В противном случае камера освобождается.
     * @param cells Начальное расположение арестантов.
     * @param N Количество дней.
     * @return Итоговое расположение арестантов после N-дней.
     */
    public int[] prisonAfterNDays(int[] cells, int N) {
        // Конвертируем массив в число
        int number = convertToNumber(cells);
        // Каждые 14 дней расположение повторяется, следовательно нет необходимости считать полное количество дней.
        int modul = N % 14;

        // Высчитываем расположение после первого дня.
        int prev = 0;
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                prev = getBit(number, 7);
                number = setBit(number, 7, 0);
            } else if (i == 7) {
                number = setBit(number, 0, 0);
            } else {
                if (prev == getBit(number, 6-i)) {
                    prev = getBit(number, 7-i);
                    number = setBit(number, 7-i, 1);
                } else {
                    prev = getBit(number, 7-i);
                    number = setBit(number, 7-i, 0);
                }
            }
        }

        // Если модуль итогового количества дней равен 1, то сразу возвращаем результат.
        if (modul == 1) return convertToArray(number);

        // Считаем расположение арестантов
        if (modul == 0) {
            modul = 14;
        }
        for (int i = 2; i <= modul; i++) {
            prev = 0;
            // Крайние камеры всегда пустые, нет необходимости их считать.
            for (int j = 1; j < 7; j++) {
                if (prev == getBit(number, 6-j)) {
                    prev = getBit(number, 7-j);
                    number = setBit(number, 7-j, 1);
                } else {
                    prev = getBit(number, 7-j);
                    number = setBit(number, 7-j, 0);
                }
            }
        }

        return convertToArray(number);
    }
    // Конвертируем массив в число, где первые 8 бит обозначают камеры
    private int convertToNumber(int[] cells) {
        int number = 0;
        for (int i = 0; i < 8; i++) {
            if (cells[i] == 1) {
                number = setBit(number, 7-i, 1);
            }
        }
        return number;
    }
    // Конвертируем первые 8 бит числа в массив
    private int[] convertToArray(int number) {
        int[] cells = new int[8];
        for (int i = 0; i < 8; i++) {
            cells[i] = (number & 1<<(7-i)) == (1<<(7-i)) ? 1 : 0;
        }
        return cells;
    }
    // Изменяем бит
    private int setBit(int number, int idx, int digit) {
        if (digit == 1) {
            return number | 1 << idx;
        } else {
            return number & ~(1 << idx);
        }
    }
    // Читаем бит, находящийся по данному индексу
    private int getBit(int number, int idx) {return (number & 1<<idx)>>>idx;}


    private void testPrisonAfterNDays() {
        //  Тесты
        int[][] tests = {
                {0,1,0,1,1,0,0,1},{1,0,0,1,0,0,1,0},{1,0,0,1,0,0,1,0},{1,0,0,1,0,0,1,0},{1,0,0,1,0,0,1,0},
                {1,0,0,1,0,0,1,0},{0,1,0,1,1,0,0,1},{1,0,0,1,0,0,1,0},{1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},
                {1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},
                {1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},
                {1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0},{1,1,0,1,1,0,0,0}};
        int[] days = {
                7, 1000000000, 1000000, 123872, 128,
                18, 70, 718, 1, 2,
                3, 4, 5, 6, 7,
                8, 9, 10, 11, 12,
                13, 14, 15, 16};
        int[][] results = {
                {0,0,1,1,0,0,0,0},{0,0,1,1,1,1,1,0},{0,1,0,0,1,0,0,0},{0,0,1,1,1,0,0,0},{0,1,0,1,0,0,1,0},
                {0,0,1,0,0,0,1,0},{0,0,0,0,1,1,0,0},{0,0,1,0,0,0,1,0},{0,0,1,0,0,0,1,0},{0,0,1,0,1,0,1,0},
                {0,0,1,1,1,1,1,0},{0,0,0,1,1,1,0,0},{0,1,0,0,1,0,0,0},{0,1,0,0,1,0,1,0},{0,1,0,0,1,1,1,0},
                {0,1,0,0,0,1,0,0},{0,1,0,1,0,1,0,0},{0,1,1,1,1,1,0,0},{0,0,1,1,1,0,0,0},{0,0,0,1,0,0,1,0},
                {0,1,0,1,0,0,1,0},{0,1,1,1,0,0,1,0},{0,0,1,0,0,0,1,0},{0,0,1,0,1,0,1,0}};
        int failed = 0;
        long startTime, endTime;
        long total = 0;
        for (int i = 0; i < tests.length; i++) {
            startTime = System.nanoTime();
            int[] curResult = prisonAfterNDays(tests[i], days[i]);
            endTime = System.nanoTime();
            total += (endTime - startTime);
            if (!Arrays.equals(curResult, results[i])) {
                failed++;
                System.out.println("Failed test #" + i + ", got " + Arrays.toString(curResult) + ", instead of : " + Arrays.toString(results[i]));
            }
        }

        System.out.println("Time: " + total + " nanoseconds");
        System.out.println("Total number of tests: " + tests.length);
        System.out.println("Success rate: " + (tests.length - failed)*100.0 / tests.length + "%");
    }
}
