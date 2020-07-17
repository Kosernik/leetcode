package ExploreCards.NaryTree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) { return result; }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currNode = stack.pop();
            if (currNode == null) continue;
            result.add(currNode.val);
            List<Node> children = currNode.children;
            if (children != null) {
                for (int i = children.size()-1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }

        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
