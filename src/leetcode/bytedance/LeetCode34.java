package leetcode.bytedance;

import java.util.ArrayList;

public class LeetCode34 {

  public int[] binarySearch(int left, int right, int[] nums, int target) {
    int mid = (left + right) / 2;
    if (nums[mid] == target) {
      return new int[]{mid, left, right};
    }
    if (right == left) {
      return new int[]{-1,-1};
    }
    if (nums[mid] < target) {
      return binarySearch(mid+1, right, nums, target);
    }
    if (nums[mid] > target) {
      return binarySearch(left, mid, nums, target);
    }
    return new int[]{-1,1};
  }

  public int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    if(nums.length == 0) return new int[]{-1,-1};
    int[] temp = binarySearch(left, right, nums, target);
    if(temp[0] == -1) {
      return temp;
    } else{
      ArrayList<Integer> list  = new ArrayList<>();
      for(int i = left; i <= right; i++) {
        if(nums[i] == target) {
          list.add(i);
        }
      }
      int firstIdx = list.get(0);
      int listSize = list.size();
      if(listSize == 1) return new int[]{firstIdx, firstIdx};
      return new int[]{list.get(0), list.get(listSize-1)};
    }
  }

  public static void main(String[] args) {
    System.out.println("ddd");
  }
}
