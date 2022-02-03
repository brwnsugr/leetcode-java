package written.leetcode.amazon2.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer2 {

  private Map<Node, Node> visitedHashMap = new HashMap<>();

  public Node copyRandomList(Node head) {
    if(head == null) return null;

    Node oldNode = head;
    Node newNode = new Node(head.val);

    visitedHashMap.put(head, newNode);

    while(oldNode != null) {

      newNode.next = getCloneNode(oldNode.next);
      newNode.random = getCloneNode(oldNode.random);

      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return visitedHashMap.get(head);
  }

  private Node getCloneNode(Node node) {
    if(visitedHashMap.containsKey(node)) {
      return visitedHashMap.get(node);
    }
    Node newNode = new Node(node.val);
    visitedHashMap.put(node, newNode);
    return visitedHashMap.get(node);
  }

}
