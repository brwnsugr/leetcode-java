package written.leetcode.coupang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphValidTree261 {

  public boolean validTree(int n, int[][] edges) {

    List<List<Integer>> adjacencyList = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      adjacencyList.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      adjacencyList.get(edge[0]).add(edge[1]);
      adjacencyList.get(edge[1]).add(edge[0]);
    }

    Map<Integer, Integer> parent = new HashMap<>();
    parent.put(0,-1);
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    while(!stack.isEmpty()) {
      int node = stack.pop();

      for(int neighbor : adjacencyList.get(node)) {
        if(parent.get(node) == neighbor) continue;
        if(parent.containsKey(neighbor)) {
          return false;
        }
        stack.add(neighbor);
        parent.put(neighbor, node);
      }
    }
    return parent.size() == n;
  }


  public static void main(String[] args) {
    GraphValidTree261 graphValidTree261 = new GraphValidTree261();


  }



}
