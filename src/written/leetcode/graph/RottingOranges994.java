package written.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges994 {

  public static List<int[]> DIRECTIONS =
      Arrays.asList(
          new int[]{0,1},
          new int[]{0,-1},
          new int[]{1,0},
          new int[]{-1,0}
      );

  public int orangesRotting(int[][] grid) {

    int totalOranges = 0;
    int rottedOranges = 0;
    int elapsedTime = 0;
    List<int[]> startingPoints = new ArrayList<>();
    int n = grid.length;
    int m = grid[0].length;

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(grid[i][j] == 1 || grid[i][j] == 2) {
          totalOranges++;
          if(grid[i][j] == 2) {
            rottedOranges++;
            startingPoints.add(new int[]{i,j});
          }
        }
      }
    }

    //no starting point
    if(startingPoints.size() == 0){
      return totalOranges == 0 ? 0 : -1;
    }

    Queue<int[]> q = new LinkedList<>();
    for(int[] startingPoint : startingPoints) {
      q.add(startingPoint);
    }


    while(!q.isEmpty()) {
      List<int[]> neighbors = new ArrayList<>(q.size());
      if(totalOranges == rottedOranges) break;
      elapsedTime++;

      while(!q.isEmpty()) {
        neighbors.add(q.poll());
      }

      for(int[] neighbor : neighbors) {
        for(int[] direction : DIRECTIONS) {
          int nextY = neighbor[0] + direction[0];
          int nextX = neighbor[1] + direction[1];
          if(nextY >= 0 && nextY < n
              && nextX >= 0 && nextX < m
              && grid[nextY][nextX] == 1) {
            grid[nextY][nextX] = 2;
            rottedOranges++;
            q.add(new int[]{nextY, nextX});
          }
        }
      }
    }
    return totalOranges == rottedOranges ? elapsedTime : -1;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{{1},{2}};
    int[][] grid2 = new int[][]{{2,1,1}, {1,1,1}, {0,1,2}};
    RottingOranges994 rottingOranges994 = new RottingOranges994();
    int i = rottingOranges994.orangesRotting(grid2);
    System.out.println(" sss" + i);
  }
}
