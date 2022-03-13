package Problems;

public class DesignParkingSystem {

    class ParkingSystem {
        private final int[] slots = new int[4];

        /**
         * LeetCode #1603. Design Parking System.
         *
         * @param big - the number of slots of big size.
         * @param medium - the number of slots of medium size.
         * @param small - the number of slots of small size.
         */
        public ParkingSystem(int big, int medium, int small) {
            slots[1] = big;
            slots[2] = medium;
            slots[3] = small;
        }

        /**
         *
         * @param carType - the type of entering car, 1 - big, 2 - medium, 3 - small.
         * @return - True - if there is an empty slot for a car, False - otherwise.
         */
        public boolean addCar(int carType) {
            if (slots[carType] > 0) {
                slots[carType]--;
                return true;
            } else {
                return false;
            }
        }
    }
}
