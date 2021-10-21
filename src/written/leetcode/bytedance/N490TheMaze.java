package written.leetcode.bytedance;

import java.util.Arrays;
import java.util.List;

public class N490TheMaze {

  private boolean pathExist = false;
  private boolean[][] visited;

  private static final List<int[]> DIRECTIONS = Arrays.asList(
      new int[]{0, 1},
      new int[]{1, 0},
      new int[]{-1, 0},
      new int[]{0, -1}
  );

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    visited = new boolean[maze.length][maze[0].length];
    boolean dfs = dfs(maze, start, destination);
    return dfs;
  }

  private boolean dfs(int[][] maze, int[] curr, int[] destination) {
//    if(visited[curr[0]][curr[1]]) return false;
    if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
    visited[curr[0]][curr[1]] = true;
    for(int[] direction : DIRECTIONS) {
      int nextY = curr[0];
      int nextX = curr[1];
      while(nextY >= 0 && nextX >= 0
          && nextY < maze.length && nextX < maze[0].length
          && maze[nextY][nextX] == 0) {
        nextY += direction[0];
        nextX += direction[1];
      }
      if(nextY ==  curr[0]  && nextX == curr[1]) continue;
      if(!visited[nextY - direction[0]][nextX - direction[1]]) {
        return dfs(maze, new int[]{nextY - direction[0], nextX - direction[1]}, destination);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    N490TheMaze sol = new N490TheMaze();
    int[][] maze1 = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
    int[][] maze2 = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
    int[] dest2 = new int[]{3,2};
    boolean b = sol.hasPath(maze1, new int[]{0, 4}, new int[]{4,4});
    System.out.println(b);

  }

}
