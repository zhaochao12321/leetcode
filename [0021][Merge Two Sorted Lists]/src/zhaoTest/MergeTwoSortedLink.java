package zhaoTest;

/**
 * Created by zhaochao on 2019/7/26.
 * <p>
 * * ��Ŀ����
 * * �ϲ�����������������һ���µ��б��µ�����Ľ����ԭ�ȵ��������������,������µ���
 * * Ҳ���ǲ��ܺϲ���������ܰ����´����Ľ�㡣
 */

public class MergeTwoSortedLink {
    public static void main(String[] args) throws Exception {
        int node1Length = (int) (Math.random() * 5) + 5;
        int node2Length = (int) (Math.random() * 5) + 5;

        ListNode node1 = ListNodeUtil.fetchNodeList(node1Length);
        ListNode node2 = ListNodeUtil.fetchNodeList(node2Length);

        ListNode merge1 = ListNodeUtil.mergeUnsortedListNode(node1.deepClone(), node2.deepClone(), node1Length + node2Length); // ���������ϲ�

        ListNode node1Sorted = ListNodeUtil.sortListNode(node1.deepClone(), node1Length); // ��������
        ListNode node2Sorted = ListNodeUtil.sortListNode(node2.deepClone(), node2Length); // ��������

        ListNode merge2 = ListNodeUtil.mergesortedListNode(node1Sorted, node2Sorted, node1Length, node2Length);   //  ����������
        System.out.println("�����һ����  " + node1);
        System.out.println("�����һ����  " + node1Sorted);
        System.out.println("����ڶ�����  " + node2);
        System.out.println("����ڶ�����  " + node2Sorted);
        System.out.println("����������  " + merge1);
        System.out.println("����������  " + merge2);


//        System.out.println(node2);
    }
}
