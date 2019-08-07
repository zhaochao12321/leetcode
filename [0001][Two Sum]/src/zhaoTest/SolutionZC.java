package zhaoTest;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class SolutionZC {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
//        ListNode listNode2 = new ListNode(1);
//        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(0);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(4);

//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        SolutionZC solutionZC = new SolutionZC();
        ListNode listNode = solutionZC.addTwoNumbers(listNode1, listNode4);
        System.out.println();


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 转化为数组进行实现，因为List转成int甚至是转成long都存在超过最大值的风险
        int lengthForL1 = ListNodeLength(l1);
        int lengthForL2 = ListNodeLength(l2);
        int[] array1 = fromListNodeToArray(l1, lengthForL1);
        int[] array2 = fromListNodeToArray(l2, lengthForL2);

        return addListNode(array1, array2, lengthForL1, lengthForL2);
    }

    private int[] fromListNodeToArray(ListNode ln, int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = ln.val;
            ln = ln.next;
        }
        return array;
    }

    private int ListNodeLength(ListNode ln) {
        int length = 0;

        while (ln != null) {
            length++;
            ln = ln.next;
        }
        return length;
    }

    private ListNode addListNode(int[] intArray1, int[] intArray2, int length1, int length2) {
        int jw = 0;              // 进位标识符
        ListNode head = null;    // 头标识符
        ListNode zhizhen = null;  // 指针标识符

        int minInt = length1 > length2 ? length2 : length1;  // 选短链
        for (int i = 0; i < minInt; i++) {                   //  可匹配长度相加
            if (i == 0) {       // 头节点
                if (intArray1[i] + intArray2[i] < 10) {
                    zhizhen = new ListNode(intArray1[i] + intArray2[i]);
                    jw = 0;
                } else {
                    zhizhen = new ListNode(intArray1[i] + intArray2[i] - 10);
                    jw = 1;
                }
                head = zhizhen;     // 记录头结点
            } else {                //  非头结点情况

                if (intArray1[i] + intArray2[i] + jw < 10) {
                    zhizhen.next = new ListNode(intArray1[i] + intArray2[i] + jw);
                    jw = 0;
                } else {
                    zhizhen.next = new ListNode(intArray1[i] + intArray2[i] + jw - 10);
                    jw = 1;
                }
                zhizhen = zhizhen.next;
            }
        }
        // 开始处理长出来的部分

        if (length1 == length2 && jw == 1) {                // 两链相加有进位,但两链等长,补一位最高位
            zhizhen.next = new ListNode(jw);
        }
        if (length1 > length2) {          //前链长
            for (int i = length2; i < length1; i++) {
                if (intArray1[i] + jw < 10) {
                    zhizhen.next = new ListNode(intArray1[i] + jw);
                    jw = 0;
                } else {
                    zhizhen.next = new ListNode(intArray1[i] + jw - 10);
                    jw = 1;
                }
                zhizhen = zhizhen.next;
            }
        } else if (length2 > length1) {   // 后链长
            for (int i = length1; i < length2; i++) {
                if (intArray2[i] + jw < 10) {
                    zhizhen.next = new ListNode(intArray2[i] + jw);
                    jw = 0;
                } else {
                    zhizhen.next = new ListNode(intArray2[i] + jw - 10);
                    jw = 1;
                }
                zhizhen = zhizhen.next;
            }
        }
        if (jw == 1) {
            zhizhen.next = new ListNode(1);
        }
        return head;
    }

}