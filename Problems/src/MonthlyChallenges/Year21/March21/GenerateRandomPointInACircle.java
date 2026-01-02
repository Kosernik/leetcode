package MonthlyChallenges.Year21.March21;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomPointInACircle {
    private final double radius;
    private final double x_center;
    private final double y_center;

    // LeetCode #478.
    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double randomX = ThreadLocalRandom.current().nextDouble(this.radius);
        double randomY = ThreadLocalRandom.current().nextDouble(this.radius);

        if ((randomX * randomX + randomY * randomY <= this.radius * this.radius)) {
            double[] points = new double[2];
            int randomXSign = ThreadLocalRandom.current().nextInt(2);
            int randomYSign = ThreadLocalRandom.current().nextInt(2);
            randomX = randomXSign == 1 ? randomX : -randomX;
            randomY = randomYSign == 1 ? randomY : -randomY;
            points[0] = this.x_center + randomX;
            points[1] = this.y_center + randomY;
            return points;
        } else {
            return this.randPoint();
        }
    }
}
