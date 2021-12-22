package written.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SourceLeadToDest1059 {

  List<List<Integer>> adjList = new ArrayList<>();

  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
    for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
    for(int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
    }
    Set<Integer> visited = new HashSet<>();
    visited.add(source);
    boolean ret = dfs(adjList, visited, source, destination);


    return ret;
  }

  private boolean dfs(List<List<Integer>> adjList, Set<Integer> visited, int curr, int dest) {
    if(adjList.get(curr).size() == 0) {
      return curr == dest;
    }
    else {
      List<Integer> neighbors = adjList.get(curr);
      for(int next : neighbors) {
        if(visited.contains(next)) {
          return false;
        }
        else if(!visited.contains(next)) {
          visited.add(next);
          if (!dfs(adjList, visited, next, dest)){
            return false;
          }
          visited.remove(next);
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    SourceLeadToDest1059 sourceLeadToDest1059 = new SourceLeadToDest1059();
    int n1 = 4;
    int n2 = 3;
    int source1 = 0;
    int source2 = 0;
    int dest1 = 3;
    int dest2 = 2;
    int[][] edges1 = new int[][]{{0,1},{0,2},{1,3},{2,3}};
    int[][] edges2 = new int[][]{{0,1}, {0,2}};
    int[][] edges3 = new int[][]{{0,1},{1,1},{1,2}};

    boolean b = sourceLeadToDest1059.leadsToDestination(n1, edges1, source1, dest1);

    System.out.println("dddd is" + b);
  }



}
