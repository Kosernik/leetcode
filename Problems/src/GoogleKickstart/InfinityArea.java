package GoogleKickstart;

import java.util.Scanner;

public class InfinityArea {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int numberOfCases = scanner.nextInt();

            for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
                int r = scanner.nextInt();
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                double result = getAreas(r, a, b);
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }

    private static double getAreas(int r, int a, int b) {
        long curRadius = r;
        double squares = Math.PI * curRadius * curRadius;

        while (curRadius != 0L) {
            curRadius = curRadius * a;
            squares += Math.PI * curRadius * curRadius;

            curRadius = curRadius / b;
            squares += Math.PI * curRadius * curRadius;
        }

        return squares;
    }
}
