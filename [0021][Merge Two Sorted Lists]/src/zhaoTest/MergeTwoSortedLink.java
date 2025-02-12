package zhaoTest;

/**
 * Created by zhaochao on 2019/7/26.
 * <p>
 * * 题目大意
 * * 合并两个排序链表并返回一个新的列表。新的链表的结果由原先的两个链表结点组成,不添加新的链
 * * 也就是不能合并后的链表不能包含新创建的结点。
 */

public class MergeTwoSortedLink {
    public static void main(String[] args) throws Exception {
        MergeTwoSortedLink mergeTwoSortedLink = new MergeTwoSortedLink();

        for (int i = 0; i < 10; i++) {
            mergeTwoSortedLink.test();
        }

    }


    public void test() throws Exception {
        int node1Length = (int) (Math.random() * 5) + 5;
        int node2Length = (int) (Math.random() * 5) + 5;

        ListNode node1 = ListNodeUtil.fetchNodeList(node1Length);
        ListNode node2 = ListNodeUtil.fetchNodeList(node2Length);

        ListNode merge1 = ListNodeUtil.mergeUnsortedListNode(node1.deepClone(), node2.deepClone(), node1Length + node2Length); // 对乱序链合并
        System.out.println("乱序链排序：  " + merge1);
        ListNode node1Sorted = ListNodeUtil.sortListNode(node1.deepClone(), node1Length); // 单链排序
        ListNode node2Sorted = ListNodeUtil.sortListNode(node2.deepClone(), node2Length); // 单链排序

        ListNode merge2 = ListNodeUtil.mergesortedListNode(node1Sorted, node2Sorted, node1Length, node2Length);   //  有序链排序


//        System.out.println("乱序第一链：  " + node1);
        System.out.println("排序第一链：  " + node1Sorted);
//        System.out.println("乱序第二链：  " + node2);
        System.out.println("排序第二链：  " + node2Sorted);
//        System.out.println("乱序链排序：  " + merge1);
        System.out.println("有序链排序：  " + merge2);


//        int flag = 0;
//        ListNode merge1Clone = merge1.deepClone();
//        ListNode merge2Clone = merge2.deepClone();
//        while (merge1 != null) {
//            if (merge1.getValue() != merge2.getValue()) {
//                flag = 1;
//                break;
//
//            }
//            merge1 = merge1.getNext();
//            merge2 = merge2.getNext();
//        }
//
//
//        while (merge2Clone != null) {
//            if (merge2Clone.getValue() != merge1Clone.getValue()) {
//                flag = 1;
//                break;
//            }
//            merge2Clone = merge2Clone.getNext();
//            merge1Clone = merge1Clone.getNext();
//        }
//
//        if (flag == 0) {
//            System.out.println("成功");
//        } else {
//            System.out.println("失败");
//        }
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


    }


//        System.out.println(node2);

}
