package MonthlyChallenges.Year23.February;

public class ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }


    /**
     * LeetCode #427. Construct Quad Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param grid - a square matrix. grid.length is a power of 2.
     * @return - the root of a quad tree.
     */
    public Node construct(int[][] grid) {
        return buildTree(grid, 0, 0, grid.length);
    }

    private Node buildTree(int[][] grid, int row, int col, int size) {
        if (size == 1) {
            boolean val = grid[row][col] == 1;
            return new Node(val, true);
        } else {
            size /= 2;
            Node topLeft = buildTree(grid, row, col, size);
            Node topRight = buildTree(grid, row, col + size, size);
            Node bottomLeft = buildTree(grid, row + size, col, size);
            Node bottomRight = buildTree(grid, row + size, col + size, size);

            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                    topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
                return new Node(topLeft.val, true);
            }

            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
