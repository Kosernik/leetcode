package MonthlyChallenges.July;

import java.util.*;

public class UglyNumber2 {
    public static void main(String[] args) {
        UglyNumber2 solution = new UglyNumber2();

        System.out.println(solution.nthUglyNumber(11));


        int[] tests = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 100, 127, 542, 1000, 1689};
        int[] results = {1,2,3,4,5,6,8,9,10,12,15,16,18,20,1536,3240,1440000,51200000,2109375000};
        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int res = solution.nthUglyNumber(tests[i]);
            if (res != results[i]) {
                failed++;
                System.out.println("Failed test #" + (i+1) + ", got " + res + " instead of " + results[i]);
            }
        }
        System.out.println("Success rate: " + ((tests.length - failed)*100/tests.length));
    }

    public int nthUglyNumber(int n) {
        if (n <= 3) {
            return n;
        }

        TreeSet<Long> uglyNumbers = new TreeSet<>();
        uglyNumbers.add(1L);

        for (int i = 1; i < n; i++) {
            long currNum = uglyNumbers.pollFirst();
            long two = currNum * 2;
            long three = currNum * 3;
            long five = currNum * 5;
            if (two > 0) uglyNumbers.add(two);
            if (three > 0) uglyNumbers.add(three);
            if (five > 0) uglyNumbers.add(five);
        }

//        System.out.println(uglyNumbers.toString());
        return uglyNumbers.first().intValue();
    }
}
