package written.hackerrank;

public class MinimumSwap2 {


  public int solution(int[] arr) {
    int answer = 0;

    for(int i = 0; i < arr.length - 1; i++) {
      if(arr[i] == i+1) {
        continue;
      }
      else {
        for(int j = i+1; j < arr.length; j++) {
          if(i+1 == arr[j]) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            answer++;
            break;
          }
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[]{7,1,3,2,4,5,6};

    MinimumSwap2 minimumSwap2 = new MinimumSwap2();
    minimumSwap2.solution(arr1);
  }

}
