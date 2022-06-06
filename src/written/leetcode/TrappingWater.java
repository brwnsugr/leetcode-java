package written.leetcode;

import java.util.Stack;

public class TrappingWater {
  public int trap(int[] height) {
    // if we meet higher wall than previous height,
    // then we move left til we meet higher than height[current]
    //
    //
    Stack<Integer> s = new Stack<>();
    int answer = 0;
    int currIdx = 0;  // [1,0,1]
    s.add(currIdx); // s = [0, 1]
    while(!s.isEmpty() && currIdx < height.length - 1) {
      currIdx++;
      // int currHeight = height[s.top()];
      while (!s.isEmpty() && height[s.peek()] < height[currIdx]) {
        int currHeight = height[s.peek()];
        s.pop();
        if(s.isEmpty()) break;
        int width = currIdx - s.peek() - 1;
        int heightDiff = Math.min(height[currIdx], height[s.peek()]) - currHeight;
        answer += (width * heightDiff);
      }
      s.add(currIdx);
    }

    return answer;

  }

  public static void main(String[] args) {
    TrappingWater trappingWater = new TrappingWater();
    int[] arr2 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    int trap = trappingWater.trap(arr2);

    System.out.println("answer is " + trap);


  }

}
