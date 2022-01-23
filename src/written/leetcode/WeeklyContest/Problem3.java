package written.leetcode.WeeklyContest;

public class Problem3 {

  long[] cache;
  public long mostPoints(int[][] questions) {
    cache = new long[questions.length];
    return dfs(questions, 0);
  }

  private long dfs(int[][] questions, int currIdx) {
    int qLen = questions.length;
    if(currIdx >= qLen) {
      return 0;
    }
    else if(cache[currIdx] > 0) {
      return cache[currIdx];
    }
    else {
      int points = questions[currIdx][0];
      int steps = questions[currIdx][1];
      long skippingCurrent = dfs(questions, currIdx +1);
      long checkCurrent = points + dfs(questions, currIdx + steps + 1);
      cache[currIdx] = Math.max(skippingCurrent, checkCurrent);
      return cache[currIdx];
    }
  }

  public static void main(String[] args) {

    int[][] q1 = new int[][]{{3,2},{4,3},{4,4},{2,5}};
    int[][] q2 = new int[][]{{1,1},{2,2}, {3,3},{4,4},{5,5}};
    int[][] q4 = new int[][]{{1,2},{2,1}, {1,1},{4,4},{5,5}};
    int[][] q3 = new int[][]{{1,1}, {4,1}, {1,1}};

    int[][] q5 = new int[][]{{1,1}, {4,1}, {1,1}, {44, 1}};
    int[][] q6 = new int[][]{{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}};
    Problem3 problem3 = new Problem3();
    long l = problem3.mostPoints(q1);
    System.out.println("dddd is " + l);

  }

}
