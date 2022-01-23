package written.leetcode.amazon.SortingAndSearching;

import java.util.Arrays;

public class MedianOfTwoSortedArrays4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //even number length -> idx: n/2 - 1, n/2, (divided by 2)
    //odd number length -> idx: n/2 (one)
    int totalLen = nums1.length + nums2.length;
    int[] nums = new int[totalLen];

    for(int i = 0; i < nums1.length; i++) {
      nums[i] = nums1[i];
    }

    for(int j = nums1.length; j < nums1.length + nums2.length; j++) {
      nums[j] = nums2[j - nums1.length];
    }

    Arrays.sort(nums);

    if(totalLen % 2 == 1) {
      return nums[totalLen / 2];
    }
    else {
      return (nums[totalLen/2 -1] + nums[totalLen/2]) / 2.0;
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1,3};
    int[] nums2 = {2};
    MedianOfTwoSortedArrays4 medianOfTwoSortedArrays4 = new MedianOfTwoSortedArrays4();
    medianOfTwoSortedArrays4.findMedianSortedArrays(nums1, nums2);
  }

}
