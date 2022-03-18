package Problems;

public class WaterAndJugProblem {
    public static void main(String[] args) {
        WaterAndJugProblem solution = new WaterAndJugProblem();

        System.out.println(solution.gcd(3, 5));
        System.out.println(solution.gcd(5, 3));
        System.out.println(solution.gcd(2, 6));
        System.out.println(solution.gcd(6, 2));
    }

    /**
     * LeetCode #365. Water and Jug Problem.
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param jug1Capacity - the capacity of the first jug.
     * @param jug2Capacity - the capacity of the second jug.
     * @param targetCapacity - the target capacity.
     * @return - True - if it is possible to measure exactly targetCapacity of water. False - otherwise.
     */
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;

        int gcd = gcd(jug1Capacity, jug2Capacity);
        return targetCapacity % gcd == 0;
    }

    private int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
