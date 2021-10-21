package Problems;

public class ConstructTheRectangle {

    /**
     * LeetCode #492. Construct the Rectangle.
     *
     * Complexity - O(sqrtN), N = 'area'.
     * Memory - O(1)
     *
     * @param area - the area of a web page.
     * @return - an array with size = 2 of two integers representing length and width of a web page.
     */
    public int[] constructRectangle(int area) {
        int[] sizes = new int[2];

        int width = (int) Math.sqrt(area);

        while (width >= 1) {
            int lengthCandidate = area / width;

            if (lengthCandidate * width == area) {
                sizes[0] = lengthCandidate;
                sizes[1] = width;
                break;
            }

            width--;
        }

        return sizes;
    }
}
