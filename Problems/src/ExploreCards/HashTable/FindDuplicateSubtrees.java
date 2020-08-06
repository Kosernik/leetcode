package ExploreCards.HashTable;

import Utils.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {

    }
//    [1,2,3,4,null,2,4,null,null,4]
//[0,0,0,0,null,null,0,null,null,null,0]
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicates = new ArrayList<>();
        if (root == null || (root.left == null && root.right == null)) return duplicates;

        Map<String, TreeNode> nodes = new HashMap<>();
        Map<TreeNode, String> paths = new HashMap<>();
        Set<TreeNode> result = new HashSet<>();
        Set<TreeNode> visited = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            if (visited.contains(currNode)) {
                String leftPath = currNode.left == null ? "n" : paths.get(currNode.left);
                String rightPath = currNode.right == null ? "n" : paths.get(currNode.right);
                String currPath = "(" + leftPath + "-" + String.valueOf(currNode.val) + "-" + rightPath + ")";
                paths.put(currNode, currPath);

                if (nodes.containsKey(currPath)) {
                    result.add(nodes.get(currPath));
                } else {
                    nodes.put(currPath, currNode);
                }

            } else {
                visited.add(currNode);
                stack.push(currNode);
                if (currNode.right != null) {
                    stack.push(currNode.right);
                }
                if (currNode.left != null) {
                    stack.push(currNode.left);
                }
            }
        }

        duplicates.addAll(result);
        return duplicates;
    }

//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        List<TreeNode> duplicates = new ArrayList<>();
//        if (root == null || (root.left == null && root.right == null)) return duplicates;
//
//        Map<String, TreeNode> paths = new HashMap<>();
//        Set<TreeNode> result = new HashSet<>();
//
//        Stack<Pair> stack = new Stack<>();
//        Pair rootPair = new Pair();
//        rootPair.node = root;
//        stack.push(rootPair);
//
//        while (!stack.isEmpty()) {
//            Pair currPair = stack.pop();
//            if (currPair.visited) {
//                String leftP = currPair.node.left == null ? "null" : String.valueOf(currPair.node.left.val);
//                String rightP = currPair.node.right == null ? "null" : String.valueOf(currPair.node.right.val);
//                String currPath = leftP + String.valueOf(currPair.node.val) + rightP;
//                currPair.path = currPath;
//                if (paths.containsKey(currPath)) {
//                    result.add(paths.get(currPath));
//                } else {
//                    paths.put(currPath, currPair.node);
//                }
//            } else {
//                currPair.visited = true;
//                stack.push(currPair);
//                if (currPair.node.right != null) {
//                    Pair right = new Pair();
//                    right.node = currPair.node.right;
//                    stack.push(right);
//                }
//                if (currPair.node.left != null) {
//                    Pair left = new Pair();
//                    left.node = currPair.node.left;
//                    stack.push(left);
//                }
//            }
//        }
//
//        duplicates.addAll(result);
//        return duplicates;
//    }
//
//    private class Pair {
//        TreeNode node;
//        String path;
//        boolean visited = false;
//    }
}
