package written.dhkorea;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int solution(String S) {
    // write your code in Java SE 8
    Stack<Integer> stack = new Stack<>();
    String[] operationList = S.split(" ");

    for(String operation : operationList) {
      if(operation.matches("\\d+")) {
        int number = Integer.parseInt(operation);
        stack.push(number);
      }
      else if(operation.equals("DUP")) {
        if(stack.size() == 0) return -1;
        int topNum = stack.peek();
        stack.push(topNum);
      }
      else if(operation.equals("POP")) {
        if(stack.size() == 0) return -1;
        stack.pop();
      }
      else if(operation.equals("+")) {
        if(stack.size() <= 1) return -1;
        int firstTopNum = stack.pop();
        int secondTopNum = stack.pop();
        stack.push(firstTopNum + secondTopNum);
      }
      else if(operation.equals("-")) {
        if(stack.size() <= 1) return -1;
        int firstTopNum = stack.pop();
        int secondTopNum = stack.pop();
        int subtractedNum = firstTopNum - secondTopNum;
        if(subtractedNum < 0) return -1;
        stack.push(subtractedNum);
      }
    }
    if(stack.size() < 1) return -1;
    return stack.pop();
  }
}


class Solution2 {

  private boolean[][] visited;
  private int count;

  public static List<int[]> directions = Arrays.asList(
      new int[]{0,1},
      new int[]{1,0},
      new int[]{0,-1},
      new int[]{-1,0}
  );

  private void traverseShip(String[] B, int currY, int currX) {
    visited[currY][currX] = true;
    int N = B.length;
    int M = B[0].length();

    for(int[] direction : directions) {
      int nextY = currY + direction[0];
      int nextX = currX + direction[1];
      if(nextY < N && nextX < M && nextY >= 0 && nextX >= 0
          && !visited[nextY][nextX] && B[nextY].charAt(nextX) == '#') {
        count++;
        traverseShip(B, nextY, nextX);
      }
    }
    return;
  }

  public int[] solution(String[] B) {
    // write your code in Java SE 8
    int N = B.length;
    int M = B[0].length();
    int patrolBoats = 0;
    int submarines = 0;
    int destroyers = 0;

    visited = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      String currentLine = B[i];
      for(int j = 0; j < M; j++) {
        count = 0;
        if(currentLine.charAt(j) == '#' && !visited[i][j]) {
          count = 1;
          traverseShip(B, i, j);
        }
        if(count == 1) {
          patrolBoats++;
        }
        if(count == 2) {
          submarines++;
        }
        if(count == 3) {
          destroyers++;
        }
      }
    }
    return new int[]{patrolBoats, submarines, destroyers};
  }
}

