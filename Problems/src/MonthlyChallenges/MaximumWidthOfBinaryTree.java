package MonthlyChallenges;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {

    }

    //                          0
    //              /                          \
    //          0(2*0)                           1(2*0+1)
    //       /         \                      /           \
    //    0(2*0)     1(2*0+1)              2(2*1)         3(2*1+1)
    //   /     \      /     \              /    \        /       \
    //0(2*0) 1(2*0+1) 2(2*1) 3(2*1+1) 4(2*2) 5(2*2+1) 6(2*3) 7(2*3+1)
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;

        // Дерево не пустое, следовательна ширина минимум 1
        int max = 1;
        // Нужна двусторонняя очередь для обхода дерева в ширину
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        // Добавляем корень дерева в очередь с номером 0
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            // Читаем номера крайнего левого и крайнего правого узлов на текущем уровне дерева
            int left = queue.peek().number;
            int right = queue.peekLast().number;
            // Считаем ширину текущего уровня и обновляем максимальную ширину, если требуется
            int currWidth = right - left + 1;
            max = Math.max(max, currWidth);

            // Добавляем в очередь следующий уровень дерева
            for (int i = 0, length = queue.size(); i < length; i++) {
                Pair currPair = queue.poll();
                TreeNode currNode = currPair.node;
                if (currNode.left != null) {
                    Pair leftPair = new Pair(currPair.number*2, currNode.left);
                    queue.add(leftPair);
                }
                if (currNode.right != null) {
                    Pair rightPair = new Pair(currPair.number*2 + 1, currNode.right);
                    queue.add(rightPair);
                }
            }
        }

        return max;
    }

    /**
     * Вспомогательный класс, состоящий из узла дерева и номера узла в своем ряду
     */
    private class Pair {
        int number;
        TreeNode node;
        Pair(int number, TreeNode node) {
            this.number = number;
            this.node = node;
        }
    }
}
