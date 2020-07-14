package MonthlyChallenges;

import java.util.Map;

public class AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        AngleBetweenHandsOfAClock solution = new AngleBetweenHandsOfAClock();
        solution.testAngleClock();
    }

    public double angleClock(int hour, int minutes) {
        // Считаем отдельно угол между 0 и минутной стрелкой, и между 0 и часовой стрелкой.
        double minuteDegree = minutes * 6.0;
        double hourDegree = (hour%12) * 30.0 +(30.0 * (minutes / 60f));

        double angle = minuteDegree > hourDegree ? minuteDegree - hourDegree : hourDegree - minuteDegree;
        if (angle > 180) {
            angle = 360 - angle;
        }
        return angle;
    }

    private void testAngleClock(){
        int[][] tests = {{12,30},{3,30},{3,15},{4,50},{12,0},{9,35},{9,55},{1,57}};
        double[] results = {165, 75, 7.5, 155, 0, 77.5, 32.5, 76.5};

        int failed = 0;

        for (int i = 0; i < tests.length; i++) {
            double currRes = angleClock(tests[i][0], tests[i][1]);
            if (currRes != results[i]) {
                failed++;
                System.out.println("Failed test #" + i + " , got: " + currRes + " , should be: " + results[i]);
            }
        }

        System.out.println("Success rate: " + (tests.length - failed)*100.0 / tests.length);
    }
}
