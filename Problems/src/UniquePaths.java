import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniques = new UniquePaths();

        int[][] tests = {{2,3},{7,3},{1,1},{1,7},{8,1},{17,7}};
        int[] results = {3, 28, 1, 1, 1, 74613};
        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int currResult = uniques.uniquePathsMemoryEff(tests[i][0], tests[i][1]);
            if (currResult != results[i]) {
                failed++;
                System.out.println("Failed test №" + i + ", grid dimensions: " + tests[i][0] + ", " + tests[i][1]);
                System.out.println("Got " + currResult + ", instead of: " + results[i]);
            }
        }
        System.out.println("Success: " + (tests.length - failed)*100.0/tests.length + "%");
    }

    public int uniquePathsMemoryEff(int m, int n) {
        // Одномерная площадка
        if (m == 1 || n == 1) {
            return 1;
        }
        // Одномерный массив, выполняющий роль верхнего ряда
        int[] grid = new int[n];
        // Заполняем единицами для первого (0-индекс) ряда
        Arrays.fill(grid, 1);

        // Первый ряд - всегда единицы, первая колонка (0-индекс) - всегда единицы
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                 int top = grid[col];
                 int left = grid[col-1];
                 grid[col] = top + left;
            }
        }

        return grid[n-1];
    }
    public int uniquePaths(int m, int n) {
        // Одномерная площадка
        if (m == 1 || n == 1) {
            return 1;
        }
        // Массив с суммами количества путей до каждой конкретной клетки
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int top = 0, left = 0;
                // Проверка выхода за пределы площадки
                if (row > 0) {top = grid[row-1][col];}
                if (col > 0) {left = grid[row][col-1];}
                // Суммируем количество путей, которыми можно добраться до верхней и до левой клетки и обновляем значение.
                grid[row][col] += (top + left);
            }
        }

        return grid[m-1][n-1];
    }
}
