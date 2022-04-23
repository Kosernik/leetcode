package GoogleKickstart;

import java.util.Scanner;

public class PalindromicFactors {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int numberOfCases = scanner.nextInt();

            for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
                long number = scanner.nextLong();

                long result = countPalis(number);

                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }

    private static long countPalis(long number) {
        long count = 0;

        for (long i = 1; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (isPalindrome(i)) count++;
            }
        }
        for (long i = (long) Math.sqrt(number); i >= 1; i--) {
            if (number % (number / i) == 0) {
                if (isPalindrome(number / i)) count++;
            }
        }

        return count;
    }

    public static boolean isPalindrome(long x) {
        if (x < 0) return false;

        long p = x;
        long q = 0L;

        while (p >= 10L){
            q *=10L;
            q += p%10L;
            p /=10L;
        }

        return q == x / 10L && p == x % 10L;
    }
}
