package MonthlyChallenges.August;

public class PowerOfFour {
    public static void main(String[] args) {
        PowerOfFour solution = new PowerOfFour();

        solution.testIsPowerOfFour();
    }
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;

        int pow = (int) (Math.log(num) / Math.log(4));

        return (int)Math.pow(4, pow) == num;
    }

    private void testIsPowerOfFour() {
        int[] tests = {16,5,-1,0,1,2136750624,2136750625,2136750626,2147483647,2097273616};
        boolean[] results = {true,false,false,false,true,false,false,false,false,false};

        for (int i = 0; i < tests.length; i++) {
            System.out.println(isPowerOfFour(tests[i]) == results[i] ?
                    "Success" :
                    ("Failed test " + tests[i] + ", got: " + !results[i]));
        }
    }
}
