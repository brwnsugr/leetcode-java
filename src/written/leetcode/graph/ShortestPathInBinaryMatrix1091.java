package written.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix1091 {

  public static List<int[]> DIRECTIONS = Arrays.asList(
      new int[]{1,0},
      new int[]{0,1},
      new int[]{1,1},
      new int[]{-1,0},
      new int[]{0,-1},
      new int[]{-1,1},
      new int[]{1,-1},
      new int[]{-1,-1}
  );

  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    int distance;
    if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
    Queue<int[]> q = new LinkedList<>();

    //enqueue the starting point
    q.add(new int[]{0,0});
    grid[0][0] = 1;

    while(!q.isEmpty()) {
      int[] currPoint = q.poll();
      distance = grid[currPoint[0]][currPoint[1]];
      if(currPoint[0] == n-1 && currPoint[1] == n-1) return distance;

      for(int[] direction : DIRECTIONS) {
        int nextY = currPoint[0] + direction[0];
        int nextX = currPoint[1] + direction[1];
        if(nextY >= 0 && nextY < n
        && nextX >= 0 && nextX < n
        && grid[nextY][nextX] == 0) {
          q.add(new int[]{nextY, nextX});
          grid[nextY][nextX] = distance + 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {

    ShortestPathInBinaryMatrix1091 sol
        = new ShortestPathInBinaryMatrix1091();



  }

}
