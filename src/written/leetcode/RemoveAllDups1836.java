package written.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Also in leetcode (https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/ , #1836)
 * Hash 랑 two pointer 사용 -> two pointer 로는 두번째 search pointer 가 첫번째 search pointer 앞에 오도록
 * impl
 *
 */
public class RemoveAllDups1836 {

  private Map<Integer, Boolean> duplicatedMap = new HashMap<>();

  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
      this.val = val; this.next = next;
    }
  }


  public ListNode deleteDuplicatesUnsorted(ListNode head) {
    // traverse from head node to the node of end following the next ..

    // let some maps to store the node values which are duplicated
    // At first, Traverse one time and check if there nodes duplicated and put this values in hashmap
    // -> key would be node value, value as just boolean value

    // At Second, traversing again, and every node, check if it should be removed or not

    // Base case
    if(head == null || head.next == null) return head;

    ListNode currNode = head;

    while(currNode != null) {
      boolean currValAlreadyExists = duplicatedMap.containsKey(currNode.val);
      duplicatedMap.put(currNode.val, currValAlreadyExists);
      currNode = currNode.next;
    }

    // initialize the position of the Node in head
    currNode = head;

    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;

    //dummy를 사용하는 이유는, logic 특성 상 node 를 삭제한다는 의미는 을
    // 이전 노드가 가리키는 next pointing 을 노드를 건너뛴 다음 노드를 가리키는 것을 의미합니다.
    // 여기서 이 이전 노드가 가리키는 next pointing을 표현하기 위해서는 prev node(더미)가 필연적으로 필요한 것입니다.
    // 만약 더미 노드가 없으면 head 를 제거할 때 node 삭제 정의를 내릴 수 없습니다.
    while(currNode != null) {
      if(duplicatedMap.get(currNode.val)) {
        prev.next = prev.next.next;
      } else {
        prev = prev.next;
      }
      currNode = currNode.next;
    }

    return dummy.next;
  }


  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(2);

    RemoveAllDups1836 removeDups = new RemoveAllDups1836();

    ListNode answerHead = removeDups.deleteDuplicatesUnsorted(head);
  }


}
