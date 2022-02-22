package written.Pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AbsoluteValueSort {

  static int[] absSort(int[] arr) {
    // your code goes here
    // High Level Approach TC: O(N*logN), SC: O(1)
    // Convert to integer to Absolute values and Do Sort,
    // And try to modify the signs of each numbers in sorted array by its occurence of signs.

    // Implementation
    // Convert to Abs val each element. and store the count of the ocrruence of each number before converting it.
    // After Converting all the nums in array, Do Sort

    Map<Integer, Integer> m = new HashMap<>();
    List<Integer> arr1 = new ArrayList<>();

    Collections.sort(arr1, Comparator.reverseOrder());

    int[] arr2 = new int[5];
    arr2[0] = 5;



    for(int i = 0; i < arr.length; i++) {
      m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
      arr[i] = Math.abs(arr[i]);
    }
//when ever find negative subtract to it
    for(int i = 0; i < arr.length; i++) {
      if(m.containsKey(-arr[i]) && m.get(-arr[i]) > 0) {
        m.put(-arr[i], m.get(-arr[i])-1);
        arr[i] = -arr[i];
      }
    }

    return arr;
  }

  static int[] absSort2(int[] arr) {
    // your code goes here
    // High Level Approach TC: O(N*logN), SC: O(1)
    // Convert to integer to Absolute values and Do Sort,
    // And try to modify the signs of each numbers in sorted array by its occurence of signs.

    // Implementation
    // Convert to Abs val each element. and store the count of the ocrruence of each number before converting it.
    // After Converting all the nums in array, Do Sort

    Stack<Integer> s= new Stack<>();


    return arr;
  }



  public static void main(String[] args) {
    Map<Integer, Integer> m = new HashMap<>();
    int[] arr1 = new int[]{2, -7, -2, -2, 0};
    int[] sol = AbsoluteValueSort.absSort(arr1);

    for(int i : sol) {
      System.out.println(i);
    }
  }

}
