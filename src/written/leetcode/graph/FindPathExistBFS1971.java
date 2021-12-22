package written.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindPathExistBFS1971 {

  public boolean validPath(int n, int[][] edges, int start, int end) {
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    List<List<Integer>> adjList = new ArrayList<>(n);
    for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());

    for(int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
    }

    q.add(start);

    while(!q.isEmpty()) {
      int curr = q.poll();
      if(curr == end) return true;
      if(!visited.contains(curr)) {
        visited.add(curr);
        List<Integer> neighbors = adjList.get(curr);
        for(int neighbor : neighbors) {
          q.add(neighbor);
        }
      }
    }
    return false;
  }

}
