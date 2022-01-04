package written.leetcode.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree101 {

  public static int ALT_NULL_VALUE = 101;

  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;

    return isValid(root.left, root.right);
  }

  private boolean isValid(TreeNode t1, TreeNode t2) {
    if(t1 == null && t2 == null) return true;
    if(t1 == null || t2 == null) return false;
    if(t1.val == t2.val) {
      return (isValid(t1.left, t2.right) && isValid(t1.right , t2.left));
    }
    return false;
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);

    root.left.left = null;
    root.left.right = new TreeNode(3);

    root.right.left = null;
    root.right.right = new TreeNode(3);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);

    SymmetricTree101 symmetricTree101 = new SymmetricTree101();
    symmetricTree101.isSymmetric(root2);

  }



}
