package zhaoTest;

public class LinkedNode {
    private int value;

    private LinkedNode next;

    public LinkedNode(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
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
}
