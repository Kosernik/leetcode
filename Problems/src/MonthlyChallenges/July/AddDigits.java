package MonthlyChallenges.July;

public class AddDigits {
    public static void main(String[] args) {
        AddDigits solution = new AddDigits();
        solution.testAddDigits();
    }
    public int addDigits(int num) {
        if (num < 10) return num;
        else {
            int added = 0;
            while (num > 9) {
                added += num % 10;
                num /= 10;
            }
            added += num;
            return addDigits(added);
        }
    }
    private void testAddDigits() {
        int[] tests = {38, 1, 9, 11, 254, 27247, 12114567, 12854, 5783};
        int[] results = {2,1, 9,  2,   2,     4,        9,     2,    5};
        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int currResult = addDigits(tests[i]);
            if (currResult != results[i]) {
                failed++;
                System.out.println("Wrong result for number: " + tests[i] + " ,got: " + currResult + " ,instead of: " + results[i]);
            }
        }
        System.out.println("Success rate: " + ((tests.length-failed)*100.0/tests.length));
    }
}
