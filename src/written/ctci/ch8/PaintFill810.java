package written.ctci.ch8;

import java.util.Arrays;
import java.util.List;

public class PaintFill810 {


  private static final List<int[]> DIRECTIONS = Arrays.asList(
      new int[] {1, 0},
      new int[] {-1, 0},
      new int[] {0, 1},
      new int[] {0, -1}
  );

  private void fill(int[][] board, int currY, int currX, int originColor, int newColor) {
    if(board[currY][currX] != originColor) {
      return;
    }
    board[currY][currX] = newColor;
    for(int[] direction : DIRECTIONS) {
      int nextY = currY + direction[0];
      int nextX = currX + direction[1];
      if(nextY >= 0 && nextY < board.length
        && nextX >= 0 && nextX < board[0].length
        && board[nextY][nextX] == originColor) {
        fill(board, nextY, nextX, originColor, newColor);
      }
    }
    return;
  }

  public void solution() {
    int[][] board1 = new int[][]{{1,1,1}, {1,1,0}, {0,1,0}};
    int startY = 1;
    int startX = 1;
    fill(board1, startY, startX, 1, 3);

    System.out.println("ddd");
  }


  public static void main(String[] args) {
    PaintFill810 paintFill810 = new PaintFill810();
    paintFill810.solution();
  }




}
