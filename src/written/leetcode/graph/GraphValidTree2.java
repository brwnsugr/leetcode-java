package written.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphValidTree2 {

  public boolean validTree(int n, int[][] edges) {
    List<List<Integer>> adjList = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for(int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
    }
    Map<Integer, Integer> parentMap = new HashMap<>();
    Stack<Integer> s = new Stack<>();
    parentMap.put(0,-1);
    s.add(0);

    while(!s.isEmpty()) {
      int currentNode = s.pop();
      for(int neighbor : adjList.get(currentNode)) {
        if(parentMap.containsKey(currentNode) && parentMap.get(currentNode) == neighbor) continue;
        if(parentMap.containsKey(neighbor)) return false;
        parentMap.put(neighbor, currentNode);
        s.add(neighbor);
      }
    }
    return parentMap.size() == n;
  }





}
