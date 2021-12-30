package written.leetcode.amazon.ArrayAndStrings;

import java.util.Stack;

public class TrappingRainWater42 {
  public int trap(int[] height) {
    int answer = 0;
    Stack<Integer> s = new Stack<>();
    for(int i = 0 ; i < height.length; i++) {
      while(!s.isEmpty() && height[s.peek()] < height[i]) {
        int top = s.peek();
        s.pop();
        if(s.isEmpty()) break;

        int dist = i - s.peek() - 1;
        int boundedHeight = Math.min(height[s.peek()], height[i]) - height[top];
        answer += dist * boundedHeight;
      }
      s.push(i);
    }
    return answer;
  }

  public static void main(String[] args) {
    TrappingRainWater42 trappingRainWater42 = new TrappingRainWater42();
    int trap = trappingRainWater42.trap(new int[]{1, 0, 1});

    System.out.println("ddd is " + trap);
  }




}
