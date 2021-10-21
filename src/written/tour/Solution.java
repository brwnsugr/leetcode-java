package written.tour;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  private static int numberOfCourse;
  private static int[] satisfactions;
  private static int[] times;
  private static int availableTime;
  private static int[][] dp;

  private static int pack() {
    for(int i = 1; i <= numberOfCourse; i++) {
      for(int j = 1; j <= availableTime; j++) {
        dp[i][j] = dp[i-1][j];
        if(j-times[i] >= 0) {
          dp[i][j] = Math.max(dp[i][j], dp[i-1][j-times[i]] + satisfactions[i]);
        }
      }
    }
    return dp[numberOfCourse][availableTime];
  }

  public static void main(String[] args) {

    Scanner ints = new Scanner(System.in);
    numberOfCourse = ints.nextInt();
    availableTime = ints.nextInt();

    satisfactions = new int[numberOfCourse+1];
    times = new int[numberOfCourse+1];
    dp = new int[numberOfCourse +1][availableTime+1];

    List<String> courses = new ArrayList<>(numberOfCourse);
    Scanner scanner = new Scanner(System.in);
    for(int i = 0; i < numberOfCourse; i++) {
      String course = scanner.nextLine();
      String[] parsedCourse = course.split(", ");
      for(int j = 0; j < 3; j++) {
        if(j == 1) {
          int estimatedTime = Integer.valueOf(parsedCourse[j]);
          times[i+1] = estimatedTime;
        }
        if(j == 2) {
          int satisfaction = Integer.valueOf(parsedCourse[j]);
          satisfactions[i+1] = satisfaction;
        }
      }
      courses.add(course);
    }
    System.out.println(pack());
  }
}
