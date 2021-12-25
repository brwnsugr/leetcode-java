package written.leetcode.graph;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints1584UnionRank {

  public int minCostConnectPoints(int[][] points) {
    int answer = 0;
    int n = points.length;
    RankUnionFind rankUnionFind = new RankUnionFind(n);
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
    for(int i = 0; i < n; i++) {
      for(int j = i+1; j < n; j++) {
        pq.add(new int[]{getDist(points[i], points[j]), i, j});
      }
    }

    int count = 0;
    while(count < n-1) {
      int[] curr = pq.poll();
      if(rankUnionFind.union(curr[1], curr[2])) {
        count++;
        answer += curr[0];
      }
    }
    return answer;
  }

  private int getDist(int[] a, int[] b) {
    return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
  }

  class RankUnionFind {

    private int root[];
    private int rank[];

    public RankUnionFind(int n) {
      root = new int[n];
      rank = new int[n];
      for(int i = 0; i < n; i++) {
        root[i] = i;
        rank[i] = 1;
      }
    }

    public int find(int x) {
      int rootX = root[x];
      if(rootX == x) return rootX;
      else {
        return root[x] = find(root[x]);
      }
    }

    public boolean union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if(rootX == rootY) return false;
      else {
        if(rank[rootX] > rank[rootY])
          root[rootY] = rootX;
        else if(rank[rootX] < rank[rootY]) {
          root[rootX] = rootY;
        }
        else {
          root[rootY] = rootX;
          rank[rootX]++;
        }
        return true;
      }
    }
  }
}
