package written.leetcode.amazon2.ArraysAndString;

import java.util.Stack;

public class TrappingRainWater42 {

  public int trap(int[] height) {
    Stack<Integer> s = new Stack<>();
    int area = 0;
    int current = 0;
    while(current < height.length) {
      while(!s.isEmpty() && height[current] > height[s.peek()]) {
        int previousIdx = s.peek();
        s.pop();
        if(s.isEmpty()) break;
        int w = current - s.peek() -1;
        int h = Math.min(height[current], height[s.peek()]) - height[previousIdx];
        area += w*h;
      }
      s.add(current);
      current++;
    }
    return area;
  }


  public static void main(String[] args) {
    TrappingRainWater42 trappingRainWater42 = new TrappingRainWater42();

    int trap = trappingRainWater42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});

    System.out.println(" ans is " + trap);


  }

}
