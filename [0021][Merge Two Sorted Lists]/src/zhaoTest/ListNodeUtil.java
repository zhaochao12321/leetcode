package zhaoTest;

import com.sun.imageio.plugins.common.I18N;

/**
 * Created by zhaochao on 2019/7/26.
 * <p>
 * 随机生成指定长度的Listnode
 */

public class ListNodeUtil {


    /**
     * 生成一个定长的ListNode
     *
     * @param length
     * @return
     */
    public static ListNode fetchNodeList(int length) {
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


    public static ListNode sortListNode(ListNode listNode, int nodelength) {
        if (listNode == null || listNode.getNext() == null) {
            return listNode;
        }
        ListNode returnListNode = listNode;
        int midValue = 0;
        for (int i = 1; i < nodelength; i++) {
            for (int j = nodelength - i; j > 0; j--) {

                if (listNode.getValue() <= listNode.getNext().getValue()) {
                    midValue = listNode.getValue();
                    listNode.setValue(listNode.getNext().getValue());
                    listNode.getNext().setValue(midValue);
                }
                listNode = listNode.getNext();
            }

            listNode = returnListNode;
        }
        return returnListNode;
    }


    /**
     * @param list1       第一乱序链
     * @param list2       第二乱序链
     * @param totalLength 两链的元素总数,此处为了计算方便传入该值,应该封装一个方法计算元素数
     * @return
     * @throws Exception
     */

    public static ListNode mergeUnsortedListNode(ListNode list1, ListNode list2, int totalLength) throws Exception {

        ListNode surfaceClone = list1.clone();

        while (list1.getNext() != null) {
            list1 = list1.getNext();
        }
        list1.setNext(list2);    //  两链连接


        return sortListNode(surfaceClone, totalLength);
    }


    public static ListNode mergesortedListNode(ListNode list1, ListNode list2, int list1Length, int list2Length) throws Exception {
        ListNode returnListNode = null;
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }                                                          // 合法性校


        if (list1.getValue() <= list2.getValue()) {

            ListNode middleListNode = list1;
            list1 = list2;
            list2 = middleListNode;
            int middlelistLength = list1Length;         //  找出大头结点,设为主数组
            list1Length = list2Length;
            list2Length = middlelistLength;

        }
        returnListNode = list1.clone();     // 对大头进行浅层clone,只记录其value和阈

        // 选头大的list为主链
        ListNode list1Pointer;
        ListNode list2Pointer = list2;
        for (int i = 0; i < list2Length; i++) {
            list1Pointer = returnListNode;      //
            for (int j = 0; j < list1Length + list2Length; j++) {
                //  这一块是个比价难处理的点,随着数组的不断合并,数组长度不断增大，所以单纯的把主数组的循环次数设定为初始值是有问题的.

                if (list1Pointer.getValue() >= list2Pointer.getValue() && list1Pointer.getNext() == null) {
                    list1Pointer.setNext(list2Pointer);
                    break;
                    //  主链已对比完,附链直接接主链后面
                }
                if (list1Pointer.getValue() >= list2Pointer.getValue() && list1Pointer.getNext().getValue() <= list2Pointer.getValue()) {
                    ListNode list1Next = list1Pointer.getNext().deepClone();
                    list1Pointer.setNext(list2Pointer.deepClone());
                    list1Pointer.getNext().setNext(list1Next);
                    list2Pointer = list2Pointer.getNext();
                    break;
                }

                list1Pointer = list1Pointer.getNext();
            }


        }


        return returnListNode;
    }


}
