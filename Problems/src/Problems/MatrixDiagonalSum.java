package Problems;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        MatrixDiagonalSum solution = new MatrixDiagonalSum();

        System.out.println("Test 0");
        int[][] test0 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(solution.diagonalSum(test0));

        System.out.println("Test 3");
        int[][] test3 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        System.out.println(solution.diagonalSum(test3));
    }

    /**
     * LeetCode #1572. Matrix Diagonal Sum.
     *
     * Complexity - O(M), M = mat.length.
     * Complexity - O(1)
     *
     * @param mat - a square matrix
     * @return - the sum of numbers on the matrix diagonals.
     */
    public int diagonalSum(int[][] mat) {
        int sum;
        if (mat.length % 2 == 0) {
            sum = 0;
        } else {
            sum = mat[mat.length/2][mat.length/2];
        }

        int left = 0;
        int right = mat.length-1;

        for (int i = 0; i < mat.length/2; i++, left++, right--) {
            sum += mat[left][left] + mat[right][right] + mat[left][right] + mat[right][left];
        }

        return sum;
    }
}
