package MonthlyChallenges;

public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter solution = new IslandPerimeter();
        solution.testIslandPerimeter();
    }

    public int islandPerimeter(int[][] grid) {
        int length = grid.length, width = grid[0].length;
        int[][] perimeters = new int[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 0) {
                    perimeters[i][j] = 0;
                } else {
                    int currPerim = 4;
                    if (i > 0 && grid[i-1][j] == 1) currPerim--;
                    if (i < (length-1) && grid[i+1][j] == 1) currPerim--;
                    if (j > 0 && grid[i][j-1] == 1) currPerim--;
                    if (j <(width-1) && grid[i][j+1] == 1) currPerim--;
                    perimeters[i][j] = currPerim;
                }
            }
        }
        int perimeter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                perimeter += perimeters[i][j];
            }
        }
        return perimeter;
    }
    public int islandPerimeterFast(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int length = grid.length, width = grid[0].length;

        int perimeter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    int currPerim = 4;
                    if (i > 0 && grid[i-1][j] == 1) currPerim--;
                    if (i < (length-1) && grid[i+1][j] == 1) currPerim--;
                    if (j > 0 && grid[i][j-1] == 1) currPerim--;
                    if (j <(width-1) && grid[i][j+1] == 1) currPerim--;
                    perimeter += currPerim;
                }
            }
        }
        return perimeter;
    }
    private void testIslandPerimeter() {
        int[][] test0 = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        int[][] test1 = {{0,0,1,1,1,0}};
        int[][] test2 = {{0},{1},{1},{1},{0}};
        int[][] test3 = {
                {1,1,1,0,0,1},
                {0,1,1,1,0,1},
                {0,0,1,1,1,1},
                {0,0,0,1,1,0}};
        int[][] test4 = {
                {0,0,1,0},
                {0,1,1,0},
                {1,1,0,0},
                {1,0,0,0},
                {1,1,1,1}};
        int[][][] tests = new int[5][][];
        tests[0] = test0; tests[1] = test1; tests[2] = test2; tests[3] = test3; tests[4] = test4;
        int[] results = {16,8,8,24,22};

        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int curRes = islandPerimeter(tests[i]);
            int currFast = islandPerimeterFast(tests[i]);
            if (curRes != results[i]) {
                failed++;
                System.out.println("Failed test #" + i);
                System.out.println("Got: " + curRes + ", instead of " + results[i]);
            }
            if (curRes != currFast) {
                System.out.println("Wrong result for faster method");
                System.out.println("Got: " + currFast + ", instead of " + results[i]);
            }
        }
        System.out.println("Success rate: " + (tests.length-failed)*100.0 / tests.length);
    }
}
