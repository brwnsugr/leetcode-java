package written.chcorp;

public class Solution1 {

  public int solution1(int[][] locations) {
    int answer = 0;
    int len = locations.length;

    for(int i = 0; i < len; i++) {
      if(locations[i][0] == 2 && locations[i][1] == 2) {
        return -1;
      }
      else {
        answer++;
      }
    }
    return answer;
  }


  public static void main(String[] args) {
    Solution1 sol = new Solution1();

    int[][] loc1 = new int[][]{{1,3}, {3,1}};
    int[][] loc2 = new int[][]{{2,2}, {1,3}};

    int i = sol.solution1(loc2);

    System.out.println(i);
  }

}
