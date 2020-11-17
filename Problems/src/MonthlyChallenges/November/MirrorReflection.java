package MonthlyChallenges.November;

public class MirrorReflection {

    /**
     * LeetCode #858.
     *
     * @param p - side of a square
     * @param q - distance from '0' to the point where laser first touches a wall.
     * @return - the number of the receptor that the ray meets first.
     */
    public int mirrorReflection(int p, int q) {
        if (p == q) return 1;
        else if (q == 0) return 0;

        int gcd = gcd(p, q);
        if (gcd != 1) {
            return mirrorReflection(p/gcd, q/gcd);
        }

        if (p % 2 == 0) {
            if (q % 2 == 0) {
                return 0;
            } else {
                return 2;
            }
        } else {
            if (q % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    private int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
