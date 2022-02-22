package written.leetcode.amazon2.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTreesForGolfEvent675 {

  private static int[][] DIRECTIONS = new int[][]{
      {1,0},{0,1},{-1,0},{0,-1}
  };

  public int cutOffTree(List<List<Integer>> forest) {

    /**
     * Naive Approach: we try to sort by height of tree
     * and try to cut off them in order and count the steps per each tree.
     *
     * e.g.
     * [[1,1],
     *  [1,1], 1st steps for cutting 1st tree: 3,
     *  [0,1]] 2nd steps for 2nd tree: 2,
     *  total steps = 3 + 2 = 5
     *
     *
     *  Deep Dive To this approach
     *
     *  sort the trees with its position
     *
     *  and then, from the starting point(0,0)
     *  we aim the first Element of trees in order from start.
     *  after reaching to each tree, then we start from the position of that tree
     *
     *  what if we can't reach to any trees while looping?
     *  -> just return -1, which equals it's impossible
     *  cut off all cuz there's no other ways to reach.
     *  k = number of cells
     * TC: O(k^2) -> deque tree arrs in order (k), and BFS(k), SC: O(3k)
     */
    List<int[]> trees = getTrees(forest);
    Collections.sort(trees, new Comparator<int[]>() {
      @Override
      public int compare(int[] t1, int[] t2) {
        return t1[2] - t2[2];
      }
    });
    int totalSteps = 0;
    int startR = 0;
    int startC = 0;

    String[] dd = new String[]{"aab", "aa"};



    int numberOfTrees = trees.size();

    for(int i = 0; i < numberOfTrees; i++) {
      int[] treeAimed = trees.get(0);
      int aimR = treeAimed[0];
      int aimC = treeAimed[1];
      int steps = getSteps(forest, startR, startC, aimR, aimC);
      if(steps == -1) return -1;
      totalSteps += steps;
      startR = aimR;
      startC = aimC;
      trees.remove(0);
    }
    return totalSteps;
  }

  private int getSteps(List<List<Integer>> forest, int startR, int startC, int aimR, int aimC) {
    int steps = 0;
    int rows = forest.size();
    int cols = forest.get(0).size();
    boolean[][] visited = new boolean[rows][cols];
    Queue<int[]> q = new LinkedList<>();
    visited[startR][startC] = true;
    q.add(new int[]{startR, startC});
    while(!q.isEmpty()) {
      int qSize = q.size();
      for(int i = 0; i < qSize; i++) {
        int[] curr = q.poll();
        if(curr[0] == aimR && curr[1] == aimC) return steps;
        for(int[] direction : DIRECTIONS) {
          int nextR = curr[0] + direction[0];
          int nextC = curr[1] + direction[1];
          if(nextR >= 0 && nextR < rows
              && nextC >= 0 && nextC < cols
              && !visited[nextR][nextC]
              && forest.get(nextR).get(nextC) > 0) {
            visited[nextR][nextC] = true;
            q.add(new int[]{nextR, nextC});
          }
        }
      }
      steps++;
    }
    return -1;
  }

  private List<int[]> getTrees(List<List<Integer>> forest) {
    List<int[]> res = new LinkedList<>();
    for(int i = 0; i < forest.size(); i++) {
      for(int j = 0; j < forest.get(0).size(); j++) {
        int height = forest.get(i).get(j);
        if(height > 1) res.add(new int[]{i,j,height});
      }
    }
    return res;
  }

  public static void main(String[] args) {
    CutOffTreesForGolfEvent675 cutOffTreesForGolfEvent675 = new CutOffTreesForGolfEvent675();
    List<List<Integer>> forest1 = new ArrayList<>(3);
    forest1.add(new ArrayList<>());
    forest1.add(new ArrayList<>());
    forest1.add(new ArrayList<>());

    forest1.get(0).add(1);
    forest1.get(0).add(2);
    forest1.get(0).add(3);

    forest1.get(1).add(0);
    forest1.get(1).add(0);
    forest1.get(1).add(4);

    forest1.get(2).add(7);
    forest1.get(2).add(6);
    forest1.get(2).add(5);
    int i = cutOffTreesForGolfEvent675.cutOffTree(forest1);
    System.out.println("answer is " + i);

    String str = "abcd";

    int abcde = str.compareTo("abd");

    System.out.println(abcde);
  }
}


