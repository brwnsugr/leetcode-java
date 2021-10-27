package written.ctci.ch8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotInGrid82 {

  static class Point {
    int y;
    int x;
    public Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  private Set<Point> failedPoints = new HashSet<>();

  public List<Point> getPath(boolean[][] maze) {
    List<Point> paths = new ArrayList<>();
    if(maze.length == 0 || maze == null) return null;
    if(hasPath(maze, maze.length-1, maze[0].length-1, paths)) {
      return paths;
    }

    return null;
  }

  public boolean hasPath(boolean[][] maze, int col, int row, List<Point> paths) {
    //base case
    if(col < 0 || row < 0 || !maze[col][row]) {
      return false;
    }

    boolean isStartPoint = (col == 0 && row == 0);
    Point currPoint = new Point(col, row);
    if(failedPoints.contains(currPoint)) {
      return false;
    }

    if(isStartPoint || hasPath(maze, col-1, row, paths) || hasPath(maze, col, row-1, paths)) {
      paths.add(currPoint);
      return true;
    }

    failedPoints.add(currPoint);
    return false;
  }


  public static void main(String[] args) {

  }
}
