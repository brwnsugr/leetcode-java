package written.leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class OptimizeWater1168 {

  private int[] group;
  private int[] rank;

  public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
    int totalCost = 0;
    List<int[]> costOrderedEdges = new ArrayList<>(n + 1 + pipes.length);

    for(int i = 0; i < n; i++) {
      costOrderedEdges.add(new int[]{0, i+1, wells[i]});
    }

    for(int[] pipe : pipes) {
      costOrderedEdges.add(new int[]{pipe[0], pipe[1], pipe[2]});
    }

    Collections.sort(costOrderedEdges, (a, b) -> a[2] - b[2]);

    //init union find ds
    group = new int[n+1];
    rank = new int[n+1];

    for(int i = 0; i <= n; i++) {
      group[i] = i;
      rank[i] = 0;
    }

    for(int[] edge : costOrderedEdges) {
      if(union(edge[0], edge[1])) {
        totalCost += edge[2];
      }
    }

    return totalCost;
  }


  private int find(int node) {
    if(group[node] != node) {
      return group[node] = find(group[node]);
    }
    else {
      return group[node];
    }
  }

  private boolean union(int node1, int node2) {
    int parentNode1 = find(node1);
    int parentNode2 = find(node2);

    if(parentNode1 == parentNode2) return false;

    if(rank[parentNode1] > rank[parentNode2]) {
      group[parentNode2] = parentNode1;
    }
    else if(rank[parentNode1] < rank[parentNode2]) {
      group[parentNode1] = parentNode2;
    }
    else {
      group[parentNode1] = parentNode2;
      rank[parentNode2]++;
    }
    return true;
  }




}
