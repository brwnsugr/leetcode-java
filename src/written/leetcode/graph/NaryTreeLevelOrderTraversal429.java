package written.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal429 {

  public List<List<Integer>> levelOrder(Node root) {
    if(root == null) return new ArrayList<>();
    if(root.children == null) return Arrays.asList(Arrays.asList(root.val));
    List<List<Integer>> answers = new ArrayList<>();
    answers.add(Arrays.asList(root.val));
    Queue<Node> q = new LinkedList<>();

    q.add(root);

    while(!q.isEmpty()) {
      Queue<Node> tempQ = new LinkedList<>();
      while(!q.isEmpty()) {
        Node curr = q.poll();
        if(curr.children != null) {
          for(Node child : curr.children) {
            tempQ.add(child);
          }
        }
      }
      List<Integer> tempList = new ArrayList<>();
      while(!tempQ.isEmpty()) {
        Node curr = tempQ.poll();
        tempList.add(curr.val);
        q.add(curr);
      }
      if(tempList.size() > 0 ) answers.add(tempList);
    }
    return answers;
  }

  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

}


