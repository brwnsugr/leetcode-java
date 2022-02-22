package written.leetcode.amazon2.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SymmetricTree101 {
  public boolean isSymmetric(TreeNode root) {
    if(root==null) return true;
    return isValid(root.left, root.right);
  }

  private boolean isValid(TreeNode left, TreeNode right) {
    if(left == null && right == null) return  true;
    else if(left== null || right == null) return false;
    else if(left.val == right.val) {
      return isValid(left.left, right.right) && isValid(left.right, left.left);
    }
    else return false;
  }




  public static void main(String[] args) {
    List<Integer> ints1 = Arrays.asList(1, null, 2);
    List<Integer> ints2 = Arrays.asList(1, null, 2);
    List<Integer> intss1 = new ArrayList<>();
//    intss1.add(1); intss1.add(null); intss1.add(3);

    List<Integer> intss2 = new ArrayList<>();
//    intss2.add(1); intss2.add(null); intss2.add(3);

    Set<List<Integer>> s= new HashSet<>();

    s.add(ints1); s.add(ints2);

    s.add(intss1); s.add(intss2);


    System.out.println(ints1 == ints2);
  }

}
