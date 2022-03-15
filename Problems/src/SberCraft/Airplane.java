package SberCraft;

public class Airplane {
    public static void main(String[] args) {
        int numberOfErrors = 0;
        for (int x = 1; x < 100; x++) {
            for (int y = 1; y < 100; y++) {
                int first = brokenDevice(x, y);
                int second = brokenDeviceAlt(x, y);
                if (first != second) {
                    System.out.println("X: " + x + " y: " + y + "\t" + first + "\t" + second + "\t");
                    numberOfErrors++;
                }
            }
        }
        System.out.println("Number of errors: " + numberOfErrors);
    }

    public static int brokenDevice(int x, int y) {
        //int ans = 0;
        //while ( y > x + 1 ) {
        //    if ( y % 2 == 0 ) {
        //        y += 1;
        //        x += 1;
        //    } else {
        //        y /= 2;
        //    }
        //}
        //return ans + x - y;
        if (x == y) return 0;
        if (x > y) return x - y;

        if (y % 2 == 0) {
            return brokenDevice(x, y / 2) + 1;
        } else {
            return brokenDevice(x, y + 1) + 1;
        }
    }

    public static  int brokenDeviceAlt(int x, int y) {
        int ans = 0;

        while (y > x) {
            if (y % 2 == 0) {
                y /= 2;
            } else {
                y += 1;
            }
            ans++;
        }

        return ans + (x-y);
    }
}
