package written.mobility;

public class Solution3 {
  public int solution(int[] A) {
    // write your code in Java SE 8
    if(A.length <= 2) return A.length;

    int answer = 0;
    int temp = 2;

    for(int i = 2; i < A.length; i++) {
      if(A[i-2] == A[i]) {
        temp++;
      }
      else {
        temp = 2;
      }
      answer = Math.max(temp, answer);
    }
    return answer;
  }

  public static void main(String[] args) {
    Solution3 solution = new Solution3();
    int[] A1 = new int[]{3,2,3,2,3};
    int[] A2 = new int[]{7,4,-2,4,-2,-9};
    int[] A3 = new int[]{7,-5,-5,-5,7,-1,7};
    int[] A4 = new int[]{7,-5,1,2,1,2,1};
    int[] A5 = new int[]{4};
    int solution1 = solution.solution(A4);

    System.out.println(solution1);

  }

}
