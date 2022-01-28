package written.leetcode.amazon.Design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeBinaryTree297 {


  public String serialize(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<Integer> arr = new ArrayList<>();
    q.add(root);
    while(!q.isEmpty()) {
      for(int i = 0; i < q.size(); i++) {
        TreeNode curr = q.poll();
        Integer value = curr == null ? null : curr.val;
        arr.add(value);
        if(curr != null) {
          q.add(curr.left);
          q.add(curr.right);
        }
      }
    }
    return arr.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    data = data.substring(1, data.length()-1);
    String[] split = data.split(", ");
    List<Integer> arr = new ArrayList<>(split.length);
    for(String element : split) {
      if(element.equals("null")) arr.add(null);
      else arr.add(Integer.valueOf(element));
    }

    if(arr.size() == 0 || arr.get(0)==null) return null;
    TreeNode root = new TreeNode(Integer.valueOf(arr.get(0)));
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    int count = 1;
    while(!q.isEmpty() && count < arr.size()) {
      TreeNode curr = q.poll();

      if(arr.get(count) != null) {
        TreeNode left = new TreeNode(arr.get(count));
        curr.left = left;
        q.add(left);
      }
      count++;
      if(count >= arr.size()) break;
      if(arr.get(count) != null) {
        TreeNode right = new TreeNode(arr.get(count));
        curr.right = right;
        q.add(right);
      }
      count++;
    }
    return root;
  }

  public static void main(String[] args) {
    SerializeDeserializeBinaryTree297 serializeDeserializeBinaryTree297 = new SerializeDeserializeBinaryTree297();
    String serialize = serializeDeserializeBinaryTree297.serialize(null);
    TreeNode deserialize = serializeDeserializeBinaryTree297.deserialize("[1,-2,3,null,null,4,5]");


    System.out.println(" ddd is " + serialize);
  }
}
