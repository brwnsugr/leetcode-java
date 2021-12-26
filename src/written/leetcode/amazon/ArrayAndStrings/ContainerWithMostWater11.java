package written.leetcode.amazon.ArrayAndStrings;

public class ContainerWithMostWater11 {

  public int maxArea(int[] height) {
    int answer = 0;
    int right = height.length-1;
    int left = 0;

    while(left < right) {
      int dist = right - left;
      answer = Math.max(answer, dist * Math.min(height[left], height[right]));
      if(height[left] < height[right]) {
        left++;
      }
      else {
        right--;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    ContainerWithMostWater11 containerWithMostWater11 = new ContainerWithMostWater11();
    int[] areas = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    int[] areas2 = new int[]{4,3,4,1,3};

    int[] areas3 = new int[]{1,1,1,1,10,10,1,2};
    int ans = containerWithMostWater11.maxArea(areas3);

    System.out.println("max area is " + ans);
  }



}
