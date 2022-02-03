package written.leetcode.amazon2.LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class CopyListWithRandomPointer {

  public Node copyRandomList(Node head) {
    Node curr = head;

    /**
     * int[0] -> node value, int[1] -> dist from head to random node.
     * e.g. first node(head) -> 0, random node null -> -1.
     */
    List<int[]> nodes = new ArrayList<>();

    while(curr != null) {
      int currVal = curr.val;
      int randomIdx = getRandomIdx(head, curr.random);
      nodes.add(new int[]{currVal, randomIdx});
      curr = curr.next;
    }

    curr = head;

    while(curr != null) {
      curr = curr.next;
    }

    Node dummy = new Node(-1);
    dummy.next = new Node(-1);
    Node copyHead = dummy.next;
    Node copyCurr = copyHead;

    for(int[] node : nodes) {
      copyCurr.val = node[0];
      copyCurr.next = new Node(-1);
      copyCurr = copyCurr.next;
    }

    for(int i = 0; i < nodes.size() ; i++) {
      copyCurr.val = nodes.get(i)[0];
      copyCurr.next = i == nodes.size()-1 ? null : new Node(-1);
      copyCurr = copyCurr.next;
    }

    copyCurr = copyHead;

    for(int[] node : nodes) {
      copyCurr.random = getNodeByIdx(node[1], copyHead);
      copyCurr = copyCurr.next;
    }

    return dummy.next;
  }

  private Node getNodeByIdx(int idx, Node copyHead) {
    if(idx == -1) return null;
    Node curr = copyHead;
    while(idx > 0) {
      curr = curr.next;
      idx--;
    }
    return curr;
  }

  private int getRandomIdx(Node head, Node randomNode) {
    if(randomNode == null) return -1;
    int ret = 0;
    Node curr = head;
    while(curr!=null) {
      if(curr == randomNode) break;
      curr = curr.next;
      ret++;
    }
    return ret;
  }



}