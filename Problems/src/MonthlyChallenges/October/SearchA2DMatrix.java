package MonthlyChallenges.October;

public class SearchA2DMatrix {

    /**
     * Returns if a target is in a 2d matrix.
     *
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param matrix - 2d-array of integers. Integers in each row are sorted from left to right. The first integer of
     *               each row is greater than the last integer of the previous row.
     * @param target - integer number.
     * @return - true - if target value is in a matrix, false - otherwise.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int height = matrix.length;;
        int width = matrix[0].length;
        int size = height * width;

        int left = 0; int right = size-1;
        int middle; int row; int col;
        while (left <= right) {
            middle = (right - left) / 2 + left;

            row = middle / width;
            col = middle % width;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) {
                right = middle-1;
            }
            else {
                left = middle+1;
            }
        }
        return false;
    }
    // Test cases:
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            0
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            1
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            7
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            10
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            20
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            23
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            3
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            13
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            50
//            [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
//            333
//            []
//            0
//            [[1,2,3,4,6,7,8,9]]
//            0
//            [[1,2,3,4,6,7,8,9]]
//            1
//            [[1,2,3,4,6,7,8,9]]
//            3
//            [[1,2,3,4,6,7,8,9]]
//            5
//            [[1,2,3,4,6,7,8,9]]
//            8
//            [[1,2,3,4,6,7,8,9]]
//            9
//            [[1,2,3,4,6,7,8,9]]
//            11
//            [[1],[2],[3],[4],[6],[7],[8],[9]]
//            0
//            [[1],[2],[3],[4],[6],[7],[8],[9]]
//            1
//            [[1],[2],[3],[4],[6],[7],[8],[9]]
//            3
//            [[1],[2],[3],[4],[6],[7],[8],[9]]
//            5
//            [[1],[2],[3],[4],[6],[7],[8],[9]]
//            8
//            [[1],[2],[3],[4],[6],[7],[8],[9]]
//            9
//            [[1],[2],[3],[4],[6],[7],[8],[9]]
//            90

    // Results for test cases:
//        false
//        true
//        true
//        true
//        true
//        true
//        true
//        false
//        true
//        false
//        false
//        false
//        true
//        true
//        false
//        true
//        true
//        false
//        false
//        true
//        true
//        false
//        true
//        true
//        false
}
