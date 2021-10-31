package written.ctci.ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchInRotatedArray103 {

  public int findIdx(int[] arr, int key) {
    int pivotIdx = findPivotIdx(arr, 0, arr.length-1);
    List<Integer> list = new ArrayList<>(arr.length);
    for(int i = pivotIdx; i < arr.length; i++) {
      list.add(arr[i]);
    }
    for(int j = 0; j < pivotIdx; j++) {
      list.add(arr[j]);
    }
    int idx = Collections.binarySearch(list, key);
    return (idx + pivotIdx) % arr.length;
  }


  private int findPivotIdx(int[] arr, int start, int end) {
    int mid = (start + end) / 2;
    if(start >= end) return start;
    //find left
    else if(arr[mid] < arr[end]) {
      return findPivotIdx(arr, start, mid);
    }
    //find right
    else {
      return findPivotIdx(arr, mid + 1, end);
    }
  }

  public static void main(String[] args) {
    /**
     * test input is as belows
     */
    int[] arr1 = new int[]{15,16,19,20,25,1,3,4,5,7,10,14};
    int[] arr2 = new int[]{15,16,19,20,1,3,4,5,7,10,14};

    SearchInRotatedArray103 searchInRotatedArray103 = new SearchInRotatedArray103();
    int rotatedIdx = searchInRotatedArray103.findIdx(arr1, 10);

    System.out.println("rotated idx is " + rotatedIdx);
  }



}
