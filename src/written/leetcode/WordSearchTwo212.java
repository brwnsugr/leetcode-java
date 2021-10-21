package written.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchTwo212 {
  private int col;
  private int row;
  private char[][] mainBoard;
  private static List<int[]> directions = Arrays.asList(
      new int[]{0,1},
      new int[]{1,0},
      new int[]{0,-1},
      new int[]{-1, 0}
  );
  private boolean[][] visited;


  private boolean hasWord(int currY, int currX, String word, int matchCount) {
    if(matchCount == word.length()) return true;
    if(mainBoard[currY][currX] != word.charAt(matchCount - 1)) return false;

    for(int i = 0; i < 4; i++) {
      int nextY = currY + directions.get(i)[0];
      int nextX = currX + directions.get(i)[1];

      if(nextY >= 0 && nextX >= 0
          && nextY < col && nextX < row
          && !visited[nextY][nextX]
          && word.charAt(matchCount) == mainBoard[nextY][nextX]) {
        visited[nextY][nextX] = true;
        if(hasWord(nextY, nextX, word, matchCount+1)) {
          return true;
        }
      }
    }
    visited[currY][currX] = false;
    return false;
  }



  public List<String> findWords(char[][] board, String[] words) {
    List<String> validWords = new ArrayList<>();
    mainBoard = board;
    col = board.length;
    row = board[0].length;

    Map<String, Boolean> wordMap = new HashMap<>();

    for(String word : words) {
      visited = new boolean[col][row];
      boolean partialAns = false;
      if(wordMap.containsKey(word)) continue;
      for(int i = 0; i < col; i++) {
        for(int j = 0; j < row; j++) {
          if(mainBoard[i][j] == word.charAt(0)) {
            visited[i][j] = true;
            partialAns = hasWord(i, j, word, 1);
            if(partialAns) {
              wordMap.put(word, true);
              validWords.add(word);
              break;
            }
          }
        }
        if(partialAns) break;
      }
    }
    return validWords;
  }

  public static void main(String[] args) {

  }

}
