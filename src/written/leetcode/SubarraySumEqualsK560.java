package written.leetcode;

public class SubarraySumEqualsK560 {

  public int subarraySum(int[] nums, int k) {
    int answer = 0;
    int[] sum = new int[nums.length];

    for(int i = 0; i < nums.length; i++) {
      if(i==0) sum[i] = nums[i];
      else {
        sum[i] = nums[i] + sum[i-1];
      }
    }

    for(int start = 0; start < nums.length; start++) {
      for(int end = start; end < nums.length; end++) {
        int tmpSum;
        if(start == 0) {
          tmpSum = sum[end];
          if(tmpSum == k) answer++;
        }
        else if(start == end) {
          tmpSum = nums[end];
          if(tmpSum == k) answer++;
        }
        else  {
          tmpSum = sum[end] - sum[start-1];
          if(tmpSum == k) answer++;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    SubarraySumEqualsK560 subarraySumEqualsK560 = new SubarraySumEqualsK560();
    int[] nums1 = new int[]{1,1,1};
    int k1 = 2;

    int[] nums2 = new int[]{1,2,3};
    int k2 = 3;

    int[] nums3 = new int[]{1};
    int k3 = 0;

    int[] nums4 = new int[]{-1,-1,1};
    int k4 = 0;

    int[] nums5 = new int[]{1,-1,0};
    int k5 = 0;

    int i = subarraySumEqualsK560.subarraySum(nums5, k5);

    System.out.println("answer is" + i);

  }
}
