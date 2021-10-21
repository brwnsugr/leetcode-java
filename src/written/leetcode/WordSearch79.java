package written.leetcode;

import java.util.Arrays;
import java.util.List;

public class WordSearch79 {

  private static List<int[]> directions = Arrays.asList(
      new int[]{0,1},
      new int[]{1,0},
      new int[]{-1, 0},
      new int[]{0,-1}
  );

  private int wordLen;
  private boolean[][] visited;
  private String targetWord;
  private int col;
  private int row;

  private boolean hasWord(char[][] board, int currY, int currX, int matchCount) {
    if(matchCount == wordLen) return true;
    if(board[currY][currX] != targetWord.charAt(matchCount-1)) {
      return false;
    }
    if(targetWord.length() == 1){
      return true;
    }

    for(int i = 0; i < 4; i++) {
      int nextY = currY + directions.get(i)[0];
      int nextX = currX + directions.get(i)[1];

      if(nextY >= 0 && nextX >= 0
          && nextY < col && nextX < row
          && targetWord.charAt(matchCount) == board[nextY][nextX]
          && !visited[nextY][nextX]) {
        visited[nextY][nextX] = true;
        if (hasWord(board, nextY, nextX, matchCount+1)){
          return true;
        }
      }
    }
    visited[currY][currX] = false;
    return false;
  }

  public boolean exist(char[][] board, String word) {
    col = board.length;
    row = board[0].length;
    wordLen = word.length();
    visited = new boolean[col][row];
    targetWord = word;
    boolean ans = false;
    for(int i = 0; i < col; i++) {
      for(int j = 0; j < row; j++) {
        if(word.charAt(0) == board[i][j]) {
          visited[i][j] = true;
          ans = hasWord(board, i, j, 1);
          if(ans) {
            return ans;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {

    char[][] board1 = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
    String word1 = "ABCCED";

    char[][] board2 = {{'a', 'a'}};
    String word2 = "aaa";

    char[][] board3 = {{'C','A','A'}, {'A','A','A'},{'B','C','D'}};
    String word3 = "AAB";

    char[][] board4 = {{'a','a','a','a'}, {'a','a','a','a'}, {'a','a','a','a'}};
    String word4 = "aaaaaaaaaaaaa";

    WordSearch79 sol = new WordSearch79();

    boolean exist = sol.exist(board2, word2);

    System.out.println("is exist? " + exist);


  }

}
