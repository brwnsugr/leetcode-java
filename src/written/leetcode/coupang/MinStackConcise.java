package written.leetcode.coupang;

import java.util.LinkedList;

public class MinStackConcise {

    class Node {
      public int value;
      public int minValue;

      public Node(int value, int minValue) {
        this.value = value;
        this.minValue = minValue;
      }
    }

    private LinkedList<Node> list;

    public MinStackConcise() {
      list = new LinkedList<>();
    }

    public void push(int val) {
      int currentMinVal;
      if(list.size() == 0) {
        currentMinVal = val;
      } else {
        Node lastNode = list.getLast();
        currentMinVal = val < lastNode.minValue ? val : lastNode.minValue;
      }
      list.addLast(new Node(val, currentMinVal));
    }

    public void pop() {
      list.removeLast();
    }

    public int top() {
      return list.getLast().value;
    }

    public int getMin() {
      return list.getLast().minValue;
    }


}
