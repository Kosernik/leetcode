package ExploreCards.LinkedList;

import Utils.ListNode;

public class RotateList {
    public static void main(String[] args) {
        RotateList solution = new RotateList();
        int[] arr = {1,2,3,4,5};
        ListNode list = ListNode.getListFromArray(arr);
        System.out.println(ListNode.printString(list));

        System.out.println("Test 0");
        ListNode result0 = solution.rotateRight(ListNode.getListFromArray(arr), 0);
        System.out.println(ListNode.printString(result0));

        System.out.println("Test 1");
        ListNode result1 = solution.rotateRight(ListNode.getListFromArray(arr), 1);
        System.out.println(ListNode.printString(result1));

        System.out.println("Test 2");
        ListNode result2 = solution.rotateRight(ListNode.getListFromArray(arr), 2);
        System.out.println(ListNode.printString(result2));

        System.out.println("Test 3");
        ListNode result3 = solution.rotateRight(ListNode.getListFromArray(arr), 3);
        System.out.println(ListNode.printString(result3));

        System.out.println("Test 4");
        ListNode result4 = solution.rotateRight(ListNode.getListFromArray(arr), 4);
        System.out.println(ListNode.printString(result4));

        System.out.println("Test 5");
        ListNode result5 = solution.rotateRight(ListNode.getListFromArray(arr), 5);
        System.out.println(ListNode.printString(result5));

        System.out.println("Test 6");
        ListNode result6 = solution.rotateRight(ListNode.getListFromArray(arr), 6);
        System.out.println(ListNode.printString(result6));
    }

    public ListNode rotateRight(ListNode head, int k) {
        // Проверка валидности входных данных
        if (k <= 0 || head == null) {return head;}

        // Создаем ссылку на новую голову листа
        ListNode resultHead;

        // Создаем "быстрый" указатель и счетчик размера листа
        int size = 0;
        ListNode fastPointer = head;

        // Сдвигаем "быстрый" указатель на k-элементов вперед до тех пор, пока не наткнемся на null или не достигнем
        // нужной длины
        while (fastPointer != null && size < k) {
            fastPointer = fastPointer.next;
            size++;
        }

        // Проверка пограничных случаев:
        // k больше чем длина листа - делим k по модулю длины и вызываем данный метод еще раз
        if (size < k) {
            return rotateRight(head, k%size);
        }
        // k равно длине листа (при условии что мы дошли "быстрым" указателем до конца листа) - нет необходимости
        // менять лист, возвращаем без изменений
        else if (fastPointer == null && size == k) {
            return head;
        }

        ListNode slowPointer = head;
        // Проходим по листу двумя указателями до тех пор, когда быстрый не дойдет до конца листа
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        // Быстрый указательдошел до конца. Указываем в качестве новой головы листа узел, следующий за медленным
        // указателем. Зацикливаем старый хвост листа на оригинальную голову. Убираем у нового хвоста листа указатель
        // на новую голову, чтобы лист не был закольцованным.
        resultHead = slowPointer.next;
        fastPointer.next = head;
        slowPointer.next = null;

        // Возвращаем указатель на новую голову.
        return resultHead;
    }
}
