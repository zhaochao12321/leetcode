package zhaoTest;

/*
 * 题目：两个倒排链求和
 *
 * 思路：递归生成倒排链,递归求和，最高位慎重处理(判断结束)
 *      为了验证方便,重写链节点tostring方法,递归显示
 *
 *
 *
 *
 * */

public class LinkedList {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedNode firstNodeList = linkedList.makeList(10);
        LinkedNode secondNodeList = linkedList.makeList(10);

        LinkedNode endNodeList = add(firstNodeList, secondNodeList, 0);

        System.out.println(endNodeList.toString());

    }

    private static LinkedNode add(LinkedNode firstNodeList, LinkedNode secondNodeList, int i) {
        LinkedNode linkedNode = null;


        if (firstNodeList.getNext() == null && (firstNodeList.getValue() + secondNodeList.getValue() + i) < 10) {
            linkedNode = new LinkedNode(firstNodeList.getValue() + secondNodeList.getValue() + i);
        } else if ((firstNodeList.getNext() == null && (firstNodeList.getValue() + secondNodeList.getValue() + i) >= 10)) {
            linkedNode = new LinkedNode((firstNodeList.getValue() + secondNodeList.getValue() + i) % 10);
            linkedNode.setNext(new LinkedNode(1));
        } else if (firstNodeList.getNext() != null) {
            int benwei = (firstNodeList.getValue() + secondNodeList.getValue() + i) % 10;
            linkedNode = new LinkedNode(benwei);
            int jinwei = (firstNodeList.getValue() + secondNodeList.getValue() + i) >= 10 ? 1 : 0;
            linkedNode.setNext(add(firstNodeList.getNext(), secondNodeList.getNext(), jinwei));


        }
        return linkedNode;

    }

    private LinkedNode makeList(int listLength) {

        LinkedNode firstNode = makeNode(listLength);
        System.out.println(firstNode.toString());
        return firstNode;
    }

    private LinkedNode makeNode(int listLength) {
        LinkedNode linkedNode = null;

        if (listLength > 0) {

            linkedNode = new LinkedNode((int) (Math.random() * 10));
            linkedNode.setNext(makeNode(listLength - 1));
        }

        return linkedNode;

    }


}
