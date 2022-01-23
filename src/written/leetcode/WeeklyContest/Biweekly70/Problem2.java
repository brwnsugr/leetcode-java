package written.leetcode.WeeklyContest.Biweekly70;

public class Problem2 {

  public int numberOfArrays(int[] differences, int lower, int upper) {
    if(differences.length == 1) {
      int max = Math.abs(differences[0]);
      if(upper - lower - max +1 <= 0) return 0;
      else return upper -lower - max +1;
    }

    int maxDiff = Integer.MIN_VALUE;

    boolean prevPositive = differences[0] >= 0 ? true : false;
    int tempMaxDiff = 0;
    boolean currPositive = false;
    for(int i = 0; i < differences.length; i++) {
      if(i==0) {
        tempMaxDiff = Math.abs(differences[i]);
        maxDiff = Math.max(tempMaxDiff, maxDiff);
        continue;
      }
      currPositive = differences[i] >= 0 ? true : false;
      int absDiff = Math.abs(differences[i]);
      if(prevPositive == currPositive) {
        tempMaxDiff += absDiff;
        maxDiff = Math.max(tempMaxDiff, maxDiff);
      }
      else {
        prevPositive = currPositive;
        tempMaxDiff = 0;
        tempMaxDiff += absDiff;
        maxDiff = Math.max(tempMaxDiff, maxDiff);
      }
    }

    if(upper - lower - maxDiff + 1 <= 0) return 0;
    else return upper - lower - maxDiff +1;
  }

  public int numberOfArrays2(int[] differences, int lower, int upper) {
    int[] hidden = new int[differences.length+1];
    hidden[0] = 0;
    long hiddenMin = 0;
    long hiddenMax = 0;
    for(int i = 0; i < differences.length; i++) {
      hidden[i+1] = differences[i] + hidden[i];
      hiddenMin = Math.min(hiddenMin, hidden[i+1]);
      hiddenMax = Math.max(hiddenMax, hidden[i+1]);
    }

    long maxDiff = hiddenMax - hiddenMin;
    long ret = upper - lower -maxDiff + 1;

    return ret > 0 ? (int) ret : 0;
  }

  public static void main(String[] args) {
    Problem2 problem2 = new Problem2();
    int[] nums1 = new int[]{96759,-21770,16529,-94344,-60558,-19699,22321,6815,63132,-90917};
    int lower1 = -84725;
    int upper1 = 99579;

    int[] nums2 = new int[]{3,-4,5,1,-2};
    int lower2 = -4;
    int upper2 = 5;
    int i = problem2.numberOfArrays2(nums2, lower2,upper2);

    System.out.println(" max diff is" + i);
  }
}
