package written.leetcode.graph;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestMoment1101 {
  private int[] parents;
  public int earliestAcq(int[][] logs, int n) {
    parents = new int[n];

    for(int i = 0; i < n; i++) {
      parents[i] = i;
    }

    MyComparator myComparator = new MyComparator();
    Arrays.sort(logs, myComparator);

    int components = n;

    for(int[] log : logs) {
      if(find(log[1]) != find(log[2])) {
        union(log[2], log[1]);
        components--;
        if(components == 1) return log[0];
      }
    }
    return -1;
  }

  private int find(int a) {
    if(parents[a] == a) return a;
    else {
      return parents[a] = find(parents[a]);
    }
  }

  private void union(int a, int b) {
    a = find(a);
    b = find(b);
    if(a != b) {
      parents[b] = a;
    }
  }

  public static void main(String[] args) {
    EarliestMoment1101 sol = new EarliestMoment1101();
    int[][] logs = new int[][]{{0,2,0}, {1,0,1}, {3,0,3}, {4,1,2}, {7,3,1}};
    int[][] logs2 = new int[][]{
        {20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},
        {20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
    int n2 = 6;
    int n = 4;
    int answer = sol.earliestAcq(logs2, n2);
    System.out.println(answer);
  }
}

class MyComparator implements Comparator<int[]> {
  @Override
  public int compare(int[] log1, int[] log2) {
    return log1[0] > log2[0] ? 1 : -1;
  }
}
