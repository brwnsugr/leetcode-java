package written.leetcode.amazon.ArrayAndStrings;

import java.util.Arrays;

public class RotateImage48 {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int[][] rotatedMatrix = new int[n][n];

    for(int i = 0; i < n; i++) {
      for(int j = n-1; j >= 0; j--) {
        rotatedMatrix[i][n-j-1] = matrix[j][i];
      }
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        matrix[i][j] = rotatedMatrix[i][j];
      }
    }
  }

  public void rotateMemorySaved(int[][] matrix) {
    int n = matrix.length;
    int[][] rotatedMatrix = new int[n][n];

    for(int i = 0; i < n; i++) {
      for(int j = n-1; j >= 0; j--) {
        rotatedMatrix[i][n-j-1] = matrix[j][i];
      }
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        matrix[i][j] = rotatedMatrix[i][j];
      }
    }
  }

  public static void main(String[] args) {
    RotateImage48 rotateImage48 = new RotateImage48();
    rotateImage48.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

    System.out.println("dddd");

  }

}
