public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance solution = new HammingDistance();
        System.out.println(solution.testHammingDistance() ? "Finished all tests successfully" : "Wrong implementation");
    }

    public int hammingDistance(int x, int y) {
        // Два одинаковых числа - нет необходимости считать разницу.
        if (x == y) return 0;
        int distance = 0;
        // Для каждой позиции, кроме позиции-знака, читаем биты и сравниваем их.
        for (int i = 0; i < 31; i++) {
            int curr = 1 << i;
            int digitInX = x & curr;
            int digitInY = y & curr;
            // Биты отличаются, увеличиваем расстояние на 1.
            if (digitInX != digitInY) distance++;
        }
        return distance;
    }
    private boolean testHammingDistance() {
        int[][] tests = {{1,4},{0,1},{0,0},{1,1},{15,2478},{1235781,1025},{Integer.MAX_VALUE,Integer.MAX_VALUE}};
        int[] results = {2,1,0,0,5,11,0};
        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int currResult = hammingDistance(tests[i][0], tests[i][1]);
            if (currResult != results[i]) {
                failed++;
                System.out.println("Failed test# " + (i + 1) + ", should be: " + results[i] + ", got: " + currResult);
            }
        }
        System.out.println("Success rate: " + (tests.length - failed)*100/tests.length + "%");
        return failed == 0;
    }
}
