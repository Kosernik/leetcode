public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        int[] tests = {5, 8, 12, 7, 1, Integer.MAX_VALUE};
        int[] results = {2, 3, 4, 3, 1, 65535};
        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int currResult = arrangingCoins.arrangeCoins(tests[i]);
            if (currResult != results[i]) {
                failed++;
                System.out.println("Failed test № " + (i+1) + ", result is: " + currResult + ", should be: " + results[i]);
            }
        }
        System.out.println("Success rate is: " + (tests.length - failed)*100/tests.length + "%");
    }
    public int arrangeCoins(int n) {
        // n ~ k*(k+1)/2
        // 2n ~ k^2 + k
        // k^2 + k - 2n ~ 0
        // Ищем дискриминант и решаем квадратное уравнение, нужна целая часть положительного корня уравнения.
        double disc = Math.sqrt(1 + 8L * n);
        return (int) (disc / 2 - 0.5);
    }
}
