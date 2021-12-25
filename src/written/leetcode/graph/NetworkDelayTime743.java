package written.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NetworkDelayTime743 {

  int answer = Integer.MAX_VALUE;
  boolean visited[];

  public int networkDelayTime(int[][] times, int n, int k) {
    List<List<int[]>> adjList = new ArrayList<>(n+1);
    int[] ret = new int[n+1];
    for(int i = 0; i <= n; i++) {
      ret[i] = 101;
    }
    ret[k] = 0;
    answer = Integer.MIN_VALUE;
    for(int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
    visited = new boolean[n+1];
    for(int[] time : times) {
      adjList.get(time[0]).add(new int[]{time[1], time[2]});
    }

    Queue<Integer> q = new LinkedList<>();
    q.add(k);

    while(!q.isEmpty()) {
      int curr = q.poll();
      visited[curr] = true;
      List<int[]> neighbors = adjList.get(curr);

      for(int[] neighbor : neighbors) {
        if(!visited[curr] || ret[neighbor[0]] > ret[curr] + neighbor[1]) {
          ret[neighbor[0]] = ret[curr] + neighbor[1];
          q.add(neighbor[0]);
        }
      }
    }
    for(int i = 1; i <= n; i++) {
      if(ret[i] == 101) return -1;
      answer = Math.max(ret[i], answer);
    }
    return answer;
  }


  public static void main(String[] args) {
    int[][] times1 = new int[][]{{2,1,1}, {2,3,1},{3,4,1}};
    int[][] times2 = new int[][]{{1,2,1}, {2,1,3}};
    int[][] times3 = new int[][]{{1,2,1}, {2,3,2}, {1,3,2}};
    int n = 4;
    int n2 = 2;
    int n3 = 3;
    int k2 = 2;
    int k3 = 1;
    int k = 2;
    NetworkDelayTime743 networkDelayTime743 = new NetworkDelayTime743();
    int i = networkDelayTime743.networkDelayTime(times1, n, k);

    System.out.println("ddd is " + i);
  }
}
