package leetcode.bytedance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode286 {

  private static final int EMPTY = Integer.MAX_VALUE;
  private static final int GATE = 0;
  private static final List<int[]> DIRECTIONS = Arrays.asList(
      new int[] {1, 0},
      new int[] {-1, 0},
      new int[] {0, 1},
      new int[] {0, -1}
  );

  public void wallsAndGates(int[][] rooms) {
    if(rooms.length == 0) return;
    int m = rooms.length;
    int n = rooms[0].length;
    Queue<int[]> q = new LinkedList<>();

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        //게이트를 발견하면 우선 Queue 에 게이트 좌표를 다 넣어두고, 해당 게이트를 시작점으로 해서 최소 거리를 마킹해준다.
        if(rooms[i][j] == GATE) {
          q.add(new int[]{i, j});
        }
      }
    }

    while(!q.isEmpty()) {
      int[] currentPoint = q.poll();
      int row = currentPoint[0];
      int col = currentPoint[1];
      for(int[] direction : DIRECTIONS) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];
        if(nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && rooms[nextRow][nextCol] == EMPTY) {
          rooms[nextRow][nextCol] = rooms[row][col] + 1;
          q.add(new int[]{nextRow, nextCol});
        }
      }
    }
  }


  public static void main(String[] args) {
    System.out.println("Wefe");
  }
}

