package written.leetcode;

public class FindNumbersWithEvenNumbersOfDigits1295 {

  public int findNumbers(int[] nums) {
    int ans = 0;
    for(int num : nums) {
      int digits = 0;
      while(num != 0) {
        num /= 10;
        digits++;
      }
      ans += (digits % 2) == 0 ? 1 : 0;
    }
    return ans;
  }

}
