package MonthlyChallenges.Year24.July;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother {
    private final char UP = 'U';
    private final char LEFT = 'L';
    private final char RIGHT = 'R';

    private final List<Character> pathToStart = new ArrayList<>();
    private final List<Character> pathToDest = new ArrayList<>();

    private boolean isFoundStart = false;
    private boolean isFoundDest = false;

    private int startValue;
    private int destValue;

    /**
     * LeetCode №2096. Step-By-Step Directions From a Binary Tree Node to Another.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root       - a root of a binary tree.
     * @param startValue - the value of a start node of a path.
     * @param destValue  - the value of a destination node of a path.
     * @return - a string representation of a path from start node to destination node.
     */
    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;

        findNodes(root, new ArrayList<>());

        if (pathToStart.isEmpty()) {
            return startIsRoot();
        } else if (pathToDest.isEmpty()) {
            return destIsRoot();
        }
        return getPath();
    }

    private String getPath() {
        StringBuilder result = new StringBuilder();

        int startIdx = 0;

        while (startIdx < pathToStart.size() && startIdx < pathToDest.size() &&
                pathToStart.get(startIdx).charValue() == pathToDest.get(startIdx)) {
            startIdx++;
        }

        result.append(String.valueOf(UP).repeat(pathToStart.size() - startIdx));
        while (startIdx < pathToDest.size()) {
            result.append(pathToDest.get(startIdx));
            startIdx++;
        }
        return result.toString();
    }

    private String startIsRoot() {
        StringBuilder result = new StringBuilder();
        for (Character ch : pathToDest) {
            result.append(ch);
        }
        return result.toString();
    }

    private String destIsRoot() {
        return String.valueOf(UP).repeat(pathToStart.size());
    }

    private void findNodes(TreeNode root, List<Character> path) {
        if (root == null) return;
        if (root.val == startValue) {
            pathToStart.addAll(path);
            isFoundStart = true;
        }
        if (root.val == destValue) {
            pathToDest.addAll(path);
            isFoundDest = true;
        }
        if (isFoundStart && isFoundDest) return;

        path.add(LEFT);
        findNodes(root.left, path);
        path.remove(path.size() - 1);

        path.add(RIGHT);
        findNodes(root.right, path);
        path.remove(path.size() - 1);
    }
}
