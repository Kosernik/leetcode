package MonthlyChallenges.Year22.September;

public class UTF8Validation {
    public static void main(String[] args) {
        UTF8Validation solution = new UTF8Validation();

        int[] test1 = {235, 140, 4};
        System.out.println(solution.validUtf8(test1));

        int[] test2 = {248, 130, 130, 130};
        System.out.println(solution.validUtf8(test2));
    }

    /**
     * LeetCode #393. UTF-8 Validation.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param data - an array of integers.
     * @return - true - if the data is valid UTF-8 encoding, false - otherwise.
     */
    public boolean validUtf8(int[] data) {
        int curLength = 0;

        int twoByte = 192;      //  1100_0000
        int threeByte = 224;    //  1110_0000
        int fourByte = 240;     //  1111_0000
        int tooMuchOnes = 248;  //  1111_1000

        for (int number : data) {
            if (curLength == 0) {
                if (readBit(number, 7) != 0) {
                    if ((number & fourByte) == fourByte) {
                        if ((number & tooMuchOnes) == tooMuchOnes) {
                            return false;
                        }
                        curLength = 3;
                    } else if ((number & threeByte) == threeByte) {
                        curLength = 2;
                    } else if ((number & twoByte) == twoByte) {
                        curLength = 1;
                    } else {
                        return false;
                    }
                }
            } else {
                curLength--;
                if (!startsWithOneZero(number)) return false;
            }
        }

        return curLength == 0;
    }

    /**
     * LeetCode #393. UTF-8 Validation.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param data - an array of integers.
     * @return - true - if the data is valid UTF-8 encoding, false - otherwise.
     */
    public boolean validUtf8DontLookItsUgly(int[] data) {
        int curLength = 0;

        int twoByte = 192;      //  1100_0000
        int threeByte = 224;    //  1110_0000
        int fourByte = 240;     //  1111_0000

        for (int number : data) {
            if (curLength == 0) {
                if (readBit(number, 7) == 1) {
                    if (readBit(number, 6) == 1) {
                        curLength = 1;
                        if (readBit(number, 5) == 1) {
                            curLength++;
                            if (readBit(number, 4) == 1) {
                                curLength++;
                                if (readBit(number, 3) == 1) {
                                    return false;
                                }
                            }
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                curLength--;
                if (!startsWithOneZero(number)) return false;
            }
        }

        return curLength == 0;
    }

    private boolean startsWithOneZero(int number) {
        return readBit(number, 7) == 1 && readBit(number, 6) == 0;
    }

    private int readBit(int number, int position) {
        return (number >> position) & 1;
    }
}
