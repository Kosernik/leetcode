import Utils.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
    /**
     * Метод возвращает лист прохода по дереву в ширину, начиная с самого нижнего уровня, элементы идут слева-направо
     * @param root Дерево
     * @return Список значений вершин
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // Результат
        List<List<Integer>> traversalList = new ArrayList<>();
        // Очередь для прохода по дереву в ширину
        Queue<TreeNode> myQueue = new ArrayDeque<>();
        // Начинаем обход с корня дерева
        myQueue.add(root);

        // Обход дерева в ширину
        while (!myQueue.isEmpty()) {
            // Создаем лист для текущего уровня дерева
            List<Integer> currLevel = new ArrayList<>();

            // Проходим только по тем элементам, которые находятся на текущем уровне
            for (int i = 0, length = myQueue.size(); i < length; i++) {
                // Удаляем текущую ноду и добавляем значение в лист
                TreeNode currNode = myQueue.poll();
                currLevel.add(currNode.val);

                // Добавляем детей только если они есть
                if (currNode.left != null) {myQueue.add(currNode.left);}
                if (currNode.right != null) {myQueue.add(currNode.right);}
            }
            // Добавляем текущий уровень к результату
            traversalList.add(currLevel);
        }

        // Разворачиваем результирующий лист и возвращаем его.
        Collections.reverse(traversalList);
        return traversalList;
    }
}
