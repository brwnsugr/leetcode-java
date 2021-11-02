package written.leetcode.coupang;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition886 {

  private boolean[] colors;
  private boolean[] visited;
  private List<List<Integer>> adjacencyList;

  public boolean possibleBipartition(int n, int[][] dislikes) {
    colors = new boolean[n+1];
    visited = new boolean[n+1];

    adjacencyList = new ArrayList<>();
    for(int i = 0; i <= n; i++) {
      adjacencyList.add(new ArrayList<>());
    }

    for(int[] dislike : dislikes) {
      adjacencyList.get(dislike[0]).add(dislike[1]);
      adjacencyList.get(dislike[1]).add(dislike[0]);
    }

    for(int i = 1; i <= n; i++) {
      if(!visited[i] && !dfs(i, true)) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(int curr, boolean currentColor) {
    visited[curr] = true;
    colors[curr] = currentColor;
    boolean nextColor = !currentColor;
    for(int neighbor : adjacencyList.get(curr)) {
      if(visited[neighbor] ) {
        if(colors[curr] == colors[neighbor]) return false;
      } else {
        if(!dfs(neighbor, nextColor)) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    PossibleBipartition886 possibleBipartition886 = new PossibleBipartition886();
    int[][] dislikes1 = new int[][]{{1,2},{1,3},{2,4}};
    boolean b = possibleBipartition886.possibleBipartition(4, dislikes1);

  }

}
