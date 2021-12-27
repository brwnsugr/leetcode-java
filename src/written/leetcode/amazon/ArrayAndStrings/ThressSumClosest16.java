package written.leetcode.amazon.ArrayAndStrings;

import java.util.Arrays;

public class ThressSumClosest16 {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int answer = 0;

    for(int i = 0; i < nums.length - 2; i++) {
      if(i == 0 || nums[i-1] != nums[i]) {
        int approxSum = getClosestSum(nums, i, target);
        if(i == 0) answer = approxSum;
        else if(Math.abs(answer - target) > Math.abs(approxSum - target)) {
          answer = approxSum;
        }
      }
    }
    return answer;
  }

  private int getClosestSum(int[] nums, int startIdx, int target) {
    int l = startIdx + 1;
    int r = nums.length - 1;
    int diff = Integer.MAX_VALUE;
    int approxSum = 0;

    while(l < r) {
      int tempSum = nums[startIdx] + nums[l] + nums[r];
      int tempDiff = Math.abs(target - tempSum);
      if(tempDiff < diff) {
        approxSum = tempSum;
        diff = tempDiff;
      }
      if(tempSum < target){
        l++;
      }
      else if(tempSum > target){
        r--;
      }
      else {
        l++;
      }
    }
    return approxSum;
  }

  public static void main(String[] args) {
    ThressSumClosest16 thressSumClosest16 = new ThressSumClosest16();
    int[] arr1 = new int[]{-1,2,1,-4};
    int[] arr2 = new int[]{0,0,0};
    int[] arr3 = new int[]{1,1,1,0};
    int[] arr4 = new int[]{0,2,1,-3};
    int[] arr5 = new int[]{1,1,-1,-1,3};
    int target4 = 1;
    int target5 = -1;

    int i = thressSumClosest16.threeSumClosest(arr5, target5);

    System.out.println("ddd is " + i);
  }
}
