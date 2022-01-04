package written.leetcode.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class ValidBinarySearchTree98 {
  public boolean isValidBST(TreeNode root) {
    // in order : L-N-R
    // 1 -> 5 -> 3 -> 4 -> 6
    List<Integer> traverseList = new ArrayList<>();
    inOrder(root, traverseList);
    for(int i = 0; i < traverseList.size() - 1; i++) {
      if(traverseList.get(i) >= traverseList.get(i+1)) return false;
    }
    return true;
  }

  private void inOrder(TreeNode currNode, List<Integer> traverseList) {
    if(currNode.left != null) inOrder(currNode.left, traverseList);
    traverseList.add(currNode.val);
    if(currNode.right != null) inOrder(currNode.right, traverseList);
    return;
  }

  public boolean isValidBST2(TreeNode root) {
    return isValid(root, null, null);
  }

  private boolean isValid(TreeNode currNode, Integer low, Integer high) {
    if(currNode == null) return true;
    if((low != null && currNode.val <= low) || (high != null && currNode.val >= high)) return false;
    return isValid(currNode.right, currNode.val, high) && isValid(currNode.left, low, currNode.val);
  }


  public static void main(String[] args) {
    ValidBinarySearchTree98 validBinarySearchTree98 = new ValidBinarySearchTree98();

  }
}
