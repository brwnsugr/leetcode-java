package written.leetcode.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LowestCommonAncesctor236 {

  List<TreeNode> qTrace = new ArrayList<>();
  Set<Integer> pTraceSet = new HashSet<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> trace = new ArrayList<>();
    TreeNode commonAncestor = null;
    trace.add(root);
    dfs(root, p, q, trace);
    for(int k = qTrace.size()-1; k>=0; k--) {
      if(pTraceSet.contains(qTrace.get(k).val)) {
        commonAncestor = qTrace.get(k); break;
      }
    }
    return commonAncestor;
  }

  private void dfs(TreeNode currNode, TreeNode p, TreeNode q, List<TreeNode> trace) {
    if(!qTrace.isEmpty() && !pTraceSet.isEmpty()) return;
    else if(currNode.val == p.val) {
      for(TreeNode node : trace) {
        pTraceSet.add(node.val);
      }
    }
    else if(currNode.val == q.val) {
      qTrace = List.copyOf(trace);
    }

    if(currNode.left != null) {
      trace.add(currNode.left);
      dfs(currNode.left, p, q, trace);
      trace.remove(trace.size()-1);
    }

    if(currNode.right != null) {
      trace.add(currNode.right);
      dfs(currNode.right, p, q, trace);
      trace.remove(trace.size()-1);
    }
    return;
  }
}
