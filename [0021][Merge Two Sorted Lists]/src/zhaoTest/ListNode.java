package zhaoTest;

/**
 * Created by zhaochao on 2019/7/25.
 */

public class ListNode {
    private int value;
    private ListNode next;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String string;
        if (next != null) {
            string = "  " + value + "  " + next.toString();
        } else {
            string = "  " + value + "  ";
        }
        return string;
    }

    @Override
    protected ListNode clone() throws CloneNotSupportedException {     // 浅层clone
        ListNode listNode = new ListNode();
        listNode.setNext(this.getNext());
        listNode.setValue(this.getValue());

        return listNode;
    }

    protected ListNode deepClone() throws CloneNotSupportedException {    //  深层clone

        ListNode listNode = new ListNode();
        listNode.setValue(this.getValue());
        if (this.getNext() != null) {
            listNode.setNext(this.getNext().deepClone());
        }

        return listNode;
    }

}
