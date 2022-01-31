package written.leetcode.NewYearGift.Binary;

public class ReverseBits190 {

  public int reverseBits(int n) {

    int mask = 1;
    int ans = 0;

    for(int i = 0; i < 32; i++) {
      int temp = n >> i;
      if((temp & mask) == 1) {
        ans += 1 << i;
      }
    }


    return 1;
  }
}
