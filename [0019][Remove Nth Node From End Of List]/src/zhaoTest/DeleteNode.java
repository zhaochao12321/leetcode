package zhaoTest;


/**
 * Created by zhaochao on 2019/7/25.
 * <p>
 * <p>
 * 删除单链表的倒数第Ｎ个结点，由随机生成的nodeList 的长度再随机生成N的值,保证N值有效
 * <p>
 * <p>
 */

public class DeleteNode {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            deleteNode();
        }
    }

    private static void deleteNode() {
        DeleteNode deleteNode = new DeleteNode();
        ListNode listNode = deleteNode.fetchNodeList((int) (Math.random() * 20) + 5);
        ListNode mm = listNode;
        while (mm.getNext() != null) {
            System.out.print(mm.getValue() + "   ");
            mm = mm.getNext();
        }
        System.out.println(mm.getValue()); // 输出最后一个元素值

        System.out.print("随机生成的nodeList：");
        int listNodeLength = 0;
        ListNode middle = listNode;
        while (middle.getNext() != null) {
            listNodeLength++;
            middle = middle.getNext();
        }
        listNodeLength++;    // 元素测长
        int daoshu = (int) (Math.random() * listNodeLength) + 1; // 随机生成删除倒数第几个node
        int deleteNumber = listNodeLength - daoshu + 1; // 删除的元素位置变为正数序号,需要加1
        ListNode listNodeAfterDelete = deleteNode.deleteNode(listNode, deleteNumber, listNodeLength);  //  deleteNumber为正数序号
        System.out.println("随机生成的nodeList的长度" + listNodeLength);
        System.out.println("需要删除元素的正向序号" + deleteNumber);

        while (listNodeAfterDelete.getNext() != null) {
            System.out.print(listNodeAfterDelete.getValue() + "   ");
            listNodeAfterDelete = listNodeAfterDelete.getNext();
        }
        System.out.println(listNodeAfterDelete.getValue()); // 输出最后一个元素值
    }


    /**
     * @param listNode
     * @param deleteNumber
     * @param totalNumber
     * @return 删除后的nodelist
     */
    private ListNode deleteNode(ListNode listNode, int deleteNumber, int totalNumber) {
        ListNode middle = new ListNode();
        ListNode pro = new ListNode();

        for (int i = 0; i < deleteNumber; i++) {
            if (deleteNumber == 1) {                // 如果删除的是第一个元素,直接修改头坐标，然后终止
                listNode = listNode.getNext();
                break;
            }
            if (i == 0) {
                try {
                    middle = listNode;  //  第一次进入,clone头节点
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                middle = middle.getNext(); // 否则移动坐标至下一个位置
            }

            if (i == deleteNumber - 2) {
                try {
                    pro = middle;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (i == deleteNumber - 1) {
                pro.setNext(middle.getNext());
                break;
            }
        }
        return listNode;
    }


    /**
     * @param length 随机长度
     * @return nodeList
     */
    private ListNode fetchNodeList(int length) {
        System.out.println("length :" + length);
        ListNode listNodeReturn = null;
        ListNode middleNode = null;

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                listNodeReturn = new ListNode();
                listNodeReturn.setValue((int) (Math.random() * 100));
                middleNode = listNodeReturn;
                continue;
            }

            ListNode node = new ListNode();
            middleNode.setNext(node);
            middleNode.setValue((int) (Math.random() * 100));
            middleNode = node;

        }
        middleNode.setValue((int) (Math.random() * 100)); //填补最下层的一个value的值

        return listNodeReturn;
    }
}
