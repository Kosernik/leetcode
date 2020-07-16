package MonthlyChallenges;

public class Pow {
    public static void main(String[] args) {
        Pow solution = new Pow();
        solution.testMyPow();
        System.out.println(solution.myPow(1.0, -2147483648));
    }
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            double curRes = myPow(x, n / 2);
            return curRes * curRes;
        } else if (n < 0) {
            return 1.0 / myPow(x, -n);
        } else if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        }

        double curRes = myPow(x, n/2);
        if (n % 2 != 0) {
            return x * curRes * curRes;
        } else {
            return curRes * curRes;
        }
    }

    private void testMyPow() {
        double[] numbers = {2.0, 2.1, 2};
        int[] powers = {10, 3, -2};
        double[] results = {1024, 9.261, 0.25};

        for (int i = 0; i < numbers.length; i++) {
            double res = myPow(numbers[i], powers[i]);
            System.out.println(res + " = " + results[i]);
        }
    }
}
