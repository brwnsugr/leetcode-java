package written.ctci.ch10;

public class SortedMerge101 {

  /**
   * length of A is bigger than that of B, and both are well ordered
   */
  public int[] solution(int[] A, int[] B) {
    int totalLen = A.length + B.length;

    int[] answerArr = new int[totalLen];
    int[] helperArr = new int[totalLen];

    for(int i = 0; i < totalLen; i++) {
      if(i < A.length) {
        helperArr[i] = A[i];
      }
      else {
        helperArr[i] = B[i-A.length];
      }
    }

    int leftStart = 0;
    int end = totalLen-1;
    int rightStart = A.length;
    int mid = A.length-1;

    int current = 0;

    while(leftStart <= mid && rightStart <= end) {
      if(helperArr[leftStart] <= helperArr[rightStart]) {
        answerArr[current] = helperArr[leftStart];
        leftStart++;
      }
      else {
        answerArr[current] = helperArr[rightStart];
        rightStart++;
      }
      current++;
    }

    if(leftStart <= mid) {
      int remain = end - current;
      for(int i = mid - remain; i <= mid; i++) {
        answerArr[current] = helperArr[i];
        current++;
      }
    }
    else if (rightStart <= end){
      for(int i = current; i <= end; i++) {
        answerArr[i] = helperArr[i];
      }
    }
    else {
      return answerArr;
    }
    return answerArr;
  }

  public static void main(String[] args) {
    SortedMerge101 sortedMerge101 = new SortedMerge101();

    int[] solution = sortedMerge101.solution(new int[]{1, 4, 5, 9,10}, new int[]{2, 3, 7, 15});

    System.out.println("ddd" + solution);


  }

}
