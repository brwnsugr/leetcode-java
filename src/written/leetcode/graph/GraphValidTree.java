package written.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {

  private int[] root;
  private boolean[] visited;

  public boolean validTree(int n, int[][] edges) {
    /**
     * 먼저, Tree 의 정의
     * -> cycle 이 없고, 모든 Vertex 간 path 는 1 개여야 함
     * -> union find 에서 edge 들을 모두 union 한 뒤, edge 를 순회하면서, root 의 개수가 1개가 넘거나,
     * union(x,y) 에서 y 자리에 두 개 이상 원소가 있으면 not tree
     * ->
     */

    Map<Set<Integer>, Boolean> edgeMap = new HashMap<>();

    root = new int[n];
    visited = new boolean[n];
    for(int i = 0; i < n; i++) {
      root[i] = i;
    }

    for(int[] edge : edges) {
      Set<Integer> set = new HashSet<>();
      set.add(edge[0]);
      set.add(edge[1]);
      if(edgeMap.containsKey(set)){
        return false;
      }
      else {
        edgeMap.put(set, true);
        union(edge[0], edge[1]);
      }
    }

    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < n; i++) {
      set.add(find(i));
      if(set.size() > 1) return false;
    }

    return true;
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if(rootX != rootY) {
      root[rootY] = rootX;
    }
  }

  public int find(int x) {
    while (x != root[x]) {
      x = root[x];
    }
    return x;
  }



  public static void main(String[] args) {

  }


}
