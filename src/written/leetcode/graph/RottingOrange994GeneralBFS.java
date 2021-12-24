package written.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange994GeneralBFS {

  public int orangesRotting(int[][] grid) {
    int freshOranges = 0;
    int elapsedTime = -1;
    /**
     * It's important that We let some dummy points in order to mark the Elapsed time correctly.
     * first we put this rotted orange in the queue
     * and then R1  q -> (R1, Dummy)
     * Dequeue -> R1 -> Traverse around the R1 , we enqueue the new oranges that would be rotted in the next turn, named R2, R3
     * q : (Dummy, R2, R3)
     * We encountered Dummy and check if there queue is empty and, if q is not empty, also enqueue the dummy point
     * q : (R2, R3, Dummy(new Enqueued!))
     * iterate the step, then new oranges to be rotted would be enqueued and We encountered the dummy, process would be repeated.
     */

    int ROWS = grid.length;
    int COLS = grid[0].length;
    Queue<int[]> q = new LinkedList<>();

    for(int i = 0; i < ROWS; i++) {
      for(int j = 0; j < COLS; j++) {
        if(grid[i][j] == 1) freshOranges++;
        if(grid[i][j] == 2) q.add(new int[]{i,j});
      }
    }

    int[][] DIRECTIONS = {{-1,0}, {0,-1}, {0,1}, {1,0}};

    //put the dummy point
    q.add(new int[]{-1,-1});

    while(!q.isEmpty()) {
      int[] curr = q.poll();
      if(curr[0] == -1) {
        elapsedTime++;
        if(!q.isEmpty()) q.add(new int[]{-1,-1});
      }
      else {
        for(int[] direction : DIRECTIONS) {
          int nextR = curr[0] + direction[0];
          int nextC = curr[1] + direction[1];
          if(nextR >= 0 && nextR < ROWS
            && nextC >= 0 && nextC < COLS
            && grid[nextR][nextC] == 1) {
            grid[nextR][nextC] = 2;
            freshOranges--;
            q.add(new int[]{nextR, nextC});
          }
        }
      }
    }

    return freshOranges == 0 ? elapsedTime : -1;
  }
}
