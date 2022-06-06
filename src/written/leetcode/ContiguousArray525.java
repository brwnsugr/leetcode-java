package written.leetcode;

import java.util.Arrays;

public class ContiguousArray525 {
  public int findMaxLength(int[] nums) {

    //[0,1] => 01 -> 2
    //[0,1,1,0] => 0110 =>
    //[0,1,0,1,1,0] => 0101 => 4?
    //   ^   ^
    //[0,1,1,2] => 4/2 = 2
    //[1,0,0,1] => [1,1,1,2]
    //[1,0,1] =>[1,1,2]

    //[1,0,0,1,1] => [1,1,1,2,3]
    //[1,0,-1,0,1]



    int[] arr = new int[2 * nums.length + 1];
    Arrays.fill(arr, -2);
    arr[nums.length] = -1;
    int maxlen = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      count = count + (nums[i] == 0 ? -1 : 1);
      if (arr[count + nums.length] >= -1) {
        maxlen = Math.max(maxlen, i - arr[count + nums.length]);
      } else {
        arr[count + nums.length] = i;
      }

    }
    return maxlen;
  }

  public static void main(String[] args) {
    ContiguousArray525 contiguousArray525 = new ContiguousArray525();
    contiguousArray525.findMaxLength(new int[]{1,0});
  }
}
