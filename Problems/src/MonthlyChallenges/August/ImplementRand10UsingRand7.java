package MonthlyChallenges.August;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ImplementRand10UsingRand7 {
    public static void main(String[] args) {
//        for (int i = 1; i <= 7; i++) {
//            System.out.print(i + "\t");
//            System.out.println(i%3);
//        }
//        for (int i = 1; i <= 7; i++) {
//            System.out.print(i + "\t");
//            System.out.println(i%4);
//        }
        Solution solution = new Solution();
        int[] count = new int[11];
        for (int i = 0; i <= 100; i++) {
            int num = solution.rand10();
            count[num]++;
        }
        System.out.println(Arrays.toString(count));
    }

}

class SolBase {
    public int rand7() {
        return ThreadLocalRandom.current().nextInt(1,8);
    }
}

class Solution extends SolBase {
    public int rand10() {
        int rowNum;
        int colNum;
        int res = 0;
        do {
            rowNum = rand7();
            colNum = rand7();
            res = rowNum + (colNum - 1) * 7;
        } while (res > 40);

        return 1 + (res-1) % 10;
    }
}
