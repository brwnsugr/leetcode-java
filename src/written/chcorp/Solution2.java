package written.chcorp;

import java.util.Arrays;
import java.util.List;

public class Solution2 {

  public static List<int[]> directions = Arrays.asList(
      new int[]{0,1},
      new int[]{1,0},
      new int[]{0,-1},
      new int[]{-1,0}
  );

  private boolean[][] visited;
  private boolean[][] visited2;
  private boolean exitTouch = false;
  private boolean exitTouch2 = false;
  private static int answer = Integer.MAX_VALUE;
  private static int answer2 = Integer.MAX_VALUE;
  private int count = 0;
  private int count2 = 0;

  private void dfs2(boolean[][] visited, int[][] cars, int currY, int currX) {
    visited[currY][currX] = true;
    if(cars[currY][currX] == 4) {
      exitTouch2 = true;
      return;
    }
    for(int[] direction : directions) {
      int nextY = currY + direction[0];
      int nextX = currX + direction[1];
      if(nextY < cars.length && nextX < cars[0].length &&
          nextY >= 0 && nextX >= 0 &&
          !visited[nextY][nextX] && cars[nextY][nextX] != 3
          && cars[nextY][nextX] != 2
        ) {
          dfs2(visited, cars, nextY, nextX);
      }
    }
    return;
  }

  private void dfs(boolean[][] visited, int[][] cars, int currY, int currX) {
    visited[currY][currX] = true;
    if(cars[currY][currX] == 4) {
      exitTouch = true;
      if(count < answer) {
        answer = count;
      }
      return;
    }
    for(int[] direction : directions) {
      int nextY = currY + direction[0];
      int nextX = currX + direction[1];
      if(nextY < cars.length && nextX < cars[0].length &&
          nextY >= 0 && nextX >= 0 &&
          !visited[nextY][nextX] && cars[nextY][nextX] != 3
      ) {
        if(cars[nextY][nextX] == 2) {
          count++;
          dfs(visited, cars, nextY, nextX);
          count--;
        }
        else {
          dfs(visited, cars, nextY, nextX);
        }
      }
    }
    return;
  }

  public int solution(int[][] cars) {

    int m = cars.length;
    int n = cars[0].length;
    visited = new boolean[m][n];
    visited2 = new boolean[m][n];

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(cars[i][j] == 1) {
          dfs(visited, cars, i, j);
          dfs2(visited2, cars, i, j);
        }
      }
    }
    if(exitTouch2) return 0;
    if(!exitTouch) return -1;
    return answer;
  }


  public static void main(String[] args) {
    Solution2 solution = new Solution2();

    int[][] cars1 = new int[][]{{0,0,3,0,0,0,0},
        {1,0,3,0,0,0,0},{0,0,3,0,0,0,0},{0,0,2,0,0,3,3},
        {2,2,2,0,2,0,0},{3,3,2,0,2,0,3},{3,3,2,0,2,0,4}};

    int[][] cars2 = new int[][]{{0,2,0,0,0},{0,4,2,0,0},{0,2,0,0,0},{0,0,0,2,1},{0,0,0,2,0}};

    int[][] cars3 = new int[][]{{0,0,0,0,0},{3,0,0,0,0},{4,3,0,0,0},{0,0,3,0,0},{0,0,0,3,1}};

    int solution1 = solution.solution(cars1);


    System.out.println(solution1);

  }

}
