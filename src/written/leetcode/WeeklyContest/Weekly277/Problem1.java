package written.leetcode.WeeklyContest.Weekly277;

public class Problem1 {
  public int countElements(int[] nums) {
    int maxNum = Integer.MIN_VALUE;
    int minNum = Integer.MAX_VALUE;
    if(nums.length <= 2) return 0;
    for(int num : nums) {
      maxNum = Math.max(maxNum, num);
      minNum = Math.min(minNum, num);
    }
    int ans = 0;
    for(int num : nums) {
      if(num > minNum && num < maxNum) ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    Problem1 problem1 = new Problem1();
    int i = problem1.countElements(new int[]{1,-1,-1,2,3,4});

    System.out.println("ddd is " + i);
  }
}
