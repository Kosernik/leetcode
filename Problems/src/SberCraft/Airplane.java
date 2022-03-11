package SberCraft;

public class Airplane {

    public static int brokenDevice(int x, int y) {
        //int ans = 0;
        //while ( y > x + 1 ) {
        //    if ( y % 2 == 0 ) {
        //        y += 1;
        //        x += 1;
        //    } else {
        //        y /= 2;
        //    }
        //    ans++;
        //}
        //return ans + x - y;
        if (x == y) return 0;
        if (x > y) return x - y;

        int ans = 0;
        while (y > x) {
            if (y % 2 == 0) {
                y /= 2;
            } else {
                x += 1;
            }
            ans++;
        }
        return ans;
    }


}
