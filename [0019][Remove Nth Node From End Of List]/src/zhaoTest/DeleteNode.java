package zhaoTest;


/**
 * Created by zhaochao on 2019/7/25.
 * <p>
 * <p>
 * ɾ��������ĵ����ڣθ���㣬��������ɵ�nodeList �ĳ������������N��ֵ,��֤Nֵ��Ч
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
        System.out.println(mm.getValue()); // ������һ��Ԫ��ֵ

        System.out.print("������ɵ�nodeList��");
        int listNodeLength = 0;
        ListNode middle = listNode;
        while (middle.getNext() != null) {
            listNodeLength++;
            middle = middle.getNext();
        }
        listNodeLength++;    // Ԫ�زⳤ
        int daoshu = (int) (Math.random() * listNodeLength) + 1; // �������ɾ�������ڼ���node
        int deleteNumber = listNodeLength - daoshu + 1; // ɾ����Ԫ��λ�ñ�Ϊ�������,��Ҫ��1
        ListNode listNodeAfterDelete = deleteNode.deleteNode(listNode, deleteNumber, listNodeLength);  //  deleteNumberΪ�������
        System.out.println("������ɵ�nodeList�ĳ���" + listNodeLength);
        System.out.println("��Ҫɾ��Ԫ�ص��������" + deleteNumber);

        while (listNodeAfterDelete.getNext() != null) {
            System.out.print(listNodeAfterDelete.getValue() + "   ");
            listNodeAfterDelete = listNodeAfterDelete.getNext();
        }
        System.out.println(listNodeAfterDelete.getValue()); // ������һ��Ԫ��ֵ
    }


    /**
     * @param listNode
     * @param deleteNumber
     * @param totalNumber
     * @return ɾ�����nodelist
     */
    private ListNode deleteNode(ListNode listNode, int deleteNumber, int totalNumber) {
        ListNode middle = new ListNode();
        ListNode pro = new ListNode();

        for (int i = 0; i < deleteNumber; i++) {
            if (deleteNumber == 1) {                // ���ɾ�����ǵ�һ��Ԫ��,ֱ���޸�ͷ���꣬Ȼ����ֹ
                listNode = listNode.getNext();
                break;
            }
            if (i == 0) {
                try {
                    middle = listNode;  //  ��һ�ν���,cloneͷ�ڵ�
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                middle = middle.getNext(); // �����ƶ���������һ��λ��
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
     * @param length �������
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
        middleNode.setValue((int) (Math.random() * 100)); //����²��һ��value��ֵ

        return listNodeReturn;
    }
}
