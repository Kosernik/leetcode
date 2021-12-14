package Problems;

import Utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();

        // [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = solution.serialize(root);
        System.out.println(serialized);

        TreeNode deser = solution.deserialize(serialized);
    }

    /*
    LeetCode #297. Serialize and Deserialize Binary Tree.
     */

    private final static char NULL_NODE = 'N';
    private final static char LINE_SEPARATOR = 'x';
    private final static char NODE_SEPARATOR = ',';

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return String.valueOf(NULL_NODE);
        }

        StringBuilder builder = new StringBuilder();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                if (node == null) {
                    builder.append(NULL_NODE);
                } else {
                    builder.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                builder.append(NODE_SEPARATOR);
            }
            builder.append(LINE_SEPARATOR);
        }

        int idx = builder.length()-3;
        while (builder.charAt(idx) == NULL_NODE) {
            idx -= 2;
        }

        return builder.substring(0, idx+1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(String.valueOf(NULL_NODE))) return null;

        String[][] splitData = splitString(data);

        TreeNode root = new TreeNode(Integer.parseInt(splitData[0][0]));

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < splitData.length; i++) {
            int idx = 0;
            for (int j = queue.size(); j > 0; j--) {
                TreeNode node = queue.poll();
                node.left = parseNode(idx < splitData[i].length ? splitData[i][idx++] : String.valueOf(NULL_NODE));
                if (node.left != null) queue.offer(node.left);
                node.right = parseNode(idx < splitData[i].length ? splitData[i][idx++] : String.valueOf(NULL_NODE));
                if (node.right != null) queue.offer(node.right);
            }
        }

        return root;
    }

    private TreeNode parseNode(String data) {
        if (data.equals(String.valueOf(NULL_NODE))) return null;

        TreeNode node = new TreeNode(Integer.parseInt(data));
        return node;
    }

    private String[][] splitString(String data) {
        String[] lines = data.split(String.valueOf(LINE_SEPARATOR));

        String[][] result = new String[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            result[i] = lines[i].split(String.valueOf(NODE_SEPARATOR));
        }

        return result;
    }
}
