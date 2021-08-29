package NaverFinancial;

public class Solution2 {

  private boolean[] visited;
  private int answerCount;

  public int solution(int[] T, int[] A) {
    // write your code in Java SE 8
    answerCount = 0;
    visited = new boolean[T.length];
    for(int i = 0; i < A.length; i++) {
      traverse(A[i], T);
    }

    return answerCount;
  }

  private void traverse(int curr, int[] T) {
    int rootSkill = T[curr];
    if(curr == rootSkill) {
      if(!visited[curr]) {
        visited[curr] = true;
        answerCount++;
      }
      return;
    }

    if(!visited[curr]) {
      visited[curr] = true;
      answerCount++;
    }
    traverse(T[curr], T);
    return;
  }

  public static void main(String[] args) {
    Solution2 solution2 = new Solution2();

    int[] T = {0, 0, 1, 1};
    int[] A = {2};
    int[] T1 = {0,0,0,0,2,3,3};
    int[] A1 = {2,5,6};
    int[] T2 = {0,3,0,0,5,0,5};
    int[] A2 = {4,2,6,1,0};
    int[] T3 = {0};
    int[] A3 = {0};
    solution2.solution(T3,A3);
  }

}
