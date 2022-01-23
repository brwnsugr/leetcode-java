package written.leetcode.WeeklyContest;

public class Problem2 {

  public int minMoves(int target, int maxDoubles) {
    int steps = 0;
    while(true) {
      if(target == 1) return steps;
      while(maxDoubles > 0) {
        maxDoubles--;
        if(target == 1) return steps;
        if(target <= 2) {
          break;
        }
        if(target % 2 == 0) {
          target /= 2;
          steps++;
        } else{
          target /= 2;
          steps += 2;
        }
      }
      steps += target - 1;
      break;
    }
    return steps;
  }

  public static void main(String[] args) {
    Problem2 problem2 = new Problem2();
    int i = problem2.minMoves(4, 0);

    System.out.println("dd" + i);
  }

}
