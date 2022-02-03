package written.leetcode.amazon2.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointerOptimized1 {

  private Map<Node, Node> visitedNodeMap = new HashMap<>();
  public Node copyRandomList(Node head) {
    if(head == null) return null;

    if(visitedNodeMap.containsKey(head)) return visitedNodeMap.get(head);

    Node newNode = new Node(head.val);
    visitedNodeMap.put(head, newNode);

    newNode.next = this.copyRandomList(head.next);
    newNode.random = this.copyRandomList(head.random);

    return newNode;
  }

}
