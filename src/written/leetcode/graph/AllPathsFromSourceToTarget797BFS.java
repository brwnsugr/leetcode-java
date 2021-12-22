package written.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AllPathsFromSourceToTarget797BFS {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int n = graph.length;
    Queue<List<Integer>> q = new LinkedList<>();

    List<List<Integer>> adjList = new ArrayList<>(n);
    for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
    for(int i = 0; i < n; i++) {
      int[] nodes = graph[i];
      for(int node : nodes) {
        adjList.get(i).add(node);
      }
    }

    List<List<Integer>> possiblePaths = new ArrayList<>();
    q.add(Arrays.asList(0));
    while(!q.isEmpty()) {
      List<Integer> currPath = q.poll();
      int lastNode = currPath.get(currPath.size()-1);
      if(lastNode == n-1) possiblePaths.add(currPath);
      else {
        List<Integer> neighbors = adjList.get(lastNode);
        for (int neighbor : neighbors) {
          List<Integer> eachPath = new ArrayList<>(currPath);
          eachPath.add(neighbor);
          q.add(eachPath);
        }
      }
    }
    return possiblePaths;
  }

  public static void main(String[] args) {
    AllPathsFromSourceToTarget797BFS allPathsFromSourceToTarget797BFS = new AllPathsFromSourceToTarget797BFS();

    int[][] graph1 = new int[][]{{1,2}, {3}, {3}, {}};
    List<List<Integer>> lists = allPathsFromSourceToTarget797BFS.allPathsSourceTarget(graph1);

  }


}
