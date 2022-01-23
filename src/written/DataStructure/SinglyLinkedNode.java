package written.DataStructure;

public class SinglyLinkedNode {

  int val;
  SinglyLinkedNode next;

  public SinglyLinkedNode() {

  }

  public SinglyLinkedNode(int val){
    this.val = val;
  }

  public SinglyLinkedNode(int val, SinglyLinkedNode node) {
    this.val = val;
    this.next = node;
  }

  public static void main(String[] args) {

    SinglyLinkedNode head = new SinglyLinkedNode();
    head.val = 3;
    head.next = new SinglyLinkedNode(6);

    System.out.println(head.next.val);

  }

}


