package written.leetcode.NewYearGift.Binary;

public class MissingNumber268 {
  public int missingNumber(int[] nums) {
    int n = nums.length;
    int missing = n;
    for(int i = 0; i < n; i++) {
      missing ^= nums[i] ^ i;
    }
    return missing;
  }
}
