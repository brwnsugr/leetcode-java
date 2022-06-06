package written.leetcode.NewYearGift.Binary;

public class NumberOf1Bits191 {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int ans = 0;
    while(n != 0) {
      n = n & (n-1);
      ans++;
    }
    return ans;
  }

  public static void main(String[] args) {

  }

}