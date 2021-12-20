package written.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class FindPathExist1971 {

  public boolean validPath(int n, int[][] edges, int start, int end) {
    List<List<Integer>> adjList = new ArrayList<>(n);
    for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());

    for(int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
    }

    Stack<Integer> s = new Stack<>();
    HashSet<Integer> visited = new HashSet<>();

    s.add(start);

    while(!s.isEmpty()) {
      int top = s.pop();
      if(top == end) return true;
      if(!visited.contains(top)) {
        visited.add(top);
        List<Integer> adjNodes = adjList.get(top);
        for(int adjNode : adjNodes) {
          if(!visited.contains(adjNode)) s.add(adjNode);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    FindPathExist1971 findPathExist1971 = new FindPathExist1971();
    int[][] edges1 = new int[][]{{0,1}, {1,2}, {2,0}};
    int[][] edges2 = new int[][]{{0,4}};

    boolean b = findPathExist1971.validPath(5, edges2, 0, 2);
    System.out.println(" truth is" + b);

  }

}
