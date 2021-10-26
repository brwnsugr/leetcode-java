package written.nv;

public class Solution {

  public int solution(int[] A) {
    // write your code in Java SE 8
    int answer = 0;

    // first check, last check
    Boolean prevIncreasing = null;
    if(A.length == 1) return 1;

    for(int i = 0; i < A.length - 1; i++) {
      Boolean tempIncreasing = null;
      if(A[i] == A[i+1]) continue;
      else if(A[i] < A[i+1]) {
        tempIncreasing = true;
        if(prevIncreasing == null) {
          answer++;
        }
        else if(prevIncreasing) {
          continue;
        }
        else if(!prevIncreasing) {
          answer++;
        }
        prevIncreasing = true;
      }
      else {
        tempIncreasing = false;
        if(prevIncreasing == null) {
          answer++;
        }
        else if(!prevIncreasing) {
          continue;
        }
        else if(prevIncreasing) {
          answer++;
        }
        prevIncreasing = false;
      }
    }

    if(prevIncreasing == null) answer++;

    return answer + 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] a1 = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
    int[] a2 = {2, 3, 4, 3, 2, 2, 1, 5};
    int[] a3 = {1,2,2};

    int solution1 = solution.solution(a2);

    System.out.println(solution1);


  }

}
