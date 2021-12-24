package written.leetcode.graph;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints1584 {

  int[] parents;


  public int minCostConnectPoints(int[][] points) {
    int answer = 0;
    PriorityQueue<int[]> pq= new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
    int n = points.length;
    UnionFind unionFind = new UnionFind(n);

    for(int i = 0; i < n; i++) {
      for(int j = i+1; j < n; j++) {
        pq.add(new int[]{calculateDist(points[i], points[j]), i, j});
      }
    }

    int count = 0;

    while(count < n-1) {
      int[] curr = pq.poll();
      if(unionFind.union(curr[1], curr[2])) {
        count++;
        answer += curr[0];
      }
    }

    return answer;
  }

  private int calculateDist(int[] pointA, int[] pointB) {
    return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
  }

  class UnionFind{

    public UnionFind(int n) {
      parents = new int[n];
      for(int i = 0; i < n; i++) parents[i] = i;
    }

    public int find(int a) {
      if(parents[a] == a) {
        return parents[a];
      }
      else {
        return parents[a] = find(parents[a]);
      }
    }

    public boolean union(int a, int b) {
      int rootA = find(a);
      int rootB = find(b);
      if(rootA == rootB) return false;
      else{
        parents[rootB] = rootA;
        return true;
      }
    }
  }

  public static void main(String[] args) {
    MinCostToConnectAllPoints1584 minCostToConnectAllPoints1584 = new MinCostToConnectAllPoints1584();
  }

}
