package written.ctci.ch8;

import java.util.ArrayList;
import java.util.List;

public class MagicIndex83 {

  public List<Integer> solution(int[] arr) {
    List<Integer> answer = new ArrayList<>();

    for(int i = 0; i < arr.length; i++) {
      if (arr[i] == i) {
        answer.add(i);
      }
    }
    return answer;
  }

  public int findPowerIndex(int[] arr) {
    int start = 0;
    int end = arr.length -1;
    return findPowerIdx(arr, start, end);
  }

  public int findPowerIdx(int[] arr, int start, int end) {
    int mid = (start+end)/2;

    if(start > end) {
      return -1;
    }

    if(mid < arr[mid]) {
      return findPowerIdx(arr, start, mid -1);
    }
    else if(mid == arr[mid]) {
      return mid;
    }
    else {
      return findPowerIdx(arr, mid +1, end);
    }
  }




  public static void main(String[] args) {
    MagicIndex83 magicIndex83 = new MagicIndex83();

    List<Integer> solution = magicIndex83.solution(new int[]{0, 1, 5, 7});

    System.out.println(solution);
  }

}
