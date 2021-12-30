package written.leetcode.amazon.ArrayAndStrings;

public class MissingNumber268 {

  public int missingNumber(int[] nums) {
    int len = nums.length;
    boolean[] check = new boolean[len+1];
    for(int i = 0; i < len; i++) check[nums[i]] = true;
    for(int i = 0; i <= len; i++) {
      if(!check[i]) return i;
    }
    return 0;
  }
}
