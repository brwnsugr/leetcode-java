package written.leetcode.graph;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints1584Prims {



  public int minCostConnectPoints(int[][] points) {

    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    int answer = 0;
    int n = points.length;
    int[] startPoint = points[0];
    boolean visited[] = new boolean[n];

    for(int i = 1; i < n; i++) {
      pq.add(new int[]{getDists(startPoint, points[i]), 0, i});
    }

    int count = 0;

    while(!pq.isEmpty() || count < n-1) {
      int[] curr = pq.poll();
      visited[curr[1]] = true;
      if(!visited[curr[2]]) {
        answer += curr[0];
        count++;
        for(int j = 0; j < n; j++) {
          if(!visited[j]) {
            pq.add(new int[]{getDists(points[curr[2]], points[j]), curr[2], j});
          }
        }
      }
    }
    return answer;
  }

  private int getDists(int[] x, int[] y) {
    return (Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]));
  }


  public static void main(String[] args) {
    MinCostToConnectAllPoints1584Prims minCostToConnectAllPoints1584Prims = new MinCostToConnectAllPoints1584Prims();
    int[][] points1 = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
    int i = minCostToConnectAllPoints1584Prims.minCostConnectPoints(points1);
    System.out.println("dd is " + i);
  }



}
