package written.leetcode.amazon.SortingAndSearching;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class KthLargestElementInArray215 {
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    int order = 1;
    for(int i = nums.length -1; i >= 0; i--) {
      if(order == k) return nums[i];
      order++;
    }
    return -1;
  }
}
