package written.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPathsFromoSourceToTarget797 {

  private List<List<Integer>> pathCases;
  private int target;

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    pathCases = new ArrayList<>();

    target = graph.length - 1;
    List<Integer> path = new ArrayList<>();
    path.add(0);
    dfs(graph, path, 0);
    return pathCases;
  }

  private void dfs(int[][] graph, List<Integer> path, int curr) {
    if(curr == target) {
      List<Integer> pathCase = List.copyOf(path);
      pathCases.add(pathCase);
      return;
    }

    for(int next : graph[curr]) {
      path.add(next);
      dfs(graph, path, next);
      path.remove(path.size()-1);
    }
  }


  public static void main(String[] args) {

    AllPathsFromoSourceToTarget797 allPathsFromoSourceToTarget797 = new AllPathsFromoSourceToTarget797();

    int[][] graph1 = new int[][]{{1,2},{3},{3}, {}};
    allPathsFromoSourceToTarget797.allPathsSourceTarget(graph1);


  }
}
